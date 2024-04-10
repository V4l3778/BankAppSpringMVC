package com.tasgroup.bankapp.businesscomponent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	
	public Transazione findById(long id) {
		return jdbct.queryForObject(SELECT_TRANSAZ_BYID, new Object[] {id}, new BeanPropertyRowMapper<Transazione>(Transazione.class));
	}
	
	public List<Transazione> findByIdCliente(long id_cliente) {
		return jdbct.query(SELECT_T_BYID_CLIENTE, new RowMapper<Transazione>() {
			@Override
			public Transazione mapRow(ResultSet rs, int rigaCorr)
					throws SQLException {
				Transazione t= new Transazione();
				t.setId(rs.getLong(1));
				t.setId_sorgente(rs.getLong(2));
				t.setId_destinaz(rs.getLong(3));
				t.setTransazDT(new java.sql.Date(rs.getDate(4).getTime()));
				t.setImporto(rs.getDouble(5));
				t.setTipo(rs.getString(6));
				return t;
			}
		});
	}
	
	public int delete(long id) {
		return jdbct.update(DELETE_TRANSAZIONE, new Object[] {id});
	}
	
}
