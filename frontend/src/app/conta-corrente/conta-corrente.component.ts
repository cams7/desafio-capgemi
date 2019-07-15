import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators, ValidationErrors } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { mergeMap } from 'rxjs/operators';
import { ContaCorrenteService } from './conta-corrente.service';
import { ContaCorrente } from '../common/model/conta-corrente';
import { OperacaoVO, TipoOperacao } from '../common/model/vo/operacao-vo';

@Component({
  selector: 'app-conta-corrente',
  templateUrl: './conta-corrente.component.html',
  styleUrls: ['./conta-corrente.component.css']
})
export class ContaCorrenteComponent implements OnInit, OnDestroy {
  
  private subscription: Subscription;
  private conta: ContaCorrente;
  
  private _submitted = false;

  contaForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private contaCorrenteService: ContaCorrenteService
  ) { }

  ngOnInit() {
    this.contaForm = this.formBuilder.group({
      saldo: [undefined],
      cliente: this.formBuilder.group({
        nome: [undefined],
        cpf: [undefined],
        dataNascimento: [undefined]
      }),
      operacao: this.formBuilder.group({
        tipoOperacao: [undefined, Validators.required],
        valor: [undefined, [
          Validators.required,
          Validators.pattern("^\\d+(\\,\\d{1,2})?$")
        ]]
      })
    });

    this.subscription = this.route.params.pipe(
      mergeMap(params  => {
        const clienteId: number = <any>params["clienteId"];
        return this.contaCorrenteService.buscarContaPeloCliente(clienteId);
      })
    ).subscribe(conta => {
      this.conta = conta;
      this.contaForm.get("saldo").setValue(conta.saldo);
      let clienteGroup = this.contaForm.get("cliente"); 
      clienteGroup.get("nome").setValue(conta.cliente.nome);
      clienteGroup.get("cpf").setValue(conta.cliente.cpf);
      clienteGroup.get("dataNascimento").setValue(conta.cliente.dataNascimento);
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
  
  salvar() {
    this._submitted = true;

    if (this.contaForm.invalid)
      return;

    const operacao = <OperacaoVO>{
      contaId: this.conta.id, 
      tipoOperacao: this.getOperacaoField('tipoOperacao').value == 1 ? TipoOperacao.DEPOSITO : TipoOperacao.SAQUE,
      valorInformado: <number><any>((<string>this.getOperacaoField('valor').value).replace(',','.'))
    };
    this.contaCorrenteService.realizarOperacao(operacao).subscribe(saldoAtualizado => {
      this.contaForm.get("saldo").setValue(saldoAtualizado);
    });
  }

  isOperacaoInvalid(fieldName: string) {
    const field = this.getOperacaoField(fieldName);
    const invalid = this._submitted && field.invalid;
    return invalid;
  }

  isOperacaoErrors(fieldName: string) {
    if(!this.isOperacaoInvalid(fieldName))
      return undefined;

    const field = this.getOperacaoField(fieldName);
    return  field.errors;
  }

  private getOperacaoField(fieldName: string) {
    return this.contaForm.get("operacao").get(fieldName);
  }

  get submitted() {
    return this._submitted;
  }
  
}
