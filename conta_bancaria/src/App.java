import java.util.Scanner;

public class App {

	public static void main(String[] args)
    {
        int     opcao;
		int     numero;
        String  cpf;

		Scanner sc = new Scanner(System.in);
		// Menu Principal
		
		System.out.println("Meu Banco RL\nRL");
		System.out.println("1-CONTA POUPANCA\n2-CONTA CORRENTE\n3-CONTA ESPECIAL\n4-CONTA EMPRESA\n5-CONTA ESTUDANTIL\n6-SAIR\n");
		System.out.print("DIGITE O CODIGO DA OPCAO SELECIONADA:_");
		opcao = sc.nextInt();
		if (opcao == 6)
			System.exit(0);
		System.out.print("QUAL A DATA DE NASCIMENTO: ");
		numero = sc.nextInt();
		System.out.print("QUAL O CPF: ");
		cpf = sc.next();
		sc.nextLine();
		//fim -----------------------------

		//Tipo de conta escolhida
		switch (opcao) {
			case 1:
				ContaPoupanca tipo = new ContaPoupanca(numero);
                break;
            case 2:
				ContaCorrente corrente = new ContaCorrente();
                break;
            case 3:
				ContaEspecial especial = new ContaEspecial();
                break;
            case 4:
                ContaEmpresa empresa = new ContaEmpresa();
                break;
            case 5:
                ContaEstudantil estudantil = new ContaEstudantil();
                break;
            case 6:
                System.exit(0); // encerrar o programa
            default:
                System.out.println("Opção inválida.");
                System.exit(1); // encerrar o programa com erro
        }
		
    }
}
