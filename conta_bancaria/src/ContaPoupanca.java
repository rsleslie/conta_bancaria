public class ContaPoupanca extends Conta
{
	private int 	diaAniversarioPoupanca = 20;
	private char 	tipoMovimento;
	private	double 	valor;

	public ContaPoupanca(int dia) 
	{
		credito(2000);
		if (diaAniversarioPoupanca == dia)
		{
			Double angtigo = getSaldo();
			credito(getSaldo() * 0.05);
			System.out.println("\n\nAniversario da Poupanca!!!");
			System.out.format("ATUALIZACAO DE SALDO DE %g PARA %g\n\n", angtigo, getSaldo());
		}

		for (int i = 1; i <= 10; i++) 
		{
			tipoMovimento = visualizar("CONTA POUPANCA");
			valor = valorMovimento();
			
			if (tipoMovimento == 'D') {
				if (valor <= getSaldo())
					debito(valor);
				else
					System.out.println("Saldo Insuficiente !!");
			} else if (tipoMovimento == 'C') {
				credito(valor);
			} else {
				System.out.println("\nTipo de movimento inválido.\n");
			}

			System.out.format("Saldo Atual: R$ %g informação especifica da conta\n", getSaldo()); 		
			System.out.print("Continuar S/N: ");
			char continuar = sc.nextLine().toUpperCase().charAt(0);
			
			if (continuar == 'N') {
				System.exit(0);
			}		
		}
	}
}
