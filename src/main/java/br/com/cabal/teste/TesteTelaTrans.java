package br.com.cabal.teste;

import java.util.List;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.dto.ceibo.TelaBoxDTO;
import br.com.cabal.jautorizacao.dto.ceibo.TelaCampoDTO;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.TransacaoService;
import br.com.cabal.jautorizacao.util.AutorizacaoUtil;
import br.com.cabal.util.ServiceLocatorEJB;
 



public class TesteTelaTrans {

	public static void main(final String[] args) throws Exception {
		try {
			final TransacaoService srv = (TransacaoService) ServiceLocatorEJB.getInstance().getEjbObject("transacaoServiceImpl");

			// final  List<TelaBoxDTO> listaTela  =  srv.obterTransacaoParaTela("5127070014662555", 827147, "06/01/2016 14:44:43", "CREDITO", false);

			//final  List<TelaBoxDTO> listaTela  =  srv.obterTransacaoParaTela("6043310000001015", 882257, "01/12/2015 02:41:44", "CREDITO", false);
			
			final  List<TelaBoxDTO> listaTela  =  srv.obterTransacaoParaTela("6043310000001015",591816, "24/01/2016 21:32:30", "CREDITO", false);

			//final  List<TelaBoxDTO> listaTela  =  srv.obterTransacaoParaTela("5474080002402969", 63250, "17/07/2016 13:35:07", "DEBITO", false);
			
			imprimeTransacao(listaTela);

		} catch (final NamingException e) {
			e.printStackTrace();

		}
	}

	public static void imprimeTransacao(final List<TelaBoxDTO> reg) throws Exception {

		for(final TelaBoxDTO box : reg) {
			System.out.println("==================================================BOX==================================================");
			//System.out.println("===>Ordem: " + box.getOrdem());
			//System.out.println("===>Layout: " + box.getLayout());
			System.out.println("==> Descrição: " + box.getDescricao());
			//System.out.println("===>Permite Agencia: " + box.isPermiteAgencia());
			//System.out.println("===>Permite Cabal: " + box.isPermiteCabal());
			//System.out.println("===>Permite Central: " + box.isPermiteCentral());
			//System.out.println("===>Permite Emissor: " + box.isPermiteEmissor());
			System.out.println("=======================================================================================================");

			for(final TelaCampoDTO campo : box.getCampos()) {
				//System.out.println("======>Ordem: " + campo.getOrdem());
				System.out.println("==>Label: " + AutorizacaoUtil.preecherCaracter(campo.getLabel(), " ", 60, 1)  + "==>Valor: " + AutorizacaoUtil.preecherCaracter(campo.getValor(), " ", 120, 1) + " ==>Ajuda: " + AutorizacaoUtil.preecherCaracter(campo.getAjuda(), " ", 120, 1));
				//System.out.println("======>Tamanho: " + campo.getTamanho());
				//System.out.println("======>Nome Campo: " + campo.getNomeCampo());
				//System.out.println("======>Permite Agencia: " + campo.isPermiteAgencia());
				//System.out.println("======>Permite Cabal: " + campo.isPermiteCabal());
				//System.out.println("======>Permite Central: " + campo.isPermiteCentral());
				//System.out.println("======>Permite Emissor: " + campo.isPermiteEmissor());
			}
		}

		System.out.println("=======================================================================================================");
	}
}