package com.chetaglio.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chetaglio.service.dto.NegozioDTO;
import com.chetaglio.service.service.CategoriaService;
import com.chetaglio.service.service.CittaService;
import com.chetaglio.service.service.NegozioService;

@Controller
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private NegozioService negozioService;
	
	@Autowired
	private CittaService cittaService;
	
	
	@RequestMapping(value="/creanegozio", method=RequestMethod.GET)
	public String creaNegozio(@ModelAttribute NegozioDTO negozioDTO, Model model){
		
		model.addAttribute("cittaList", cittaService.findAll());
		model.addAttribute("negozioForm", negozioDTO);
		
		return "admin/creanegozio";
	}
	
	
	@RequestMapping(value="/salvanegozio", method=RequestMethod.POST)
	public String salvaNegozio(@ModelAttribute NegozioDTO negozioDTO, Model model){
		if(negozioDTO.getId() == null){
			negozioService.create(negozioDTO);
		}else{
			NegozioDTO negozio = negozioService.findById(negozioDTO.getId());
			BeanUtils.cop
			negozioService.update(negozioDTO);
		}
		return "admin/ricercanegozio";
	}
	
	
	@RequestMapping(value="/ricercanegozio", method=RequestMethod.GET)
	public String ricercaNegozio(Model model, @RequestParam(value="page", required=false, defaultValue="1") int pagina, @RequestParam(value="maxresult", required=false, defaultValue="10") int numeroRisultatiPagina, @RequestParam(value="idCitta", required = false, defaultValue = "-1") int idCitta, @RequestParam(value="idCategoria", required = false, defaultValue = "-1") int idCategoria, @RequestParam(required = false) String insegna){
		
		List<NegozioDTO> listNegozioDTO = null;
		if((idCitta != -1) || (idCategoria != -1) || !StringUtils.isEmpty(insegna)){
			listNegozioDTO = negozioService.findByCittaCategoriaInsegna(Long.valueOf(idCitta), Long.valueOf(idCategoria), insegna, pagina, numeroRisultatiPagina);
		}else{
			listNegozioDTO = negozioService.findAll(pagina, numeroRisultatiPagina);
		}
		
		model.addAttribute("cittaList", cittaService.findAll());
		model.addAttribute("categoriaList", categoriaService.findAll());
		model.addAttribute("negoziList", listNegozioDTO);
		
		return "admin/ricercanegozio";
	}
	

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam(value="name",required=false,defaultValue="nando") String name, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if (name.contains("/")) {
			redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
			return "redirect:uploadnegozicsv";
		}
		if (!file.isEmpty()) {
			try {
				negozioService.saveFromCSV(file.getInputStream());
				redirectAttributes.addFlashAttribute("message",	"You successfully uploaded " + name + "!");
			}
			catch (Exception e) {
				redirectAttributes.addFlashAttribute("message", "You failed to upload " + name + " => " + e.getMessage());
			}
		}
		else {
			redirectAttributes.addFlashAttribute("message", "You failed to upload " + name + " because the file was empty");
		}

		return "redirect:uploadnegozicsv";
	}
	
	
	/*
	 * ricercanegozio
	 * uploadnegozicsv
	 */
	@RequestMapping(value="/{pagina}", method=RequestMethod.GET)
	public String upload(@PathVariable(value="pagina")String pagina){
		return "admin/" + pagina;
	}
	
	
	@RequestMapping(value="/modificanegozio", method=RequestMethod.GET)
	public String modificaNegozio(@ModelAttribute NegozioDTO negozioDTO, Model model){
		
		negozioDTO = negozioService.findById(negozioDTO.getId());
		
		model.addAttribute("cittaList", cittaService.findAll());
		model.addAttribute("negozioForm", negozioDTO);
		
		return "admin/modificanegozio";
	}

}
