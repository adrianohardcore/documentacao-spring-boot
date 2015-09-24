/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adrianohardcore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "DOCTOCLIENTE")
    private String doctocliente;

    @Size(max = 60)
    @Column(name = "NOMECLIENTE")
    private String nomecliente;



	public String getDoctocliente() {
		return doctocliente;
	}

	public void setDoctocliente(String doctocliente) {
		this.doctocliente = doctocliente;
	}

	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
  
    
    
}
