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

import com.chetaglio.model.entity.Immagine;
import com.chetaglio.model.entity.Negozio;
import com.chetaglio.service.dto.ImmagineDTO;
import com.chetaglio.service.dto.NegozioDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ImmagineAdapterTest {
	
	@Autowired
	private ImmagineAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public ImmagineAdapter ImmagineAdapter(){
			return new ImmagineAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		Negozio n = new Negozio();
		n.setCognome("cognome");
		
		Immagine c = new Immagine();
		c.setId(1l);
		c.setUrl("url");
		c.setNegozio(n);
		
		adapter.fromEntityToDto(c);
	}
	
	@Test
	public void fromDtoToEntity(){
		NegozioDTO n = new NegozioDTO();
		n.setCognome("cognome");
		
		ImmagineDTO c = new ImmagineDTO();
		c.setId(1l);
		c.setUrl("url");
		c.setNegozio(n);
		
		adapter.fromDtoToEntity(c);
	}
}
