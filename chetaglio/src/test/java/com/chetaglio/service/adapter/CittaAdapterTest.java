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

import com.chetaglio.model.entity.Citta;
import com.chetaglio.service.dto.CittaDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class CittaAdapterTest {
	
	@Autowired
	private CittaAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public CittaAdapter CittaAdapter(){
			return new CittaAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		Citta c = new Citta();
		c.setNome("nome");
		c.setId(1l);
		c.setProvincia("provincia");
		c.setRegione("regione");
		
		adapter.fromEntityToDto(c);
	}
	
	@Test
	public void fromDtoToEntity(){
		CittaDTO c = new CittaDTO();
		c.setNome("nome");
		c.setId(1l);
		c.setProvincia("provincia");
		c.setRegione("regione");
		
		adapter.fromDtoToEntity(c);
	}
}
