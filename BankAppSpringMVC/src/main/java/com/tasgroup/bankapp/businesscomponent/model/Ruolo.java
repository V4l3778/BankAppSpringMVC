package com.tasgroup.bankapp.businesscomponent.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Ruolo implements Serializable{
	private static final long serialVersionUID = 3726447227280863602L;
	
	private long id;
	@NotBlank(message = "Il ruolo non puo' essere nullo")
	@Pattern(regexp = "^[a-zA-Z]{2-30}$", message = "Solo caratteri accettati. 2-30 caratteri")
	private String ruolo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}
