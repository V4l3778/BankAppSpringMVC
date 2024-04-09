package com.tasgroup.bankapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tasgroup.bankapp.businesscomponent.dao.RuoloDAO;
import com.tasgroup.bankapp.businesscomponent.model.Ruolo;

@Controller
public class RuoloController {
	@Autowired
	RuoloDAO rDAO;
	
	@RequestMapping("/ruoloForm")
	public String visualizzaForm(Model m) {
		m.addAttribute("ruolo", new Ruolo());
		return "ruoloFormPage";
	}
	
	@RequestMapping(value= "/salvaRuolo", method= RequestMethod.POST)
	public ModelAndView createRuolo(@Valid @ModelAttribute("ruolo") Ruolo ruolo, BindingResult br) {
		if(br.hasErrors()) {
			return new ModelAndView("ruoloFormPage","command",ruolo);
		} else {
			rDAO.create(ruolo);
			return new ModelAndView("redirect:/ruoloReport");
		}
	}
	
	@RequestMapping("/trovaRuolo/{id}")
	public ModelAndView trovaRuolo(@PathVariable long id) {
		Ruolo ruolo= rDAO.findById(id);
		return new ModelAndView("trovaRuoloPage","command",ruolo);
	}
	
	@RequestMapping(value= "/modifica", method= RequestMethod.POST)
	public ModelAndView modificaRuolo(Ruolo r) {
		rDAO.update(r);
		return new ModelAndView("redirect:/ruoloReport");
	}
	
	@RequestMapping("/cancella/{id}")
	public ModelAndView cancellaRuolo(@PathVariable long id) {
		rDAO.delete(id);
		return new ModelAndView("redirect:/ruoloReport");
	}
}
