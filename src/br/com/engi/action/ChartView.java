package br.com.engi.action;

import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.engi.dao.DAO2;
import br.com.engi.model.Chart;

@ManagedBean(name = "chartView")
public class ChartView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3425030274059167287L;
	
	/** atributos **/
	
	 /** tela **/
	private String vlPer1;
	private String vlPer2;
	private String dsInfo1;
	private String dsInfo2;
	private String dsInfo3;
	private String dsPer1;
	private String dsPer2;
	
	private Boolean includeChart;
	
	 /** gráfico **/
	private BigDecimal vlDecPer1;
	private BigDecimal vlDecPer2;
	private BigDecimal vlProc1;
	private BigDecimal vlProc2;
	private BigDecimal vlInsu1;
	private BigDecimal vlInsu2;
	
	// 01/2016 - Sinistralidade
	private BigDecimal percFx1;
	private BigDecimal percFx2;
	private BigDecimal percFx3;
	private BigDecimal percFx4;
	private BigDecimal percFx5;
	private BigDecimal percFx6;
	private BigDecimal percFx7;
	private BigDecimal percFx8;
	private BigDecimal percFx9;
	private BigDecimal percFx10;
	
	// 01/2017 - Sinistralidade
	private BigDecimal percFx1_2;
	private BigDecimal percFx2_2;
	private BigDecimal percFx3_2;
	private BigDecimal percFx4_2;
	private BigDecimal percFx5_2;
	private BigDecimal percFx6_2;
	private BigDecimal percFx7_2;
	private BigDecimal percFx8_2;
	private BigDecimal percFx9_2;
	private BigDecimal percFx10_2;
	
	// Gênero - Masculino
	private BigDecimal percHFx1;
	private BigDecimal percHFx2;
	private BigDecimal percHFx3;
	private BigDecimal percHFx4;
	private BigDecimal percHFx5;
	private BigDecimal percHFx6;
	private BigDecimal percHFx7;
	private BigDecimal percHFx8;
	private BigDecimal percHFx9;
	private BigDecimal percHFx10;
	
	// Gênero - Feminino
	private BigDecimal percMFx1;
	private BigDecimal percMFx2;
	private BigDecimal percMFx3;
	private BigDecimal percMFx4;
	private BigDecimal percMFx5;
	private BigDecimal percMFx6;
	private BigDecimal percMFx7;
	private BigDecimal percMFx8;
	private BigDecimal percMFx9;
	private BigDecimal percMFx10;
	
	private BarChartModel barModel;
	private BarChartModel barModel2;
	
	/** métodos **/
	
    @PostConstruct
    public void init() {
    	Chart chart = new Chart();
    	DAO2 dao2 = new DAO2();
    	
    	chart = dao2.buscarPorChart(1);
    	
    	/** tela **/
    	this.setDsInfo1(chart.getDsInfo1());
    	this.setDsInfo2(chart.getDsInfo2());
    	this.setDsInfo3(chart.getDsInfo3());
    	this.setVlPer1(chart.getVlPer1());
    	this.setVlPer2(chart.getVlPer2());
    	
    	/** gráfico **/
    	this.setVlDecPer1(chart.getVlDecPer1());
    	this.setVlDecPer2(chart.getVlDecPer2());
    	this.setVlProc1(chart.getVlProc1());
    	this.setVlProc2(chart.getVlProc2());
    	this.setVlInsu1(chart.getVlInsu1());
    	this.setVlInsu2(chart.getVlInsu2());
    	
    	// 01/2016 - Sinistralidade
    	this.setPercFx1(chart.getPercFx1());
    	this.setPercFx2(chart.getPercFx2());
    	this.setPercFx3(chart.getPercFx3());
    	this.setPercFx4(chart.getPercFx4());
    	this.setPercFx5(chart.getPercFx5());
    	this.setPercFx6(chart.getPercFx6());
    	this.setPercFx7(chart.getPercFx7());
    	this.setPercFx8(chart.getPercFx8());
    	this.setPercFx9(chart.getPercFx9());
    	this.setPercFx10(chart.getPercFx10());
    	
    	// 01/2017 - Sinistralidade
    	this.setPercFx1_2(chart.getPercFx1_2());
    	this.setPercFx2_2(chart.getPercFx2_2());
    	this.setPercFx3_2(chart.getPercFx3_2());
    	this.setPercFx4_2(chart.getPercFx4_2());
    	this.setPercFx5_2(chart.getPercFx5_2());
    	this.setPercFx6_2(chart.getPercFx6_2());
    	this.setPercFx7_2(chart.getPercFx7_2());
    	this.setPercFx8_2(chart.getPercFx8_2());
    	this.setPercFx9_2(chart.getPercFx9_2());
    	this.setPercFx10_2(chart.getPercFx10_2());
    	
    	// Gênero - Masculino
    	this.setPercHFx1(chart.getPercHFx1());
    	this.setPercHFx2(chart.getPercHFx2());
    	this.setPercHFx3(chart.getPercHFx3());
    	this.setPercHFx4(chart.getPercHFx4());
    	this.setPercHFx5(chart.getPercHFx5());
    	this.setPercHFx6(chart.getPercHFx6());
    	this.setPercHFx7(chart.getPercHFx7());
    	this.setPercHFx8(chart.getPercHFx8());
    	this.setPercHFx9(chart.getPercHFx9());
    	this.setPercHFx10(chart.getPercHFx10());
    	
    	// Gênero - Feminino
    	this.setPercMFx1(chart.getPercMFx1());
    	this.setPercMFx2(chart.getPercMFx2());
    	this.setPercMFx3(chart.getPercMFx3());
    	this.setPercMFx4(chart.getPercMFx4());
    	this.setPercMFx5(chart.getPercMFx5());
    	this.setPercMFx6(chart.getPercMFx6());
    	this.setPercMFx7(chart.getPercMFx7());
    	this.setPercMFx8(chart.getPercMFx8());
    	this.setPercMFx9(chart.getPercMFx9());
    	this.setPercMFx10(chart.getPercMFx10());
    	
    	
    	if (chart.getTipo() == 1) { //FATURAMENTO POR CLIENTE
    		this.setIncludeChart(false);
    		
    		this.setDsPer1("Faturamento Período 1: ");
    		this.setDsPer2("Faturamento Período 2: ");
    		createBarModelFT();
    	} else {
    		if (chart.getTipo() == 2) { //VALOR GLOSADO POR PRESTADOR
    			this.setIncludeChart(false);
    			
    			this.setDsPer1("Total de Glosas Período 1: ");
        		this.setDsPer2("Total de Glosas Período 2: ");
        		createBarModelTG();
    		} else {
    			if (chart.getTipo() == 3) { //SINISTRALIDADE POR FAIXA ETÁRIA
    				this.setIncludeChart(true);
    				
    				this.setDsPer1("Sinistralidade Período 1: ");
            		this.setDsPer2("Sinistralidade Período 2: ");
            		createBarModelSF(); /** sinistralidade faixa etária **/
            		createBarModelGF(); /** gênero faixa etária **/
    			}
    		}
    	}
    }
    
    /** FATURAMENTO POR CLIENTE **/
	private void createBarModelFT() {
        barModel = initBarModelFT();
         
        barModel.setTitle("Faturamento Cliente");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Período");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Faturamento");
        yAxis.setMin(0);
        yAxis.setMax(200000);
    }
	
	private BarChartModel initBarModelFT() {
        BarChartModel model = new BarChartModel();
        
        ChartSeries per1 = new ChartSeries();
        per1.setLabel("01/2016");
        per1.set("Janeiro", this.getVlDecPer1());
 
        ChartSeries per2 = new ChartSeries();
        per2.setLabel("01/2017");
        per2.set("Janeiro", this.getVlDecPer2());
 
        model.addSeries(per1);
        model.addSeries(per2);
         
        return model;
    }
	
	/** VALOR GLOSADO POR PRESTADOR **/
	private void createBarModelTG() {
        barModel = initBarModelTG();
         
        barModel.setTitle("Valor Glosado Prestador");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Período");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Valores Glosados");
        yAxis.setMin(0);
        yAxis.setMax(10000);
    }
	
	private BarChartModel initBarModelTG() {
        BarChartModel model = new BarChartModel();
        
        ChartSeries proc1 = new ChartSeries();
        proc1.setLabel("Procedimentos");
        proc1.set("01/2016", this.getVlProc1());
        proc1.set("01/2017", this.getVlProc2());
        
        ChartSeries insu1 = new ChartSeries();
        insu1.setLabel("Insumos");
        insu1.set("01/2016", this.getVlInsu1());
        insu1.set("01/2017", this.getVlInsu2());
        
        model.addSeries(proc1);
        model.addSeries(insu1);
        
        return model;
    }
	
	/** SINISTRALIDADE POR FAIXA ETÁRIA **/
	private void createBarModelSF() {
        barModel = initBarModelSF();
         
        barModel.setTitle("Sinistralidade por Faixa Etária");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Faixas");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Percentual (%)");
        yAxis.setMin(0);
        yAxis.setMax(40);
    }
	
	private BarChartModel initBarModelSF() {
        BarChartModel model = new BarChartModel();
        
        ChartSeries fxPer1 = new ChartSeries();
        fxPer1.setLabel("01/2016");
        fxPer1.set("0-18", this.getPercFx1());
        fxPer1.set("19-23", this.getPercFx2());
        fxPer1.set("24-28", this.getPercFx3());
        fxPer1.set("29-33", this.getPercFx4());
        fxPer1.set("34-38", this.getPercFx5());
        fxPer1.set("39-43", this.getPercFx6());
        fxPer1.set("44-48", this.getPercFx7());
        fxPer1.set("49-53", this.getPercFx8());
        fxPer1.set("54-58", this.getPercFx9());
        fxPer1.set("59-999", this.getPercFx10());
        
        ChartSeries fxPer2 = new ChartSeries();
        fxPer2.setLabel("01/2017");
        fxPer2.set("0-18", this.getPercFx1_2());
        fxPer2.set("19-23", this.getPercFx2_2());
        fxPer2.set("24-28", this.getPercFx3_2());
        fxPer2.set("29-33", this.getPercFx4_2());
        fxPer2.set("34-38", this.getPercFx5_2());
        fxPer2.set("39-43", this.getPercFx6_2());
        fxPer2.set("44-48", this.getPercFx7_2());
        fxPer2.set("49-53", this.getPercFx8_2());
        fxPer2.set("54-58", this.getPercFx9_2());
        fxPer2.set("59-999", this.getPercFx10_2());
        
        model.addSeries(fxPer1);
        model.addSeries(fxPer2);
        
        return model;
    }
	
	/** GÊNERO POR FAIXA ETÁRIA **/
	private void createBarModelGF() {
		barModel2 = initBarModelGF();
         
		barModel2.setTitle("Gênero por Faixa Etária");
		barModel2.setLegendPosition("ne");
         
        Axis xAxis = barModel2.getAxis(AxisType.X);
        xAxis.setLabel("Faixas");
         
        Axis yAxis = barModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Percentual (%)");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
	
	private BarChartModel initBarModelGF() {
        BarChartModel model = new BarChartModel();
        
        ChartSeries genH = new ChartSeries();
        genH.setLabel("Homens");
        genH.set("0-18", this.getPercHFx1());
        genH.set("19-23", this.getPercHFx2());
        genH.set("24-28", this.getPercHFx3());
        genH.set("29-33", this.getPercHFx4());
        genH.set("34-38", this.getPercHFx5());
        genH.set("39-43", this.getPercHFx6());
        genH.set("44-48", this.getPercHFx7());
        genH.set("49-53", this.getPercHFx8());
        genH.set("54-58", this.getPercHFx9());
        genH.set("59-999", this.getPercHFx10());
        
        ChartSeries genM = new ChartSeries();
        genM.setLabel("Mulheres");
        genM.set("0-18", this.getPercMFx1());
        genM.set("19-23", this.getPercMFx2());
        genM.set("24-28", this.getPercMFx3());
        genM.set("29-33", this.getPercMFx4());
        genM.set("34-38", this.getPercMFx5());
        genM.set("39-43", this.getPercMFx6());
        genM.set("44-48", this.getPercMFx7());
        genM.set("49-53", this.getPercMFx8());
        genM.set("54-58", this.getPercMFx9());
        genM.set("59-999", this.getPercMFx10());
        
        model.addSeries(genH);
        model.addSeries(genM);
        
        return model;
    }
    
    /** gets e sets **/
    
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public BarChartModel getBarModel2() {
		return barModel2;
	}

	public void setBarModel2(BarChartModel barModel2) {
		this.barModel2 = barModel2;
	}

	public String getVlPer1() {
		return vlPer1;
	}

	public void setVlPer1(String vlPer1) {
		this.vlPer1 = vlPer1;
	}

	public String getVlPer2() {
		return vlPer2;
	}

	public void setVlPer2(String vlPer2) {
		this.vlPer2 = vlPer2;
	}

	public String getDsInfo1() {
		return dsInfo1;
	}

	public void setDsInfo1(String dsInfo1) {
		this.dsInfo1 = dsInfo1;
	}

	public String getDsInfo2() {
		return dsInfo2;
	}

	public void setDsInfo2(String dsInfo2) {
		this.dsInfo2 = dsInfo2;
	}

	public String getDsInfo3() {
		return dsInfo3;
	}

	public void setDsInfo3(String dsInfo3) {
		this.dsInfo3 = dsInfo3;
	}

	public String getDsPer1() {
		return dsPer1;
	}

	public void setDsPer1(String dsPer1) {
		this.dsPer1 = dsPer1;
	}

	public String getDsPer2() {
		return dsPer2;
	}

	public void setDsPer2(String dsPer2) {
		this.dsPer2 = dsPer2;
	}

	public BigDecimal getVlDecPer1() {
		return vlDecPer1;
	}

	public void setVlDecPer1(BigDecimal vlDecPer1) {
		this.vlDecPer1 = vlDecPer1;
	}

	public BigDecimal getVlDecPer2() {
		return vlDecPer2;
	}

	public void setVlDecPer2(BigDecimal vlDecPer2) {
		this.vlDecPer2 = vlDecPer2;
	}

	public BigDecimal getVlProc1() {
		return vlProc1;
	}

	public void setVlProc1(BigDecimal vlProc1) {
		this.vlProc1 = vlProc1;
	}

	public BigDecimal getVlProc2() {
		return vlProc2;
	}

	public void setVlProc2(BigDecimal vlProc2) {
		this.vlProc2 = vlProc2;
	}

	public BigDecimal getVlInsu1() {
		return vlInsu1;
	}

	public void setVlInsu1(BigDecimal vlInsu1) {
		this.vlInsu1 = vlInsu1;
	}

	public BigDecimal getVlInsu2() {
		return vlInsu2;
	}

	public void setVlInsu2(BigDecimal vlInsu2) {
		this.vlInsu2 = vlInsu2;
	}

	public BigDecimal getPercFx1() {
		return percFx1;
	}

	public void setPercFx1(BigDecimal percFx1) {
		this.percFx1 = percFx1;
	}

	public BigDecimal getPercFx2() {
		return percFx2;
	}

	public void setPercFx2(BigDecimal percFx2) {
		this.percFx2 = percFx2;
	}

	public BigDecimal getPercFx3() {
		return percFx3;
	}

	public void setPercFx3(BigDecimal percFx3) {
		this.percFx3 = percFx3;
	}

	public BigDecimal getPercFx4() {
		return percFx4;
	}

	public void setPercFx4(BigDecimal percFx4) {
		this.percFx4 = percFx4;
	}

	public BigDecimal getPercFx5() {
		return percFx5;
	}

	public void setPercFx5(BigDecimal percFx5) {
		this.percFx5 = percFx5;
	}

	public BigDecimal getPercFx6() {
		return percFx6;
	}

	public void setPercFx6(BigDecimal percFx6) {
		this.percFx6 = percFx6;
	}

	public BigDecimal getPercFx7() {
		return percFx7;
	}

	public void setPercFx7(BigDecimal percFx7) {
		this.percFx7 = percFx7;
	}

	public BigDecimal getPercFx8() {
		return percFx8;
	}

	public void setPercFx8(BigDecimal percFx8) {
		this.percFx8 = percFx8;
	}

	public BigDecimal getPercFx9() {
		return percFx9;
	}

	public void setPercFx9(BigDecimal percFx9) {
		this.percFx9 = percFx9;
	}

	public BigDecimal getPercFx10() {
		return percFx10;
	}

	public void setPercFx10(BigDecimal percFx10) {
		this.percFx10 = percFx10;
	}

	public BigDecimal getPercFx1_2() {
		return percFx1_2;
	}

	public void setPercFx1_2(BigDecimal percFx1_2) {
		this.percFx1_2 = percFx1_2;
	}

	public BigDecimal getPercFx2_2() {
		return percFx2_2;
	}

	public void setPercFx2_2(BigDecimal percFx2_2) {
		this.percFx2_2 = percFx2_2;
	}

	public BigDecimal getPercFx3_2() {
		return percFx3_2;
	}

	public void setPercFx3_2(BigDecimal percFx3_2) {
		this.percFx3_2 = percFx3_2;
	}

	public BigDecimal getPercFx4_2() {
		return percFx4_2;
	}

	public void setPercFx4_2(BigDecimal percFx4_2) {
		this.percFx4_2 = percFx4_2;
	}

	public BigDecimal getPercFx5_2() {
		return percFx5_2;
	}

	public void setPercFx5_2(BigDecimal percFx5_2) {
		this.percFx5_2 = percFx5_2;
	}

	public BigDecimal getPercFx6_2() {
		return percFx6_2;
	}

	public void setPercFx6_2(BigDecimal percFx6_2) {
		this.percFx6_2 = percFx6_2;
	}

	public BigDecimal getPercFx7_2() {
		return percFx7_2;
	}

	public void setPercFx7_2(BigDecimal percFx7_2) {
		this.percFx7_2 = percFx7_2;
	}

	public BigDecimal getPercFx8_2() {
		return percFx8_2;
	}

	public void setPercFx8_2(BigDecimal percFx8_2) {
		this.percFx8_2 = percFx8_2;
	}

	public BigDecimal getPercFx9_2() {
		return percFx9_2;
	}

	public void setPercFx9_2(BigDecimal percFx9_2) {
		this.percFx9_2 = percFx9_2;
	}

	public BigDecimal getPercFx10_2() {
		return percFx10_2;
	}

	public void setPercFx10_2(BigDecimal percFx10_2) {
		this.percFx10_2 = percFx10_2;
	}

	public Boolean getIncludeChart() {
		return includeChart;
	}

	public void setIncludeChart(Boolean includeChart) {
		this.includeChart = includeChart;
	}

	public BigDecimal getPercHFx1() {
		return percHFx1;
	}

	public void setPercHFx1(BigDecimal percHFx1) {
		this.percHFx1 = percHFx1;
	}

	public BigDecimal getPercHFx2() {
		return percHFx2;
	}

	public void setPercHFx2(BigDecimal percHFx2) {
		this.percHFx2 = percHFx2;
	}

	public BigDecimal getPercHFx3() {
		return percHFx3;
	}

	public void setPercHFx3(BigDecimal percHFx3) {
		this.percHFx3 = percHFx3;
	}

	public BigDecimal getPercHFx4() {
		return percHFx4;
	}

	public void setPercHFx4(BigDecimal percHFx4) {
		this.percHFx4 = percHFx4;
	}

	public BigDecimal getPercHFx5() {
		return percHFx5;
	}

	public void setPercHFx5(BigDecimal percHFx5) {
		this.percHFx5 = percHFx5;
	}

	public BigDecimal getPercHFx6() {
		return percHFx6;
	}

	public void setPercHFx6(BigDecimal percHFx6) {
		this.percHFx6 = percHFx6;
	}

	public BigDecimal getPercHFx7() {
		return percHFx7;
	}

	public void setPercHFx7(BigDecimal percHFx7) {
		this.percHFx7 = percHFx7;
	}

	public BigDecimal getPercHFx8() {
		return percHFx8;
	}

	public void setPercHFx8(BigDecimal percHFx8) {
		this.percHFx8 = percHFx8;
	}

	public BigDecimal getPercHFx9() {
		return percHFx9;
	}

	public void setPercHFx9(BigDecimal percHFx9) {
		this.percHFx9 = percHFx9;
	}

	public BigDecimal getPercHFx10() {
		return percHFx10;
	}

	public void setPercHFx10(BigDecimal percHFx10) {
		this.percHFx10 = percHFx10;
	}

	public BigDecimal getPercMFx1() {
		return percMFx1;
	}

	public void setPercMFx1(BigDecimal percMFx1) {
		this.percMFx1 = percMFx1;
	}

	public BigDecimal getPercMFx2() {
		return percMFx2;
	}

	public void setPercMFx2(BigDecimal percMFx2) {
		this.percMFx2 = percMFx2;
	}

	public BigDecimal getPercMFx3() {
		return percMFx3;
	}

	public void setPercMFx3(BigDecimal percMFx3) {
		this.percMFx3 = percMFx3;
	}

	public BigDecimal getPercMFx4() {
		return percMFx4;
	}

	public void setPercMFx4(BigDecimal percMFx4) {
		this.percMFx4 = percMFx4;
	}

	public BigDecimal getPercMFx5() {
		return percMFx5;
	}

	public void setPercMFx5(BigDecimal percMFx5) {
		this.percMFx5 = percMFx5;
	}

	public BigDecimal getPercMFx6() {
		return percMFx6;
	}

	public void setPercMFx6(BigDecimal percMFx6) {
		this.percMFx6 = percMFx6;
	}

	public BigDecimal getPercMFx7() {
		return percMFx7;
	}

	public void setPercMFx7(BigDecimal percMFx7) {
		this.percMFx7 = percMFx7;
	}

	public BigDecimal getPercMFx8() {
		return percMFx8;
	}

	public void setPercMFx8(BigDecimal percMFx8) {
		this.percMFx8 = percMFx8;
	}

	public BigDecimal getPercMFx9() {
		return percMFx9;
	}

	public void setPercMFx9(BigDecimal percMFx9) {
		this.percMFx9 = percMFx9;
	}

	public BigDecimal getPercMFx10() {
		return percMFx10;
	}

	public void setPercMFx10(BigDecimal percMFx10) {
		this.percMFx10 = percMFx10;
	}
	
}