package br.edu.mvc.controller;

import java.util.Calendar;

public class Tarefas {
	private Integer id;
	private String tarefa;
	private String materia;
	private Calendar data_entrega;
	private String usuario;
	
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTarefa() {
		return this.tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public String getMateria() {
		return this.materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Calendar getData_entrega() {
		return this.data_entrega;
	}
	public void setData_entrega(Calendar data_entrega) {
		this.data_entrega = data_entrega;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}


