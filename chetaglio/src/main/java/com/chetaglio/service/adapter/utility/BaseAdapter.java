package com.chetaglio.service.adapter.utility;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class BaseAdapter {
	
	public DozerBeanMapper mapper; 
	
	public BaseAdapter(){
		List<String> myMappingFiles = new ArrayList<String>();
		myMappingFiles.add("mapper.xml");
		
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
	}
}
