package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

import entities.Endereco;
import entities.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioController {

	/*
	 * Método para que possamos capturar os dados
	 * de um funcionário preenchido pelo usuário
	 */
	public void cadastrarFuncionario() {
		
		//Criando um objeto da classe Scanner
		var scanner = new Scanner(System.in);
		
		System.out.println("\nCADASTRO DE FUNCIONÁRIO:\n");
		
		//Criando um objeto da classe Funcionario
		var funcionario = new Funcionario();
		
		//Instanciando o atributo Endereco do funcionário
		funcionario.setEndereco(new Endereco());
		
		funcionario.setId(UUID.randomUUID()); //gerando um ID aleatório para o funcionário
		funcionario.getEndereco().setId(UUID.randomUUID()); //gerando um ID aleatório para o endereço do funcionário
		
		System.out.print("INFORME O NOME................: ");
		funcionario.setNome(scanner.nextLine());
		
		System.out.print("CPF...........................: ");
		funcionario.setCpf(scanner.nextLine());
		
		System.out.print("DATA DE ADMISSÃO (dd/MM/yyyy).: ");
		var input = scanner.nextLine();
		var dataAdmissao = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		funcionario.setDataAdmissao(dataAdmissao);
		
		System.out.print("LOGRADOURO....................: ");
		funcionario.getEndereco().setLogradouro(scanner.nextLine());
		
		System.out.print("NUMERO........................: ");
		funcionario.getEndereco().setNumero(scanner.nextLine());
		
		System.out.print("COMPLEMENTO...................: ");
		funcionario.getEndereco().setComplemento(scanner.nextLine());
		
		System.out.print("BAIRRO........................: ");
		funcionario.getEndereco().setBairro(scanner.nextLine());
		
		System.out.print("CIDADE........................: ");
		funcionario.getEndereco().setCidade(scanner.nextLine());
		
		System.out.print("ESTADO........................: ");
		funcionario.getEndereco().setEstado(scanner.nextLine());
		
		System.out.print("CEP...........................: ");
		funcionario.getEndereco().setCep(scanner.nextLine());
		
		var funcionarioRepository = new FuncionarioRepository();
		funcionarioRepository.inserir(funcionario);
		
		scanner.close();
	}
}
