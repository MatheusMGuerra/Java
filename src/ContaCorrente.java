
public class ContaCorrente extends Conta {
	private float saldoContaCorrente;
	private float chequeEspecial = 3000;

	public void exibirDados() {
		if(this.getContaAtiva()==true) {
			System.out.println("O nome do titular : " + this.getPessoa().getNome());
			System.out.println("O CPF do titular :  " + this.getPessoa().getCPF());
			System.out.println("O numero da conta : " + this.getNumero());
			System.out.println("A sua agencia : " + this.getAgencia());
			System.out.println("O seu saldo : " + this.saldoContaCorrente);
		} else {
			System.out.println("Essa conta está inativa.");
		}
	}

	public float getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(float saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

	@Override
	public String toString() {
		return "ContaCorrente [saldoContaCorrente=" + saldoContaCorrente + "]";
	}

	@Override
	public void abrirConta() {
		if (this.getContaAtiva() == false) {
			System.out.println("Seja bem vindo! Sua Conta Corrente está aberta");
			this.setContaAtiva(true);
		} else {
			System.err.println("Conta já está aberta");
		}

	}

	@Override
	public void fecharConta() {
		if (this.getContaAtiva() == true) {
			this.setContaAtiva(false);
			System.out.println("Conta Corrente fechada com sucesso");
		} else {
			System.err.println("Impossivel fechar uma conta inativa");
		}
	}

	@Override
	public void sacar(float valor) {
		if(this.getContaAtiva()==true) {
			if (valor < 0) { 
				System.err.println("Valores inferiores a zero são indisponíveis para saque.");
				}
				else {
				acaoSaque(valor);
				}
		} else {
			System.out.println("Essa conta está inativa.");
		}	
	}
	
	@Override
	public void acaoSaque(float valor) {
		if (valor <= saldoContaCorrente) {
			this.saldoContaCorrente = saldoContaCorrente - valor;
			System.out.println("Saque efetuado com sucesso!\n"
					+ "Seu novo saldo é: " + this.saldoContaCorrente);
		}

		else if (valor <= saldoContaCorrente + chequeEspecial) {
			this.saldoContaCorrente = saldoContaCorrente - valor;
			System.out.println("Saque efetuado com sucesso. Você está em cheque especial.\n"
					+ "Seu novo saldo é: " + this.saldoContaCorrente);

		} else {
			System.out.println("Você não possui saldo nem cheque especial disponível nesse valor.\n"
					+ "Seu saldo é: " + this.saldoContaCorrente);
		}
		
	}

	@Override
	public void depositar(float valor) {
		if(this.getContaAtiva()==true) {
			if (valor > 0 && valor <= 5000) {
				this.saldoContaCorrente = saldoContaCorrente + valor;
				System.out.println("Depósito efetuado com sucesso!\n"
						+ "Seu novo saldo é: " + this.saldoContaCorrente);
			}

			else if (valor <= 0) {
				System.err.println("Valores menores que zero são inválidos para depósito.");
			}

			else {
				System.err.println("O limite de depósito é de R$ 5.000,00.");
			}
		} else {
			System.out.println("Essa conta está inativa.");
		}
	}
	

	@Override
	public void transferir(float valor, Conta qRecebe) {
		this.sacar(valor);
		qRecebe.depositar(valor);

	}

}
