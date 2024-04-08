package com.tasgroup.bankapp.businesscomponent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tasgroup.bankapp.businesscomponent.model.Conto;

public class ContoDAO implements DAOConstants {
	private JdbcTemplate jdbct;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbct) {
		this.jdbct= jdbct;
	}
	
	public int create(Conto c) {
		return jdbct.update(INSERT_CONTO,
				new Object[] {c.getId_cliente(),c.getSaldo(),c.getApertura()});
	}
	
	public int update(Conto c) {
		return jdbct.update(UPDATE_CONTO,
				new Object[] {c.getId_cliente(),c.getSaldo(),c.getApertura()});
	}
	
	public Conto findById(long id) {
		return jdbct.queryForObject(SELECT_CONTO_BYID, new Object[] {id}, new BeanPropertyRowMapper<Conto>(Conto.class));
	}
	
	public List<Conto> findByIdCliente(long id_cliente) {
		return jdbct.query(SELECT_CONTO_BYCLIENTE, new RowMapper<Conto>() {
			@Override
			public Conto mapRow(ResultSet rs, int rigaCorr)
					throws SQLException {
				Conto c= new Conto();
				c.setId(rs.getLong(1));
				c.setId_cliente(rs.getLong(2));
				c.setSaldo(rs.getDouble(3));
				c.setApertura(new java.sql.Date(rs.getDate(4).getTime()));
				return c;
			}
		});
	}
	
	public List<Conto> findAll() {
		return jdbct.query(SELECT_CONTI, new RowMapper<Conto>() {
			@Override
			public Conto mapRow(ResultSet rs, int rigaCorr)
					throws SQLException {
				Conto c= new Conto();
				c.setId(rs.getLong(1));
				c.setId_cliente(rs.getLong(2));
				c.setSaldo(rs.getDouble(3));
				c.setApertura(new java.sql.Date(rs.getDate(4).getTime()));
				return c;
			}
		});
	}
	
	public int delete(long id) {
		return jdbct.update(DELETE_CLIENTE, new Object[] {id});
	}
}
