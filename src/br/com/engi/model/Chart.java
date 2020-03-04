package br.com.engi.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chart")
public class Chart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5579865865582787903L;

	@Id
	@Column(name="codigo")
	private Integer codigo; //codigo
	
	@Column(name="vl_per1")
	private String vlPer1; //vl_per1
	
	@Column(name="vl_per2")
	private String vlPer2; //vl_per2
	
	@Column(name="ds_info1")
	private String dsInfo1; //ds_info1
	
	@Column(name="ds_info2")
	private String dsInfo2; //ds_info2
	
	@Column(name="ds_info3")
	private String dsInfo3; //ds_info3
	
	@Column(name="tipo")
	private Integer tipo; //tipo
	
	@Column(name="vl_dec_per1")
	private BigDecimal vlDecPer1; //vl_dec_per1
	
	@Column(name="vl_dec_per2")
	private BigDecimal vlDecPer2; //vl_dec_per2
	
	@Column(name="vl_proc1")
	private BigDecimal vlProc1; //vl_proc1
	
	@Column(name="vl_proc2")
	private BigDecimal vlProc2; //vl_proc2
	
	@Column(name="vl_insu1")
	private BigDecimal vlInsu1; //vl_insu1
	
	@Column(name="vl_insu2")
	private BigDecimal vlInsu2; //vl_insu2
	
	@Column(name="perc_fx1")
	private BigDecimal percFx1; //perc_fx1
	
	@Column(name="perc_fx2")
	private BigDecimal percFx2; //perc_fx2
	
	@Column(name="perc_fx3")
	private BigDecimal percFx3; //perc_fx3
	
	@Column(name="perc_fx4")
	private BigDecimal percFx4; //perc_fx4
	
	@Column(name="perc_fx5")
	private BigDecimal percFx5; //perc_fx5
	
	@Column(name="perc_fx6")
	private BigDecimal percFx6; //perc_fx6
	
	@Column(name="perc_fx7")
	private BigDecimal percFx7; //perc_fx7
	
	@Column(name="perc_fx8")
	private BigDecimal percFx8; //perc_fx8
	
	@Column(name="perc_fx9")
	private BigDecimal percFx9; //perc_fx9
	
	@Column(name="perc_fx10")
	private BigDecimal percFx10; //perc_fx10
	
	@Column(name="perc_fx1_2")
	private BigDecimal percFx1_2; //perc_fx1_2
	
	@Column(name="perc_fx2_2")
	private BigDecimal percFx2_2; //perc_fx2_2
	
	@Column(name="perc_fx3_2")
	private BigDecimal percFx3_2; //perc_fx3_2
	
	@Column(name="perc_fx4_2")
	private BigDecimal percFx4_2; //perc_fx4_2
	
	@Column(name="perc_fx5_2")
	private BigDecimal percFx5_2; //perc_fx5_2
	
	@Column(name="perc_fx6_2")
	private BigDecimal percFx6_2; //perc_fx6_2
	
	@Column(name="perc_fx7_2")
	private BigDecimal percFx7_2; //perc_fx7_2
	
	@Column(name="perc_fx8_2")
	private BigDecimal percFx8_2; //perc_fx8_2
	
	@Column(name="perc_fx9_2")
	private BigDecimal percFx9_2; //perc_fx9_2
	
	@Column(name="perc_fx10_2")
	private BigDecimal percFx10_2; //perc_fx10_2
	
	@Column(name="perc_h_fx1")
	private BigDecimal percHFx1; //perc_h_fx1
	
	@Column(name="perc_h_fx2")
	private BigDecimal percHFx2; //perc_h_fx2
	
	@Column(name="perc_h_fx3")
	private BigDecimal percHFx3; //perc_h_fx3
	
	@Column(name="perc_h_fx4")
	private BigDecimal percHFx4; //perc_h_fx4
	
	@Column(name="perc_h_fx5")
	private BigDecimal percHFx5; //perc_h_fx5
	
	@Column(name="perc_h_fx6")
	private BigDecimal percHFx6; //perc_h_fx6
	
	@Column(name="perc_h_fx7")
	private BigDecimal percHFx7; //perc_h_fx7
	
	@Column(name="perc_h_fx8")
	private BigDecimal percHFx8; //perc_h_fx8
	
	@Column(name="perc_h_fx9")
	private BigDecimal percHFx9; //perc_h_fx9
	
	@Column(name="perc_h_fx10")
	private BigDecimal percHFx10; //perc_h_fx10
	
	@Column(name="perc_m_fx1")
	private BigDecimal percMFx1; //perc_m_fx1
	
	@Column(name="perc_m_fx2")
	private BigDecimal percMFx2; //perc_m_fx2
	
	@Column(name="perc_m_fx3")
	private BigDecimal percMFx3; //perc_m_fx3
	
	@Column(name="perc_m_fx4")
	private BigDecimal percMFx4; //perc_m_fx4
	
	@Column(name="perc_m_fx5")
	private BigDecimal percMFx5; //perc_m_fx5
	
	@Column(name="perc_m_fx6")
	private BigDecimal percMFx6; //perc_m_fx6
	
	@Column(name="perc_m_fx7")
	private BigDecimal percMFx7; //perc_m_fx7
	
	@Column(name="perc_m_fx8")
	private BigDecimal percMFx8; //perc_m_fx8
	
	@Column(name="perc_m_fx9")
	private BigDecimal percMFx9; //perc_m_fx9
	
	@Column(name="perc_m_fx10")
	private BigDecimal percMFx10; //perc_m_fx10
	
	public Chart() {
		super();
	}

	public Chart(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public Chart(Integer codigo, String vlPer1, String vlPer2, String dsInfo1,
			String dsInfo2, String dsInfo3, Integer tipo, BigDecimal vlDecPer1,
			BigDecimal vlDecPer2, BigDecimal vlProc1, BigDecimal vlProc2,
			BigDecimal vlInsu1, BigDecimal vlInsu2, BigDecimal percFx1,
			BigDecimal percFx2, BigDecimal percFx3, BigDecimal percFx4,
			BigDecimal percFx5, BigDecimal percFx6, BigDecimal percFx7,
			BigDecimal percFx8, BigDecimal percFx9, BigDecimal percFx10,
			BigDecimal percFx1_2, BigDecimal percFx2_2, BigDecimal percFx3_2,
			BigDecimal percFx4_2, BigDecimal percFx5_2, BigDecimal percFx6_2,
			BigDecimal percFx7_2, BigDecimal percFx8_2, BigDecimal percFx9_2,
			BigDecimal percFx10_2, BigDecimal percHFx1, BigDecimal percHFx2,
			BigDecimal percHFx3, BigDecimal percHFx4, BigDecimal percHFx5,
			BigDecimal percHFx6, BigDecimal percHFx7, BigDecimal percHFx8,
			BigDecimal percHFx9, BigDecimal percHFx10, BigDecimal percMFx1,
			BigDecimal percMFx2, BigDecimal percMFx3, BigDecimal percMFx4,
			BigDecimal percMFx5, BigDecimal percMFx6, BigDecimal percMFx7,
			BigDecimal percMFx8, BigDecimal percMFx9, BigDecimal percMFx10) {
		super();
		this.codigo = codigo;
		this.vlPer1 = vlPer1;
		this.vlPer2 = vlPer2;
		this.dsInfo1 = dsInfo1;
		this.dsInfo2 = dsInfo2;
		this.dsInfo3 = dsInfo3;
		this.tipo = tipo;
		this.vlDecPer1 = vlDecPer1;
		this.vlDecPer2 = vlDecPer2;
		this.vlProc1 = vlProc1;
		this.vlProc2 = vlProc2;
		this.vlInsu1 = vlInsu1;
		this.vlInsu2 = vlInsu2;
		this.percFx1 = percFx1;
		this.percFx2 = percFx2;
		this.percFx3 = percFx3;
		this.percFx4 = percFx4;
		this.percFx5 = percFx5;
		this.percFx6 = percFx6;
		this.percFx7 = percFx7;
		this.percFx8 = percFx8;
		this.percFx9 = percFx9;
		this.percFx10 = percFx10;
		this.percFx1_2 = percFx1_2;
		this.percFx2_2 = percFx2_2;
		this.percFx3_2 = percFx3_2;
		this.percFx4_2 = percFx4_2;
		this.percFx5_2 = percFx5_2;
		this.percFx6_2 = percFx6_2;
		this.percFx7_2 = percFx7_2;
		this.percFx8_2 = percFx8_2;
		this.percFx9_2 = percFx9_2;
		this.percFx10_2 = percFx10_2;
		this.percHFx1 = percHFx1;
		this.percHFx2 = percHFx2;
		this.percHFx3 = percHFx3;
		this.percHFx4 = percHFx4;
		this.percHFx5 = percHFx5;
		this.percHFx6 = percHFx6;
		this.percHFx7 = percHFx7;
		this.percHFx8 = percHFx8;
		this.percHFx9 = percHFx9;
		this.percHFx10 = percHFx10;
		this.percMFx1 = percMFx1;
		this.percMFx2 = percMFx2;
		this.percMFx3 = percMFx3;
		this.percMFx4 = percMFx4;
		this.percMFx5 = percMFx5;
		this.percMFx6 = percMFx6;
		this.percMFx7 = percMFx7;
		this.percMFx8 = percMFx8;
		this.percMFx9 = percMFx9;
		this.percMFx10 = percMFx10;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dsInfo1 == null) ? 0 : dsInfo1.hashCode());
		result = prime * result + ((dsInfo2 == null) ? 0 : dsInfo2.hashCode());
		result = prime * result + ((dsInfo3 == null) ? 0 : dsInfo3.hashCode());
		result = prime * result + ((percFx1 == null) ? 0 : percFx1.hashCode());
		result = prime * result
				+ ((percFx10 == null) ? 0 : percFx10.hashCode());
		result = prime * result
				+ ((percFx10_2 == null) ? 0 : percFx10_2.hashCode());
		result = prime * result
				+ ((percFx1_2 == null) ? 0 : percFx1_2.hashCode());
		result = prime * result + ((percFx2 == null) ? 0 : percFx2.hashCode());
		result = prime * result
				+ ((percFx2_2 == null) ? 0 : percFx2_2.hashCode());
		result = prime * result + ((percFx3 == null) ? 0 : percFx3.hashCode());
		result = prime * result
				+ ((percFx3_2 == null) ? 0 : percFx3_2.hashCode());
		result = prime * result + ((percFx4 == null) ? 0 : percFx4.hashCode());
		result = prime * result
				+ ((percFx4_2 == null) ? 0 : percFx4_2.hashCode());
		result = prime * result + ((percFx5 == null) ? 0 : percFx5.hashCode());
		result = prime * result
				+ ((percFx5_2 == null) ? 0 : percFx5_2.hashCode());
		result = prime * result + ((percFx6 == null) ? 0 : percFx6.hashCode());
		result = prime * result
				+ ((percFx6_2 == null) ? 0 : percFx6_2.hashCode());
		result = prime * result + ((percFx7 == null) ? 0 : percFx7.hashCode());
		result = prime * result
				+ ((percFx7_2 == null) ? 0 : percFx7_2.hashCode());
		result = prime * result + ((percFx8 == null) ? 0 : percFx8.hashCode());
		result = prime * result
				+ ((percFx8_2 == null) ? 0 : percFx8_2.hashCode());
		result = prime * result + ((percFx9 == null) ? 0 : percFx9.hashCode());
		result = prime * result
				+ ((percFx9_2 == null) ? 0 : percFx9_2.hashCode());
		result = prime * result
				+ ((percHFx1 == null) ? 0 : percHFx1.hashCode());
		result = prime * result
				+ ((percHFx10 == null) ? 0 : percHFx10.hashCode());
		result = prime * result
				+ ((percHFx2 == null) ? 0 : percHFx2.hashCode());
		result = prime * result
				+ ((percHFx3 == null) ? 0 : percHFx3.hashCode());
		result = prime * result
				+ ((percHFx4 == null) ? 0 : percHFx4.hashCode());
		result = prime * result
				+ ((percHFx5 == null) ? 0 : percHFx5.hashCode());
		result = prime * result
				+ ((percHFx6 == null) ? 0 : percHFx6.hashCode());
		result = prime * result
				+ ((percHFx7 == null) ? 0 : percHFx7.hashCode());
		result = prime * result
				+ ((percHFx8 == null) ? 0 : percHFx8.hashCode());
		result = prime * result
				+ ((percHFx9 == null) ? 0 : percHFx9.hashCode());
		result = prime * result
				+ ((percMFx1 == null) ? 0 : percMFx1.hashCode());
		result = prime * result
				+ ((percMFx10 == null) ? 0 : percMFx10.hashCode());
		result = prime * result
				+ ((percMFx2 == null) ? 0 : percMFx2.hashCode());
		result = prime * result
				+ ((percMFx3 == null) ? 0 : percMFx3.hashCode());
		result = prime * result
				+ ((percMFx4 == null) ? 0 : percMFx4.hashCode());
		result = prime * result
				+ ((percMFx5 == null) ? 0 : percMFx5.hashCode());
		result = prime * result
				+ ((percMFx6 == null) ? 0 : percMFx6.hashCode());
		result = prime * result
				+ ((percMFx7 == null) ? 0 : percMFx7.hashCode());
		result = prime * result
				+ ((percMFx8 == null) ? 0 : percMFx8.hashCode());
		result = prime * result
				+ ((percMFx9 == null) ? 0 : percMFx9.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((vlDecPer1 == null) ? 0 : vlDecPer1.hashCode());
		result = prime * result
				+ ((vlDecPer2 == null) ? 0 : vlDecPer2.hashCode());
		result = prime * result + ((vlInsu1 == null) ? 0 : vlInsu1.hashCode());
		result = prime * result + ((vlInsu2 == null) ? 0 : vlInsu2.hashCode());
		result = prime * result + ((vlPer1 == null) ? 0 : vlPer1.hashCode());
		result = prime * result + ((vlPer2 == null) ? 0 : vlPer2.hashCode());
		result = prime * result + ((vlProc1 == null) ? 0 : vlProc1.hashCode());
		result = prime * result + ((vlProc2 == null) ? 0 : vlProc2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chart other = (Chart) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dsInfo1 == null) {
			if (other.dsInfo1 != null)
				return false;
		} else if (!dsInfo1.equals(other.dsInfo1))
			return false;
		if (dsInfo2 == null) {
			if (other.dsInfo2 != null)
				return false;
		} else if (!dsInfo2.equals(other.dsInfo2))
			return false;
		if (dsInfo3 == null) {
			if (other.dsInfo3 != null)
				return false;
		} else if (!dsInfo3.equals(other.dsInfo3))
			return false;
		if (percFx1 == null) {
			if (other.percFx1 != null)
				return false;
		} else if (!percFx1.equals(other.percFx1))
			return false;
		if (percFx10 == null) {
			if (other.percFx10 != null)
				return false;
		} else if (!percFx10.equals(other.percFx10))
			return false;
		if (percFx10_2 == null) {
			if (other.percFx10_2 != null)
				return false;
		} else if (!percFx10_2.equals(other.percFx10_2))
			return false;
		if (percFx1_2 == null) {
			if (other.percFx1_2 != null)
				return false;
		} else if (!percFx1_2.equals(other.percFx1_2))
			return false;
		if (percFx2 == null) {
			if (other.percFx2 != null)
				return false;
		} else if (!percFx2.equals(other.percFx2))
			return false;
		if (percFx2_2 == null) {
			if (other.percFx2_2 != null)
				return false;
		} else if (!percFx2_2.equals(other.percFx2_2))
			return false;
		if (percFx3 == null) {
			if (other.percFx3 != null)
				return false;
		} else if (!percFx3.equals(other.percFx3))
			return false;
		if (percFx3_2 == null) {
			if (other.percFx3_2 != null)
				return false;
		} else if (!percFx3_2.equals(other.percFx3_2))
			return false;
		if (percFx4 == null) {
			if (other.percFx4 != null)
				return false;
		} else if (!percFx4.equals(other.percFx4))
			return false;
		if (percFx4_2 == null) {
			if (other.percFx4_2 != null)
				return false;
		} else if (!percFx4_2.equals(other.percFx4_2))
			return false;
		if (percFx5 == null) {
			if (other.percFx5 != null)
				return false;
		} else if (!percFx5.equals(other.percFx5))
			return false;
		if (percFx5_2 == null) {
			if (other.percFx5_2 != null)
				return false;
		} else if (!percFx5_2.equals(other.percFx5_2))
			return false;
		if (percFx6 == null) {
			if (other.percFx6 != null)
				return false;
		} else if (!percFx6.equals(other.percFx6))
			return false;
		if (percFx6_2 == null) {
			if (other.percFx6_2 != null)
				return false;
		} else if (!percFx6_2.equals(other.percFx6_2))
			return false;
		if (percFx7 == null) {
			if (other.percFx7 != null)
				return false;
		} else if (!percFx7.equals(other.percFx7))
			return false;
		if (percFx7_2 == null) {
			if (other.percFx7_2 != null)
				return false;
		} else if (!percFx7_2.equals(other.percFx7_2))
			return false;
		if (percFx8 == null) {
			if (other.percFx8 != null)
				return false;
		} else if (!percFx8.equals(other.percFx8))
			return false;
		if (percFx8_2 == null) {
			if (other.percFx8_2 != null)
				return false;
		} else if (!percFx8_2.equals(other.percFx8_2))
			return false;
		if (percFx9 == null) {
			if (other.percFx9 != null)
				return false;
		} else if (!percFx9.equals(other.percFx9))
			return false;
		if (percFx9_2 == null) {
			if (other.percFx9_2 != null)
				return false;
		} else if (!percFx9_2.equals(other.percFx9_2))
			return false;
		if (percHFx1 == null) {
			if (other.percHFx1 != null)
				return false;
		} else if (!percHFx1.equals(other.percHFx1))
			return false;
		if (percHFx10 == null) {
			if (other.percHFx10 != null)
				return false;
		} else if (!percHFx10.equals(other.percHFx10))
			return false;
		if (percHFx2 == null) {
			if (other.percHFx2 != null)
				return false;
		} else if (!percHFx2.equals(other.percHFx2))
			return false;
		if (percHFx3 == null) {
			if (other.percHFx3 != null)
				return false;
		} else if (!percHFx3.equals(other.percHFx3))
			return false;
		if (percHFx4 == null) {
			if (other.percHFx4 != null)
				return false;
		} else if (!percHFx4.equals(other.percHFx4))
			return false;
		if (percHFx5 == null) {
			if (other.percHFx5 != null)
				return false;
		} else if (!percHFx5.equals(other.percHFx5))
			return false;
		if (percHFx6 == null) {
			if (other.percHFx6 != null)
				return false;
		} else if (!percHFx6.equals(other.percHFx6))
			return false;
		if (percHFx7 == null) {
			if (other.percHFx7 != null)
				return false;
		} else if (!percHFx7.equals(other.percHFx7))
			return false;
		if (percHFx8 == null) {
			if (other.percHFx8 != null)
				return false;
		} else if (!percHFx8.equals(other.percHFx8))
			return false;
		if (percHFx9 == null) {
			if (other.percHFx9 != null)
				return false;
		} else if (!percHFx9.equals(other.percHFx9))
			return false;
		if (percMFx1 == null) {
			if (other.percMFx1 != null)
				return false;
		} else if (!percMFx1.equals(other.percMFx1))
			return false;
		if (percMFx10 == null) {
			if (other.percMFx10 != null)
				return false;
		} else if (!percMFx10.equals(other.percMFx10))
			return false;
		if (percMFx2 == null) {
			if (other.percMFx2 != null)
				return false;
		} else if (!percMFx2.equals(other.percMFx2))
			return false;
		if (percMFx3 == null) {
			if (other.percMFx3 != null)
				return false;
		} else if (!percMFx3.equals(other.percMFx3))
			return false;
		if (percMFx4 == null) {
			if (other.percMFx4 != null)
				return false;
		} else if (!percMFx4.equals(other.percMFx4))
			return false;
		if (percMFx5 == null) {
			if (other.percMFx5 != null)
				return false;
		} else if (!percMFx5.equals(other.percMFx5))
			return false;
		if (percMFx6 == null) {
			if (other.percMFx6 != null)
				return false;
		} else if (!percMFx6.equals(other.percMFx6))
			return false;
		if (percMFx7 == null) {
			if (other.percMFx7 != null)
				return false;
		} else if (!percMFx7.equals(other.percMFx7))
			return false;
		if (percMFx8 == null) {
			if (other.percMFx8 != null)
				return false;
		} else if (!percMFx8.equals(other.percMFx8))
			return false;
		if (percMFx9 == null) {
			if (other.percMFx9 != null)
				return false;
		} else if (!percMFx9.equals(other.percMFx9))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (vlDecPer1 == null) {
			if (other.vlDecPer1 != null)
				return false;
		} else if (!vlDecPer1.equals(other.vlDecPer1))
			return false;
		if (vlDecPer2 == null) {
			if (other.vlDecPer2 != null)
				return false;
		} else if (!vlDecPer2.equals(other.vlDecPer2))
			return false;
		if (vlInsu1 == null) {
			if (other.vlInsu1 != null)
				return false;
		} else if (!vlInsu1.equals(other.vlInsu1))
			return false;
		if (vlInsu2 == null) {
			if (other.vlInsu2 != null)
				return false;
		} else if (!vlInsu2.equals(other.vlInsu2))
			return false;
		if (vlPer1 == null) {
			if (other.vlPer1 != null)
				return false;
		} else if (!vlPer1.equals(other.vlPer1))
			return false;
		if (vlPer2 == null) {
			if (other.vlPer2 != null)
				return false;
		} else if (!vlPer2.equals(other.vlPer2))
			return false;
		if (vlProc1 == null) {
			if (other.vlProc1 != null)
				return false;
		} else if (!vlProc1.equals(other.vlProc1))
			return false;
		if (vlProc2 == null) {
			if (other.vlProc2 != null)
				return false;
		} else if (!vlProc2.equals(other.vlProc2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chart [codigo=" + codigo + ", vlPer1=" + vlPer1 + ", vlPer2="
				+ vlPer2 + ", dsInfo1=" + dsInfo1 + ", dsInfo2=" + dsInfo2
				+ ", dsInfo3=" + dsInfo3 + ", tipo=" + tipo + ", vlDecPer1="
				+ vlDecPer1 + ", vlDecPer2=" + vlDecPer2 + ", vlProc1="
				+ vlProc1 + ", vlProc2=" + vlProc2 + ", vlInsu1=" + vlInsu1
				+ ", vlInsu2=" + vlInsu2 + ", percFx1=" + percFx1
				+ ", percFx2=" + percFx2 + ", percFx3=" + percFx3
				+ ", percFx4=" + percFx4 + ", percFx5=" + percFx5
				+ ", percFx6=" + percFx6 + ", percFx7=" + percFx7
				+ ", percFx8=" + percFx8 + ", percFx9=" + percFx9
				+ ", percFx10=" + percFx10 + ", percFx1_2=" + percFx1_2
				+ ", percFx2_2=" + percFx2_2 + ", percFx3_2=" + percFx3_2
				+ ", percFx4_2=" + percFx4_2 + ", percFx5_2=" + percFx5_2
				+ ", percFx6_2=" + percFx6_2 + ", percFx7_2=" + percFx7_2
				+ ", percFx8_2=" + percFx8_2 + ", percFx9_2=" + percFx9_2
				+ ", percFx10_2=" + percFx10_2 + ", percHFx1=" + percHFx1
				+ ", percHFx2=" + percHFx2 + ", percHFx3=" + percHFx3
				+ ", percHFx4=" + percHFx4 + ", percHFx5=" + percHFx5
				+ ", percHFx6=" + percHFx6 + ", percHFx7=" + percHFx7
				+ ", percHFx8=" + percHFx8 + ", percHFx9=" + percHFx9
				+ ", percHFx10=" + percHFx10 + ", percMFx1=" + percMFx1
				+ ", percMFx2=" + percMFx2 + ", percMFx3=" + percMFx3
				+ ", percMFx4=" + percMFx4 + ", percMFx5=" + percMFx5
				+ ", percMFx6=" + percMFx6 + ", percMFx7=" + percMFx7
				+ ", percMFx8=" + percMFx8 + ", percMFx9=" + percMFx9
				+ ", percMFx10=" + percMFx10 + "]";
	}
	
}