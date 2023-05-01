public class ContaCorrente extends Conta {
    
    private int contadorTalao;
    
    public ContaCorrente() 
    {
        char    tipoMovimento;
        double  valor;
        
        contadorTalao = 0;
		credito(2000);
		for (int i = 1; i <= 10; i++) 
		{
			tipoMovimento = visualizar("CONTA CORRENTE");
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
                
			System.out.println("Pedir Talao S/N :");
			char pedirTalao = sc.next().charAt(0);
			sc.nextLine();
			if (pedirTalao == 'S')
				debito(pediTalao());
				System.out.format("Saldo Atual: R$ %g- informação especifica da conta\n", getSaldo()); 
			
		
        }
    }
    
    public double pediTalao() {
        if (contadorTalao < 3) {
            contadorTalao++;
            System.out.println("\nTalão solicitado com sucesso.\n");
            return 30;
        } else {
            System.out.println("Você já solicitou o limite máximo de talões.");
        }
        return 0;
    }
}
