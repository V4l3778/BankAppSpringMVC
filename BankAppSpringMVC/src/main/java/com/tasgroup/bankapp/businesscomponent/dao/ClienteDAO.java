package com.tasgroup.bankapp.businesscomponent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tasgroup.bankapp.businesscomponent.model.Cliente;

public class ClienteDAO implements DAOConstants {
	private JdbcTemplate jdbct;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbct) {
		this.jdbct= jdbct;
	}
	
	public int create(Cliente c) {
		return jdbct.update(INSERT_CLIENTE,
				new Object[] {c.getNome(),c.getCognome(),c.getIndirizzo(),c.getTelefono(),c.getNascita()});
	}
	
	public int update(Cliente c) {
		return jdbct.update(UPDATE_CLIENTE,
				new Object[] {c.getNome(),c.getCognome(),c.getIndirizzo(),c.getTelefono(),c.getNascita()});
	}
	
	public Cliente findById(long id) {
		return jdbct.queryForObject(SELECT_CLIENTE_BYID, new Object[] {id}, new BeanPropertyRowMapper<Cliente>(Cliente.class));
	}
	
	public List<Cliente> getAll() {
		return jdbct.query(SELECT_CLIENTI, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet rs, int rigaCorr) 
					throws SQLException {
				Cliente c= new Cliente();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setCognome(rs.getString(3));
				c.setIndirizzo(rs.getString(4));
				c.setTelefono(rs.getString(5));
				c.setNascita(new java.sql.Date(rs.getDate(6).getTime()));
				return c;
			}
		});
	}

	public int delete(long id) {
		return jdbct.update(DELETE_CLIENTE, new Object[] {id});
	}
}
