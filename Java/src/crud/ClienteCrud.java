package crud;

import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteCrud {
	public static void main(String[] args) {

	
	ClienteDAO clientesDAO = new ClienteDAO();
	
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	int posicao = 0;
	
	int id = 0;
	String nome = "";
	String cpf = "";
	String telefone = "";
	String endereco = "";
	String email = "";
		

	do {
		System.out.println("\n\t * CRUD CLIENTE *");
		System.out.println("\n\t1 - Cadastrar Cliente");
		System.out.println("\t2 - Consultar todos os Clientes");
		System.out.println("\t3 - Excluir Cliente");
		System.out.println("\t4 - Atualizar Cliente");
		System.out.println("\t0 - Fechar");
		
		opcao = input.nextInt();
		
		switch (opcao) { 
		case 1: 

			System.out.println("\n*Cadastrar Cliente*");
			System.out.println("\nDigite o nome do cliente: ");
			nome = input.nextLine();
			nome = input.nextLine();
			System.out.println("Digite o CPF do cliente: ");
			cpf = input.nextLine();
			System.out.println("Digite o telefone do cliente: ");
			telefone = input.nextLine();
			System.out.println("Digite o endereço do cliente: ");
			endereco = input.nextLine();
			System.out.println("Digite o email do cliente: ");
			email = input.nextLine();

			
			
			Cliente clientes = new Cliente();
			
			clientes.setNome(nome);
			clientes.setCpf(cpf);
			clientes.setTelefone(telefone);
			clientes.setEndereco(endereco);
			clientes.setEmail(email);
			
			clientesDAO.save(clientes);
			
			System.out.println("\n* Cadastro do cliente realizado com sucesso *\n");
			break;
		case 2:

			for (Cliente a : clientesDAO.getCliente()) { 
				System.out.println("\n\tId do cliente: " + a.getId_cliente() + "\n\tNome do cliente: " 
			+ a.getNome() + "\n\tCPF do cliente:  " + a.getCpf() + "\n\tTelefone do cliente:  " + a.getTelefone() + "\n\tEndereço do cliente:  " + a.getEndereco() + "\n\tEmail do cliente:  " + a.getEmail());
			}
			
			System.out.println("\n\n Final da Consulta ");
			break;
		case 3:

			System.out.println("\nInforme o ID do cliente para excluir ");
			posicao = input.nextInt();
			clientesDAO.deleteById(posicao);
			System.out.println("\n Excluido com sucesso ");
			break;
		case 4: 
			System.out.println("Informe o id do cliente para atualizar: ");
			id = input.nextInt();
			input.nextLine();
			System.out.println("Digite o novo nome do Cliente: ");
			nome = input.nextLine();
			System.out.println("Digite o novo CPF do Cliente: ");
			cpf = input.nextLine();
			System.out.println("Digite o novo telefone do Cliente: ");
			telefone = input.nextLine();
			System.out.println("Digite o novo endereco do Cliente: ");
			endereco = input.nextLine();
			System.out.println("Digite o novo email do Cliente: ");
			email = input.nextLine();
			
			Cliente meuCliente1 = new Cliente(id, nome, cpf,  telefone, endereco, email);
			
			clientesDAO.update(meuCliente1);
			break;
		default:
			System.out.println(opcao != 0 ? "\n Esta opção não existe, " + "selecione outra opção.\n" : "");
			break;
		}
	} while (opcao != 0);
	  input.close();
	  System.out.println("\n Fim ");
	
   }
}