package org.cafe.domain.clientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.cafe.domain.financeiro.CartaoDeCredito;
import org.cafe.domain.financeiro.Pagamento;
import org.cafe.domain.produto.Menu;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;
import org.cafe.domain.produto.TipoProduto;

public class Coordenador extends Cliente {

    @Override
    public Pedido escolherPedido(Menu menu) {
    	Pedido pedido = new Pedido();
    	List<Produto> produtosNaturais = new ArrayList<>();
    	produtosNaturais = menu.listarProdutosPorTipo(TipoProduto.NATURAL);    	
    	Collections.sort(produtosNaturais, new Comparator<Produto>() {
			@Override
			public int compare(Produto o1, Produto o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});

    	for (Produto produto : produtosNaturais) {
			pedido.addItem(produto);
			if (new Integer(2).equals(pedido.itens().size())) {
				break;
			}
		}
    	
		return pedido;
    }

    @Override
    public Pagamento escolherTipoDePagamento() {
    	CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();    	
        return cartaoDeCredito;
    }

}
