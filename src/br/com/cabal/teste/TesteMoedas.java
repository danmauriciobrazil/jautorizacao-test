package br.com.cabal.teste;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.service.credito.interfaces.MonedaService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteMoedas {
	public static void main(String[] args) {
		try {
			MonedaService srv = (MonedaService) ServiceLocatorEJB.getInstance().getEjbObject("MonedaServiceImpl");
			System.out.println(srv.getMonedaDTO(840).getDescripcion());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
