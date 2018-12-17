import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorFesta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Iniciando as variaveis
		ArrayList<Cliente> cliente = new  ArrayList<Cliente>();
		ArrayList<Fornecedor> fornecedor = new  ArrayList<Fornecedor>();
		ArrayList<Aluguel> aluguel = new  ArrayList<Aluguel>();
		ArrayList<Tema> tema = new  ArrayList<Tema>();
		ArrayList<Tema> temasLocados = new  ArrayList<Tema>();

		int opcao = 0;
		
		
		
		//Inicio do loop do menu
		while(true) {
			
			opcao = menu();
			System.out.println(opcao);
			
			switch(opcao) {
				case 1:
					cadastraClient(cliente);
					break;
				case 2:
					cadastraFornecedor(fornecedor);
					break;
				case 3:
					cadastraTema(tema, fornecedor);
				case 4:
					
			
				
			
			
			
			}
			
			
			
			
		}

	} 
	
	
	/**
	 * Metodo para cadastrar novos clientes na lista de clientes
	 * 
	 * @param c
	 */
	public static void cadastraClient(ArrayList <Cliente> c) {
		
		Scanner ler = new Scanner(System.in);
		String n = null;
		String t = null;
		String end = null;
		String d = null;
		
		
		System.out.println("---Cadastro Cliente---");
		System.out.print("\nDigite o nome: ");
		n = ler.nextLine();
		ler.nextLine();
		
		System.out.print("\nDigite o telefone: ");
		t = ler.nextLine();
		ler.nextLine();
		
		System.out.print("\nDigite o endereco: ");
		end = ler.nextLine();
		ler.nextLine();

		System.out.print("\nDigite a data do cadastro: ");
		d = ler.nextLine();
		ler.nextLine();
		
		
		Cliente cli = new Cliente(n,t, end, d);
		c.add(cli);
		ler.close();
	}

	/**
	 * Metodo para cadastrar novos fornecedores na lista de fornecedores
	 * 
	 * @param f -> variavel do tipo Fornecedor que possui todos os fornecedores cadastrados
	 */
	public static void cadastraFornecedor(ArrayList <Fornecedor> f) {
		
		
		ArrayList<String> p = new ArrayList<String>();
		Scanner ler = new Scanner(System.in);
		String n = null;
		String t = null;
		String end = null;
		
		
		System.out.println("---Cadastro Fornecedor---");
		System.out.print("\nDigite o nome: ");
		n = ler.nextLine();
		ler.nextLine();
		
		System.out.print("\nDigite o telefone: ");
		t = ler.nextLine();
		ler.nextLine();
		
		System.out.print("\nDigite o endereco: ");
		end = ler.nextLine();
		ler.nextLine();
		
		
		while (true) {
			System.out.print("\nDeseja adicionar um produto? (S/N) ");
			t = ler.nextLine();
			ler.nextLine();
			
			if (t.equals("S")){
				System.out.print("\n Digite o nome do produto?");
				t = ler.nextLine();
				ler.nextLine();
				p.add(t);
			}else
				break;
			
		}
		
		Fornecedor fo = new Fornecedor(n,t,end,p);
		
		f.add(fo);
		ler.close();		
		
		
	}
	
	/**
	 * Metodo pra cadastrar novos temas na lista de temas
	 * 
	 * @param t -> variavel do tipo Tema que possui todos os temas cadastrados
	 * @param f -> variavel do tipo Fornecedor que possui todos os fornecedores cadastrados
	 */
	public static void cadastraTema(ArrayList <Tema> t, ArrayList<Fornecedor> f) {
		
		
		ArrayList<String> i = new ArrayList<String>();
		ArrayList<Fornecedor> forn = new ArrayList<Fornecedor>();
		String n = null;
		String cT = null;
		String aux = null;
		int p = 0;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("---Cadastro Tema---");
		System.out.print("\nDigite o nome: ");
		n = ler.nextLine();
		ler.nextLine();
		
		System.out.print("\nDigite a cor da toalha: ");
		cT = ler.nextLine();
		ler.nextLine();
		
		System.out.print("\nDigite o preco do tema: ");
		p = ler.nextInt();
		ler.nextLine();
		
		
		while (true) {
			System.out.print("\nDeseja adicionar um novo item? (S/N) ");
			aux = ler.nextLine();
			ler.nextLine();
			
			if (aux.equals("S")){
				System.out.print("\n Digite o nome do item:");
				aux = ler.nextLine();
				ler.nextLine();
				i.add(aux);
			}else
				break;
			
		}
		
		while (true) {
			System.out.print("\nDeseja adicionar um novo fornecedor? (S/N) ");
			aux = ler.nextLine();
			ler.nextLine();
			
			if (aux.equals("S")){
				forn.add(buscaFornecedor(f));
			}else
				break;
		}
		
		Tema tema = new Tema(n, i, cT, f, p);
		t.add(tema);
		ler.close();
	}
	
	/**
	 * Metodo para procurar um fornecedor entre os cadastrados 
	 * 
	 * @param f -> variavel do tipo Fornecedor que possui todos os fornecedores cadastrados
	 * @return fornecedor -> retorna o um objeto fornecedor se encontrado, caso contrario retorna null
	 */
	public static Fornecedor buscaFornecedor(ArrayList<Fornecedor> f) {
		
		Scanner ler = new Scanner(System.in);
		System.out.print("\n Digite o nome do fornecedor:");
		String nome = ler.nextLine();
		ler.nextLine();
		
		if(f.isEmpty()) {
			ler.close();
			return null;
		}
		else {
			for(Fornecedor forn: f) {
				if(forn.getNome().equals(nome)) {
					ler.close();
					return forn;
				}
			}
		}
		ler.close();
		return null;
		
	}

	/**
	 * Metodo para procurar um cliente entre os cadastrados 
	 * 
	 * @param c -> variavel do tipo Cliente que possui todos os clientes cadastrados
	 * @return cliente -> retorna o um objeto cliente se encontrado, caso contrario retorna null
	 */
	public static Cliente buscaCliente(ArrayList<Cliente> c) {
		
		Scanner ler = new Scanner(System.in);
		System.out.print("\n Digite o nome do cliente:");
		String nome = ler.nextLine();
		ler.nextLine();
		
		if(c.isEmpty()) {
			ler.close();
			return null;
		}
		else {
			for(Cliente cli : c) {
				if(cli.getNome().equals(nome)) {
					ler.close();
					return cli;
				}
			}
		}
		ler.close();
		return null;
		
	}
	
	/**
	 * Metodo para procurar um tema entre os cadastrados 
	 * 
	 * @param t -> variavel do tipo Tena que possui todos os temas cadastrados
	 * @return tema -> retorna o um objeto Tema se encontrado, caso contrario retorna null
	 */
	public static Tema buscaTema(ArrayList<Tema> t) {
		
		Scanner ler = new Scanner(System.in);
		System.out.print("\n Digite o nome do Tema:");
		String nome = ler.nextLine();
		ler.nextLine();
		
		if(t.isEmpty()) {
			ler.close();
			return null;
		}
		else {
			for(Tema tem: t) {
				if(tem.getNome().equals(nome)) {
					ler.close();
					return tem;
				}
			}
		}
		ler.close();
		return null;
		
	}
	
	/**
	 * Metodo para cadastrar uma nova locacao
	 * 
	 * @param a -> variavel do tipo Aluguel que possui todas as locacoes cadastrados
	 * @param c -> variavel do tipo Cliente que possui todos os clientes cadastrados
	 * @param t -> variavel do tipo Tema que possui todos os temas cadastrados
	 * @param tL -> variavel do tipo Tema que possui todos os TEMAS LOCADOS 
	 */
	public static void cadastraAluguel(ArrayList<Aluguel> a, ArrayList<Cliente> c, ArrayList<Tema> t, ArrayList<Tema> tL ) {

		Scanner ler = new Scanner(System.in);
		Cliente cli = buscaCliente(c);
		Tema tem;
		String aux;
		
		while(true) {//testar, acho que nao vai funcionar
			
			tem = buscaTema(t);
			
			if(tem == null) {
				System.out.println("Tema nao encontrado ou inexistente. Deseja escolher outro tema? (S/N)");
				aux = ler.nextLine();
				ler.nextLine();
				if(aux.equals("N"))
					break;
			}else {
				for(Tema temaLocado: tL) {
					if (temaLocado.equals(tem)){
						System.out.println("Tema ja alugado. Escolha outro tema");
					}
				}
				break;
			}
		}
		ler.close();
	}
	
	//Metodo para a escolha do menu
	/**
	 * Metodo que desenha o menu no terminal
	 * 
	 * @return inteiro -> retorna o valor escolhido no menu
	 */
	public static int menu() {
		
		int x = 0;
		Scanner ler = new Scanner(System.in);
		clearConsole();		
		System.out.println("---MENU---");
		System.out.println("1) Cadastrar cliente");
		System.out.println("2) Cadastrar Fornecedor");
		System.out.println("3) Cadastrar Tema");
		System.out.print("Escolha uma opcao: ");
		
		
		x = ler.nextInt();
		System.out.println("\n\n\n\n\n");

		ler.close();
		return x;
		
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}

}
