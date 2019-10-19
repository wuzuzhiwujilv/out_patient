package com.eye.op.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.eye.op.common.bean.GenerateBean;

@Entity
@Table(name = "questionnaire")
public class Questionnaire extends GenerateBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private String id;
	private String name;
	private String idCard;
	private String height;
	private String weight;
	private String levelOfFather;// 教育水平
	private String levleOfMother;
	private String ifFatherMyopia;// 父亲是否近视
	private String ifMotherMyopia;
	private String ifFatherHighMyopia;// 是否高度近视
	private String ifMotherHighMyopia;
	private String incomeLevel; // 家庭收入
	private String ChildbearingAge;// 生育年龄
	private String deliveryMod; // 分娩方式
	private String dateOfPregnancy;// 孕期
	private String ifmoke;
	private String ifecondSomke;
	private String milkTime;// 母乳时间
	private String medicalHistory;
	private String dateOfOutsite; // 户外运动时间
	private String dateOfReader; // 读书时间
	private String dateOfHomework; // 电子产品完成家庭作业时间
	private String TVDistance;// 电视距离
	private String illumination; // 照明
	private String drinkMilK;
	private String sleepTime;// 睡觉时间
	private String getUpTime; // 起床时间
	private String durationOfNap;// 午睡时长
	private String durationSleep;
	private String pcTime;
	private String mobileTime;
	private String ifSport;
	private String typeOfSport;
	private String timeOfSprot;

	@Column(name = "height")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "idcard")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setIfFatherMyopia(String ifFatherMyopia) {
		this.ifFatherMyopia = ifFatherMyopia;
	}

	public void setIfMotherMyopia(String ifMotherMyopia) {
		this.ifMotherMyopia = ifMotherMyopia;
	}

	public void setIfFatherHighMyopia(String ifFatherHighMyopia) {
		this.ifFatherHighMyopia = ifFatherHighMyopia;
	}

	public void setIfMotherHighMyopia(String ifMotherHighMyopia) {
		this.ifMotherHighMyopia = ifMotherHighMyopia;
	}

	@Column(name = "is_father_myopia")
	public String getIfFatherMyopia() {
		return ifFatherMyopia;
	}

	@Column(name = "is_mather_myopia")
	public String getIfMotherMyopia() {
		return ifMotherMyopia;
	}

	@Column(name = "is_fatherhighmyopia")
	public String getIfFatherHighMyopia() {
		return ifFatherHighMyopia;
	}

	@Column(name = "is_motherhighmyopia")
	public String getIfMotherHighMyopia() {
		return ifMotherHighMyopia;
	}

	@Column(name = "weight")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "level_father")
	public String getLevelOfFather() {
		return levelOfFather;
	}

	public void setLevelOfFather(String levelOfFather) {
		this.levelOfFather = levelOfFather;
	}

	@Column(name = "level_mother")
	public String getLevleOfMother() {
		return levleOfMother;
	}

	public void setLevleOfMother(String levleOfMother) {
		this.levleOfMother = levleOfMother;
	}

	@Column(name = "income")
	public String getIncomeLevel() {
		return incomeLevel;
	}

	public void setIncomeLevel(String incomeLevel) {
		this.incomeLevel = incomeLevel;
	}

	@Column(name = "date_outside")
	public String getDateOfOutsite() {
		return dateOfOutsite;
	}

	public void setDateOfOutsite(String dateOfOutsite) {
		this.dateOfOutsite = dateOfOutsite;
	}

	@Column(name = "date_read")
	public String getDateOfReader() {
		return dateOfReader;
	}

	public void setDateOfReader(String dateOfReader) {
		this.dateOfReader = dateOfReader;
	}

	@Column(name = "date_homework")
	public String getDateOfHomework() {
		return dateOfHomework;
	}

	public void setDateOfHomework(String dateOfHomework) {
		this.dateOfHomework = dateOfHomework;
	}

	@Column(name = "tv_distance")
	public String getTVDistance() {
		return TVDistance;
	}

	public void setTVDistance(String tVDistance) {
		TVDistance = tVDistance;
	}

	@Column(name = "zhaoming")
	public String getIllumination() {
		return illumination;
	}

	public void setIllumination(String illumination) {
		this.illumination = illumination;
	}

	@Column(name = "drink_milk")
	public String getDrinkMilK() {
		return drinkMilK;
	}

	public void setDrinkMilK(String drinkMilK) {
		this.drinkMilK = drinkMilK;
	}

	@Column(name = "is_smoke")
	public String getIfmoke() {
		return ifmoke;
	}

	public void setIfmoke(String ifmoke) {
		this.ifmoke = ifmoke;
	}

	@Column(name = "is_secondsmoke")
	public String getIfecondSomke() {
		return ifecondSomke;
	}

	public void setIfecondSomke(String ifecondSomke) {
		this.ifecondSomke = ifecondSomke;
	}

	@Column(name = "is_sport")
	public String getIfSport() {
		return ifSport;
	}

	public void setIfSport(String ifSport) {
		this.ifSport = ifSport;
	}

	@Column(name = "sleep_time")
	public String getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(String sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Column(name = "getup_time")
	public String getGetUpTime() {
		return getUpTime;
	}

	public void setGetUpTime(String getUpTime) {
		this.getUpTime = getUpTime;
	}

	@Column(name = "duration_nap")
	public String getDurationOfNap() {
		return durationOfNap;
	}

	public void setDurationOfNap(String durationOfNap) {
		this.durationOfNap = durationOfNap;
	}

	@Column(name = "duration_sleep")
	public String getDurationSleep() {
		return durationSleep;
	}

	public void setDurationSleep(String durationSleep) {
		this.durationSleep = durationSleep;
	}

	@Column(name = "pc_time")
	public String getPcTime() {
		return pcTime;
	}

	public void setPcTime(String pcTime) {
		this.pcTime = pcTime;
	}

	@Column(name = "moible_time")
	public String getMobileTime() {
		return mobileTime;
	}

	public void setMobileTime(String mobileTime) {
		this.mobileTime = mobileTime;
	}

	@Column(name = "type_sport")
	public String getTypeOfSport() {
		return typeOfSport;
	}

	public void setTypeOfSport(String typeOfSport) {
		this.typeOfSport = typeOfSport;
	}

	@Column(name = "time_sprot")
	public String getTimeOfSprot() {
		return timeOfSprot;
	}

	public void setTimeOfSprot(String timeOfSprot) {
		this.timeOfSprot = timeOfSprot;
	}

	@Column(name = "child_mod")
	public String getChildbearingAge() {
		return ChildbearingAge;
	}

	public void setChildbearingAge(String childbearingAge) {
		ChildbearingAge = childbearingAge;
	}

	@Column(name = "deliver_mod")
	public String getDeliveryMod() {
		return deliveryMod;
	}

	public void setDeliveryMod(String deliveryMod) {
		this.deliveryMod = deliveryMod;
	}

	@Column(name = "date_preg")
	public String getDateOfPregnancy() {
		return dateOfPregnancy;
	}

	public void setDateOfPregnancy(String dateOfPregnancy) {
		this.dateOfPregnancy = dateOfPregnancy;
	}

	@Column(name = "milk_time")
	public String getMilkTime() {
		return milkTime;
	}

	public void setMilkTime(String milkTime) {
		this.milkTime = milkTime;
	}

	@Column(name = "medica_history")
	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

}
