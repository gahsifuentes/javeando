package org.cafe.domain.financeiro;

import org.cafe.domain.clientes.Cliente;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;

public class PagamentoNoDinheiro extends Pagamento {

    @Override
    public boolean processar(Cliente cliente, Pedido pedido) {
        double total = 0;        
        for (Produto produto : pedido.itens()) {
        	total += produto.getPreco();
		}
        if (total <= cliente.getDinheiro()) {
        	cliente.setDinheiro(cliente.getDinheiro() - total);
        	return true;
        } else {
        	return false;
        }                	       
    }
}
