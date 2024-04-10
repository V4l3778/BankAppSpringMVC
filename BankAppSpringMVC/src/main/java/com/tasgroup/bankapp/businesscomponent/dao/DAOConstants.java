package com.tasgroup.bankapp.businesscomponent.dao;

public interface DAOConstants {
	String INSERT_CLIENTE= "Insert into Cliente values(id_cliente.next_val,?,?,?,?,?)";
	String UPDATE_CLIENTE= "Update Cliente set nome= ?, cognome= ?, indirizzo= ?, numero= ?, nascita= ? where id_cliente= ?";
	String SELECT_CLIENTE_BYID= "Select * from Cliente where id_cliente= ?";
	String SELECT_CLIENTI= "Select * from Cliente";
	String DELETE_CLIENTE= "Delete Cliente where id_cliente= ?";

//=====================================================================================================

	String INSERT_CONTO= "Insert into Conto values(id_conto.next_val,?,?,?)";
	String UPDATE_CONTO= "Update Conto set id_cliente= ?, saldo= ?, apertura= ? where id_conto= ?";
	String SELECT_CONTO_BYID= "Select * from Cliente where id_cliente= ?";
	String SELECT_CONTI= "Select * from Cliente";
	String SELECT_CONTO_BYCLIENTE= "Select * from Conto where id_cliente= ?";
	String DELETE_CONTO= "Delete Conto where id_conto= ?";
	
//=====================================================================================================
	
	String INSERT_T_DEP_PREL= "Insert into Transazione(id_transazione,id_sorgente,data,importo,tipo) "
			+ "values(id_transazione.next_val,?,?,?,?";
	String INSERT_TRASFERIMENTO= "Insert into Transazione values(id_transazione.next_val,?,?,?,?,?";
	String SELECT_TRANSAZ_BYID= "Select * from Transazione where id_transazione= ?";
	String SELECT_T_BYID_CLIENTE= "select * from Transazione,Conto where transazione.id_sorgente = conto.id_conto OR "
																			+ "transazione.id_destinaz = conto.id_conto"
																			+ "having conto.id_cliente=?";
	String DELETE_TRANSAZIONE= "Delete Transazione where id_transazione= ?";
	
//=====================================================================================================
			
	String INSERT_RUOLO= "Insert into Ruolo values(id_ruolo.next_val,?)";
	String SELECT_RUOLO_BYID= "Select * from Ruolo where id_ruolo= ?";
	String UPDATE_RUOLO= "Update Ruolo set descrizione= ? where id_ruolo= ?";
	String DELETE_RUOLO= "Delete Ruolo where id_ruolo= ?";
}
