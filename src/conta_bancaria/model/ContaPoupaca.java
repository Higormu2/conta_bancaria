package conta_bancaria.model;

public class ContaPoupaca extends Conta{

	private int contapoupanca;
	
	public ContaPoupaca(int numero, int agencia, int tipo, String titular, float saldo, float limite, int contapoupanca ) {
		super(numero, agencia, tipo, titular, saldo);
		
		this.contapoupanca = contapoupanca;
		
	}
	
	public int getcontapoupanca()
	{
		return contapoupanca;
	}
	public void setcontapoupanca(int contapoupanca)
	{
		this.contapoupanca = contapoupanca;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Aniversario da conta: %d%n", this.contapoupanca);
		}

}
