package org.cafe.domain.financeiro;

import java.util.ArrayList;
import java.util.List;

import org.cafe.domain.produto.Produto;

public class Conta {
    private long numero;
    private double saldo;
    private double limiteCartao;
    private List<Double> lancamentosCartao = new ArrayList<>();

    public Conta(long numero, double saldo, double limiteCartao) {
        this.numero = numero;
        this.saldo = saldo;
        this.limiteCartao = limiteCartao;
    }

    public long getNumero() {
        return numero;
    }

    public boolean debitar(double valor) {
    	if ((this.saldo - valor) >= 0) {
    		this.saldo -= valor;
    		return true;
    	} else {
    		return false;
    	}
    }

    public boolean creditar(double valor) {
    	   
        if ((this.limiteDisponivel() - valor) >= 0) {
        	lancamentosCartao.add(valor);
        	return true;
        } else {        
        	return false;
        }
        	
        
    }

    public double getSaldo() {
        return saldo;
    }

    public double limiteDisponivel() {
    	double lancamentos = 0d;
    	for (int i = 0; i < lancamentosCartao.toArray().length; i++) {
    		lancamentos += lancamentosCartao.get(i).doubleValue();			
		} 
        return this.limiteCartao - lancamentos;
    }
}
