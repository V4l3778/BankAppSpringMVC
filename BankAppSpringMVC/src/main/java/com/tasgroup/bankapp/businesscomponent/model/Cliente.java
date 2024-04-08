package com.tasgroup.bankapp.businesscomponent.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class Cliente implements Serializable{
	private static final long serialVersionUID = -727666159054761560L;
	
	private long id;
	@NotBlank(message = "Il nome non puo' essere nullo")
	private String nome;
	@NotBlank(message = "Il cognome non puo' essere nullo")
	private String cognome;
	@NotBlank(message = "L'indirizzo non puo' essere nullo")
	@Pattern(regexp = "^[via,strada,piazza,viale,vicolo][a-zA-Z0-9 ,]{2,100}$", message = "Inserire: via/piazza/viale + indirizzo + , civico")
	private String indirizzo;
	@NotBlank(message = "Il telefono non puo' essere nullo")
	@Pattern(regexp = "^[0-9 +]{10,15}$", message = "Solo numeri,+ accettati. 10-15 caratteri")
	private String telefono;
	@NotBlank(message = "La data di nascita non puo' essere nulla")
	private Date nascita;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
}
