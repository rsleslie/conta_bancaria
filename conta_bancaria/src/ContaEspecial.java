public class ContaEspecial extends Conta {

    private double limite = 1000;

    public  ContaEspecial()
    {
        char    tipoMovimento;
        double  valor;
        
        credito(2000);
		for (int i = 1; i <= 10; i++) 
		{
			tipoMovimento = visualizar("CONTA ESPECIAL");
			valor = valorMovimento();
			
			if (tipoMovimento == 'D') {
				if (getSaldo() >= 0 && valor <= getSaldo())
					debito(valor);
				else
                    debito(usarLimite(valor));
			} else if (tipoMovimento == 'C') {
				credito(valor);
			} else {
				System.out.println("Tipo de movimento inválido.");
			}

			System.out.format("Saldo Atual: R$ %g informação especifica da conta\n", getSaldo()); 		

			System.out.print("Continuar S/N: ");
			char continuar = sc.nextLine().toUpperCase().charAt(0);

			if (continuar == 'N')
				System.exit(0);			
		
        }
    }
    public double usarLimite(double valor) {
        if (getSaldo() + limite >= valor) {
            double novoSaldo = getSaldo() - valor;
            if (novoSaldo < 0) {
                this.limite -= (novoSaldo * -1);
                System.out.format("\nVoce esta no limite!\nLimite = %g\n", this.limite);
                return getSaldo();
            }
        } else {
            System.out.println("Valor superior ao limite disponível.");
        }
        return 0;
    }

}