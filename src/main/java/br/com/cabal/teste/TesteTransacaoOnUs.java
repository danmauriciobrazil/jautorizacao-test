package br.com.cabal.teste;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.enums.TipoMensagemEnum;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.SrvTransacaoOnlineService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteTransacaoOnUs {

	public static void main(final String[] args) {
		@SuppressWarnings("unused")
		TransacaoDTO dto = null;
		try {
			final SrvTransacaoOnlineService srv = (SrvTransacaoOnlineService) ServiceLocatorEJB.getInstance().getEjbObject("srvConsumidorTransacaoOnline");
			for (int i = 0; i < 1; i++) {
				dto = enviarAutorizacao(srv);
				// enviarConfirmacao(srv, dto);
				// enviarDesfazimento(srv, dto);
				// enviarCancelamento(srv);
			}
		} catch (final NamingException e) {
			e.printStackTrace();
		}
	}

	public static TransacaoDTO enviarAutorizacao(final SrvTransacaoOnlineService srv) {
		TransacaoDTO dto = new TransacaoDTO();

		dto.setTipoMensagem("0100");
		dto.setNroCartao("6043319000000133");
		dto.setNroCartao("4660700000015139");
		dto.setNsu("7087");
		// Nº autorização apenas saída
		dto.setComercioExterno("51000181000");
		dto.setNomeComercio("LOJA");
		dto.setCidadeComercio("CIDADE");
		dto.setUfEstabelecimento("DF");
		dto.setIdTerminal("PV819999");
		dto.setMccRede("5541"); // não obrigatório
		dto.setHora("092427");
		dto.setDataString("0417");
		dto.setDtHoraGMT("1212112427");
		dto.setCodInstituicao("13485");
		dto.setValorMe("120");
		dto.setMoedaMe("986");
		// Valor da parcela apenas à vista
		// Saldo disponível à vista apenas saída
		// Saldo disponível parcelado apenas saída
		dto.setCodProcessamento("303000"); // devo validar o range definido no
											// doc?
		// dto.setTipoParcelado("20"); //não obrigatório
		// dto.setQtdParcelaString("2"); //não obrigatório
		// Código de resposta apenas saída
		// Descrição da resposta apenas saída
		// dto.setSenha("06BA1B045F5E64E3"); //não obrigatório. 003000 003020 é
		// obrigatório
		dto.setDadosTransacaoOriginal(null); // não obrigatório, apenas para
												// desfazimento
		dto.setModoEntrada("051");
		dto.setTrilha("5156010000209939=19082019430000000000"); // não
																// obrigatório
		// dto.setDadosChipCartao("5F2A02098682025800950500000080009A031503189C01009F02060000000037879F03060000000000009F10120010A500030200002E6D00000000000000FF9F1A0200769F2608CF5ADF4C4A14B57D9F2701809F3303E0F8E89F3602023B9F3704B7FD73669F3403410302");
		// //não obrigatório
		// dto.setCvv2("793"); //não obrigatório
		dto.setVencimentoCartao("1908"); // não obrigatório
		// Dados do Parcelamento (CET) apenas saída
		// dto.setDadosAdicionais("T420701032109203120"); // não obrigatório

		dto.setImplementacaoMsg(TipoMensagemEnum.TRANSACAO_ON_US);
		dto = srv.enviarAutorizacao(dto);

		System.out.println("Autorização...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Código Resposta Interno: " + dto.getCodRespostaInterno());
		System.out.println("Saldo de Saque: " + dto.getSaldoSaque());
		System.out.println("Saldo de Parcelado: " + dto.getSaldoParcelado());
		System.out.println("Saldo de A vista: " + dto.getSaldoAVista());
		System.out.println("Descrição: " + dto.getDescricaoResposta());

		return dto;
	}

	public static void enviarConfirmacao(final SrvTransacaoOnlineService srv, final TransacaoDTO obj) {
		TransacaoDTO dto = new TransacaoDTO();

		dto.setTipoMensagem("0202");
		dto.setNroCartao("5156010000209939");
		dto.setNsu("111111");
		dto.setNroAutorizacao(813164l);
		dto.setIdTerminal("PV819999");
		dto.setCodProcessamento("003000");
		dto.setDataString("1008");
		dto.setHora("092427");
		dto.setDtHoraGMT("1212112427");
		dto.setCodInstituicao("13485");
		dto.setCodResposta("00");
		dto.setDadosTransacaoOriginal("010011111112121124270000001348500000000000");

		dto.setImplementacaoMsg(TipoMensagemEnum.TRANSACAO_ON_US);
		dto = srv.enviarConfirmacao(dto);

		System.out.println("Confirmação...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Código Resposta Interno: " + dto.getCodRespostaInterno());
		System.out.println("Descrição: " + dto.getDescricaoResposta());
	}

	public static void enviarDesfazimento(final SrvTransacaoOnlineService srv, final TransacaoDTO obj) {
		TransacaoDTO dto = new TransacaoDTO();

		dto.setTipoMensagem("0420");
		dto.setNroCartao("5156010000209939");
		dto.setNsu("111111");
		dto.setIdTerminal("PV819999");
		dto.setCodProcessamento("203000");
		dto.setDataString("0417");
		dto.setHora("092427");
		dto.setDtHoraGMT("1212112427");
		dto.setCodInstituicao("13485");
		dto.setCodResposta("00");
		dto.setDadosTransacaoOriginal("010011111112121124270000001348500000000000");

		dto.setImplementacaoMsg(TipoMensagemEnum.TRANSACAO_ON_US);
		dto = srv.enviarDesfazimento(dto);

		System.out.println("Desfazimento...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Descrição: " + dto.getDescricaoResposta());
	}

	public static TransacaoDTO enviarCancelamento(final SrvTransacaoOnlineService srv) {
		TransacaoDTO dto = new TransacaoDTO();

		dto.setTipoMensagem("0400");
		dto.setNroCartao("6043319000040360");
		dto.setNsu("1234");
		// Nº autorização apenas saída
		dto.setComercioExterno("001234");
		dto.setNomeComercio("ESTORNO");
		dto.setCidadeComercio("BARUERI");
		dto.setUfEstabelecimento("SP");
		dto.setIdTerminal("NEXXPAGO");
		dto.setModoEntrada("051");
		dto.setHora("092427");
		dto.setDataString("0917");
		dto.setDtHoraGMT("1212112427");
		dto.setCodInstituicao("00000001111");
		dto.setValorMe("1,23");
		dto.setMoedaMe("986");
		// Valor da parcela apenas à vista
		// Saldo disponível à vista apenas saída
		// Saldo disponível parcelado apenas saída
		dto.setCodProcessamento("280000"); // devo validar o range definido no
											// doc?
		// dto.setTipoParcelado(null); // não obrigatório
		// dto.setQtdParcela(1); // não obrigatório
		// // Código de resposta apenas saída
		// // Descrição da resposta apenas saída
		// dto.setSenha("06BA1B045F5E64E3"); // não obrigatório. 003000 003020 é
		// obrigatório
		// dto.setDadosTransacaoOriginal(null); // não obrigatório, apenas para
		// desfazimento
		// dto.setModoEntrada("051");
		// dto.setTrilha("5156010000209939=19082019430000000000"); // não
		// obrigatório
		// dto.setDadosChipCartao("5F2A02098682025800950500000080009A031503189C01009F02060000000037879F03060000000000009F10120010A500030200002E6D00000000000000FF9F1A0200769F2608CF5ADF4C4A14B57D9F2701809F3303E0F8E89F3602023B9F3704B7FD73669F3403410302");
		// // não
		// obrigatório
		// dto.setCvv2("793"); // não obrigatório
		// dto.setVencimentoCartao("1908"); // não obrigatório
		// Dados do Parcelamento (CET) apenas saída
		dto.setDadosTransacaoOriginal("010009395309180939540000000111100000000000");
		// dto.setDadosAdicionais("AAAAAAAAAA"); // não obrigatório

		/*
		 * dto.setNetWorkData("AAAAAAAAAA");
		 * dto.setInformacoesEstabelecimento("AAAAAAAAAA");
		 */

		dto.setImplementacaoMsg(TipoMensagemEnum.TRANSACAO_ON_US);
		dto = srv.enviarCancelamento(dto);

		System.out.println("Cancelamento...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Código Resposta Interno: " + dto.getCodRespostaInterno());
		System.out.println("Descrição: " + dto.getDescricaoResposta());

		return dto;
	}

}
