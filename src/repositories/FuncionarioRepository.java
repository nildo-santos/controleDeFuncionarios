package repositories;

import java.sql.DriverManager;

import entities.Funcionario;

public class FuncionarioRepository {

	public void inserir(Funcionario funcionario) {
		
		try {
			var host = "jdbc:mysql://localhost:3306/bd_aula03?useSSL=false&serverTimezone=UTC";
			var user = "root";
			var pass = "coti";
			
			var connection = DriverManager.getConnection(host, user, pass);
			
			var statementEnd = connection.prepareStatement
					("insert into endereco(id, logradouro,numero, complemento, bairro, cidade, estado, cep) values(?,?,?,?,?,?,?,?)");
			statementEnd.setString(1, funcionario.getEndereco().getId().toString());
			statementEnd.setString(2, funcionario.getEndereco().getLogradouro());
			statementEnd.setString(3, funcionario.getEndereco().getNumero());
			statementEnd.setString(4, funcionario.getEndereco().getComplemento());
			statementEnd.setString(5, funcionario.getEndereco().getBairro());
			statementEnd.setString(6, funcionario.getEndereco().getCidade());
			statementEnd.setString(7, funcionario.getEndereco().getEstado());
			statementEnd.setString(8, funcionario.getEndereco().getCep());
			statementEnd.execute();//executando o comando
			
			var statementFunc = connection.prepareStatement(
					"insert into funcionario(id, nome, cpf, dataadmissao, endereco_id) values(?,?,?,?,?)");
			statementFunc.setString(1, funcionario.getId().toString());
			statementFunc.setString(2, funcionario.getNome());
			statementFunc.setString(3, funcionario.getCpf());
			statementFunc.setDate(4, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
			statementFunc.setString(5, funcionario.getEndereco().getId().toString());
			statementFunc.execute();//executando o comando
			System.out.println("\nFuncionário gravado com sucesso!");
			
			connection.close();//fechando a conexão
		}
		catch (Exception e) {
			System.out.println("\nFalha ao gravar funcionário: " + e.getMessage());
		}
	}
	
}
