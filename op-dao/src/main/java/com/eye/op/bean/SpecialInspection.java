package com.eye.op.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.eye.op.common.bean.GenerateBean;

@Entity
@Table(name="specilInspection")
@XmlRootElement
public class SpecialInspection extends GenerateBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//光学生物测量
	private  String ALODValue;//
	
	private  String  ALOSValue;
	//CCT值
	private  String  CCTODValue;
	
	private  String  CCTOSValue;
	//AD值
	private  String  ADODValue;
	
	private  String  ADOSValue;
	//ACD值
	private  String  ACDODValue;
	
	private  String  ACDOSValue;
	//LT值
	private  String  LTODValue;
	
	private  String  LTOSValue;
	//K1值
	private  String  K1ODValue;
	
	private  String  K1OSValue;
	//K2值
	private  String  K2ODValue;
	
	private  String  K2OSValue;
	//AST值
	private  String  ASTODValue;
	
	private  String  ASTOSValue;
	//PUPIL值
	private  String  PUPILODValue;
	
	private  String  PUPILOSValue;
	//WTW值
	private  String  WTWODValue;
	
	private  String  WTWOSValue;
	//验光 （表屈光）
	private  String  refractionOD; // 表屈光
	
	private  String  refractionDS;
	
	private  String  refractionDCX;
	
	private  String  refractionOS;
	
	private  String  refraction_OS_DS;
	
	private  String  refraction_OS_DCX;
	
	private  String  mydriasisOD;
	
	private  String  mydriasisDS;
	
	private  String  mydriasisDCX;
	
	private  String  mydriasisOS;
	
	private  String  mydriasis_OS_DS;
	
	private  String  mydriasis_OS_DCX;
	
	//视功能检查
	private  String  AFOD;
	
	private  String  AFOS;
	
	private  String  AFOU;
	//AMP值
	private  String  AMPOD;
	
	private  String  AMPOS;
	
	private  String  AMPOU;
	
	private  String  BCCOD;
	
	private  String  BCCOS;
	
	private  String  BCCOU;
	
	private  String  NRAOD;
	
	private  String  NRAOS;
	
	private  String  NRAOU;
	//PRA值
	private  String  PRAOD;
	
	private  String  PRAOS;
	
	private  String  PRAOU;
	
	private  String  NPCValue;
	
	private  String  AC＿AValue;
	
//	private  String[]  mydriatic;
	
	private  String lstMydriatic;

	private  String  img_specialTest;
	
	private  String  img_path;

//	@Transient
//	public String[] getMydriatic() {
//		return mydriatic;
//	}
//
//	public void setMydriatic(String[] mydriatic) {
//		this.mydriatic = mydriatic;
//	}

	@Column(name="mydriatic")
	public String getLstMydriatic() {
		return lstMydriatic;
	}

	public void setLstMydriatic(String lstMydriatic) {
		this.lstMydriatic = lstMydriatic;
	}

	@Column
	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	@Transient
	public String getImg_specialTest() {
		return img_specialTest;
	}

	public void setImg_specialTest(String img_specialTest) {
		this.img_specialTest = img_specialTest;
	}


	@Column(name="ALOD")
	public String getALODValue() {
		return ALODValue;
	}

	public void setALODValue(String aLODValue) {
		ALODValue = aLODValue;
	}

	@Column(name="ALOS")
	public String getALOSValue() {
		return ALOSValue;
	}

	public void setALOSValue(String aLOSValue) {
		ALOSValue = aLOSValue;
	}
	
	@Column(name="CCTOD")
	public String getCCTODValue() {
		return CCTODValue;
	}

	public void setCCTODValue(String cCTODValue) {
		CCTODValue = cCTODValue;
	}

	@Column(name="CCTOS")
	public String getCCTOSValue() {
		return CCTOSValue;
	}

	public void setCCTOSValue(String cCTOSValue) {
		CCTOSValue = cCTOSValue;
	}

	@Column(name="ADOD")
	public String getADODValue() {
		return ADODValue;
	}

	public void setADODValue(String aDODValue) {
		ADODValue = aDODValue;
	}
	
	@Column(name="ADOS")
	public String getADOSValue() {
		return ADOSValue;
	}

	public void setADOSValue(String aDOSValue) {
		ADOSValue = aDOSValue;
	}

	@Column(name="ACDOD")
	public String getACDODValue() {
		return ACDODValue;
	}

	public void setACDODValue(String aCDODValue) {
		ACDODValue = aCDODValue;
	}

	@Column(name="ACDOS")
	public String getACDOSValue() {
		return ACDOSValue;
	}

	public void setACDOSValue(String aCDOSValue) {
		ACDOSValue = aCDOSValue;
	}

	@Column(name="LT_OD")
	public String getLTODValue() {
		return LTODValue;
	}

	public void setLTODValue(String lTODValue) {
		LTODValue = lTODValue;
	}

	@Column(name="LT_OS")
	public String getLTOSValue() {
		return LTOSValue;
	}

	public void setLTOSValue(String lTOSValue) {
		LTOSValue = lTOSValue;
	}

	@Column(name="K1_OD")
	public String getK1ODValue() {
		return K1ODValue;
	}

	public void setK1ODValue(String k1odValue) {
		K1ODValue = k1odValue;
	}

	@Column(name="K1_OS")
	public String getK1OSValue() {
		return K1OSValue;
	}

	public void setK1OSValue(String k1osValue) {
		K1OSValue = k1osValue;
	}

	@Column(name="K2_OD")
	public String getK2ODValue() {
		return K2ODValue;
	}

	public void setK2ODValue(String k2odValue) {
		K2ODValue = k2odValue;
	}

	@Column(name="K2_OS")
	public String getK2OSValue() {
		return K2OSValue;
	}

	public void setK2OSValue(String k2osValue) {
		K2OSValue = k2osValue;
	}

	@Column(name="AST_OD")
	public String getASTODValue() {
		return ASTODValue;
	}

	public void setASTODValue(String aSTODValue) {
		ASTODValue = aSTODValue;
	}

	@Column(name="AST_OS")
	public String getASTOSValue() {
		return ASTOSValue;
	}

	public void setASTOSValue(String aSTOSValue) {
		ASTOSValue = aSTOSValue;
	}

	@Column(name="PUPIL_OD")
	public String getPUPILODValue() {
		return PUPILODValue;
	}

	public void setPUPILODValue(String pUPILODValue) {
		PUPILODValue = pUPILODValue;
	}

	@Column(name="PUPIL_OS")
	public String getPUPILOSValue() {
		return PUPILOSValue;
	}

	public void setPUPILOSValue(String pUPILOSValue) {
		PUPILOSValue = pUPILOSValue;
	}

	@Column(name="WTW_OD")
	public String getWTWODValue() {
		return WTWODValue;
	}

	public void setWTWODValue(String wTWODValue) {
		WTWODValue = wTWODValue;
	}

	@Column(name="WTW_OS")
	public String getWTWOSValue() {
		return WTWOSValue;
	}

	public void setWTWOSValue(String wTWOSValue) {
		WTWOSValue = wTWOSValue;
	}

	@Column(name="refraction_OD")
	public String getRefractionOD() {
		return refractionOD;
	}

	public void setRefractionOD(String refractionOD) {
		this.refractionOD = refractionOD;
	}

	@Column(name="refraction_OS")
	public String getRefractionDS() {
		return refractionDS;
	}

	public void setRefractionDS(String refractionDS) {
		this.refractionDS = refractionDS;
	}

	@Column(name="refractionDCX")
	public String getRefractionDCX() {
		return refractionDCX;
	}

	public void setRefractionDCX(String refractionDCX) {
		this.refractionDCX = refractionDCX;
	}

	@Column(name="refractionOS")
	public String getRefractionOS() {
		return refractionOS;
	}

	public void setRefractionOS(String refractionOS) {
		this.refractionOS = refractionOS;
	}

	@Column(name="refraction_OS_DS")
	public String getRefraction_OS_DS() {
		return refraction_OS_DS;
	}

	public void setRefraction_OS_DS(String refraction_OS_DS) {
		this.refraction_OS_DS = refraction_OS_DS;
	}

	@Column(name="refraction_OS_DCX")
	public String getRefraction_OS_DCX() {
		return refraction_OS_DCX;
	}

	public void setRefraction_OS_DCX(String refraction_OS_DCX) {
		this.refraction_OS_DCX = refraction_OS_DCX;
	}

	@Column(name="mydriasisOD")
	public String getMydriasisOD() {
		return mydriasisOD;
	}

	public void setMydriasisOD(String mydriasisOD) {
		this.mydriasisOD = mydriasisOD;
	}

	@Column(name="mydriasisDS")
	public String getMydriasisDS() {
		return mydriasisDS;
	}

	public void setMydriasisDS(String mydriasisDS) {
		this.mydriasisDS = mydriasisDS;
	}

	@Column(name="mydriasisDCX")
	public String getMydriasisDCX() {
		return mydriasisDCX;
	}

	public void setMydriasisDCX(String mydriasisDCX) {
		this.mydriasisDCX = mydriasisDCX;
	}

	@Column(name="mydriasisOS")
	public String getMydriasisOS() {
		return mydriasisOS;
	}

	public void setMydriasisOS(String mydriasisOS) {
		this.mydriasisOS = mydriasisOS;
	}

	@Column(name="mydriasis_OS_DS")
	public String getMydriasis_OS_DS() {
		return mydriasis_OS_DS;
	}

	public void setMydriasis_OS_DS(String mydriasis_OS_DS) {
		this.mydriasis_OS_DS = mydriasis_OS_DS;
	}

	@Column(name="mydriasis_OS_DCX")
	public String getMydriasis_OS_DCX() {
		return mydriasis_OS_DCX;
	}

	public void setMydriasis_OS_DCX(String mydriasis_OS_DCX) {
		this.mydriasis_OS_DCX = mydriasis_OS_DCX;
	}

	@Column(name="AFOD")
	public String getAFOD() {
		return AFOD;
	}

	public void setAFOD(String aFOD) {
		AFOD = aFOD;
	}

	@Column(name="AFOS")
	public String getAFOS() {
		return AFOS;
	}

	public void setAFOS(String aFOS) {
		AFOS = aFOS;
	}

	@Column(name="AFOU")
	public String getAFOU() {
		return AFOU;
	}

	public void setAFOU(String aFOU) {
		AFOU = aFOU;
	}

	@Column(name="AMPOD")
	public String getAMPOD() {
		return AMPOD;
	}

	public void setAMPOD(String aMPOD) {
		AMPOD = aMPOD;
	}

	@Column
	public String getAMPOS() {
		return AMPOS;
	}

	public void setAMPOS(String aMPOS) {
		AMPOS = aMPOS;
	}

	@Column
	public String getAMPOU() {
		return AMPOU;
	}

	public void setAMPOU(String aMPOU) {
		AMPOU = aMPOU;
	}

	@Column
	public String getBCCOD() {
		return BCCOD;
	}

	public void setBCCOD(String bCCOD) {
		BCCOD = bCCOD;
	}

	@Column
	public String getBCCOS() {
		return BCCOS;
	}

	public void setBCCOS(String bCCOS) {
		BCCOS = bCCOS;
	}

	@Column
	public String getBCCOU() {
		return BCCOU;
	}

	public void setBCCOU(String bCCOU) {
		BCCOU = bCCOU;
	}

	@Column
	public String getNRAOD() {
		return NRAOD;
	}

	public void setNRAOD(String nRAOD) {
		NRAOD = nRAOD;
	}

	@Column
	public String getNRAOS() {
		return NRAOS;
	}

	public void setNRAOS(String nRAOS) {
		NRAOS = nRAOS;
	}

	@Column
	public String getNRAOU() {
		return NRAOU;
	}

	public void setNRAOU(String nRAOU) {
		NRAOU = nRAOU;
	}

	@Column
	public String getPRAOD() {
		return PRAOD;
	}

	public void setPRAOD(String pRAOD) {
		PRAOD = pRAOD;
	}

	@Column
	public String getPRAOS() {
		return PRAOS;
	}

	public void setPRAOS(String pRAOS) {
		PRAOS = pRAOS;
	}

	@Column
	public String getPRAOU() {
		return PRAOU;
	}

	public void setPRAOU(String pRAOU) {
		PRAOU = pRAOU;
	}

	@Column
	public String getNPCValue() {
		return NPCValue;
	}

	public void setNPCValue(String nPCValue) {
		NPCValue = nPCValue;
	}

	@Column(name="AC_AValue")
	public String getAC＿AValue() {
		return AC＿AValue;
	}

	public void setAC＿AValue(String aC＿AValue) {
		AC＿AValue = aC＿AValue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
