package br.com.gabriel.fintech;

public class CarteiraDigital {

	public static void main(String[] args) {
		
		String nomeDoCliente = "Gabriel";
		double saldoAtual = 27000;
		double valorSaque = 4000;
		double taxaSaque = 5.00;
		
		double cotacaoDolar = 5.26;
		
		boolean clienteVip = false;
		
		double taxaDeRendimeto;
		
		
		System.out.println("Nome do cliente: " + nomeDoCliente);
		System.out.println("Saldo atual: " + saldoAtual);
		System.out.println("Valor do saque: " + valorSaque);
			
		// Bloco de código para verificar se um cliente pode ser vip ou não.
		if (saldoAtual >= 10000) {
			clienteVip = true;
			
			System.out.println("Cliente VIP Ativado!");
		} else {
			System.out.println("Tenha 10.000 na conta para se tornar cliente VIP.");
		}
		
		// Bloco de código para se o cliente for vip ele pode ter benefícios.
		if (clienteVip) { 
			// Bloco de código para verificar o saldo e realizar o saque sem taxa.
			if (saldoAtual >= valorSaque && valorSaque > 0) {
				double valorDoCashback = 0.01 * valorSaque;
				saldoAtual = saldoAtual - valorSaque;
				saldoAtual += valorDoCashback;
				int valorDolar = (int) (saldoAtual / cotacaoDolar);
				
				System.err.println("Transação livre de taxas.");
				System.err.println("Valor do Cashback: " + valorDoCashback);
				System.out.println("Novo saldo: " + saldoAtual);
				System.out.println("Seu saldo em dolar: " + valorDolar);
			} else {
				System.out.println("Saldo insuficiente");
			}
		} else {
			// Bloco de código para verificar o saldo e realizar o saque com taxa.
			if (saldoAtual >= valorSaque) {
				saldoAtual = saldoAtual - valorSaque - taxaSaque;
				int valorDolar = (int) ((int) saldoAtual / cotacaoDolar);
				
				System.err.println("Transação com taxa de: " + taxaSaque);
				System.out.println("Novo saldo: " + saldoAtual);
				System.out.println("Seu saldo em dolar: " + valorDolar);
			} else {
				System.out.println("Saldo insuficiente");
			}
		}
		
		System.err.println("Sistema de rendimento ao mês: ");
		clienteVip = saldoAtual >= 10000;
		for(int mes = 1; mes <= 12; mes++) {
			if (clienteVip) {
				taxaDeRendimeto = 0.008;
				saldoAtual = saldoAtual + (saldoAtual * taxaDeRendimeto);
				System.out.printf("Mês %d: Saldo R$ %.2f%n", mes, saldoAtual);
			} else {
				taxaDeRendimeto = 0.005;
				saldoAtual = saldoAtual + (saldoAtual * taxaDeRendimeto);
				System.out.printf("Mês %d: Saldo R$ %.2f%n", mes, saldoAtual);
			}
		}
	}
}

