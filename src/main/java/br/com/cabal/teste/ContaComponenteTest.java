package br.com.cabal.teste;

import java.util.List;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.service.ceibo.interfaces.ContaComponenteMarcadaService;
import br.com.cabal.util.ServiceLocatorEJB;

public class ContaComponenteTest {

 public static void main(String[] args) throws Exception {
		
	 ContaComponenteMarcadaService contaComponente = (ContaComponenteMarcadaService) ServiceLocatorEJB.getInstance().getEjbObject("contaComponenteMarcadaImpl");
	 
	 String servico = "BloqTemp";
	
	// System.out.println("Cadastrando um registro de bloqueio: "+ contaComponente.alteraComponenteMarcado(7563008291940L, 1, servico));
	
	// System.out.println("Cadastrando um registro de bloqueio: "+ contaComponente.cadastraComponenteMarcado(7563008291940L, 1,servico ));
	 
	 List<TransacaoDTO>  listaContaComponenteMarcada  = contaComponente.consultaContaComponenteMarcada(7563003133324L, 1) ;
	 
	 imprimeTransacao(listaContaComponenteMarcada);
	 

	
}

private static void imprimeTransacao(List<TransacaoDTO> listaContaComponenteMarcada) {
	
	for(final TransacaoDTO lista : listaContaComponenteMarcada) {
		System.out.println("Conta Cartão: " + lista.getContaComponente());
		System.out.println("Componente: " + lista.getComponente());
		System.out.println("Data de inicio: "+ lista.getDataInicio());
		System.out.println("Data de Validade: " + lista.getDataValidade());
		System.out.println("Nome serviço bloqueio: " + lista.getServico());
	}
	
}
}