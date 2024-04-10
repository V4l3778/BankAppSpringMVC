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

import com.tasgroup.bankapp.businesscomponent.dao.ClienteDAO;
import com.tasgroup.bankapp.businesscomponent.model.Cliente;

@Controller
public class ClienteController {
	@Autowired
	ClienteDAO cDAO;
	
	@RequestMapping("/clienteForm")
	public String visualizzaForm(Model m) {
		m.addAttribute("cliente", new Cliente());
		return "clienteFormPage";
	}
	
	@RequestMapping(value="/salvaCliente", method= RequestMethod.POST)
	public ModelAndView createCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult br) {
		if(br.hasErrors()) {
			return new ModelAndView("clienteFormPage","command",cliente);
		} else {
			cDAO.create(cliente);
			return new ModelAndView("redirect:/clienteReport");
		}
	}
	
	@RequestMapping("/clienteReport")
	public ModelAndView visualizzaClienti() {
		List<Cliente> listaClienti= cDAO.getAll();
		return new ModelAndView("clientiReportPage","listaClienti",listaClienti);
	}
	
	@RequestMapping("trovaCliente/{id}")
	public ModelAndView trovaCliente(@PathVariable long id) {
		Cliente cliente= cDAO.findById(id);
		return new ModelAndView("trovaClientePage","command",cliente);
	}
	
	@RequestMapping(value= "/modifica", method= RequestMethod.POST)
	public ModelAndView modificaCliente(Cliente c) {
		cDAO.update(c);
		return new ModelAndView("redirect:/clienteReport");
	}
	
	@RequestMapping("/cancella/{id}")
	public ModelAndView cancellaCliente(@PathVariable long id) {
		cDAO.delete(id);
		return new ModelAndView("redirect:/clienteReport");
	}
}
