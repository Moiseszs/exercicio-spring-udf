package com.fatec.exercicio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dependente {

	private int codigoFuncionario;
	private String nome;
	private double salario;
	private Funcionario funcionario;
}
