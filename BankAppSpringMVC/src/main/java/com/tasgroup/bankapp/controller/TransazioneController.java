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

import com.tasgroup.bankapp.businesscomponent.dao.TransazioneDAO;
import com.tasgroup.bankapp.businesscomponent.model.Transazione;

@Controller
public class TransazioneController {
	@Autowired
	TransazioneDAO tDAO;
	
	@RequestMapping("/transazioneForm")
	public String visualizzaForm(Model m) {
		m.addAttribute("transazione", new Transazione());
		return "transazioneFormPage";
	}
	
	@RequestMapping(value= "/salvaTransazione", method= RequestMethod.POST)
	public ModelAndView createTDepPrel(@Valid @ModelAttribute("transazione") Transazione transaz, BindingResult br) {
		if (transaz.getTipo().equals("prelievo") || transaz.getTipo().equals("deposito")){
			if(br.hasErrors()) {
				return new ModelAndView("transazioneFormPage","command",transaz);
			} else {
				tDAO.createDepPrel(transaz);
				return new ModelAndView("redirect:/transazioneReport");
			}
		} else {
			if(br.hasErrors()) {
				return new ModelAndView("transazioneFormPage","command",transaz);
			} else {
				tDAO.createTrasferimento(transaz);
				return new ModelAndView("redirect:/transazioneReport");
			}
		}
	}
	
	@RequestMapping("/trovaTransazione/{id}")
	public ModelAndView findById(@PathVariable long id) {
		Transazione transaz= tDAO.findById(id);
		return new ModelAndView("trovaTransazionePage","command",transaz);
	}
	
	@RequestMapping("/trovaTransazioneByCliente/{id_cliente}")
	public ModelAndView findTransazByIdCliente(@PathVariable long id_cliente) {
		List<Transazione> transaz= tDAO.findByIdCliente(id_cliente);
		return new ModelAndView("trovaTransazionePage","command",transaz);
	}
	
	@RequestMapping("/cancella/{id}")
	public ModelAndView cancellaTransaz(@PathVariable long id) {
		tDAO.delete(id);
		return new ModelAndView("redirect:/transazioneReport");
	}
	
	
	
	
}
