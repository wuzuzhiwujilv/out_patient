package com.eye.op.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eye.op.common.bean.GenerateBean;

@Entity
@Table(name="routine")
public class RoutineInspection extends GenerateBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  String NVOD;
	
	private  String NVOS;
	
	private  String CVOD;
	
	private  String CVOS;
	
	private  String lightReflection; // 映光
	
	private  String preganglionic; // 眼前节
	
	private  String img_preganglionic_result;
	
	private  String img_preganglionic_path;
	
	private  String eyeGround;//眼底
	
	private  String img_eyeground_result;
	
	private  String  img_eyeground_path;
	
	private  String  eyeMove;
	//九张图片   (上中下  )
	private  String  img_eyeMoveLT_result;
	
	private  String  img_eyeMoveLT_path; 
	
	private  String  img_eyeMoveCT_result;
	
	private  String  img_eyeMoveCT_path;
	
	private  String  img_eyeMoveRT_result;
	
	private  String  img_eyeMoveRT_path;
	
	private  String  img_eyeMoveLC_result;
	
	private  String  img_eyeMoveLC_path;
	
	private  String  img_eyeMoveCC_result;
	
	private  String  img_eyeMoveCC_path;
	
	private  String  img_eyeMoveRC_result;
	
	private  String  img_eyeMoveRC_path;
	
	private  String  img_eyeMoveLB_result;
	
	private  String  img_eyeMoveLB_path;
	
	private  String  img_eyeMoveCB_result;
	
	private  String  img_eyeMoveCB_path;
	
	private  String  img_eyeMoveRB_result;
	
	private  String  img_eyeMoveRB_path;
	
	private  String  synoptophore; //同视机
	
	private  String  synoptophore_LT;
	
	private  String  synoptophore_CT;
	
	private  String  synoptophore_RT;
	
	private  String  synoptophore_LC;
	
	private  String  synoptophore_CC;
	
	private  String  synoptophore_RC;
	
	private  String  synoptophore_LB;
	
	private  String  synoptophore_CB;
	
	private  String  synoptophore_RB;
	
	//三棱镜加遮盖
	
	private  String  prism_REF_33;
	
	private  String  prism_REF_6;
	
	private  String  prism_LEF_33;
	
	private  String  prism_LEF_6;
	
	private  String  Titimus;
	
	@Column
	public String getNVOD() {
		return NVOD;
	}

	public void setNVOD(String nVOD) {
		NVOD = nVOD;
	}

	@Column
	public String getNVOS() {
		return NVOS;
	}

	public void setNVOS(String nVOS) {
		NVOS = nVOS;
	}

	@Column
	public String getCVOD() {
		return CVOD;
	}

	public void setCVOD(String cVOD) {
		CVOD = cVOD;
	}

	@Column
	public String getCVOS() {
		return CVOS;
	}

	public void setCVOS(String cVOS) {
		CVOS = cVOS;
	}

	@Column
	public String getLightReflection() {
		return lightReflection;
	}

	public void setLightReflection(String lightReflection) {
		this.lightReflection = lightReflection;
	}

	@Column
	public String getPreganglionic() {
		return preganglionic;
	}

	public void setPreganglionic(String preganglionic) {
		this.preganglionic = preganglionic;
	}

	@Transient
	public String getImg_preganglionic_result() {
		return img_preganglionic_result;
	}

	public void setImg_preganglionic_result(String img_preganglionic_result) {
		this.img_preganglionic_result = img_preganglionic_result;
	}

	@Column
	public String getImg_preganglionic_path() {
		return img_preganglionic_path;
	}

	public void setImg_preganglionic_path(String img_preganglionic_path) {
		this.img_preganglionic_path = img_preganglionic_path;
	}

	@Column
	public String getEyeGround() {
		return eyeGround;
	}

	public void setEyeGround(String eyeGround) {
		this.eyeGround = eyeGround;
	}
	
	@Column
	public String getImg_eyeground_path() {
		return img_eyeground_path;
	}

	public void setImg_eyeground_path(String img_eyeground_path) {
		this.img_eyeground_path = img_eyeground_path;
	}

	@Transient
	public String getImg_eyeground_result() {
		return img_eyeground_result;
	}

	public void setImg_eyeground_result(String img_eyeground_result) {
		this.img_eyeground_result = img_eyeground_result;
	}

	@Column
	public String getEyeMove() {
		return eyeMove;
	}

	public void setEyeMove(String eyeMove) {
		this.eyeMove = eyeMove;
	}

	@Transient
	public String getImg_eyeMoveLT_result() {
		return img_eyeMoveLT_result;
	}

	public void setImg_eyeMoveLT_result(String img_eyeMoveLT_result) {
		this.img_eyeMoveLT_result = img_eyeMoveLT_result;
	}

	@Column
	public String getImg_eyeMoveLT_path() {
		return img_eyeMoveLT_path;
	}

	public void setImg_eyeMoveLT_path(String img_eyeMoveLT_path) {
		this.img_eyeMoveLT_path = img_eyeMoveLT_path;
	}

	@Transient
	public String getImg_eyeMoveCT_result() {
		return img_eyeMoveCT_result;
	}

	public void setImg_eyeMoveCT_result(String img_eyeMoveCT_result) {
		this.img_eyeMoveCT_result = img_eyeMoveCT_result;
	}

	@Column
	public String getImg_eyeMoveCT_path() {
		return img_eyeMoveCT_path;
	}

	public void setImg_eyeMoveCT_path(String img_eyeMoveCT_path) {
		this.img_eyeMoveCT_path = img_eyeMoveCT_path;
	}

	@Transient
	public String getImg_eyeMoveRT_result() {
		return img_eyeMoveRT_result;
	}

	public void setImg_eyeMoveRT_result(String img_eyeMoveRT_result) {
		this.img_eyeMoveRT_result = img_eyeMoveRT_result;
	}

	@Column
	public String getImg_eyeMoveRT_path() {
		return img_eyeMoveRT_path;
	}

	public void setImg_eyeMoveRT_path(String img_eyeMoveRT_path) {
		this.img_eyeMoveRT_path = img_eyeMoveRT_path;
	}

	@Transient
	public String getImg_eyeMoveLC_result() {
		return img_eyeMoveLC_result;
	}

	public void setImg_eyeMoveLC_result(String img_eyeMoveLC_result) {
		this.img_eyeMoveLC_result = img_eyeMoveLC_result;
	}

	@Column
	public String getImg_eyeMoveLC_path() {
		return img_eyeMoveLC_path;
	}

	public void setImg_eyeMoveLC_path(String img_eyeMoveLC_path) {
		this.img_eyeMoveLC_path = img_eyeMoveLC_path;
	}

	@Transient
	public String getImg_eyeMoveCC_result() {
		return img_eyeMoveCC_result;
	}

	public void setImg_eyeMoveCC_result(String img_eyeMoveCC_result) {
		this.img_eyeMoveCC_result = img_eyeMoveCC_result;
	}

	@Column
	public String getImg_eyeMoveCC_path() {
		return img_eyeMoveCC_path;
	}

	public void setImg_eyeMoveCC_path(String img_eyeMoveCC_path) {
		this.img_eyeMoveCC_path = img_eyeMoveCC_path;
	}

	@Transient
	public String getImg_eyeMoveRC_result() {
		return img_eyeMoveRC_result;
	}

	public void setImg_eyeMoveRC_result(String img_eyeMoveRC_result) {
		this.img_eyeMoveRC_result = img_eyeMoveRC_result;
	}

	@Column
	public String getImg_eyeMoveRC_path() {
		return img_eyeMoveRC_path;
	}

	public void setImg_eyeMoveRC_path(String img_eyeMoveRC_path) {
		this.img_eyeMoveRC_path = img_eyeMoveRC_path;
	}

	@Transient
	public String getImg_eyeMoveLB_result() {
		return img_eyeMoveLB_result;
	}

	public void setImg_eyeMoveLB_result(String img_eyeMoveLB_result) {
		this.img_eyeMoveLB_result = img_eyeMoveLB_result;
	}

	@Column
	public String getImg_eyeMoveLB_path() {
		return img_eyeMoveLB_path;
	}

	public void setImg_eyeMoveLB_path(String img_eyeMoveLB_path) {
		this.img_eyeMoveLB_path = img_eyeMoveLB_path;
	}
	
	@Transient
	public String getImg_eyeMoveCB_result() {
		return img_eyeMoveCB_result;
	}

	public void setImg_eyeMoveCB_result(String img_eyeMoveCB_result) {
		this.img_eyeMoveCB_result = img_eyeMoveCB_result;
	}

	@Column
	public String getImg_eyeMoveCB_path() {
		return img_eyeMoveCB_path;
	}

	public void setImg_eyeMoveCB_path(String img_eyeMoveCB_path) {
		this.img_eyeMoveCB_path = img_eyeMoveCB_path;
	}

	@Transient
	public String getImg_eyeMoveRB_result() {
		return img_eyeMoveRB_result;
	}

	public void setImg_eyeMoveRB_result(String img_eyeMoveRB_result) {
		this.img_eyeMoveRB_result = img_eyeMoveRB_result;
	}

	@Column
	public String getImg_eyeMoveRB_path() {
		return img_eyeMoveRB_path;
	}

	public void setImg_eyeMoveRB_path(String img_eyeMoveRB_path) {
		this.img_eyeMoveRB_path = img_eyeMoveRB_path;
	}

	@Column
	public String getSynoptophore() {
		return synoptophore;
	}

	public void setSynoptophore(String synoptophore) {
		this.synoptophore = synoptophore;
	}

	@Column
	public String getSynoptophore_LT() {
		return synoptophore_LT;
	}

	public void setSynoptophore_LT(String synoptophore_LT) {
		this.synoptophore_LT = synoptophore_LT;
	}

	@Column
	public String getSynoptophore_CT() {
		return synoptophore_CT;
	}

	public void setSynoptophore_CT(String synoptophore_CT) {
		this.synoptophore_CT = synoptophore_CT;
	}

	@Column
	public String getSynoptophore_RT() {
		return synoptophore_RT;
	}

	public void setSynoptophore_RT(String synoptophore_RT) {
		this.synoptophore_RT = synoptophore_RT;
	}

	@Column
	public String getSynoptophore_LC() {
		return synoptophore_LC;
	}

	public void setSynoptophore_LC(String synoptophore_LC) {
		this.synoptophore_LC = synoptophore_LC;
	}

	@Column
	public String getSynoptophore_CC() {
		return synoptophore_CC;
	}

	public void setSynoptophore_CC(String synoptophore_CC) {
		this.synoptophore_CC = synoptophore_CC;
	}

	@Column
	public String getSynoptophore_RC() {
		return synoptophore_RC;
	}

	public void setSynoptophore_RC(String synoptophore_RC) {
		this.synoptophore_RC = synoptophore_RC;
	}

	@Column
	public String getSynoptophore_LB() {
		return synoptophore_LB;
	}

	public void setSynoptophore_LB(String synoptophore_LB) {
		this.synoptophore_LB = synoptophore_LB;
	}

	@Column
	public String getSynoptophore_CB() {
		return synoptophore_CB;
	}

	public void setSynoptophore_CB(String synoptophore_CB) {
		this.synoptophore_CB = synoptophore_CB;
	}

	@Column
	public String getSynoptophore_RB() {
		return synoptophore_RB;
	}

	public void setSynoptophore_RB(String synoptophore_RB) {
		this.synoptophore_RB = synoptophore_RB;
	}

	@Column
	public String getPrism_REF_33() {
		return prism_REF_33;
	}

	public void setPrism_REF_33(String prism_REF_33) {
		this.prism_REF_33 = prism_REF_33;
	}

	@Column
	public String getPrism_REF_6() {
		return prism_REF_6;
	}

	public void setPrism_REF_6(String prism_REF_6) {
		this.prism_REF_6 = prism_REF_6;
	}

	@Column
	public String getPrism_LEF_33() {
		return prism_LEF_33;
	}

	public void setPrism_LEF_33(String prism_LEF_33) {
		this.prism_LEF_33 = prism_LEF_33;
	}

	@Column
	public String getPrism_LEF_6() {
		return prism_LEF_6;
	}

	public void setPrism_LEF_6(String prism_LEF_6) {
		this.prism_LEF_6 = prism_LEF_6;
	}

	@Column
	public String getTitimus() {
		return Titimus;
	}

	public void setTitimus(String titimus) {
		Titimus = titimus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
