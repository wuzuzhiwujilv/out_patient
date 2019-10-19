package com.eye.op.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.eye.op.common.bean.GenerateBean;

@Entity
@Table(name="screening")
@XmlRootElement
public class Screening extends GenerateBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String lightReflection; //映光
	
	private String dioptroscopy; //spot筛查结果
	
	private String NVOD;//右眼裸眼视力
	
	private String NVOS;//左眼裸眼视力

	private String CVOD;//右眼矫正视力
	
	private String CVOS;//左眼矫正视力
	
	private String ODValue;//灵活度右眼视力
	
	private String OSValue;//灵活度左眼视力

	@Column(name="reflective")
	public String getLightReflection() {
		return lightReflection;
	}

	public void setLightReflection(String lightReflection) {
		this.lightReflection = lightReflection;
	}

	@Column(name="spot_result")
	public String getDioptroscopy() {
		return dioptroscopy;
	}

	public void setDioptroscopy(String dioptroscopy) {
		this.dioptroscopy = dioptroscopy;
	}

	@Column(name="naked_od")
	public String getNVOD() {
		return NVOD;
	}

	public void setNVOD(String nVOD) {
		NVOD = nVOD;
	}

	@Column(name="naked_os")
	public String getNVOS() {
		return NVOS;
	}

	public void setNVOS(String nVOS) {
		NVOS = nVOS;
	}

	@Column(name="correcttion_od")
	public String getCVOD() {
		return CVOD;
	}

	public void setCVOD(String cVOD) {
		CVOD = cVOD;
	}

	@Column(name="correction_os")
	public String getCVOS() {
		return CVOS;
	}

	public void setCVOS(String cVOS) {
		CVOS = cVOS;
	}

	@Column(name="flexcheck_od")
	public String getODValue() {
		return ODValue;
	}

	public void setODValue(String oDValue) {
		ODValue = oDValue;
	}

	@Column(name="flexcheck_os")
	public String getOSValue() {
		return OSValue;
	}

	public void setOSValue(String oSValue) {
		OSValue = oSValue;
	}

	


}
