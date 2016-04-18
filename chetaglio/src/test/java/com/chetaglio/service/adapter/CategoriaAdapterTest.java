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

import com.chetaglio.model.entity.Categoria;
import com.chetaglio.service.dto.CategoriaDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class CategoriaAdapterTest {
	
	@Autowired
	private CategoriaAdapter adapter;
	
	@Configuration
    static class ContextConfiguration {

		@Bean
		public CategoriaAdapter CategoriaAdapter(){
			return new CategoriaAdapter();
		}
		
        @Bean
        public Mapper mapper() {
        	return new DozerBeanMapper();
        }
    }
	
	@Test
	public void fromEntityToDto(){
		Categoria c = new Categoria();
		c.setDescrizione("descrizione");
		c.setId(1l);
		c.setNome("nome");
		
		adapter.fromEntityToDto(c);
	}
	
	@Test
	public void fromDtoToEntity(){
		CategoriaDTO c = new CategoriaDTO();
		c.setDescrizione("descrizione");
		c.setId(1l);
		c.setNome("nome");
		
		adapter.fromDtoToEntity(c);
	}
}
