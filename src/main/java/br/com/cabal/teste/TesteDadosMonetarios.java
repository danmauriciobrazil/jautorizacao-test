package br.com.cabal.teste;

import br.com.cabal.jautorizacao.dto.credito.LimitesContaDTO;
import br.com.cabal.jautorizacao.dto.credito.LimitesDispPortadorDTO;
import br.com.cabal.jautorizacao.service.dadosMonetarios.interfaces.DadosMonetariosService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteDadosMonetarios
{

	public static void main(String[] args) throws Exception
	{
		DadosMonetariosService srv = (DadosMonetariosService) ServiceLocatorEJB.getInstance().getEjbObject("dadosMonetariosServiceImpl");

		LimitesContaDTO limCtaDTO = new LimitesContaDTO();
		LimitesDispPortadorDTO limDispPort = new LimitesDispPortadorDTO();

		long cta = 9100001004107l;
		int componente = 1;

		limCtaDTO = srv.getLimitesConta(cta);
		System.out.println("portador1:"+limCtaDTO.toString());

    	limDispPort = srv.getLimitesDisponiveisConta(cta);
		System.out.println("portador2:"+limDispPort.toString());

		//limAdi = srv.getLimiteAdicional(cta, componente);
		
		limDispPort = srv.getLimitesDisponiveisAdicional(cta, componente);
		System.out.println("Limite do adicional Portador 3 " + componente + ": " + limDispPort);
		//System.out.println("Limite do adicional 3 " + componente + ": " + limAdi);

		limDispPort = srv.getLimitesDisponiveisAdicional(cta, componente);
		System.out.println("portador: 4"+limDispPort.toString());

	}

}
