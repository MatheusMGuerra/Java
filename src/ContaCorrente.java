
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
			System.out.println("Essa conta est� inativa.");
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
			System.out.println("Seja bem vindo! Sua Conta Corrente est� aberta");
			this.setContaAtiva(true);
		} else {
			System.err.println("Conta j� est� aberta");
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
				System.err.println("Valores inferiores a zero s�o indispon�veis para saque.");
				}
				else {
				acaoSaque(valor);
				}
		} else {
			System.out.println("Essa conta est� inativa.");
		}	
	}
	
	@Override
	public void acaoSaque(float valor) {
		if (valor <= saldoContaCorrente) {
			this.saldoContaCorrente = saldoContaCorrente - valor;
			System.out.println("Saque efetuado com sucesso!\n"
					+ "Seu novo saldo �: " + this.saldoContaCorrente);
		}

		else if (valor <= saldoContaCorrente + chequeEspecial) {
			this.saldoContaCorrente = saldoContaCorrente - valor;
			System.out.println("Saque efetuado com sucesso. Voc� est� em cheque especial.\n"
					+ "Seu novo saldo �: " + this.saldoContaCorrente);

		} else {
			System.out.println("Voc� n�o possui saldo nem cheque especial dispon�vel nesse valor.\n"
					+ "Seu saldo �: " + this.saldoContaCorrente);
		}
		
	}

	@Override
	public void depositar(float valor) {
		if(this.getContaAtiva()==true) {
			if (valor > 0 && valor <= 5000) {
				this.saldoContaCorrente = saldoContaCorrente + valor;
				System.out.println("Dep�sito efetuado com sucesso!\n"
						+ "Seu novo saldo �: " + this.saldoContaCorrente);
			}

			else if (valor <= 0) {
				System.err.println("Valores menores que zero s�o inv�lidos para dep�sito.");
			}

			else {
				System.err.println("O limite de dep�sito � de R$ 5.000,00.");
			}
		} else {
			System.out.println("Essa conta est� inativa.");
		}
	}
	

	@Override
	public void transferir(float valor, Conta qRecebe) {
		this.sacar(valor);
		qRecebe.depositar(valor);

	}

}
