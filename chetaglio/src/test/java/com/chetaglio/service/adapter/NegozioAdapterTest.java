package com.chetaglio.service.adapter;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.chetaglio.model.entity.Negozio;
import com.chetaglio.service.dto.NegozioDTO;
import com.chetaglio.utility.FactoryDataTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class NegozioAdapterTest {
	
	@Autowired
	private NegozioAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public NegozioAdapter NegozioAdapter(){
			return new NegozioAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		Negozio negozio = FactoryDataTest.getNegozio();
		adapter.fromEntityToDto(negozio);
	}
	
	@Test
	public void fromDtoToEntity(){
		NegozioDTO negozio = FactoryDataTest.getNegozioDTO();
		adapter.fromDtoToEntity(negozio);
	}
}
