package com.example.mymvvmnewstrail.model;

public class Sajda{
	private boolean obligatory;
	private int id;
	private boolean recommended;

	public void setObligatory(boolean obligatory){
		this.obligatory = obligatory;
	}

	public boolean isObligatory(){
		return obligatory;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRecommended(boolean recommended){
		this.recommended = recommended;
	}

	public boolean isRecommended(){
		return recommended;
	}

	@Override
 	public String toString(){
		return 
			"Sajda{" + 
			"obligatory = '" + obligatory + '\'' + 
			",id = '" + id + '\'' + 
			",recommended = '" + recommended + '\'' + 
			"}";
		}
}
