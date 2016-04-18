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

import com.chetaglio.model.entity.Servizio;
import com.chetaglio.service.dto.ServizioDTO;
import com.chetaglio.utility.FactoryDataTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ServizioAdapterTest {
	
	@Autowired
	private ServizioAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public ServizioAdapter ServizioAdapter(){
			return new ServizioAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		
		Servizio c = new Servizio();
		c.setCosto(1D);
		c.setId(1l);
		c.setNome("nome");
		c.setNegozio(FactoryDataTest.getNegozio());
		c.setCategoria(FactoryDataTest.getCategoria());
		
		adapter.fromEntityToDto(c);
	}
	
	@Test
	public void fromDtoToEntity(){
		ServizioDTO c = new ServizioDTO();
		c.setCosto(1D);
		c.setId(1l);
		c.setNome("nome");
		c.setNegozio(FactoryDataTest.getNegozioDTO());
		c.setCategoria(FactoryDataTest.getCategoriaDTO());
		
		adapter.fromDtoToEntity(c);
	}
}
