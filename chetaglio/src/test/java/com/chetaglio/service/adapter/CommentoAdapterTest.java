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

import com.chetaglio.model.entity.Commento;
import com.chetaglio.model.entity.Utente;
import com.chetaglio.service.dto.CommentoDTO;
import com.chetaglio.service.dto.UtenteDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class CommentoAdapterTest {
	
	@Autowired
	private CommentoAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public CommentoAdapter CommentoAdapter(){
			return new CommentoAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		Utente u = new Utente();
		u.setCognome("cognome");
		
		Commento c = new Commento();
		c.setId(1l);
		c.setCommento("commento");
		c.setUtente(u);
		
		adapter.fromEntityToDto(c);
	}
	
	@Test
	public void fromDtoToEntity(){
		UtenteDTO u = new UtenteDTO();
		u.setCognome("cognome");
		
		CommentoDTO c = new CommentoDTO();
		c.setId(1l);
		c.setCommento("commento");
		c.setUtente(u);
		
		adapter.fromDtoToEntity(c);
		
	}
}
