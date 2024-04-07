package com.tasgroup.bankapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class Transazione implements Serializable{
	private static final long serialVersionUID = -670854752219624349L;

	private long id;
	@NotBlank(message = "Il conto sorgente non puo' essere nullo")
	private long id_sorgente;
	private long id_destinaz;
	@NotBlank(message = "La data e l'ora della transazione non possono essere nulli")
	private Date transazDT;
	@NotBlank(message = "L'importo non può essere nullo")
	@Pattern(regexp = "^[0-9.,]{3-20}$", message = "Solo numeri,. accettati. 3-20 caratteri")
	private double importo;
	@NotBlank(message = "Il tipo di transazione non puo' essere nullo")
	@Pattern(regexp = "^[deposito|prelievo|trasferimento]$", message = "Solo numeri,. accettati. 3-20 caratteri")
	private String tipo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_sorgente() {
		return id_sorgente;
	}
	public void setId_sorgente(long id_sorgente) {
		this.id_sorgente = id_sorgente;
	}
	public long getId_destinaz() {
		return id_destinaz;
	}
	public void setId_destinaz(long id_destinaz) {
		this.id_destinaz = id_destinaz;
	}
	public Date getTransazDT() {
		return transazDT;
	}
	public void setTransazDT(Date transazDT) {
		this.transazDT = transazDT;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
