package com.fatec.exercicio.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fatec.exercicio.model.Funcionario;
import com.fatec.exercicio.persistence.FuncionarioDAO;


@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioDAO dao;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			funcionarios = dao.list();
		} catch (ClassNotFoundException | SQLException e) {
			return "error";
		}
		model.addAttribute("funcionarios", funcionarios);
		return "index";
	}
	
	@PostMapping("/soma")
	public String getSoma(@RequestParam("codigo") int codigo, Model model) {
		double soma = 0;
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setCodigo(codigo);
			soma = dao.findSomaSalario(funcionario);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("soma", soma);
		return "SomaView";
	}
	
	@PostMapping("/relacao")
	public String getRelacao(@RequestParam("codigo") int codigo, Model model) {
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(codigo);
		try {
			funcionario = dao.findFromFunction(funcionario);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("funcionario", funcionario);
		return "FuncionarioView";
	}
}
