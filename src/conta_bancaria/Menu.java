package conta_bancaria;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupaca;
import conta_bancaria.util.Cores;

public class Menu {
	private static String corTexto = Cores.AZUL;
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	private static String corFundo = Cores.FUNDO_PRETO;

	public static void main(String[] args) {

		Queue<String> fila = new LinkedList<String>();
		int opcao;
		// Criar dados de testes
		criarContasTeste();
		String resposta;
		boolean finalizar = false;

		filas: while (finalizar == false) {

			System.out.println(corFundo + corTexto);

			Cores.aplicarTema();
			System.out.println("******************************************************");
			System.out.println("  \n Banco do Brazil com Z - O seu Futuro começa aqui!\n");
			System.out.println("******************************************************");
			System.out.println("******************************************************");
			System.out.println("								 				   	  ");
			System.out.println("  1 - Criar Conta			     					  ");
			System.out.println("  2 - Listar todas as Contas	 				  	  ");
			System.out.println("  3 - Buscar Conta por Numero	 					  ");
			System.out.println("  4 - Atualizar Dados da Conta	 					  ");
			System.out.println("  5 - Apagar Conta				  					  ");
			System.out.println("  6 - Sacar						  					  ");
			System.out.println("  7 - Depositar					  					  ");
			System.out.println("  8 - Transferir valores entre Contas				  ");
			System.out.println("  0 - Depositar					 					  ");
			System.out.println("								  					  ");
			System.out.println("******************************************************");
			System.out.println("Entre com a opção desejada:		  					  ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 8");
				leia.nextLine();
			}

			System.out.println(Cores.RESET);

			switch (opcao) {

			case 1:
				do {
					System.out.println("******************************");
					System.out.println("	 Criar Conta		");
					System.out.println("******************************\n");
					cadastrarConta();

					System.out.println("Quer adicionar mais um cliente a fila? (Sim/Não)");
					resposta = leia.next();
				} while (resposta.equalsIgnoreCase("Sim"));

				keyPress();
				break;
			case 2:

				System.out.println("**********************");
				System.out.println("Listar todas as Contas");
				System.out.println("**********************");
				listarContas();

				keyPress();
				break;
			case 3: {

				System.out.println("************************");
				System.out.println("Buscar Conta por Numero ");
				System.out.println("************************");

				System.out.println("**********************************");
				System.out.println("Informe o numero da conta?		  ");
				System.out.println("**********************************");
				procurarContaPorNumero();

			}

				keyPress();
				break;
			case 4: {
				
					System.out.println("****************************");
					System.out.println("  Atualizar Dados da Conta  ");
					System.out.println("****************************");
					atualizarConta();

			}

				keyPress();
				break;
			case 5: {

				System.out.println("************************");
				System.out.println("    Apagar Conta	    ");
				System.out.println("************************");
				deletarConta();

			}

				keyPress();
				break;
			case 6: {
				if (fila.isEmpty()) {
					System.out.println("Fila está fazia");
				} else {
					System.out.println("****************************");
					System.out.println("  			Sacar		    ");
					System.out.println("****************************");

				}

			}

				keyPress();
				break;

			case 7: {
				if (fila.isEmpty()) {
					System.out.println("Fila está fazia");
				} else {
					System.out.println("****************************");
					System.out.println("  		  Depositar		    ");
					System.out.println("****************************");

				}

			}

				keyPress();
				break;

			case 8: {
				if (fila.isEmpty()) {
					System.out.println("Fila está fazia");
				} else {
					System.out.println("***********************************");
					System.out.println("  Transferir valores entre Contas  ");
					System.out.println("***********************************");
				}

			}

				keyPress();
				break;

			case 0: {
				finalizar = true;
				break filas;
			}
			}
			System.out.println("Deseja fazer mais uma operação? ");
			resposta = leia.next();
		}
	}

	public static void keyPress() {
		System.out.println(Cores.RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	public static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaPoupaca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}

	public static void listarContas() {
		contaController.listarTodas();
	}

	public static void cadastrarConta() {
		System.out.println("Digite o número da agência: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do titular da conta: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("Digite o tipo da conta (1 - cc | 2 - CP): ");
		int tipo = leia.nextInt();

		System.out.println("Digite o saldo da conta: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();

			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {

			System.out.println("Digite o dia do aniversario da conta: ");
			int aniversario = leia.nextInt();

			contaController.cadastrar(
					new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.VERMELHO + "Tipo de cona inválida" + Cores.RESET);
		}
	}

	public static void procurarContaPorNumero() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);
	}

	public static void deletarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {
			// Confirmação da exclusão
			System.out.printf("\nTem certeza que você deseja excluir a conta numero %d? (S/N)", numero);
			String confirmacao = leia.nextLine();
			if (confirmacao.equalsIgnoreCase("S"))
				contaController.deletar(numero);
			else
				System.out.println("\nOperação cancelada!");
		} else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);

	}
	
	public static void atualizarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Optional<Conta> conta = contaController.buscarNaCollection(numero);
		
		if(conta.isPresent()) 
		{
			//Obtém os dados atuais da conta
			int agencia = conta.get().getAgencia();
			String titular = conta.get().getTitular();
			int tipo = conta.get().getTipo();
			float saldo = conta.get().getSaldo();
			
			//Atualiza a agencia ou mantém o valor atual
			System.out.printf("Agência atual: %d%n Digite o número da nova agência (Pressionae ENTER para manter o valor atual)", agencia);
			
			String entrada = leia.nextLine();
			
			agencia = entrada.isEmpty()? agencia : Integer.parseInt(entrada);
			
			//Atualizar o titular ou mantem o valor atual
		
			System.out.printf("Tiutlar atual: %s%n Digite o nome do novo titular (Pressionae ENTER para manter o valor atual)", titular);
			entrada = leia.nextLine();
			
			titular = entrada.isEmpty()? titular : entrada;
			
			//Atualizar o saldo ou mantem o valor atual
			
			System.out.printf("Saldo atual: %.2f%n Digite o novo saldo (Pressionae ENTER para manter o valor atual)", saldo);
			entrada = leia.nextLine();
			
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));
			
			switch(tipo){
			
			case 1 -> {
				ContaCorrente contaCorrente = (ContaCorrente) conta.get();
				float limite = contaCorrente.getLimite();
				
				System.out.printf("Limite atual: %.2f%n Digite o novo limite (Pressionae ENTER para manter o valor atual)", limite);
				entrada = leia.nextLine();
				
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",", "."));
				
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				
			}
			case 2 ->{
				ContaPoupaca contaPoupaca = (ContaPoupaca) conta.get();
				int aniversario = contaPoupaca.getContaPoupanca();
				
				System.out.printf("Aniversario atual: %d%n Digite o novo aniversario (Pressionae ENTER para manter o valor atual)", aniversario);
				entrada = leia.nextLine();
				
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				
				contaController.atualizar(new ContaPoupaca(numero, agencia, tipo, titular, saldo, aniversario));
			}
			default -> System.out.println(Cores.VERMELHO + "Tipo da conta é inválido!"+ Cores.RESET);
				
			}
			
			
		}else
		{
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}

}
