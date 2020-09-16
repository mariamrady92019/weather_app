package com.example.mymvvmnewstrail.model;

import java.util.List;

public class SurahsItem{
	private int number;
	private String englishName;
	private String revelationType;
	private String name;
	private List<AyahsItem> ayahs;
	private String englishNameTranslation;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setEnglishName(String englishName){
		this.englishName = englishName;
	}

	public String getEnglishName(){
		return englishName;
	}

	public void setRevelationType(String revelationType){
		this.revelationType = revelationType;
	}

	public String getRevelationType(){
		return revelationType;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAyahs(List<AyahsItem> ayahs){
		this.ayahs = ayahs;
	}

	public List<AyahsItem> getAyahs(){
		return ayahs;
	}

	public void setEnglishNameTranslation(String englishNameTranslation){
		this.englishNameTranslation = englishNameTranslation;
	}

	public String getEnglishNameTranslation(){
		return englishNameTranslation;
	}

	@Override
 	public String toString(){
		return 
			"SurahsItem{" + 
			"number = '" + number + '\'' + 
			",englishName = '" + englishName + '\'' + 
			",revelationType = '" + revelationType + '\'' + 
			",name = '" + name + '\'' + 
			",ayahs = '" + ayahs + '\'' + 
			",englishNameTranslation = '" + englishNameTranslation + '\'' + 
			"}";
		}
}