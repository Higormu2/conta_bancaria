package conta_bancaria;

import java.util.InputMismatchException;
import java.util.LinkedList;
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
			}catch(InputMismatchException e) {
				opcao = - 1;
				System.out.println("Digite um número inteiro entre 0 e 8");
				leia.nextLine();
			}
			
			opcao = leia.nextInt();
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
				if (fila.isEmpty()) {
					System.out.println("Fila está fazia");
				} else {
					System.out.println("************************");
					System.out.println("Buscar Conta por Numero ");
					System.out.println("************************");

					System.out.println("**********************************");
					System.out.println("Informe o numero da conta?		  ");
					System.out.println("**********************************");
					resposta = leia.next();

				}

			}

				keyPress();
				break;
			case 4: {
				if (fila.isEmpty()) {
					System.out.println("Fila está fazia");
				} else {
					System.out.println("****************************");
					System.out.println("  Atualizar Dados da Conta  ");
					System.out.println("****************************");
				}

			}

				keyPress();
				break;
			case 5: {
				if (fila.isEmpty()) {
					System.out.println("Fila está fazia");
				} else {
					System.out.println("************************");
					System.out.println("    Apagar Conta	    ");
					System.out.println("************************");
					for (String fil : fila) {
						System.out.println(fil);
					}
					System.out.println("**********************************************");
					System.out.println("Informe o numero da conta que deseja excluir? ");
					System.out.println("**********************************************");
					resposta = leia.next();

					if (fila.contains(resposta) == true) {
						System.out.println("Cliente selecionado para ser excluído: " + resposta);
						fila.remove(resposta);
						System.out.println("***************");
						System.out.println("Fila atualizada");
						System.out.println("***************");
						if (fila.contains(resposta) == false) {
							System.out.println("Conta excluída com sucesso!");
						} else {
							System.out.println("Error!");
						}

					} else {
						System.out.println("********************");
						System.out.println("Nome não encontrado!");
						System.out.println("********************");
					}
				}

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
				new ContaPoupaca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 100.00f, 10));
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

}
