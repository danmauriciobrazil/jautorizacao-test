package br.com.cabal.teste;

import br.com.cabal.jautorizacao.dto.credito.LimitesContaDTO;
import br.com.cabal.jautorizacao.dto.credito.LimitesDispPortadorDTO;
import br.com.cabal.jautorizacao.service.dadosMonetarios.interfaces.DadosMonetariosConfirmadosService;
import br.com.cabal.jautorizacao.service.dadosMonetarios.interfaces.DadosMonetariosService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteDadosMonetarios
{

	public static void main(String[] args) throws Exception
	{
		DadosMonetariosService srv = (DadosMonetariosService) ServiceLocatorEJB.getInstance().getEjbObject("dadosMonetariosServiceImpl");

		LimitesContaDTO limCtaDTO = new LimitesContaDTO();
		LimitesDispPortadorDTO limDispPort = new LimitesDispPortadorDTO();

		long cta = 7564312030790l;
		int componente = 1;

		limCtaDTO = srv.getLimitesConta(cta);
		System.out.println("portador1:"+limCtaDTO.toString());

    	limDispPort = srv.getLimitesDisponiveisConta(cta);
		System.out.println("portador2:"+limDispPort.toString());



	}

}
