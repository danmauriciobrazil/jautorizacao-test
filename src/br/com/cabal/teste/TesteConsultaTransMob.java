package br.com.cabal.teste;

import java.util.List;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.TransacaoMobService;
import br.com.cabal.util.ServiceLocatorEJB;

/**
 * @author danilo.silva
 *
 */
public class TesteConsultaTransMob {

	public static void main(final String[] args) throws Exception {
		try {
			final TransacaoMobService srv = (TransacaoMobService) ServiceLocatorEJB.getInstance().getEjbObject("transacaoMobServiceImpl");

			// List<TransacaoDTO> lista = srv.listarTransacoes("15/06/2016", "16/06/2016", 7563049133535l, 1, "CREDITO");

			List<TransacaoDTO> lista = srv.listarTransacoes("01/06/2016", "30/06/2016", 7563049133535l, 1, "DEBITO");

			// final List<TransacaoDTO> lista =
			// srv.listarTransacoes("01/11/2015", "30/11/2015",
			// "5127070018399980", "CREDITO", false);

			// final List<TransacaoDTO> lista =
			// srv.listarTransacoes("18/05/2015", "20/05/2015",
			// "9995220000754375", "CONVENIO", false);

			// final TransacaoDTO transacao =
			// srv.obterTransacao("6042034001475413", 265890,
			// "22/07/2015 07:06:49", "DEBITO", false);

			// MasterCard para testar cavv.
			// final TransacaoDTO transacao =
			// srv.obterTransacao("6042034001729099", 795691,
			// "05/09/2014 14:06:57", "CREDITO", false);

			// Visa para testar cavv.
			// final TransacaoDTO transacao = srv.obterTransacao(832284l,
			// "06/05/2016 18:09:23", 7563144169778l, 2, "CREDITO");

			// imprimeTransacao(transacao);

			for (final TransacaoDTO a : lista) {
				imprimeTransacao(a);

			}

		} catch (final NamingException e) {
			e.printStackTrace();
			throw new Exception("Objeto de autorização inválido! Não permito objeto: ");

		}
	}

	public static void imprimeTransacao(final TransacaoDTO reg) {
		System.out.println("==============================");
		System.out.println("Cartão :" + reg.getNroCartao());
		System.out.println("Componente :" + reg.getComponente());
		System.out.println("Data Negócio :" + reg.getDataNegocio());
		System.out.println("Valor da transação :" + reg.getValorTransacaoMe());
		System.out.println("Valor da transação :" + reg.getValorTransacaoMo());
		System.out.println("Valor da transação :" + reg.getValorTransacaoMr());
		System.out.println("Numero da autorização :" + reg.getNroAutid());
		System.out.println("Descrição resposta :" + reg.getDescricaoResposta());
		System.out.println("Nome Comércio :" + reg.getNomeComercio());
		System.out.println("Cidade do comércio :" + reg.getNomeLocalComercio());
		System.out.println("Ramo: " + reg.getMccRede());
		System.out.println("Parcelado: " + reg.getQtdParcela());
		System.out.println("Local Internacional: " + reg.getLocalInternacional());
		System.out.println(" Sinal Crédito ou Débito: " + reg.getCodigoOperacaoDetalhado());
		System.out.println("Numero de parcela: " + reg.getNroParcela());
		System.out.println("Quantidade de Parcelas: " + reg.getQtdParcela());
		System.out.println("Codigo operação: " + reg.getCodigoOperacao());

	}

}
