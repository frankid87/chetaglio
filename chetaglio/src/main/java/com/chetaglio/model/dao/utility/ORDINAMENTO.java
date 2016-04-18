package com.chetaglio.model.dao.utility;

public enum ORDINAMENTO{
	ASC("asc"),
	DESC("desc");
	
	private String value;
	
	ORDINAMENTO(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}