package com.tasgroup.bankapp.businesscomponent.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tasgroup.bankapp.businesscomponent.model.Transazione;

public class TransazioneDAO implements DAOConstants{
	private JdbcTemplate jdbct;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbct) {
		this.jdbct= jdbct;
	}
	
	public int createDepPrel(Transazione t) {
		return jdbct.update(INSERT_T_DEP_PREL,
				new Object[] {t.getId_sorgente(), t.getTransazDT(), t.getImporto(), t.getTipo()});
	}
	
	public int createTrasferimento(Transazione t) {
		return jdbct.update(INSERT_TRASFERIMENTO,
				new Object[] {t.getId_sorgente(), t.getId_destinaz(), t.getTransazDT(), t.getImporto(), t.getTipo()});
	}
	
	public int delete(long id) {
		return jdbct.update(DELETE_TRANSAZIONE, new Object[] {id});
	}
	
}
