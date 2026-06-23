package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
		
		private List<Conta> ListaContas = new ArrayList<Conta>();
		int numero = 0;


	@Override
	public void listarTodas() {
		for(var conta : ListaContas) 
		{
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		ListaContas.add(conta);
		System.out.printf("A conta número %d foi criada com sucesso! %n", conta.getNumero());
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	//Método Auxiliar
	
	public int gerarNumero() {
		return ++ numero;
	}

	
	
}
