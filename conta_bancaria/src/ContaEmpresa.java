public class ContaEmpresa extends Conta {
	
	private double emprestimoEmpresa = 10000;

	public ContaEmpresa() 
	{
		char    tipoMovimento;
		double  valor;
		
		credito(2000);
		for (int i = 1; i <= 10; i++) 
		{
			tipoMovimento = visualizar("CONTA EMPRESA");
			valor = valorMovimento();
			
			if (tipoMovimento == 'D') {
				if (getSaldo() >= 0 && valor <= getSaldo())
					debito(valor);
				else
				System.out.println("\nSaldo Insuficiente !!\n");
			} else if (tipoMovimento == 'C') {
				credito(valor);
			} else {
				System.out.println("\nTipo de movimento inválido.\n");
			}

			System.out.format("Saldo Atual: R$ %g informação especifica da conta\n", getSaldo()); 		

			System.out.print("Continuar S/N: ");
			char continuar = sc.nextLine().toUpperCase().charAt(0);

			if (continuar == 'N')
				System.exit(0);
			
			System.out.format("ESTA DISPONIVEL %g PARA EMPRESTIMO\n", emprestimoEmpresa);
			System.out.print("FAZER EMPRESTIMO S/N: ");
			char emprestimo = sc.nextLine().toUpperCase().charAt(0);

			if (emprestimo == 'S')
			{
				System.out.print("VALOR DO EMPRESTIMO - USE VIRGULA AO INVES DE PONTO: R$ ");
				double valorEmprestimo = sc.nextDouble();
				sc.nextLine();
				
				usarEmprestimo(valorEmprestimo);
			}
		}
	}

	public void usarEmprestimo(double valor) {
		if (valor <= emprestimoEmpresa) {
			emprestimoEmpresa -= valor;
			credito(valor);
			System.out.printf("R$ %.2f usados do empréstimo.%n", valor);
		} else {
			System.out.println("Valor solicitado excede o empréstimo disponível.");
		}
	}

}
