package conta_bancaria.model;

public class ContaPoupaca extends Conta {

    private int contaPoupanca;

    public ContaPoupaca(int numero, int agencia, int tipo, String titular, float saldo, int contaPoupanca) {
        super(numero, agencia, tipo, titular, saldo);
        this.contaPoupanca = contaPoupanca;
    }

    public int getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(int contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.printf("Aniversario da conta: %d%n", this.contaPoupanca);
    }
}