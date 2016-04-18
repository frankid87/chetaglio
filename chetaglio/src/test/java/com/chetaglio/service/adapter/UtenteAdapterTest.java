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

import com.chetaglio.model.entity.Utente;
import com.chetaglio.service.dto.UtenteDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class UtenteAdapterTest {
	
	@Autowired
	private UtenteAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public UtenteAdapter UtenteAdapter(){
			return new UtenteAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		Utente c = new Utente();
		c.setId(1l);
		c.setNome("nome");
		c.setCognome("cognome");		
		adapter.fromEntityToDto(c);
	}
	
	@Test
	public void fromDtoToEntity(){
		UtenteDTO c = new UtenteDTO();
		c.setId(1l);
		c.setNome("nome");
		c.setCognome("cognome");
		
		adapter.fromDtoToEntity(c);
	}
}
