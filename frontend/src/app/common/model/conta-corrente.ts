import { Cliente } from './cliente';

export interface ContaCorrente {
    id: number;
    saldo: number;
    cliente: Cliente;
}
