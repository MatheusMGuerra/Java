import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;

		ContaCorrente cc1 = new ContaCorrente();
		Pessoa p1 = new Pessoa();
		p1.setNome("Richard Rasmussem");
		p1.setCPF("702.423.674-99");
		cc1.setPessoa(p1);
		cc1.setNumero(1234);
		cc1.setAgencia(0001);
		cc1.setSaldoContaCorrente(1000);

		ContaPoupanca cp3 = new ContaPoupanca();
		Pessoa p3 = new Pessoa();
		p3.setNome("Aroldo Bauer");
		p3.setCPF("706.322.535-63");
		cp3.setPessoa(p3);
		cp3.setNumero(4321);
		cp3.setAgencia(0003);
		cp3.setSaldoContaPoupanca(3000);

		do {
			System.out.println("\nBem vindo ao Java Bank");

			System.out.println("Selecione uma opção: \n" + 
			"1 - Ativar Conta \n" + 
			"2 - Desativar Conta\n" +
			"3 - Sacar\n" + 
			"4 - Depositar\n" +
			"5 - Transferir\n" +
			"6 - Exibir dados da conta\n" +
			"7 - Sair");
			opcao = sc.nextInt();

			if (opcao >= 1 && opcao <= 7) {
				int aux;
				switch (opcao) {
				case 1:
					System.out.println("Informe o número da conta: ");
					aux = sc.nextInt();
					if (aux == cc1.getNumero()) {
						cc1.abrirConta();
					}else if (aux == cp3.getNumero()) {
						cp3.abrirConta();
					} else {
						System.err.println("Conta não encontrada.");
					}
					break;
				case 2:
					System.out.println("Informe o número da conta: ");
					aux = sc.nextInt();
					if (aux == cc1.getNumero()) {
						cc1.fecharConta();
					}else if (aux == cp3.getNumero()) {
						cp3.fecharConta();
					} else {
						System.out.println("Conta não encontrada.");
					}
					break;
				case 3:
					System.out.println("Informe o número da conta: ");
					aux = sc.nextInt();
					if (aux == cc1.getNumero()) {
						System.out.println("Informe o valor do saque: ");
						cc1.sacar(sc.nextFloat());
					} else if (aux == cp3.getNumero()) {
						System.out.println("Informe o valor do saque: ");
						cp3.sacar(sc.nextFloat());
					} else {
						System.out.println("Conta não encontrada.");
					}
					break;
				case 4:
					System.out.println("Informe o número da conta: ");
					aux = sc.nextInt();
					if (aux == cc1.getNumero()) {
						System.out.println("Informe o valor do depósito: ");
						cc1.depositar(sc.nextFloat());
					} else if (aux == cp3.getNumero()) {
						System.out.println("Informe o valor do depósito: ");
						cp3.depositar(sc.nextFloat());
					} else {
						System.out.println("Conta não encontrada.");
					}
					break;
				case 5:
					System.out.println("Informe o número da conta: ");
					aux = sc.nextInt();
					System.out.println("Informe a conta que receberá o valor: ");
					int aux2 = sc.nextInt();
					if (aux == cc1.getNumero() && aux2 == cp3.getNumero()) {
						System.out.println("Informe o valor da transferência: ");
						cc1.transferir(sc.nextFloat(), cp3);
					} else if (aux == cp3.getNumero() && aux2 == cc1.getNumero()) {
						System.out.println("Informe o valor da transferência: ");
						cp3.transferir(sc.nextFloat(), cc1);
					} else {
						System.out.println("Conta não encontrada.");
					}
					break;
				case 6:
					System.out.println("Informe o número da conta: ");
					aux = sc.nextInt();
					if (aux == cc1.getNumero()) {
						cc1.exibirDados();
					} else if (aux == cp3.getNumero()) {
						cp3.exibirDados();
					} else {
						System.out.println("Conta não encontrada.");
					}
					break;
				default:
					
					break;
				}
			} else {
				System.out.println("Opção inválida, tente novamente.");
			}

		} while (opcao != 7);

		sc.close();
	}
}
