package br.com.cabal.teste;

import java.util.Date;

import br.com.cabal.jautorizacao.dto.transacao.TransacaoDTO;
import br.com.cabal.jautorizacao.exceptions.CartaoNaoEncontradoException;
import br.com.cabal.jautorizacao.exceptions.ContaNaoEncontadaException;
import br.com.cabal.jautorizacao.exceptions.ObjetoTransacaoInvalidoException;
import br.com.cabal.jautorizacao.exceptions.ValorNaoInformadoException;
import br.com.cabal.jautorizacao.service.autorizacao.interfaces.SrvTransacaoBatchCreditoService;
import br.com.cabal.util.ServiceLocatorEJB;

public class TesteAutorizacaoFicticia
{

	public static void main(String[] args) throws ObjetoTransacaoInvalidoException, CartaoNaoEncontradoException,
			ContaNaoEncontadaException, ValorNaoInformadoException
	{

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

	}

}
