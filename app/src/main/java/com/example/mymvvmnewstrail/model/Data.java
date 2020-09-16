package com.example.mymvvmnewstrail.model;

import java.util.List;

public class Data{
	private Edition edition;
	private List<SurahsItem> surahs;

	public void setEdition(Edition edition){
		this.edition = edition;
	}

	public Edition getEdition(){
		return edition;
	}

	public void setSurahs(List<SurahsItem> surahs){
		this.surahs = surahs;
	}

	public List<SurahsItem> getSurahs(){
		return surahs;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"edition = '" + edition + '\'' + 
			",surahs = '" + surahs + '\'' + 
			"}";
		}
}