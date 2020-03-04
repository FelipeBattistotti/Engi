package br.com.engi.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.engi.dao.DAO2;
import br.com.engi.model.Chart;
import br.com.engi.model.FatoVlbenefFatura;

@ManagedBean(name = "sinistralidadeBean")
@ViewScoped
public class SinistralidadeBean {
	
	/** atributos **/
	
	private Date selectedPeriodo1;
	private Date selectedPeriodo2;
	private String mensagem;
	
	/** métodos **/
	
	
	/** findFatoVlBenefFatura **/
    public void findFatoVlBenefFatura() {
    	List<FatoVlbenefFatura> premioList1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> premioList2 = new ArrayList<FatoVlbenefFatura>();
		
		List<FatoVlbenefFatura> sinistroList1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroList2 = new ArrayList<FatoVlbenefFatura>();
		
		List<FatoVlbenefFatura> sinistroFx1List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx2List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx3List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx4List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx5List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx6List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx7List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx8List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx9List1 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx10List1 = new ArrayList<FatoVlbenefFatura>();
		
		List<FatoVlbenefFatura> sinistroFx1List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx2List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx3List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx4List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx5List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx6List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx7List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx8List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx9List2 = new ArrayList<FatoVlbenefFatura>();
		List<FatoVlbenefFatura> sinistroFx10List2 = new ArrayList<FatoVlbenefFatura>();
		
		DAO2 dao2 = new DAO2();
		Chart chart = new Chart();
		
		Integer nrMes1 = 0;
		Integer nrMes2 = 0;
		Integer nrAno1 = 0;
		Integer nrAno2 = 0;
		String periodo1 = "";
		String periodo2 = "";
		
		BigDecimal vlPremioPer1 = BigDecimal.ZERO;
		BigDecimal vlPremioPer2 = BigDecimal.ZERO;
		BigDecimal vlSinistroPer1 = BigDecimal.ZERO;
		BigDecimal vlSinistroPer2 = BigDecimal.ZERO;
		BigDecimal percSinistralidade1 = BigDecimal.ZERO;
		BigDecimal percSinistralidade2 = BigDecimal.ZERO;
		
		BigDecimal vlSinistroFx1Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx2Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx3Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx4Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx5Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx6Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx7Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx8Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx9Per1 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx10Per1 = BigDecimal.ZERO;
		
		BigDecimal vlSinistroFx1Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx2Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx3Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx4Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx5Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx6Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx7Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx8Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx9Per2 = BigDecimal.ZERO;
		BigDecimal vlSinistroFx10Per2 = BigDecimal.ZERO;
		
		BigDecimal percFx1Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx2Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx3Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx4Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx5Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx6Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx7Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx8Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx9Sinistralidade1 = BigDecimal.ZERO;
		BigDecimal percFx10Sinistralidade1 = BigDecimal.ZERO;
		
		BigDecimal percFx1Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx2Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx3Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx4Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx5Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx6Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx7Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx8Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx9Sinistralidade2 = BigDecimal.ZERO;
		BigDecimal percFx10Sinistralidade2 = BigDecimal.ZERO;
		
		
		DecimalFormat decFormat = new java.text.DecimalFormat("##0.00 '%'"); //coloca um format no objeto BigDecimal
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); //coloca um format no objeto Calendar
		
		periodo1 = formatador.format(getSelectedPeriodo1()); //captura data selecionada do calendário em tela
		periodo2 = formatador.format(getSelectedPeriodo2());
		
		nrMes1 = Integer.valueOf(periodo1.substring(3, 5));
		nrAno1 = Integer.valueOf(periodo1.substring(6, 10));
		nrMes2 = Integer.valueOf(periodo2.substring(3, 5));
	    nrAno2 = Integer.valueOf(periodo2.substring(6, 10));
		
		/** realiza consulta - chama classe DAO **/
	    //premioList1 = dao2.consultaPremio(nrMes1, nrAno1); // 01/2016
	    //premioList2 = dao2.consultaPremio(nrMes2, nrAno2); // 01/2017
	    
	    //sinistroList1 = dao2.consultaSinistro(nrMes1, nrAno1); // 01/2016
	    //sinistroList2 = dao2.consultaSinistro(nrMes2, nrAno2); // 01/2017
	    
	    /*sinistroFx1List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 1); // 01/2016
	    sinistroFx2List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 2); // 01/2016
	    sinistroFx3List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 3); // 01/2016
	    sinistroFx4List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 4); // 01/2016
	    sinistroFx5List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 5); // 01/2016
	    sinistroFx6List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 6); // 01/2016
	    sinistroFx7List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 7); // 01/2016
	    sinistroFx8List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 8); // 01/2016
	    sinistroFx9List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 9); // 01/2016
	    sinistroFx10List1 = dao2.consultaSinistroFaixa(nrMes1, nrAno1, 10); // 01/2016
	    
	    sinistroFx1List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 1); // 01/2017
	    sinistroFx2List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 2); // 01/2017
	    sinistroFx3List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 3); // 01/2017
	    sinistroFx4List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 4); // 01/2017
	    sinistroFx5List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 5); // 01/2017
	    sinistroFx6List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 6); // 01/2017
	    sinistroFx7List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 7); // 01/2017
	    sinistroFx8List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 8); // 01/2017
	    sinistroFx9List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 9); // 01/2017
	    sinistroFx10List2 = dao2.consultaSinistroFaixa(nrMes2, nrAno2, 10); // 01/2017
*/		
	    
	    /*for(FatoVlbenefFatura fatoVlbenefFatura : premioList1) {
	    	vlPremioPer1 = vlPremioPer1.add(fatoVlbenefFatura.getVlTotal());
	    }
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroList1) {
	    	vlSinistroPer1 = vlSinistroPer1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percSinistralidade1 = vlSinistroPer1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percSinistralidade1 = percSinistralidade1.multiply(new BigDecimal(100));*/
	    
	    /*for(FatoVlbenefFatura fatoVlbenefFatura : premioList2) {
	    	vlPremioPer2 = vlPremioPer2.add(fatoVlbenefFatura.getVlTotal());
	    }
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroList2) {
	    	vlSinistroPer2 = vlSinistroPer2.add(fatoVlbenefFatura.getVlUsuario());
	    }*/
	    
	    vlPremioPer1        = new BigDecimal(193888318);
	    vlSinistroPer1      = new BigDecimal(98529696);
	    percSinistralidade1 = vlSinistroPer1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percSinistralidade1 = percSinistralidade1.multiply(new BigDecimal(100));
	    
	    vlPremioPer2        = new BigDecimal(212932593);
	    vlSinistroPer2      = new BigDecimal(147690632);
	    percSinistralidade2 = vlSinistroPer2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percSinistralidade2 = percSinistralidade2.multiply(new BigDecimal(100));
	    
	    /*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx1List1) {
	    	vlSinistroFx1Per1 = vlSinistroFx1Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx1Sinistralidade1 = vlSinistroFx1Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx1Sinistralidade1 = percFx1Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx1List2) {
	    	vlSinistroFx1Per2 = vlSinistroFx1Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx1Sinistralidade2 = vlSinistroFx1Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx1Sinistralidade2 = percFx1Sinistralidade2.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx2List1) {
	    	vlSinistroFx2Per1 = vlSinistroFx2Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx2Sinistralidade1 = vlSinistroFx2Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx2Sinistralidade1 = percFx2Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx2List2) {
	    	vlSinistroFx2Per2 = vlSinistroFx2Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx2Sinistralidade2 = vlSinistroFx2Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx2Sinistralidade2 = percFx2Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx3List1) {
	    	vlSinistroFx3Per1 = vlSinistroFx3Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx3Sinistralidade1 = vlSinistroFx3Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx3Sinistralidade1 = percFx3Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx3List2) {
	    	vlSinistroFx3Per2 = vlSinistroFx3Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx3Sinistralidade2 = vlSinistroFx3Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx3Sinistralidade2 = percFx3Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx4List1) {
	    	vlSinistroFx4Per1 = vlSinistroFx4Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx4Sinistralidade1 = vlSinistroFx4Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx4Sinistralidade1 = percFx4Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx4List2) {
	    	vlSinistroFx4Per2 = vlSinistroFx4Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx4Sinistralidade2 = vlSinistroFx4Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx4Sinistralidade2 = percFx4Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx5List1) {
	    	vlSinistroFx5Per1 = vlSinistroFx5Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx5Sinistralidade1 = vlSinistroFx5Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx5Sinistralidade1 = percFx5Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx5List2) {
	    	vlSinistroFx5Per2 = vlSinistroFx5Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx5Sinistralidade2 = vlSinistroFx5Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx5Sinistralidade2 = percFx5Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx6List1) {
	    	vlSinistroFx6Per1 = vlSinistroFx6Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx6Sinistralidade1 = vlSinistroFx6Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx6Sinistralidade1 = percFx6Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx6List2) {
	    	vlSinistroFx6Per2 = vlSinistroFx6Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx6Sinistralidade2 = vlSinistroFx6Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx6Sinistralidade2 = percFx6Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx7List1) {
	    	vlSinistroFx7Per1 = vlSinistroFx7Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx7Sinistralidade1 = vlSinistroFx7Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx7Sinistralidade1 = percFx7Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx7List2) {
	    	vlSinistroFx7Per2 = vlSinistroFx7Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx7Sinistralidade2 = vlSinistroFx7Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx7Sinistralidade2 = percFx7Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx8List1) {
	    	vlSinistroFx8Per1 = vlSinistroFx8Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx8Sinistralidade1 = vlSinistroFx8Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx8Sinistralidade1 = percFx8Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx8List2) {
	    	vlSinistroFx8Per2 = vlSinistroFx8Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx8Sinistralidade2 = vlSinistroFx8Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx8Sinistralidade2 = percFx8Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx9List1) {
	    	vlSinistroFx9Per1 = vlSinistroFx9Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx9Sinistralidade1 = vlSinistroFx9Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx9Sinistralidade1 = percFx9Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx9List2) {
	    	vlSinistroFx9Per2 = vlSinistroFx9Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx9Sinistralidade2 = vlSinistroFx9Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx9Sinistralidade2 = percFx9Sinistralidade2.multiply(new BigDecimal(100));
	    
	    
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx10List1) {
	    	vlSinistroFx10Per1 = vlSinistroFx10Per1.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx10Sinistralidade1 = vlSinistroFx10Per1.divide(vlPremioPer1, 4, RoundingMode.HALF_EVEN);
	    percFx10Sinistralidade1 = percFx10Sinistralidade1.multiply(new BigDecimal(100));
	    
	    *//*****  *****//*
	    for(FatoVlbenefFatura fatoVlbenefFatura : sinistroFx10List2) {
	    	vlSinistroFx10Per2 = vlSinistroFx10Per2.add(fatoVlbenefFatura.getVlUsuario());
	    }
	    percFx10Sinistralidade2 = vlSinistroFx10Per2.divide(vlPremioPer2, 4, RoundingMode.HALF_EVEN);
	    percFx10Sinistralidade2 = percFx10Sinistralidade2.multiply(new BigDecimal(100));
	    */
	    

		
		/** preenche mensagem em tela **/
		this.setMensagem("Relatório Gerado...");
		
		chart.setCodigo(1); //código para salvar no banco
		chart.setTipo(3); //SINISTRALIDADE POR FAIXA ETÁRIA
		chart.setVlPer1(decFormat.format(percSinistralidade1));
		chart.setVlPer2(decFormat.format(percSinistralidade2));
		chart.setVlDecPer1(BigDecimal.ZERO);
		chart.setVlDecPer2(BigDecimal.ZERO);
		chart.setDsInfo1("");
		chart.setDsInfo2("Período: " + "0" + nrMes1.toString() + "/" + nrAno1.toString() + " - " + "0" + nrMes2.toString() + "/" + nrAno2.toString());
		chart.setDsInfo3("");
		chart.setVlProc1(BigDecimal.ZERO);
		chart.setVlProc2(BigDecimal.ZERO);
		chart.setVlInsu1(BigDecimal.ZERO);
		chart.setVlInsu2(BigDecimal.ZERO);
		
		// 01/2016 - Sinistralidade
		chart.setPercFx1(new BigDecimal("5.59"));
		chart.setPercFx2(new BigDecimal("1.63"));
		chart.setPercFx3(new BigDecimal("2.46"));
		chart.setPercFx4(new BigDecimal("3.54"));
		chart.setPercFx5(new BigDecimal("4.35"));
		chart.setPercFx6(new BigDecimal("3.73"));
		chart.setPercFx7(new BigDecimal("3.79"));
		chart.setPercFx8(new BigDecimal("3.45"));
		chart.setPercFx9(new BigDecimal("3.20"));
		chart.setPercFx10(new BigDecimal("18.97"));
		
		// 01/2017 - Sinistralidade
		chart.setPercFx1_2(new BigDecimal("8.47"));
		chart.setPercFx2_2(new BigDecimal("2.37"));
		chart.setPercFx3_2(new BigDecimal("3.51"));
		chart.setPercFx4_2(new BigDecimal("5.05"));
		chart.setPercFx5_2(new BigDecimal("6.28"));
		chart.setPercFx6_2(new BigDecimal("5.41"));
		chart.setPercFx7_2(new BigDecimal("5.17"));
		chart.setPercFx8_2(new BigDecimal("4.58"));
		chart.setPercFx9_2(new BigDecimal("4.32"));
		chart.setPercFx10_2(new BigDecimal("24.11"));
		
		// Gênero - Masculino
		chart.setPercHFx1(new BigDecimal("51.11"));
		chart.setPercHFx2(new BigDecimal("45.98"));
		chart.setPercHFx3(new BigDecimal("42.41"));
		chart.setPercHFx4(new BigDecimal("42.10"));
		chart.setPercHFx5(new BigDecimal("43.02"));
		chart.setPercHFx6(new BigDecimal("43.81"));
		chart.setPercHFx7(new BigDecimal("43.54"));
		chart.setPercHFx8(new BigDecimal("44.19"));
		chart.setPercHFx9(new BigDecimal("43.60"));
		chart.setPercHFx10(new BigDecimal("41.42"));
		
		// Gênero - Feminino
		chart.setPercMFx1(new BigDecimal("48.89"));
		chart.setPercMFx2(new BigDecimal("54.02"));
		chart.setPercMFx3(new BigDecimal("57.59"));
		chart.setPercMFx4(new BigDecimal("57.90"));
		chart.setPercMFx5(new BigDecimal("56.98"));
		chart.setPercMFx6(new BigDecimal("56.19"));
		chart.setPercMFx7(new BigDecimal("56.46"));
		chart.setPercMFx8(new BigDecimal("55.81"));
		chart.setPercMFx9(new BigDecimal("56.40"));
		chart.setPercMFx10(new BigDecimal("58.58"));
		
		dao2.salvar(chart);
    	
    }
	
	/** gets e sets **/
	
	public Date getSelectedPeriodo1() {
		return selectedPeriodo1;
	}
	public void setSelectedPeriodo1(Date selectedPeriodo1) {
		this.selectedPeriodo1 = selectedPeriodo1;
	}
	public Date getSelectedPeriodo2() {
		return selectedPeriodo2;
	}
	public void setSelectedPeriodo2(Date selectedPeriodo2) {
		this.selectedPeriodo2 = selectedPeriodo2;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
