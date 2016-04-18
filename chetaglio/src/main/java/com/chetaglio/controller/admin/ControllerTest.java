package com.chetaglio.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/test")
public class ControllerTest {
	
	@RequestMapping(value="/{page}", method=RequestMethod.GET)
	public String test(@PathVariable(value="page")String page){
		return "js/"+page;		
	}

}
