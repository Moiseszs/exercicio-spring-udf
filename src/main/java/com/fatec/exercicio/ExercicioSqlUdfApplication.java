package com.fatec.exercicio;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.exercicio.model.Funcionario;
import com.fatec.exercicio.persistence.FuncionarioDAO;

@SpringBootApplication
public class ExercicioSqlUdfApplication {

	private static FuncionarioDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(ExercicioSqlUdfApplication.class, args);
	}

}
