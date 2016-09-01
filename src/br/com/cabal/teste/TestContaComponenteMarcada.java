package br.com.cabal.teste;

import java.util.List;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.service.ceibo.interfaces.ContaComponenteMarcadaService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TestContaComponenteMarcada {

	public static void main(String[] args) throws Exception {
		final ContaComponenteMarcadaService contaComponente = (ContaComponenteMarcadaService) ServiceLocatorEJB.getInstance().getEjbObject("contaComponenteMarcadaImpl");

		final String servico = "MOBBLOQWEB";

		// System.out.println("Aleterando um registro de bloqueio: " +
		// contaComponente.alteraComponenteMarcado(7560001001015l, 1,servico));

		System.out.println("Cadastrando um registro de bloqueio:  " + contaComponente.cadastraComponenteMarcado(7560001001015l, 1, servico));

		// final List<TransacaoDTO> listaContaComponenteMarcada =
		// contaComponente
		// .consultaContaComponenteMarcada(7560001001015l, 1);
		//
		// imprimeTransacao(listaContaComponenteMarcada);
	}

	@SuppressWarnings("unused")
	private static void imprimeTransacao(List<TransacaoDTO> listaContaComponenteMarcada) {

		for (final TransacaoDTO lista : listaContaComponenteMarcada) {
			System.out.println("Nome serviço bloqueio: " + lista.getServico() + "\n");
		}
	}
}
