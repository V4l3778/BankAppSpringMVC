package com.tasgroup.bankapp.businesscomponent.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class RuoloDAO implements DAOConstants{
	private JdbcTemplate jdbct;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbct) {
		this.jdbct= jdbct;
	}
	
	public int create(Rurolo r) {
		return jdbct.update(INSERT_RUOLO,
				new Object[] {r.getDescrizione()});
	}
	
	public int update(Rurolo r) {
		return jdbct.update(UPDATE_RUOLO,
				new Object[] {r.getDescrizione()});
	}
	
	public int delete(long id) {
		return jdbct.update(DELETE_RUOLO, new Object[] {id});
	}
	
}
