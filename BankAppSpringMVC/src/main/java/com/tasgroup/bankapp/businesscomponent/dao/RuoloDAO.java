package com.tasgroup.bankapp.businesscomponent.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tasgroup.bankapp.businesscomponent.model.Ruolo;

public class RuoloDAO implements DAOConstants{
	private JdbcTemplate jdbct;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbct) {
		this.jdbct= jdbct;
	}
	
	public int create(Ruolo r) {
		return jdbct.update(INSERT_RUOLO,
				new Object[] {r.getRuolo()});
	}
	
	public Ruolo findById(long id) {
		return jdbct.queryForObject(SELECT_RUOLO_BYID, new Object[] {id}, new BeanPropertyRowMapper<Ruolo>(Ruolo.class));
	}
	
	public int update(Ruolo r) {
		return jdbct.update(UPDATE_RUOLO,
				new Object[] {r.getRuolo()});
	}
	
	public int delete(long id) {
		return jdbct.update(DELETE_RUOLO, new Object[] {id});
	}
}
