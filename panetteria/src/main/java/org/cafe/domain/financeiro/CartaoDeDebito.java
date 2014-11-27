package org.cafe.domain.financeiro;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;

public class CartaoDeDebito extends Pagamento {
	
	Banco banco = Banco.instance();

    @Override
    public boolean processar(Cliente cliente, Pedido pedido) {
    	double total = 0;        
        for (Produto produto : pedido.itens()) {
        	total += produto.getPreco();
		}
        
        if (total <= banco.getConta(cliente.getNumeroDaConta()).getSaldo()) {
        	banco.getConta(cliente.getNumeroDaConta()).debitar(total);        	
        	return true;
        } else {
        	return false;
        } 
    }

}
