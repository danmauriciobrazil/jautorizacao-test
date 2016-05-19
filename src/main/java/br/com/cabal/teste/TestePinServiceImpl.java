package br.com.cabal.teste;

import br.com.cabal.jautorizacao.service.hsm.interfaces.PinService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TestePinServiceImpl
{
	public static void main(final String[] args) throws Exception
	{
		
		final PinService srv = (PinService) ServiceLocatorEJB.getInstance().getEjbObject("pinServiceImpl");

		
		System.out.println("Validando senha: " + srv.validarPinProcessadora("6043310000001015", "B79269C87A2710AF"));
		
		
		
	}

}
