package br.com.cabal.teste;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.enums.CodigoProcessamentoEnum;
import br.com.cabal.jautorizacao.enums.TipoMensagemEnum;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.SrvTransacaoOnlineService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteTrocaPontosAzul
{

	public static void main(final String[] args)
	{
		@SuppressWarnings("unused")
		TransacaoDTO dto = null;
		try
		{
			final SrvTransacaoOnlineService srv = (SrvTransacaoOnlineService) ServiceLocatorEJB.getInstance().getEjbObject(
					"srvConsumidorTransacaoOnline");
			for (int i = 0; i < 1; i++)
			{
				dto = enviarAutorizacao(srv);
				//enviarConfirmacao(srv, dto);
				//enviarDesfazimento(srv, dto);
				 //enviarCancelamento(srv);
			}
		}
		catch (final NamingException e)
		{
			e.printStackTrace();
		}
	}

	public static void enviarDesfazimento(final SrvTransacaoOnlineService srv, final TransacaoDTO obj)
	{
		TransacaoDTO dto = new TransacaoDTO();
		
 
		
		
		dto.setNroCartao("9995220003574226");
		dto.setNroAutid(804880l);
		dto.setCodResposta("00");
		dto.setCodProcessamento("002072");
		dto.setValorMe("50");
		dto.setDtHoraGMT("201150908");
		dto.setNsu("84975");
		dto.setDataString("0216");
		dto.setHora("150908");
		dto.setComercioExterno("000052100101001");
		dto.setDadosTransacaoOriginal("02008497502161509080000000000000000000000");
		dto.setOrigen("WEBCAB");
		dto.setImplementacaoMsg(TipoMensagemEnum.COMPRA_PONTOS_GENERICO);
		dto = srv.enviarDesfazimento(dto);
		System.out.println("Desfazimento...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Descrição: " + dto.getDescricaoResposta());
	}

	public static void enviarConfirmacao(final SrvTransacaoOnlineService srv, final TransacaoDTO obj)
	{
		TransacaoDTO dto = new TransacaoDTO();
		dto.setNroCartao("9995220003574226");
		dto.setNroAutid(804943l);
		dto.setCodResposta("99");
		dto.setImplementacaoMsg(TipoMensagemEnum.COMPRA_PONTOS_GENERICO);
		dto = srv.enviarConfirmacao(dto);
		System.out.println("Confirmacao...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Descrição: " + dto.getDescricaoResposta());
	}

	public static TransacaoDTO enviarAutorizacao(final SrvTransacaoOnlineService srv)
	{
		TransacaoDTO dto = new TransacaoDTO();
	       dto.setNroCartao("9995220003574226");
	        dto.setValorMe(String.valueOf("0001000000.0"));
	        dto.setImplementacaoMsg(TipoMensagemEnum.COMPRA_PONTOS_GENERICO);
	        dto.setCodProcessamento("002075");
	        dto.setDadosAdicionais("024024Troca de pontos - SMILES");
	        dto.setComercioExterno("000052100101001");

//			
//		dto.setNroCartao("9995220003574226");
//		dto.setCodProcessamento("002072");
//		dto.setValorMe("10,00");
//		dto.setComercioExterno("000052100101001");
//		dto.setNomeLocalComercio("COMPRA DE PONTOS B2W");
//		dto.setDadosAdicionais("Troca de Pontos - AMERICANAS - Cod.02-509558254");
//		dto.setImplementacaoMsg(TipoMensagemEnum.COMPRA_PONTOS_GENERICO);
		dto = srv.enviarAutorizacao(dto);
		System.out.println("Autorização...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Descrição: " + dto.getDescricaoResposta());
		return dto;
	}
	
	public static TransacaoDTO enviarCancelamento(SrvTransacaoOnlineService srv){
		
		TransacaoDTO dto = new TransacaoDTO();
	
		dto.setNroCartao("9995220003574226");
		dto.setCodProcessamento(CodigoProcessamentoEnum.COMPRA_TROCA_PONTOS_AZUL.getCodProcessamento());
		dto.setValorMe("10,00");
		dto.setComercioExterno("000052100101001");
		dto.setNomeLocalComercio(null);
		dto.setDadosAdicionais(null);
		dto.setDadosTransacaoOriginal("020014231908261028530000000000000000000000");

		dto.setImplementacaoMsg(TipoMensagemEnum.COMPRA_PONTOS_GENERICO);
		dto = srv.enviarCancelamento(dto);
		System.out.println("Cancelamento...");
		System.out.println("Autid: " + dto.getNroAutid());
		System.out.println("Código Resposta: " + dto.getCodResposta());
		System.out.println("Descrição: " + dto.getDescricaoResposta());
		return dto;	
	}
}
