package com.chetaglio.service.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chetaglio.service.service.NegozioService;
import com.chetaglio.utility.FactoryDataTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-test.xml")
public class DaoTest {
	
	@Autowired
	private NegozioService negozioService;
	
	@Test
	public void test(){
//		negozioService.findByCittaCategoriaInsegna(null, null, "capelli' Rossi");
		
		negozioService.create(FactoryDataTest.getNegozio());
	}
}
