package br.com.cabal.teste;

import br.com.cabal.jautorizacao.service.hsm.interfaces.ResetAtcService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteResetAtcImpl {
	public static void main(final String[] args) throws Exception {

		final ResetAtcService atc = (ResetAtcService) ServiceLocatorEJB.getInstance().getEjbObject("resetAtcServiceImpl");

		String cartaoMaster = "6042030000000046";
		String funcao = "CREDITO";
		System.out.println("Resultado : " + atc.ResetAtc(cartaoMaster, funcao));

		// B79269C87A2710AF
	}

}
