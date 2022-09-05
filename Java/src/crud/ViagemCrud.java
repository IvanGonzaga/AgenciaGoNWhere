package crud;

import java.util.Scanner;

import dao.ViagemDAO;
import model.Viagem;

public class ViagemCrud {
	public static void main(String[] args) {

	
	ViagemDAO viagensDAO = new ViagemDAO();	
	Scanner input = new Scanner(System.in);
	
	int opcao = 0;
	int posicao = 0;
	
	int id = 0;
	double preco = 0;
	String periodo = "";
	String origem = "";
	String destino = "";

	do {
		System.out.println("\n\t* CRUD Viagem *");
		System.out.println("\n\t1 - Cadastrar Viagem");
		System.out.println("\t2 - Consultar todas as Viagens");
		System.out.println("\t3 - Excluir Viagem");
		System.out.println("\t4 - Atualizar Viagem");
		System.out.println("\t0 - Fechar");
		
		opcao = input.nextInt();
		
		switch (opcao) { 
		case 1: 

			System.out.println("\n* Cadastrar Viagem *");
			System.out.println("\nDigite o preco da viagem: ");
			preco = input.nextDouble();
			System.out.println("Digite o periodo da viagem: ");
			periodo = input.nextLine();
			periodo = input.nextLine();
			System.out.println("Digite a origem da viagem: ");
			origem = input.nextLine();
			System.out.println("Digite o destino da viagem: ");
			destino = input.nextLine();
		
			Viagem viagens = new Viagem();
			
			viagens.setPreco(preco);
			viagens.setPeriodo(periodo);
			viagens.setOrigem(origem);
			viagens.setDestino(destino);
		
			viagensDAO.save(viagens);
			
			System.out.println("\n* Cadastro da viagem realizado com sucesso *\n");
			break;
		case 2:

			for (Viagem a : viagensDAO.getViagem()) { 
				System.out.println("\n\tId da viagem: " + a.getId_viagem() + "\n\tPreco: " 
			+ a.getPreco() + "\n\tPeriodo:  " + a.getPeriodo() + "\n\tOrigem:  " + a.getOrigem() + "\n\tDestino:  " + a.getDestino());
			}
			
			System.out.println("\n\n Final da Consulta ");
			break;
		case 3:

			System.out.println("\nInforme o ID da viagem para excluir ");
			posicao = input.nextInt();
			viagensDAO.deleteById(posicao);
			System.out.println("\n Excluido com sucesso ");
			break;
		case 4: 
			System.out.println("Informe o id da viagem para atualizar: ");
			id = input.nextInt();
			input.nextLine();
			System.out.println("Digite o novo preco da Viagem: " +preco);
			System.out.println("Digite o novo periodo da Viagem: ");
			periodo = input.nextLine();
			System.out.println("Digite a nova origem da Viagem: ");
			origem = input.nextLine();
			System.out.println("Digite o novo destino da Viagem: ");
			destino = input.nextLine();
			
			Viagem minhaViagem = new Viagem(id, preco, periodo, origem, destino);
			
			viagensDAO.update(minhaViagem);
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