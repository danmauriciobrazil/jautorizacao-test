package br.com.cabal.teste;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.dto.ceibo.TelaBoxDTO;
import br.com.cabal.jautorizacao.dto.ceibo.TelaCampoDTO;
import br.com.cabal.jautorizacao.dto.credito.LimitesContaDTO;
import br.com.cabal.jautorizacao.dto.credito.LimitesDispPortadorDTO;
import br.com.cabal.jautorizacao.dto.debcred.CascataTarifaAdmMensalDTO;
import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.enums.TipoMensagemEnum;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.SrvTransacaoBatchCreditoService;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.SrvTransacaoOnlineService;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.TransacaoService;
import br.com.cabal.jautorizacao.service.credito.interfaces.MonedaService;
import br.com.cabal.jautorizacao.service.dadosMonetarios.interfaces.DadosMonetariosService;
import br.com.cabal.jautorizacao.service.debcred.interfaces.CascataTarifaAdmMensalService;
import br.com.cabal.jautorizacao.service.hsm.interfaces.PinService;
import br.com.cabal.jautorizacao.service.hsm.interfaces.ResetAtcService;
import br.com.cabal.jautorizacao.util.AutorizacaoUtil;
import br.com.cabal.util.ServiceLocatorEJB;

public class ComponentesJAutorizacao {

	public static void main(String[] args) throws Exception {
			
		Scanner scan = new Scanner(System.in);
		System.out.println("Favor insira o IP e Porta : ");
		ServiceLocatorEJB.conexao = scan.nextLine();
		
		
		 
		TransacaoDTO dto = new TransacaoDTO();
		dto.setNroCartao("6035220014716319");
		dto.setNsu("900311");
		dto.setMerchantType(null);
		dto.setFuncaoTransacao("COMPRA");
		dto.setNroComercio(0l);
		dto.setCodResposta("00");// fixo
		dto.setCodInstituicao(String.valueOf(1));
		dto.setCodigoOperacao(1);
		dto.setNomeLocalComercio("BABIES                 BELO HORIZONT BR ");
		dto.setMoedaMe("986");
		dto.setMoedaMo("986");
		dto.setPlanoVenda(7);
		dto.setNroAutid(null);
		dto.setNroAutorizacao(755556l);
		dto.setNsuEstorno(0l);

		// campos obrigatorios
		dto.setTxJurosParcBanco(0.0);//
		dto.setTxJurosParcFinal(0.0);//
		dto.setValorMe("251.289");
		dto.setQtdParcela(1);
		dto.setValorCet(0.0);
		dto.setIofAdicional(0.0);//
		dto.setIofDiario(0.0);//
		dto.setDataVencPrimParcela(new Date(0l));//
		dto.setValorJurosTransacao(0.0); //
		dto.setData(new Date());
		dto.setBanTx("VI");
		dto.setBanCar("VI");
		dto.setTipoOperacao(15);
		dto.setIdTerminal(null);
		dto.setProducto(7l);
		dto.setCodInstituicao("1");
		dto.setHora(null);
		dto.setValorParcelaReal("10.28");//

		try
		{
			SrvTransacaoBatchCreditoService srv = (SrvTransacaoBatchCreditoService) ServiceLocatorEJB.getInstance().getEjbObject(
					"srvTransacaoBatchImpl");

			srv.enviarBatch(dto);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	
	
	try {
		CascataTarifaAdmMensalService srv = (CascataTarifaAdmMensalService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalServiceImpl");

		CascataTarifaAdmMensalDTO obj = srv.pesquisarCascataTarifaAdmMensal(756, 55, 60);
		
		if(obj != null){
			System.out.println(obj.getEmissor()         );
			System.out.println(obj.getPercMaxQtdContas());
			System.out.println(obj.getPercMinQtdContas());
			System.out.println(obj.getValorTarAdmMensal());
			System.out.println(obj.getValorTarAdmMensalCabal());
			System.out.println(obj.getValorTarAdmMensalVisa());
			obj.setValorTarAdmMensal(0.4);
			obj.setValorTarAdmMensalCabal(0.0);
			obj.setValorTarAdmMensalVisa(0.0);
			srv.alterarCascataTarifaAdmMensal(obj);
			System.out.println("Alterado!\n\n");
		}
		
	} catch (NamingException e) {
		e.printStackTrace();
	}

	try {
		final TransacaoService srv = (TransacaoService) ServiceLocatorEJB.getInstance().getEjbObject("transacaoServiceImpl");

		final List<TransacaoDTO> lista = srv.listarTransacoes("01/02/2016", "01/02/2016", "6042030000000038","CREDITO", false);

		for (final TransacaoDTO a : lista) {
			 
			System.out.println("Tabela:" + a.getTabelaOrigem());
			System.out.println("==============================");

			System.out.println("Tabela:" + a.getTabelaOrigem());

			System.out.println("1º QUADRANTE \n");

			System.out.println("Cartão :" + a.getNroCartao());
			System.out.println("Estado Cartão :" + a.getEstadoCartao());
			System.out.println("Conta Cartão :" + a.getNroConta());

			System.out.println("2 º QUADRANTE \n");

			System.out.println("Nome do Estabelecimento :" + a.getNomeLocalComercio()+"\n"+
			"End. do Estabelecimento :" + a.getEnderecoEstabelecimento()+"\n"+
			"Comercio Externo :" + a.getComercioExterno()+"\n"+
			"Id do Terminal :" + a.getIdTerminal()+"\n"+
			"Cod. Adquirente :" + a.getCodInstituicao()+"\n"+
			"Descrição Adquirente :" + a.getAdquirenteDescricao()+"\n"+
			"Ramo (MCC) :" + a.getRamo()+"\n"+
			"Descrição do Ramo (MCC)  :" + a.getDescricaoRamo()+"\n"+
			"UF Estabelecimento :" + a.getUfEstabelecimento());

			System.out.println("3 º QUADRANTE \n"+

			"Número da Autorização :" + a.getNroAutid()+"\n"+
			"Modo de Entrada :" + a.getModoEntrada()+"\n"+
			"Rede :" + a.getRedeCaptura()+"\n"+
			"Data/Hora da Rede :" + a.getDtHoraGMT()+"\n"+
			"Data/Hora :" + a.getDataString()+"\n"+
			"Fecha Negócio :" + a.getDataNegocio()+"\n"+
			"Resultado :" + a.getDescricaoResposta()+"\n"+
			"Valor em R$ :" + a.getValorMe()+"\n"+
			"Moeda R$ :" + a.getMoedaMe()+"\n"+
			"Valor em U$ :" + a.getValorMr()+"\n"+
			"Moeda U$ :" + a.getMoedaMo()+"\n"+
			"Parcelas em R$ :" + a.getValorParcelaReal()+"\n"+
			"Quantidade de Parcelas :" + a.getQtdParcela()+"\n"+
			"Cotação do Dólar :" + a.getCotacaoDolar()+"\n"+
			"Parcelas em U$ :" + a.getValorParcelaDolar()+"\n"+
			"NSU do Emissor :" + a.getNsuBanco()+"\n"+
			"NSU de Resposta :" + a.getNsuRespuesta()+"\n"+
			"NSU de Estorno :" + a.getNsuEstorno()+"\n"+
			"NSU da Rede :" + a.getNsu()+"\n"+
			"Modo de entrada Senha:" + a.getModoEntradaSenhaDescricao()+"\n"+
			"Tipo de Transação : " + a.getTipoOperacaoDescricao()+"\n"+
			"Autorizada online : " + a.getAutorizOnline()+"\n"+
			"Codigo  Interno :" + a.getCodRespostaInterno()+"\n"+
			"Descrição de resposta interna :" + a.getDescricaoResposta()+"\n"+
			"Autoriz Online :" + a.getDescAutorizOnline()+"\n"+
			"TIPo de Autorização:" + a.getTipoAutorizacao()+"\n"+
			"CODIGO operacion:" + a.getCodigoOperacao());

			System.out.println("4 º QUADRANTE \n"+

			"SecureCode :" + a.getAvaliacaoSecureCode()+"\n"+
			"Forma de Autenticação :" + a.getCAVV()+"\n"+
			"CVV2 :" + a.getAvaliacaoCVV2()+"\n"+
			"Criptograma (CHIP) :" + a.getAvaliacaoChip()+"\n"+
			"Transação enviada p/ PAYTRUE :" + a.envioParaPaytrue()+"\n"+
			"ID regra ofendida :" + a.getIdRegra()+"\n"+
			"Descriçaõ da Regra ofendida :" + a.getRegraOfendidaDescricao()+"\n\n"+
			
			"NSU Crédito :" + a.getNsuCredito());
		}

	}
	catch (final NamingException e) {
		e.printStackTrace();
		throw new Exception("Objeto de autorização inválido! Não permito objeto: ");

	}



	DadosMonetariosService srv = (DadosMonetariosService) ServiceLocatorEJB.getInstance().getEjbObject("dadosMonetariosServiceImpl");
	
	LimitesContaDTO limCtaDTO = new LimitesContaDTO();
	LimitesDispPortadorDTO limDispPort = new LimitesDispPortadorDTO();
	
	long cta = 9100001004107l;
	int componente = 1;
	
	limCtaDTO = srv.getLimitesConta(cta);

	limDispPort = srv.getLimitesDisponiveisConta(cta);

	limDispPort = srv.getLimitesDisponiveisAdicional(cta, componente);
	
	limDispPort = srv.getLimitesDisponiveisAdicional(cta, componente);

	System.out.println( "portador1:"+limCtaDTO.toString()+"\n"+
	"portador2:"+limDispPort.toString()+
			"Limite do adicional Portador 3 " + componente + ": " +limDispPort+"\n"+
	"portador: 4"+limDispPort.toString()+"\n \n");
	
	try {
		MonedaService me = (MonedaService) ServiceLocatorEJB.getInstance().getEjbObject("MonedaServiceImpl");
		System.out.println(me.getMonedaDTO(840).getDescripcion());
	} catch (NamingException e) {
		e.printStackTrace();
	}
	
	PinService pin = (PinService) ServiceLocatorEJB.getInstance().getEjbObject("pinServiceImpl");
	
	System.out.println( "Validando senha: " + pin.validarPinProcessadora("6043310000001015", "B79269C87A2710AF")+"\n\n\n");
	
	ResetAtcService atc = (ResetAtcService) ServiceLocatorEJB.getInstance().getEjbObject("resetAtcServiceImpl");
	String cartaoMaster ="5158940002995807";
	String funcao ="CREDITO";
	System.out.println( "Resultado : "+atc.ResetAtc(cartaoMaster,funcao)+"\n\n\n");

	
	try {
		final TransacaoService tran = (TransacaoService) ServiceLocatorEJB.getInstance().getEjbObject("transacaoServiceImpl");
		
		final  List<TelaBoxDTO> listaTela  =  tran.obterTransacaoParaTela("6043310000001015",591816, "24/01/2016 21:32:30", "CREDITO", false);
		
		imprimeTransacao(listaTela);

	} catch (final NamingException e) {
		e.printStackTrace();

	}
}

public static TransacaoDTO imprimeTransacao(final List<TelaBoxDTO> reg) throws Exception {

	for(final TelaBoxDTO box : reg) {
		System.out.println( "==================================================BOX==================================================");
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




try
{
	final SrvTransacaoOnlineService srv = (SrvTransacaoOnlineService) ServiceLocatorEJB.getInstance().getEjbObject(
			"srvConsumidorTransacaoOnline");
	for (int i = 0; i < 1; i++)
	{
		enviarAutorizacaoT(srv);
		enviarAutorizacao(srv);
	}
}
catch (final NamingException e)
{
	e.printStackTrace();
}
return null;
}

private static TransacaoDTO enviarAutorizacao(SrvTransacaoOnlineService srv) {
	TransacaoDTO dto = new TransacaoDTO();
	dto.setNroCartao("9995220003574226");
	dto.setCodProcessamento("002072");
	dto.setValorMe("10,00");
	dto.setComercioExterno("000052100101001");
	dto.setNomeLocalComercio("COMPRA DE PONTOS B2W");
	dto.setDadosAdicionais("Troca de Pontos - AMERICANAS - Cod.02-509558254");
	dto.setImplementacaoMsg(TipoMensagemEnum.COMPRA_PONTOS_GENERICO);
	dto = srv.enviarAutorizacao(dto);
	System.out.println( 
	"\n\n\nAutorização..."
	+"Autid: " + dto.getNroAutid()
	+"Código Resposta: " + dto.getCodResposta()
	+"Descrição: " + dto.getDescricaoResposta());
	return dto;
}

private static TransacaoDTO enviarAutorizacaoT(SrvTransacaoOnlineService srv) {
	TransacaoDTO dto = new TransacaoDTO();

	dto.setTipoMensagem("9000");
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
	dto.setCodProcessamento("303000"); // devo validar o range definido no doc?
	// dto.setTipoParcelado("20"); //não obrigatório
	// dto.setQtdParcelaString("2"); //não obrigatório
	// Código de resposta apenas saída
	// Descrição da resposta apenas saída
	// dto.setSenha("06BA1B045F5E64E3"); //não obrigatório. 003000 003020 é obrigatório
	dto.setDadosTransacaoOriginal(null); // não obrigatório, apenas para desfazimento
	dto.setModoEntrada("051");
	dto.setTrilha("5156010000209939=19082019430000000000"); // não obrigatório
	// dto.setDadosChipCartao("5F2A02098682025800950500000080009A031503189C01009F02060000000037879F03060000000000009F10120010A500030200002E6D00000000000000FF9F1A0200769F2608CF5ADF4C4A14B57D9F2701809F3303E0F8E89F3602023B9F3704B7FD73669F3403410302");
	// //não obrigatório
	// dto.setCvv2("793"); //não obrigatório
	dto.setVencimentoCartao("1908"); // não obrigatório
	// Dados do Parcelamento (CET) apenas saída
	//dto.setDadosAdicionais("T420701032109203120"); // não obrigatório

	dto.setImplementacaoMsg(TipoMensagemEnum.TRANSACAO_ON_US);
	dto = srv.enviarAutorizacao(dto);

	System.out.println( 
	"\n\n\nAutorização..."
	+"Autid: " + dto.getNroAutid()
	+"Código Resposta: " + dto.getCodResposta()
	+"Código Resposta Interno: " + dto.getCodRespostaInterno()
	+"Saldo de Saque: " +dto.getSaldoSaque()
	+"Saldo de Parcelado: " +dto.getSaldoParcelado()
	+"Saldo de A vista: " +dto.getSaldoAVista()
	+"Descrição: " + dto.getDescricaoResposta());

	return dto;
}
}
