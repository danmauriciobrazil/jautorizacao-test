package br.com.cabal.teste;

import javax.naming.NamingException;

import br.com.cabal.jautorizacao.dto.debcred.CascataTarifaAdmMensalDTO;
import br.com.cabal.jautorizacao.service.debcred.interfaces.CascataTarifaAdmMensalService;
import br.com.cabal.util.ServiceLocatorEJB;








public class TesteCascataTarifaAdm {
	public static void main(String[] args) throws Exception {
//		try {
//			CascataTarifaAdmMensalService srv = (CascataTarifaAdmMensalService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalServiceImpl");
//
//			List<CascataTarifaAdmMensalDTO> lista = srv.pesquisarCascataTarifaAdmMensalOrdEmiPercMin();
//			
//			for(CascataTarifaAdmMensalDTO obj : lista){
//				System.out.println(obj.getEmissor()         );
//				System.out.println(obj.getPercMaxQtdContas());
//				System.out.println(obj.getPercMinQtdContas());
//				System.out.println(obj.getValorTarAdmMensal());
//				System.out.println(obj.getValorTarAdmMensalCabal());
//				System.out.println(obj.getValorTarAdmMensalVisa());
//			}
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}


		
//		try {
//			CascataTarifaAdmMensalService srv = (CascataTarifaAdmMensalService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalServiceImpl");
//
//			CascataTarifaAdmMensalDTO obj = new CascataTarifaAdmMensalDTO();
//			
//			obj.setEmissor(756);
//			obj.setPercMaxQtdContas(99);
//			obj.setPercMinQtdContas(88);
//			obj.setValorTarAdmMensal(11.99);
//			obj.setValorTarAdmMensalCabal(12.88);
//			obj.setValorTarAdmMensalVisa(13.77);
//			
//			srv.cadastrarCascataTarifaAdmMensal(obj);
//		
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		
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
				System.out.println("Alterado!");
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
//		try {
//			CascataTarifaAdmMensalService srv = (CascataTarifaAdmMensalService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalServiceImpl");
//
//			srv.excluirCascataTarifaAdmMensal(756, 55, 60);
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		
		
//		try {
//			CascataTarifaAdmMensalExcecaoService srv = (CascataTarifaAdmMensalExcecaoService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalExcecaoServiceImpl");
//	
//			List<CascataTarifaAdmMensalExcecaoDTO> lista = srv.pesquisarCascataTarAdmMensalExcOrderPeriodoProm(756, 3027);
//			
//			for(CascataTarifaAdmMensalExcecaoDTO obj : lista){
//				System.out.println(obj.getEmissor()         );
//				System.out.println(obj.getCooperativa());
//				System.out.println(obj.getPeriodoPromocao());
//				System.out.println(obj.getValorTarAdmMensal());
//			}
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}

		
//		try {
//			CascataTarifaAdmMensalExcecaoService srv = (CascataTarifaAdmMensalExcecaoService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalExcecaoServiceImpl");
//	
//			CascataTarifaAdmMensalExcecaoDTO obj = new CascataTarifaAdmMensalExcecaoDTO();
//			
//			obj.setEmissor(756);
//			obj.setCooperativa(3027);
//			obj.setPeriodoPromocao(201406);
//			obj.setValorTarAdmMensal(999.77);
//
//			srv.cadastrarCascataTarAdmMensalExc(obj);
//		
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
	
	
//		try {
//			CascataTarifaAdmMensalExcecaoService srv = (CascataTarifaAdmMensalExcecaoService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalExcecaoServiceImpl");
//	
//			CascataTarifaAdmMensalExcecaoDTO obj = srv.pesquisarCascataTarAdmMensalExc(756, 3027, 201406);
//			
//			if(obj != null){
//				System.out.println(obj.getEmissor()          );
//				System.out.println(obj.getCooperativa()      );
//				System.out.println(obj.getPeriodoPromocao()  );
//				System.out.println(obj.getValorTarAdmMensal());
//				
//				obj.setValorTarAdmMensal(11.0);
//				
//				srv.alterarCascataTarAdmMensalExc(obj);
//		
//				System.out.println("Alterado!");
//			}
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			CascataTarifaAdmMensalExcecaoService srv = (CascataTarifaAdmMensalExcecaoService) ServiceLocatorEJB.getInstance().getEjbObject("cascataTarifaAdmMensalExcecaoServiceImpl");
//	
//			srv.excluirCascataTarAdmMensalExc(756, 3027, 201309);
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		
		
	}
	
}
