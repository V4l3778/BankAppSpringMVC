package com.tasgroup.bankapp.dao;

public interface DAOConstants {
	String INSERT_CLIENTE= "Insert into Cliente values(id_cliente.next_val,?,?,?,?,?)";
	String UPDATE_CLIENTE= "Update Cliente set nome= ?, cognome= ?, indirizzo= ?, numero= ?, nascita= ? where id_cliente= ?";
	String DELETE_CLIENTE= "Delete Cliente where id_cliente= ?";

//=====================================================================================================

	String INSERT_CONTO= "Insert into Conto values(id_conto.next_val,?,?,?)";
	String UPDATE_CONTO= "Update Conto set id_cliente= ?, saldo= ?, apertura= ? where id_conto= ?";
	String DELETE_CONTO= "Delete Conto where id_conto= ?";
	
//=====================================================================================================
	
	String INSERT_TRANSAZIONE_SORG= "Insert into Transazione(id_transazione,id_sorgente,data,importo,tipo) "
			+ "values(id_transazione.next_val,?,?,?,?";
	String INSERT_TRANSAZIONE= "Insert into Transazione values(id_transazione.next_val,?,?,?,?,?";
	String DELETE_TRANSAZIONE= "Delete Transazione where id_transazione= ?";
	
//=====================================================================================================
			
	String INSERT_RUOLO= "Insert into Ruolo values(id_ruolo.next_val,descrizione)";
	String DELETE_RUOLO= "Delete Ruolo where id_ruolo= ?";
}
