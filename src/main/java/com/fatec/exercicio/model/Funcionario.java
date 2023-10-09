package com.fatec.exercicio.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Funcionario {

	private int codigo;
	private String nome;
	private double salario;
	private List<Dependente> dependentes;

	public Funcionario() {
		dependentes = new ArrayList<Dependente>();
	}
}
