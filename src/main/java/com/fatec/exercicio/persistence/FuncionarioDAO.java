package com.fatec.exercicio.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fatec.exercicio.model.Dependente;
import com.fatec.exercicio.model.Funcionario;

@Repository
public class FuncionarioDAO implements DAO<Funcionario>{

	private Connection connection;
	
	private Connection connect() throws ClassNotFoundException, SQLException{
		String url = "jdbc:jtds:sqlserver://localhost:1433/db_exercicio_udf001";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url);
		return connection;
	}
	
	@Override
	public void insert() throws SQLException, ClassNotFoundException {
		
	}
	
	@Override
	public void update(Funcionario e) throws SQLException, ClassNotFoundException {
	}
	
	@Override
	public Funcionario find(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		
		return funcionario;
	}
	
	@Override
	public List<Funcionario> list() throws SQLException, ClassNotFoundException {
		connection = connect();
		String query = "SELECT codigo, nome, salario FROM funcionario";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet res = statement.executeQuery();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		while(res.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setCodigo(res.getInt("codigo"));
			funcionario.setNome(res.getString("nome"));
			funcionario.setSalario(res.getDouble("salario"));
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}
	
	@Override
	public Funcionario findFromFunction(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		connection = connect();
		String query = "SELECT nome_funcionario, nome_dependente, salario_funcionario, "
				+ "salario_dependente FROM dbo.relacao_funcionarios(?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, funcionario.getCodigo());
		ResultSet res = statement.executeQuery();
		while(res.next()) {
			Dependente dependente = new Dependente();
			funcionario.setSalario(res.getDouble("salario_funcionario"));
			funcionario.setNome(res.getString("nome_funcionario"));
			dependente.setNome(res.getString("nome_dependente"));
			dependente.setSalario(res.getDouble("salario_dependente"));
			dependente.setFuncionario(funcionario);
			funcionario.getDependentes().add(dependente);
			
		}
		return funcionario;
	}
	
	@Override
	public double findSomaSalario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
		connection = connect();
		String query = "SELECT dbo.soma_salarios(?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, funcionario.getCodigo());
		ResultSet res = statement.executeQuery();
		double soma = 0;
		if(res.next()) {
			soma = res.getDouble(1);
		}
		return soma;
	}
	
}
