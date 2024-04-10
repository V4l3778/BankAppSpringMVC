package com.tasgroup.bankapp.controller;

import java.util.List;

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

import com.tasgroup.bankapp.businesscomponent.dao.ContoDAO;
import com.tasgroup.bankapp.businesscomponent.model.Conto;

@Controller
public class ContoController {
	@Autowired
	ContoDAO cDAO;
	
	@RequestMapping("/contoForm")
	public String visualizzaForm(Model m) {
		m.addAttribute("conto", new Conto());
		return "contoFormPage";
	}
	
	@RequestMapping(value= "/salvaConto", method= RequestMethod.POST)
	public ModelAndView createConto(@Valid @ModelAttribute("conto") Conto conto, BindingResult br) {
		if(br.hasErrors()) {
			return new ModelAndView("contoFormPage","command",conto);
		} else {
			cDAO.create(conto);
			return new ModelAndView("redirect:/contoReport");
		}
	}
	
	@RequestMapping("/contoReport")
	public ModelAndView visualizzaConti() {
		List<Conto> listaConti= cDAO.getAll();
		return new ModelAndView("contiReportPage","listaConti",listaConti);
	}
	
	@RequestMapping("/trovaConto/{id}")
	public ModelAndView trovaConto(@PathVariable long id) {
		Conto conto= cDAO.findById(id);
		return new ModelAndView("trovaContoPage","command",conto);
	}
	
	@RequestMapping("/trovaContoByCliente/{id_cliente}")
	public ModelAndView trovaContoByCliente(@PathVariable long id_cliente) {
		List<Conto> conto= cDAO.findByIdCliente(id_cliente);
		return new ModelAndView("trovaContoByClientePage","command",conto);
	}
	
	@RequestMapping(value= "/modifica", method= RequestMethod.POST)
	public ModelAndView modificaConto(Conto c) {
		cDAO.update(c);
		return new ModelAndView("redirect:/contoReport");
	}
	
	@RequestMapping("/cancella/{id}")
	public ModelAndView cancellaConto(@PathVariable long id) {
		cDAO.delete(id);
		return new ModelAndView("redirect:/contoReport");
	}
}
