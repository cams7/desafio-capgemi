export interface OperacaoVO {
    contaId: number;
    valorInformado: number;
    tipoOperacao: TipoOperacao
}
export enum TipoOperacao {
    DEPOSITO="DEPOSITO",
    SAQUE="SAQUE"
}
