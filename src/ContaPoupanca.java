
public class ContaPoupanca extends Conta {
	private float saldoContaPoupanca;
	
	public void exibirDados() {
		if(this.getContaAtiva()==true) {
			System.out.println("O nome do titular : " + this.getPessoa().getNome());
			System.out.println("O CPF do titular :  " + this.getPessoa().getCPF());
			System.out.println("O numero da conta : " + this.getNumero());
			System.out.println("A sua agencia : " + this.getAgencia());
			System.out.println("O seu saldo : " + this.saldoContaPoupanca);
		} else {
			System.out.println("A conta está inativa.");
		}
	}

	public float getSaldoContaPoupanca() {
		return saldoContaPoupanca;
	}

	public void setSaldoContaPoupanca(float saldoContaPoupanca) {
		this.saldoContaPoupanca = saldoContaPoupanca;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [saldoContaPoupanca=" + saldoContaPoupanca + "]";
	}

	@Override
	public void abrirConta() {
		if (this.getContaAtiva() == false) {
			System.out.println("Seja bem vindo! " + "sua Conta Poupança está aberta");
			this.setContaAtiva(true);
		} else {
			System.err.println("Conta já está aberta");
		}

	}

	@Override
	public void fecharConta() {
		if (this.getContaAtiva() == true) {
			this.setContaAtiva(false);
			System.out.println("Conta Poupança fechada com sucesso");
		} else {
			System.err.println("Impossivel fechar um conta inativa");
		}
	}

	@Override
	public void sacar(float valor) {
		if (this.getContaAtiva()==true) {
			if (valor < 0) {
				System.err.println("Valores inferiores a zero são indisponíveis para saque.");
			} else {
				acaoSaque(valor);
			}
		} else {
			System.out.println("A conta está inativa.");
		}
		

	}

	@Override
	public void acaoSaque(float valor) {
		if (valor <= this.saldoContaPoupanca) {
			this.saldoContaPoupanca = saldoContaPoupanca - valor;
			System.out.println("Saque efetuado com sucesso!\n"
					+ "Seu novo saldo é: " + this.saldoContaPoupanca);
		} else {
			System.err.println("Saldo insuficiente");
		}

	}

	@Override
	public void depositar(float valor) {
		if (this.getContaAtiva()==true) {
			this.saldoContaPoupanca = saldoContaPoupanca + valor;
		} else {
			System.out.println("A conta está inativa.");
		}
	}

	@Override
	public void transferir(float valor, Conta qRecebe) {
		this.sacar(valor);
		qRecebe.depositar(valor);

	}

}
