package br.com.cabal.teste;

import javax.swing.JOptionPane;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.service.credito.interfaces.NsuCreditoService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteNsuCredito {

	public static void main(String[] args) throws Exception {
	
		ServiceLocatorEJB.conexao = JOptionPane.showInputDialog("Insira o IP/porta de homologação:");
	   final NsuCreditoService nsu = (NsuCreditoService) ServiceLocatorEJB.getInstance().getEjbObject("NsuCreditoImpl");
		TransacaoDTO tranDTO = new TransacaoDTO();
		String funcao ="CREDITO";
		String funcao1 ="DEBITO";
		System.out.println("NSU para saque de Débito é : "+nsu.recuperarNsuDebito(funcao1));
		
		System.out.println("NSU para saque de crédito é : "+nsu.recuperarNsuCredito(funcao));
		
		System.out.println("NSU Crédito DTO : "+tranDTO.getNsuCredito());
		
	

	}

	
}
