package conta_bancaria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
	 private static String corTexto = Cores.AZUL;
	 private static String corFundo = Cores.FUNDO_PRETO;

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Queue<String> fila = new LinkedList<String>();
		int opcao;
		String resposta;
		boolean finalizar = false;
		
		filas:
		while(finalizar == false){
			
			
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
			opcao = leia.nextInt();
			System.out.println(Cores.RESET);
			
			switch(opcao) {
			
			case 1:
				do
				{
					System.out.println("************************"); 
					System.out.println("	 Criar Conta		"); 
					System.out.println("************************\n"); 
					
					System.out.println("Informe o nome do cliente: ");
					String nome = leia.next();
					fila.add(nome);
					System.out.println("Quer adicionar mais um cliente a fila? (Sim/Não)");
					resposta = leia.next();
					
					
				}while(resposta.equalsIgnoreCase("Sim"));
	
			break;
			case 2:
				
				if(fila.isEmpty()) {
					System.out.println("Nenhuma conta encontrada"); 
				}else
				{
					System.out.println("**********************"); 
					System.out.println("Listar todas as Contas"); 
					System.out.println("**********************"); 
					
					for(String fil:fila)
					{
						System.out.println(fil);
					}
				}
			break;
			case 3:
			{
				if(fila.isEmpty()) {
					System.out.println("Fila está fazia"); 
				}else
				{
					System.out.println("************************"); 
					System.out.println("Buscar Conta por Numero "); 
					System.out.println("************************"); 
					
					System.out.println("**********************************"); 
					System.out.println("Informe o numero da conta?		  ");
					System.out.println("**********************************"); 
					resposta = leia.next();

				}

			}
			break;
			case 4:
			{
				if(fila.isEmpty()) {
					System.out.println("Fila está fazia"); 
				}else
				{
					System.out.println("****************************"); 
					System.out.println("  Atualizar Dados da Conta  "); 
					System.out.println("****************************"); 
				}
				
				
			}
			break;
			case 5:
			{
				if(fila.isEmpty()) {
					System.out.println("Fila está fazia"); 
				}else
				{
					System.out.println("************************"); 
					System.out.println("    Apagar Conta	    "); 
					System.out.println("************************"); 
					for(String fil:fila)
					{
						System.out.println(fil);
					}
					System.out.println("**********************************************"); 
					System.out.println("Informe o numero da conta que deseja excluir? ");
					System.out.println("**********************************************"); 
					resposta = leia.next();
					
					if(fila.contains(resposta) == true)
					{
						System.out.println("Cliente selecionado para ser excluído: "+resposta);
						fila.remove(resposta);
						System.out.println("***************");
						System.out.println("Fila atualizada");
						System.out.println("***************");
						if(fila.contains(resposta)== false)
						{
							System.out.println("Conta excluída com sucesso!");
						}
						else
						{
							System.out.println("Error!");
						}
						
					}else
					{
						System.out.println("********************");
						System.out.println("Nome não encontrado!");
						System.out.println("********************");
					}
				}
				
				
				
			}
			break;
			case 6:
			{
				if(fila.isEmpty()) {
					System.out.println("Fila está fazia"); 
				}else
				{
					System.out.println("****************************"); 
					System.out.println("  			Sacar		    "); 
					System.out.println("****************************"); 
				}
				
				
			}
			break;
			
			case 7:
			{
				if(fila.isEmpty()) {
					System.out.println("Fila está fazia"); 
				}else
				{
					System.out.println("****************************"); 
					System.out.println("  		  Depositar		    "); 
					System.out.println("****************************"); 
				}
				
				
			}
			break;
			
			case 8:
			{
				if(fila.isEmpty()) {
					System.out.println("Fila está fazia"); 
				}else
				{
					System.out.println("***********************************"); 
					System.out.println("  Transferir valores entre Contas  "); 
					System.out.println("***********************************"); 
				}
				
				
			}
			break;
			
			case 0:
			{
				finalizar = true;
				break filas;
			}
			}
			System.out.println("Deseja fazer mais uma operação? ");
			resposta = leia.next();
		}
	}

}
