import java.util.Scanner;

public abstract class Conta
{
	private		int		numero;
	private		String	cpf;
	private		double	saldo;
	private		boolean	ativo;
	Scanner sc = new Scanner(System.in);

	public void conta(int numero, String cpf)
	{
		this.numero = numero;
		this.cpf	= cpf;
		this.ativo	= true;
	}
	
	public void debito(double valor){
		this.saldo -= valor;
	}
	
	public void credito(double valor){
		this.saldo += valor;
	}

	public char visualizar(String tipoConta)
	{
		System.out.println("\nMeu Banco\nRL\n");
		System.out.format("%s\n", tipoConta);
		System.out.format("Saldo Atual: R$ %g- informação especifica da conta\n", getSaldo()); 
		System.out.print("MOVIMENTO D-debito ou C-Crédito:");
		char tipoMovimento = sc.next().charAt(0);
		sc.nextLine(); // consome a quebra de linha pendente
		return tipoMovimento;

	}
	
	public	double valorMovimento()
	{
		System.out.print("Valor movimento - USE VIRGULA AO INVES DE PONTO: R$ ");
		double valor = sc.nextDouble();
		sc.nextLine(); // consome a quebra de linha pendente
		return valor;	
	}

	public int getNumero(){
		return numero;
	}
	
	public boolean getAtivo(){
		return true;
	}
	public String getCpf(){
		return cpf;
	}

	public double getSaldo(){
		return this.saldo;
	}		
}
