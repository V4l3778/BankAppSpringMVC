package com.tasgroup.bankapp.businesscomponent.dao;

public class TransazioneDAO implements DAOConstants{
	private JdbcTemplate jdbct;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbct) {
		this.jdbct= jdbct;
	}
	
	public int createTansazioneSorg(Transazione t) {
		return jdbct.update(INSERT_TRANSAZIONE,
				new Object[] {t.getId_sorgente(), t.getTransazDT(), t.getImporto(), t.getTipo()});
	}
	
	public int createTransazione(Transazione t) {
		return jdbct.update(INSERT_TRANSAZIONE,
				new Object[] {t.getId_sorgente(), t.getId_destinaz(), t.getTransazDT(), t.getImporto(), t.getTipo()});
	}
	
	public int delete(long id) {
		return jdbct.update(DELETE_TRANSAZIONE, new Object[] {id});
	}
	
}
