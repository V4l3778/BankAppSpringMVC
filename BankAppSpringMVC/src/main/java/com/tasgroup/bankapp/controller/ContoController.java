package com.tasgroup.bankapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tasgroup.bankapp.businesscomponent.dao.ContoDAO;
import com.tasgroup.bankapp.businesscomponent.model.Conto;

@Controller
public class ContoController {
	@Autowired
	ContoDAO cDAO;
	
	@RequestMapping("/contoForm")
	public String visualizzaForm(Model m) {
		m.addAttribute("conto", new Conto());
		return "paginacontoform";
	}
	
	@RequestMapping(value= "/salva", method= RequestMethod.POST)
	public ModelAndView createConto(@Valid @ModelAttribute("conto") Conto conto, BindingResult br) {
		if(br.hasErrors()) {
			return new ModelAndView("paginacontoform","command",conto);
		} else {
			cDAO.create(conto);
			return new ModelAndView("redirect:/contoReport");
		}
	}
	
	@RequestMapping("/contoReport")
	public ModelAndView visualizzaConti() {
		List<Conto> listaConti= cDAO.getAll();
		return new ModelAndView("paginaAdminConti");
	}
	
	
	
	
	
	
}
