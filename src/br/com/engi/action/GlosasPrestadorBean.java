package br.com.engi.action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.engi.dao.DAO2;
import br.com.engi.model.Chart;
import br.com.engi.model.FatoMovInsuPrestador;
import br.com.engi.model.FatoMoviprocPrestador;

@ManagedBean(name = "glosasPrestadorBean")
@ViewScoped
public class GlosasPrestadorBean {
	
	/** atributos **/
	
	private String nomePrestador;
	private Date selectedPeriodo1;
	private Date selectedPeriodo2;
	private String mensagem;
	
	
	/** métodos **/
	
	/** findFatoMoviProcMovInsuPrestador **/
    public void findFatoMoviProcMovInsuPrestador() {
		List<FatoMoviprocPrestador> fatoMoviprocPrestadorList1 = new ArrayList<FatoMoviprocPrestador>();
		List<FatoMoviprocPrestador> fatoMoviprocPrestadorList2 = new ArrayList<FatoMoviprocPrestador>();
		List<FatoMovInsuPrestador> fatoMovInsuPrestadorList1 = new ArrayList<FatoMovInsuPrestador>();
		List<FatoMovInsuPrestador> fatoMovInsuPrestadorList2 = new ArrayList<FatoMovInsuPrestador>();
		DAO2 dao2 = new DAO2();
		Chart chart = new Chart();
		
		Integer nrMes1 = 0;
		Integer nrMes2 = 0;
		Integer nrAno1 = 0;
		Integer nrAno2 = 0;
		String periodo1 = "";
		String periodo2 = "";
		BigDecimal vlSomaPer1 = BigDecimal.ZERO;
		BigDecimal vlSomaPer2 = BigDecimal.ZERO;
		BigDecimal vlProc1 = BigDecimal.ZERO;
		BigDecimal vlProc2 = BigDecimal.ZERO;
		BigDecimal vlInsu1 = BigDecimal.ZERO;
		BigDecimal vlInsu2 = BigDecimal.ZERO;
		
		String nomePrestadorSelect = "";
		
		DecimalFormat decFormat = new java.text.DecimalFormat("'R$ ' ###,###,##0.00"); //coloca um format no objeto BigDecimal
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); //coloca um format no objeto Calendar
		
		periodo1 = formatador.format(getSelectedPeriodo1()); //captura data selecionada do calendário em tela
		periodo2 = formatador.format(getSelectedPeriodo2());
		
		nrMes1 = Integer.valueOf(periodo1.substring(3, 5));
		nrAno1 = Integer.valueOf(periodo1.substring(6, 10));
		nrMes2 = Integer.valueOf(periodo2.substring(3, 5));
	    nrAno2 = Integer.valueOf(periodo2.substring(6, 10));
		
		/** realiza consulta - chama classe DAO **/
	    fatoMoviprocPrestadorList1 = dao2.consultaTotalGlosaProc(this.getNomePrestador(), nrMes1, nrAno1); // 01/2016
	    fatoMoviprocPrestadorList2 = dao2.consultaTotalGlosaProc(this.getNomePrestador(), nrMes2, nrAno2); // 01/2017
	    fatoMovInsuPrestadorList1  = dao2.consultaTotalGlosaInsu(this.getNomePrestador(), nrMes1, nrAno1); // 01/2016
	    fatoMovInsuPrestadorList2  = dao2.consultaTotalGlosaInsu(this.getNomePrestador(), nrMes2, nrAno2); // 01/2017
		
		for(FatoMoviprocPrestador fatoMoviprocPrestador : fatoMoviprocPrestadorList1) {
			vlSomaPer1 = vlSomaPer1.add(fatoMoviprocPrestador.getVlPrincipal());
			vlProc1 = vlProc1.add(fatoMoviprocPrestador.getVlPrincipal());
		}
		
		for(FatoMoviprocPrestador fatoMoviprocPrestador : fatoMoviprocPrestadorList2) {
			vlSomaPer2 = vlSomaPer2.add(fatoMoviprocPrestador.getVlPrincipal());
			vlProc2 = vlProc2.add(fatoMoviprocPrestador.getVlPrincipal());
			nomePrestadorSelect = fatoMoviprocPrestador.getNmPrestador();
		}
		
		
		for(FatoMovInsuPrestador fatoMovInsuPrestador : fatoMovInsuPrestadorList1) {
			vlSomaPer1 = vlSomaPer1.add(fatoMovInsuPrestador.getVlInsumo());
			vlInsu1 = vlInsu1.add(fatoMovInsuPrestador.getVlInsumo());
		}
		
		for(FatoMovInsuPrestador fatoMovInsuPrestador : fatoMovInsuPrestadorList2) {
			vlSomaPer2 = vlSomaPer2.add(fatoMovInsuPrestador.getVlInsumo());
			vlInsu2 = vlInsu2.add(fatoMovInsuPrestador.getVlInsumo());
			nomePrestadorSelect = fatoMovInsuPrestador.getNmPrestador();
		}
		
		/** preenche mensagem em tela **/
		this.setMensagem("Relatório Gerado...");
		
		chart.setCodigo(1); //código para salvar no banco
		chart.setTipo(2); //VALOR GLOSADO POR PRESTADOR
		chart.setVlPer1(decFormat.format(vlSomaPer1));
		chart.setVlPer2(decFormat.format(vlSomaPer2));
		chart.setVlDecPer1(vlSomaPer1);
		chart.setVlDecPer2(vlSomaPer2);
		chart.setDsInfo1("Prestador: " + nomePrestadorSelect);
		chart.setDsInfo2("Período: " + "0" + nrMes1.toString() + "/" + nrAno1.toString() + " - " + "0" + nrMes2.toString() + "/" + nrAno2.toString());
		chart.setDsInfo3("");
		chart.setVlProc1(vlProc1);
		chart.setVlProc2(vlProc2);
		chart.setVlInsu1(vlInsu1);
		chart.setVlInsu2(vlInsu2);
		
		dao2.salvar(chart);
		
	}
    
    /** gets e sets **/
    
	public String getNomePrestador() {
		return nomePrestador;
	}
	public void setNomePrestador(String nomePrestador) {
		this.nomePrestador = nomePrestador;
	}

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
