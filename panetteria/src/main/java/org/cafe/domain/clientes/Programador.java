package org.cafe.domain.clientes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.cafe.domain.financeiro.Pagamento;
import org.cafe.domain.financeiro.PagamentoNoDinheiro;
import org.cafe.domain.produto.Menu;
import org.cafe.domain.produto.Pedido;
import org.cafe.domain.produto.Produto;
import org.cafe.domain.produto.TipoProduto;

public class Programador extends Cliente {
	
	
	public Produto selecionarProduto(List<Produto> produtosPorTipo) {		
		double menorPreco = produtosPorTipo.get(0).getPreco(); // seta o preço do primeiro produto da lista recebida no método
		int prodMenor = 0;
    	for(int i = 1; i < produtosPorTipo.size(); i++) {    		
    		if (produtosPorTipo.get(i).getPreco() < menorPreco) { // verifica o menor preço por tipo
    			menorPreco = produtosPorTipo.get(i).getPreco(); // atualiza o menor preço
    			prodMenor = i; // marca o index do produto cujo preço é o menor.
    		}
    	}
    	return produtosPorTipo.get(prodMenor);
	}

    @Override
    public Pedido escolherPedido(Menu menu) {
    	Pedido pedido = new Pedido();
    	List<Produto> produtosSelecionados = new ArrayList<>();
    	produtosSelecionados.add(selecionarProduto(menu.listarProdutosPorTipo(TipoProduto.CAFETERIA)));
    	produtosSelecionados.add(selecionarProduto(menu.listarProdutosPorTipo(TipoProduto.DOCE)));
    	
    	Collections.sort(produtosSelecionados, new Comparator<Produto>() {
			@Override
			public int compare(Produto o1, Produto o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});

    	for (Produto produto : produtosSelecionados) {
			pedido.addItem(produto);
		}
    	
		return pedido;
	}

	@Override
	public Pagamento escolherTipoDePagamento() {

		PagamentoNoDinheiro pagamentoNoDinheiro = new PagamentoNoDinheiro();
		return pagamentoNoDinheiro;
	}

}
