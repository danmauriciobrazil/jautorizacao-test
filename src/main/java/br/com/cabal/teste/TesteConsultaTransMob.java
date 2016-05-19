package br.com.cabal.teste;

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

			//List<TransacaoDTO> lista = srv.listarTransacoes("04/01/2016" , "05/01/2016", 7563009317773l, 1, "CREDITO");
			
//			List<TransacaoDTO> lista = srv.listarTransacoes(dataInicial, dataFinal, contaComponente, componente, funcao);


			//final List<TransacaoDTO> lista = srv.listarTransacoes("01/11/2015", "30/11/2015", "5127070018399980", "CREDITO", false);

			 //final List<TransacaoDTO> lista = srv.listarTransacoes("18/05/2015", "20/05/2015", "9995220000754375", "CONVENIO", false);

			// final TransacaoDTO transacao = srv.obterTransacao("6042034001475413", 265890, "22/07/2015 07:06:49", "DEBITO", false);

				//MasterCard para testar cavv.
			//final TransacaoDTO transacao = srv.obterTransacao("6042034001729099", 795691, "05/09/2014 14:06:57", "CREDITO", false);
				
			 	//Visa para testar cavv.
			 final TransacaoDTO transacao = srv.obterTransacao(832284l, "06/05/2016 18:09:23", 7563144169778l, 2, "CREDITO");

		imprimeTransacao(transacao);

//			for (final TransacaoDTO a : lista) {
//				imprimeTransacao(a);
//
//			}

		}
		catch (final NamingException e) {
			e.printStackTrace();
			throw new Exception("Objeto de autoriza��o inv�lido! N�o permito objeto: ");

		}
	}

	public static void imprimeTransacao(final TransacaoDTO reg) {
		System.out.println("==============================");

		System.out.println("Tabela:" + reg.getTabelaOrigem());

		System.out.println("1� QUADRANTE \n");

		System.out.println("Cart�o :" + reg.getNroCartao());
		System.out.println("Estado Cart�o :" + reg.getEstadoCartao());
		System.out.println("Conta Cart�o :" + reg.getNroConta() + "\n");

		System.out.println("2 � QUADRANTE \n");

		System.out.println("Nome do Estabelecimento :" + reg.getNomeLocalComercio());
		System.out.println("End. do Estabelecimento :" + reg.getEnderecoEstabelecimento());
		System.out.println("Comercio Externo :" + reg.getComercioExterno());
		System.out.println("Id do Terminal :" + reg.getIdTerminal());
		System.out.println("Cod. Adquirente :" + reg.getCodInstituicao());
		System.out.println("Descri��o Adquirente :" + reg.getAdquirenteDescricao());
		System.out.println("Ramo (MCC) :" + reg.getRamo());
		System.out.println("Descri��o do Ramo (MCC)  :" + reg.getDescricaoRamo());
		System.out.println("UF Estabelecimento :" + reg.getUfEstabelecimento() + "\n");

		System.out.println("3 � QUADRANTE \n");

		System.out.println("N�mero da Autoriza��o :" + reg.getNroAutid());
		System.out.println("Modo de Entrada :" + reg.getModoEntrada());
		System.out.println("Rede :" + reg.getRedeCaptura());
		System.out.println("Data/Hora da Rede :" + reg.getDtHoraGMT());
		System.out.println("Data/Hora :" + reg.getDataString());
		System.out.println("Fecha Neg�cio :" + reg.getDataNegocio());
		System.out.println("Resultado :" + reg.getDescricaoResposta());
		System.out.println("Valor em R$ :" + reg.getValorMe());
		System.out.println("Moeda R$ :" + reg.getMoedaMe());
		System.out.println("Valor em U$ :" + reg.getValorMr());
		System.out.println("Moeda U$ :" + reg.getMoedaMo());
		System.out.println("Parcelas em R$ :" + reg.getValorParcelaReal());
		System.out.println("Quantidade de Parcelas :" + reg.getQtdParcela());
		System.out.println("Cota��o do D�lar :" + reg.getCotacaoDolar());
		System.out.println("Parcelas em U$ :" + reg.getValorParcelaDolar());
		System.out.println("NSU do Emissor :" + reg.getNsuBanco());
		System.out.println("NSU de Resposta :" + reg.getNsuRespuesta());
		System.out.println("NSU de Estorno :" + reg.getNsuEstorno());
		System.out.println("NSU da Rede :" + reg.getNsu());
		System.out.println("Modo de entrada Senha:" + reg.getModoEntradaSenhaDescricao());
		System.out.println("Tipo de Transa��o : " + reg.getTipoOperacaoDescricao());
		System.out.println("Autorizada online : " + reg.getAutorizOnline());
		System.out.println("Codigo  Interno :" + reg.getCodRespostaInterno());
		System.out.println("Descri��o de resposta interna :" + reg.getDescricaoResposta());
		System.out.println("Autoriz Online :" + reg.getDescAutorizOnline());
		System.out.println("TIPo de Autoriza��o:" + reg.getTipoAutorizacao());
		System.out.println("CODIGO operacion:" + reg.getCodigoOperacao());
		System.out.println("NSU do Mobile: "+ reg.getNsuMob());
		System.out.println("Id da tarjeta virtual: "+ reg.getIdTarjetaVirtual());
		

		System.out.println("4 � QUADRANTE \n");

		System.out.println("SecureCode :" + reg.getAvaliacaoSecureCode());
		System.out.println("Forma de Autentica��o :" + reg.getCAVV());
		System.out.println("CVV2 :" + reg.getAvaliacaoCVV2());
		System.out.println("Criptograma (CHIP) :" + reg.getAvaliacaoChip());
		System.out.println("Transa��o enviada p/ PAYTRUE :" + reg.envioParaPaytrue());
		System.out.println("ID regra ofendida :" + reg.getIdRegra());
		System.out.println("Descri�a� da Regra ofendida :" + reg.getRegraOfendidaDescricao());
		
	
		
	}

	
}
