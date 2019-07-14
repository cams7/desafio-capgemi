import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ContaCorrente } from '../common/model/conta-corrente';
import { OperacaoVO } from '../common/model/vo/operacao-vo';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};
const contasUrl = 'http://localhost:8080/contas';
@Injectable({
  providedIn: 'root'
})
export class ContaCorrenteService {

  constructor(
    private http: HttpClient
  ) { }

  buscarContas() {
    return <Observable<ContaCorrente[]>>this.http.get(contasUrl);
  }

  buscarConta(contaId: number) {
    return <Observable<ContaCorrente>>this.http.get(`${contasUrl}/${contaId}`);
  }

  buscarContaPeloCliente(clienteId: number) {
    return <Observable<ContaCorrente>>this.http.get(`${contasUrl}/cliente/${clienteId}`);
  }

  salvarConta(conta: ContaCorrente) {
    return  <Observable<ContaCorrente>>this.http.post(contasUrl, conta, httpOptions);
  }

  atualizarConta(conta: ContaCorrente): Observable<void> {
    return  <Observable<any>>this.http.put(contasUrl, conta, httpOptions);
  }

  excluirConta(contaId: number): Observable<void> {
    return <Observable<any>>this.http.delete(`${contasUrl}/${contaId}`);
  }

  realizarOperacao(operacao: OperacaoVO) {
    return  <Observable<number>>this.http.post(`${contasUrl}/realizar_operacao`, operacao, httpOptions);
  }
}
