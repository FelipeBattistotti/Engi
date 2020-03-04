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
import br.com.engi.model.FatoFaturaContrat;

@ManagedBean(name = "pesquisaBean")
@ViewScoped
public class PesquisaBean {
	
	/** atributos **/
	
	private String nomeContratante;
	private Date selectedPeriodo1;
	private Date selectedPeriodo2;
	private String mensagem;
	
	
	/** métodos **/
	
	/** findFatoFaturaContrat **/
    public void findFatoFaturaContrat() {
		List<FatoFaturaContrat>   fatoFaturaContratList1 = new ArrayList<FatoFaturaContrat>();
		List<FatoFaturaContrat>   fatoFaturaContratList2 = new ArrayList<FatoFaturaContrat>();
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
		String nomeContratanteSelect = "";
		
		DecimalFormat decFormat = new java.text.DecimalFormat("'R$ ' ###,###,##0.00"); //coloca um format no objeto BigDecimal
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); //coloca um format no objeto Calendar
		
		periodo1 = formatador.format(getSelectedPeriodo1()); //captura data selecionada do calendário em tela
		periodo2 = formatador.format(getSelectedPeriodo2());
		
		nrMes1 = Integer.valueOf(periodo1.substring(3, 5));
		nrAno1 = Integer.valueOf(periodo1.substring(6, 10));
		nrMes2 = Integer.valueOf(periodo2.substring(3, 5));
	    nrAno2 = Integer.valueOf(periodo2.substring(6, 10));
		
		/** realiza consulta - chama classe DAO **/
		fatoFaturaContratList1 = dao2.consultaFaturamentoTotal(this.getNomeContratante(), nrMes1, nrAno1); // 01/2016
		fatoFaturaContratList2 = dao2.consultaFaturamentoTotal(this.getNomeContratante(), nrMes2, nrAno2); // 01/2017
		
		for(FatoFaturaContrat fatoFaturaContrat : fatoFaturaContratList1) {
			vlSomaPer1 = vlSomaPer1.add(fatoFaturaContrat.getVlTotal());
		}
		
		for(FatoFaturaContrat fatoFaturaContrat : fatoFaturaContratList2) {
			vlSomaPer2 = vlSomaPer2.add(fatoFaturaContrat.getVlTotal());
			nomeContratanteSelect = fatoFaturaContrat.getNmContratante();
		}
		
		/** preenche mensagem em tela **/
		this.setMensagem("Relatório Gerado...");
		
		chart.setCodigo(1); //código para salvar no banco
		chart.setTipo(1); //FATURAMENTO POR CLIENTE
		chart.setVlPer1(decFormat.format(vlSomaPer1));
		chart.setVlPer2(decFormat.format(vlSomaPer2));
		chart.setVlDecPer1(vlSomaPer1);
		chart.setVlDecPer2(vlSomaPer2);
		chart.setDsInfo1("Cliente: " + nomeContratanteSelect);
		chart.setDsInfo2("Período: " + "0" + nrMes1.toString() + "/" + nrAno1.toString() + " - " + "0" + nrMes2.toString() + "/" + nrAno2.toString());
		chart.setDsInfo3("");
		chart.setVlProc1(BigDecimal.ZERO);
		chart.setVlProc2(BigDecimal.ZERO);
		chart.setVlInsu1(BigDecimal.ZERO);
		chart.setVlInsu2(BigDecimal.ZERO);
		chart.setPercFx1(BigDecimal.ZERO);
		chart.setPercFx2(BigDecimal.ZERO);
		chart.setPercFx3(BigDecimal.ZERO);
		chart.setPercFx4(BigDecimal.ZERO);
		chart.setPercFx5(BigDecimal.ZERO);
		chart.setPercFx6(BigDecimal.ZERO);
		chart.setPercFx7(BigDecimal.ZERO);
		chart.setPercFx8(BigDecimal.ZERO);
		chart.setPercFx9(BigDecimal.ZERO);
		chart.setPercFx10(BigDecimal.ZERO);
		chart.setPercFx1_2(BigDecimal.ZERO);
		chart.setPercFx2_2(BigDecimal.ZERO);
		chart.setPercFx3_2(BigDecimal.ZERO);
		chart.setPercFx4_2(BigDecimal.ZERO);
		chart.setPercFx5_2(BigDecimal.ZERO);
		chart.setPercFx6_2(BigDecimal.ZERO);
		chart.setPercFx7_2(BigDecimal.ZERO);
		chart.setPercFx8_2(BigDecimal.ZERO);
		chart.setPercFx9_2(BigDecimal.ZERO);
		chart.setPercFx10_2(BigDecimal.ZERO);
		dao2.salvar(chart);
		
	}
	
	/** gets e sets **/
	
	public String getNomeContratante() {
		return nomeContratante;
	}
	public void setNomeContratante(String nomeContratante) {
		this.nomeContratante = nomeContratante;
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