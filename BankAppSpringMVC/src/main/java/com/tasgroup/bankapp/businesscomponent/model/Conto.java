package com.tasgroup.bankapp.businesscomponent.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

public class Conto implements Serializable{
	private static final long serialVersionUID = -8455813825224806917L;
	
	private long id;
	@NotBlank(message = "L'intestatario del conto non puo' essere vuoto")
	private long id_cliente;
	@NotBlank(message = "Il saldo non puo' essere nullo")
	@DecimalMin(value = "0.00", message = "Il conto non puo' andare in negativo")
	private double saldo;
	@NotBlank(message = "La data di apertura non puo' essere nulla")
	private Date apertura;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Date getApertura() {
		return apertura;
	}
	public void setApertura(Date apertura) {
		this.apertura = apertura;
	}
}
