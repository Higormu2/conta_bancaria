package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private List<Conta> ListaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void listarTodas() {
		for (var conta : ListaContas) {
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

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);

	}

	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			ListaContas.set(ListaContas.indexOf(buscaConta.get()), conta);
				conta.visualizar();
			
		}else
			System.out.printf("\nA conta número %d não foi encontrada!", conta.getNumero());

	}

	@Override
	public void deletar(int numero) {
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			if (ListaContas.remove(conta.get()))
			{
				System.out.printf("\nA conta número %d foi excluída com sucesso!", numero);
			}
		else
			System.out.printf("\nA conta número %d não foi encontrada!", numero);

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

	// Método Auxiliar
	//aumenta o valor do numero, assim as contas vão gerando um número em fila
	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : ListaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}

}
