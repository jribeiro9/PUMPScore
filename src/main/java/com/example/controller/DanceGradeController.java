package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Module;
import com.example.model.DanceGrade;
import com.example.service.ModuleService;
import com.example.service.DanceGradeService;

@Controller
@RequestMapping("/danceGrades")
public class DanceGradeController {
	
	@Autowired
	private DanceGradeService danceGradeService;
	
	@Autowired
	private ModuleService moduleService; //module service

	// Primeira tela da pagina de DanceGrade
	@GetMapping
	public String index(Model model) {
		List<DanceGrade> all = danceGradeService.findAll();
		model.addAttribute("listDanceGrade", all);
		model.addAttribute("");
		return "danceGrades/index";
	}
	
	// Tela de Show DanceGrade
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			DanceGrade danceGrade = danceGradeService.findOne(id).get();
			model.addAttribute("danceGrade", danceGrade);
		}
		return "danceGrades/show";
	}

	// Tela com Formulario de New DanceGrade
	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute DanceGrade entityDanceGrade, 
			             @ModelAttribute Module entityModule) {
		// model.addAttribute("danceGrade", entityDanceGrade);
		List<Module> all = moduleService.findAll();
		model.addAttribute("modules", all);
		
		return "danceGrades/form";
	}
	
	// Processamento do formulario New DanceGrade (ou Alter DanceGrade) 
	@PostMapping
	public String create(@Valid @ModelAttribute DanceGrade entityDanceGrade, 
			             @Valid @ModelAttribute Module entityModule,
			             BindingResult result, RedirectAttributes redirectAttributes) {
		DanceGrade danceGrade = null;
		String pagina_retorno = "redirect:/danceGrades/" ;
	
		try {
			danceGrade = danceGradeService.save(entityDanceGrade);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
			pagina_retorno = pagina_retorno + danceGrade.getId();
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}catch (Throwable e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
		}
		
		return pagina_retorno;
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		
		try {
			if (id != null) {
				List<Module> all = moduleService.findAll();
				model.addAttribute("modules", all);
				
				DanceGrade entity = danceGradeService.findOne(id).get();
				model.addAttribute("danceGrade", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "danceGrades/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute DanceGrade entity, BindingResult result, 
			             RedirectAttributes redirectAttributes) {
		DanceGrade danceGrade = null;
		try {
			danceGrade = danceGradeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/danceGrades/" + danceGrade.getId();
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				DanceGrade entity = danceGradeService.findOne(id).get();
				danceGradeService.delete(entity);
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/danceGrades/";
	}
	
	private static final String MSG_SUCESS_INSERT = "DanceGrade inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "DanceGrade successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted DanceGrade successfully.";
	private static final String MSG_ERROR = "Erro na inserção do DanceGrade";


}