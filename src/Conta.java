public abstract class Conta {
	private Pessoa pessoa;
	private int numero;
	private int agencia;
	private boolean contaAtiva = false;

	// Metodos abstratos que terão que ser implementados pelas classes filhas
	public abstract void abrirConta();

	public abstract void fecharConta();

	public abstract void sacar(float valor);

	public abstract void depositar(float valor);
	
	public abstract void transferir (float valor, Conta qRecebe);
	
	public abstract void acaoSaque (float valor);

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Conta [pessoa=" + pessoa + ", numero=" + numero + ", agencia=" + agencia + ", contaAtiva=" + contaAtiva
				+ "]";
	}

	public boolean getContaAtiva() {
		return contaAtiva;
	}

	public void setContaAtiva(boolean contaAtiva) {
		this.contaAtiva = contaAtiva;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
