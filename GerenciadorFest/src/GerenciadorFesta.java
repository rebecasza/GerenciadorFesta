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
		ArrayList<TemaLocado> temasLocados = new  ArrayList<TemaLocado>();
		int opcao = 0;

		//inicializa o programa com algumas variaveis principaise
		inicializaTestes(cliente, fornecedor, aluguel, tema, temasLocados);

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
				break;
			case 4:
				cadastraAluguel(aluguel, cliente, tema, temasLocados);
				break;
			case 5:
				finalizaAluguel(aluguel, temasLocados);
				break;
			case 6:
				imprimeTodosClientes(cliente);
				break;
			case 7:
				imprimeTodosFornecedores(fornecedor);
				break;
			case 8:
				imprimeTodosTemas(tema);
				break;
			case 9:
				imprimeTodosAlugueis(aluguel);
				break;
			case 10:
				imprimeTodosTemasLocados(temasLocados);
				break;
			case 11:
				editarCliente(cliente);
				break;
			case 12:
				editarTema(tema);
				break;
			case 13:
				editarFornecedor(fornecedor);
				break;
			case 14:
				removerCliente(cliente);
				break;
			case 15:
				removerTema(tema);
				break;
			case 16:
				removerFornecedor(fornecedor);
				break;
			
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

		System.out.println("\n\n\n---Cadastro Cliente---");
		System.out.println("\nDigite o nome: ");
		n = ler.nextLine();

		System.out.print("\nDigite o telefone: ");
		t = ler.nextLine();

		System.out.print("\nDigite o endereco: ");
		end = ler.nextLine();

		System.out.print("\nDigite a data do cadastro: ");
		d = ler.nextLine();

		Cliente cli = new Cliente(n,t, end, d);
		c.add(cli);
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

		System.out.print("\nDigite o telefone: ");
		t = ler.nextLine();

		System.out.print("\nDigite o endereco: ");
		end = ler.nextLine();

		while (true) {
			System.out.print("\nDeseja adicionar um produto? (s/n) ");
			t = ler.nextLine();

			if (t.equals("s") || t.equals("S")){
				System.out.print("\n Digite o nome do produto?");
				t = ler.nextLine();
				p.add(t);
				System.out.print("Produto adicionado com sucesso!");

			}else if (t.equals("n") || t.equals("N"))
				break;
		}

		Fornecedor fo = new Fornecedor(n,t,end,p);
		f.add(fo);
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
		Fornecedor fTemp;
		String n = null;
		String cT = null;
		String aux = null;
		int p = 0;

		Scanner ler = new Scanner(System.in);

		System.out.println("---Cadastro Tema---");
		
		System.out.print("\nDigite o nome: ");
		n = ler.nextLine();

		System.out.print("\nDigite a cor da toalha: ");
		cT = ler.nextLine();

		System.out.print("\nDigite o preco do tema: ");
		p = ler.nextInt();

		while (true) {
			System.out.print("\nDeseja adicionar um novo fornecedor? (s/n)");
			aux = ler.nextLine();

			if (aux.equals("s") || aux.equals("S")){
				fTemp = buscaFornecedor(f);
				if(fTemp != null) {
					forn.add(fTemp);
					System.out.println("Fornecedor adicionado com sucesso!");
				}
			}else if(aux.equals("n") || aux.equals("N"))
				break;
		}
				
		for(Fornecedor temp: forn) {
			i.addAll(temp.getProduto());
		}

		Tema tema = new Tema(n, i, cT, forn, p);
		t.add(tema);
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

		if(f.isEmpty()) {
			return null;
		}
		else {
			for(Fornecedor forn: f) {
				if(forn.getNome().equals(nome)) {
					return forn;
				}
			}
		}
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

		if(c.isEmpty()) {
			return null;
		}
		else {
			for(Cliente cli : c) {
				if(cli.getNome().equals(nome)) {
					return cli;
				}
			}
		}
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
		//ler.nextLine();

		if(t.isEmpty()) {
//			System.out.println("Nao existem temas cadastrados!");
			return null;
		}
		else {
			for(Tema tem: t) {
				if(tem.getNome().equals(nome)) {
					return tem;
				}
			}
		}
//		System.out.println("Tema nao encontrado!");
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
	public static void cadastraAluguel(ArrayList<Aluguel> a, ArrayList<Cliente> c, ArrayList<Tema> t, ArrayList<TemaLocado> tL ) {

		Scanner ler = new Scanner(System.in);
		Cliente cli;
		Tema tem;
		String d;
		String hI;
		String hF;
		String e;
		double pF;
		int qP;
		boolean flagLocacao = false;
		
		System.out.println("---Cadastro de Aluguel---");
		
		do {//busca o cliente que quer aludar
			cli = buscaCliente(c);
			if(cli == null)
				System.out.println("Cliente nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(cli == null);
		
		do {//busca um tema para alugar
			tem = buscaTema(t);
			if(tem == null)
				System.out.println("Tema nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(tem == null);

		flagLocacao = true;
		do {//continua ate a flagLocacao ser true, ou seja, o tema nao esta locado naquela data

			System.out.print("\nDigite a data: (ex: dd/mm)");
			d = ler.nextLine();

			for (TemaLocado temp : tL) {
				if(temp.getData().equals(d) && temp.getTema().equals(tem)) {
					System.out.print("Este tema ja esta reservado para esta data! Escolha outra data.");
					break;
				}else
					flagLocacao = false;

			}
		}while(flagLocacao);	
		
		System.out.print("\nDigite hora inicial da festa: (ex: 9am)");
		hI = ler.nextLine();
		
		System.out.print("\nDigite hora final da festa: (ex: 6pm)");
		hF = ler.nextLine();
		
		System.out.print("\nDigite o endereco da festa: ");
		e = ler.nextLine();
		
		System.out.print("\nDigite a quantidade de pessoas: ");
		qP = Integer.parseInt(ler.nextLine());
		
		
		
		//da os descontos de acordo com a quantidade de pessoas
		if(qP > 50 && qP <= 100) {
			pF = (double)tem.getPreco()*0.95;
		}else if(qP > 100  && qP<= 200) {
			pF = (double)tem.getPreco()*0.90;
		}else if (qP > 200) {
			pF = (double)tem.getPreco()*0.85;
		}else
			pF = (double)tem.getPreco();
		
		//da desconto de acordo com a data do mes
		if(Integer.parseInt(d.substring(0, 2))>15)
			pF = pF*95;


		Aluguel al = new Aluguel(cli,tem,pF,d,hI,hF,e,qP,false);
	}
	
	public static void finalizaAluguel(ArrayList<Aluguel> a, ArrayList<TemaLocado> tL) {
		Aluguel alu = null;
		TemaLocado tempTemaLocado = null;
		boolean flagAchado = false;
		Scanner ler = new Scanner(System.in);

		
		do {//busca o cliente quer finalizar a locacao
			System.out.print("\n Digite o nome do cliente que quer finalizar a locacao: ");
			String nome = ler.nextLine();
			
			for(Aluguel al:a) {
				if(al.getCliente().getNome().equals(nome)) {
					alu = al;
					flagAchado = true;
				}
			}
			if(!flagAchado)
				System.out.println("Cliente nao encontrado! Tente novamente.\n\n");
		}while(!flagAchado);
		System.out.println("Cliente encontrado!");
		
		
		
		if(alu != null)
			alu.setLocacaoFinalizada(true);
		
		for(TemaLocado temaLocado: tL) {
			if (temaLocado.getTema().equals(alu.getTema()) && temaLocado.getData().equals(alu.getData())) {
				tempTemaLocado = tL.get((tL.lastIndexOf(temaLocado)));
			}
		}
		
		if(tempTemaLocado!=null)
			tL.remove(tempTemaLocado);
		
		System.out.println("\n\nAluguel finalizado com sucesso!\n");
		
	}
	
	public static void imprimeUmCliente(Cliente cli) {
		
		System.out.println("\n\n----Informacoes do cliente----");
		System.out.println("Nome: "+cli.getNome());
		System.out.println("Telefone: "+cli.getTelefone());
		System.out.println("Endereco: "+cli.getEndereco());
		System.out.println("Cliente desde: "+cli.getDataCadastro());
		System.out.println("\n");
		
	}
	
	public static void imprimeTodosClientes(ArrayList<Cliente> c) {
		
		if(c.isEmpty()) {
			System.out.println("\nSem clientes cadastrados.");
			return;
		}
		for(Cliente cli: c)
			imprimeUmCliente(cli);
	}

	public static void imprimeUmFornecedor(Fornecedor forn) {
		
		System.out.println("\n\n----Informacoes do fornecedor----");
		System.out.println("Nome: "+forn.getNome());
		System.out.println("Telefone: "+forn.getTelefone());
		System.out.println("Endereco: "+forn.getEndereco());
		
		for(String s : forn.getProduto())
			System.out.println("Produto:" +s);
	}
	
	public static void imprimeTodosFornecedores(ArrayList<Fornecedor> f) {
		
		if(f.isEmpty()) {
			System.out.println("\nSem fornecedores cadastrados.");
			return;
		}
		for(Fornecedor forn: f)
			imprimeUmFornecedor(forn);
	}
	
	public static void imprimeUmTema(Tema t) {
		
		System.out.println("\n\n----Informacoes do Tema----\n");
		System.out.println("Nome: "+t.getNome());
		System.out.println("Cor da toalha: "+t.getCorToalha());
		
		for(Fornecedor f : t.getFornecedor())
			System.out.println("Fornecedor: " + f.getNome());

		for(String s : t.getItens())
			System.out.println("Item: " + s);

		System.out.println("Preco sem desconto: "+t.getPreco());
		System.out.println("\n");
		
	}
	
	public static void imprimeTodosTemas(ArrayList<Tema> t) {
		
		if(t.isEmpty()) {
			System.out.println("\nSem temas cadastrados.");
			return;
		}
		for(Tema tema: t)
			imprimeUmTema(tema);
	}
	
	public static void imprimeUmAluguel(Aluguel a) {
		
		System.out.println("\n\n----Informacoes do Aluguel----\n");
		System.out.println("Cliente: "+a.getCliente().getNome());
		System.out.println("Tema da festa: "+a.getTema().getNome());
		System.out.println("Endereco: "+a.getEndereco());
		System.out.println("Data da festa: "+a.getData());
		System.out.println("Inicio da festa: "+a.getHoraInicio());
		System.out.println("Fim da festa: "+a.getHoraFim());
		System.out.println("Numero de pessoas: "+a.getQtdPessoas());
		System.out.println("Preco final: "+a.getPrecoFinal());
		System.out.println("Locacao finalizada? "+a.isLocacaoFinalizada());


		System.out.println("\n");
		
	}
	
	public static void imprimeTodosAlugueis(ArrayList<Aluguel> a) {
		
		if(a.isEmpty()) {
			System.out.println("\nSem alugueis cadastrados.");
			return;
		}
		for(Aluguel al: a)
			imprimeUmAluguel(al);
		
	}
	
	public static void imprimeUmTemaLocado(TemaLocado tl) {
		System.out.println("\n\n----Informacoes sobre temas locados----\n");
		System.out.println("Nome do tema: " + tl.getTema().getNome());
		System.out.println("Data da Locacao: "+ tl.getData());
		System.out.println("\n");

	}
	
	public static void imprimeTodosTemasLocados(ArrayList<TemaLocado> tl) {
		
		if(tl.isEmpty()) {
			System.out.println("\nSem temas locados.");
			return;
		}
		for (TemaLocado temp:tl)
			imprimeUmTemaLocado(temp);

	}
	
	public static void editarCliente(ArrayList<Cliente> c) {
		
		Cliente cli;
		String aux = null;
		Scanner ler = new Scanner(System.in);

		System.out.println("\n\n----Editar Cliente---");


		do {//busca o cliente que se quer editar
			cli = buscaCliente(c);
			if(cli == null)
				System.out.println("Cliente nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(cli == null);
		
		aux = null;
		System.out.print("\nDeseja editar o nome? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo nome: ");
			cli.setNome(ler.nextLine());
			System.out.println("Nome editado com sucesso!");
		}
			
		aux = null;
		System.out.print("\nDeseja editar o telefone? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo telefone: ");
			cli.setTelefone(ler.nextLine());
			System.out.println("Telefone editado com sucesso!");
		}
		
		aux = null;
		System.out.print("\nDeseja editar o endereco? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo endereco: ");
			cli.setEndereco(ler.nextLine());
			System.out.println("Endereco editado com sucesso!");
		}
		
		System.out.println("Edicoes realizadas com sucesso!");

	}
	
	public static void editarFornecedor(ArrayList<Fornecedor> f) {
		
		Fornecedor forn;
		String aux = null;
		Scanner ler = new Scanner(System.in);

		System.out.println("\n\n----Editar Fornecedor---");


		do {//busca o fornecedor que se quer editar
			forn = buscaFornecedor(f);
			if(forn == null)
				System.out.println("Fornecedor nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(forn == null);
		
		aux = null;
		System.out.print("\nDeseja editar o nome? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo nome: ");
			forn.setNome(ler.nextLine());
			System.out.println("Nome editado com sucesso!");
		}
			
		aux = null;
		System.out.print("\nDeseja editar o telefone? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo telefone: ");
			forn.setTelefone(ler.nextLine());
			System.out.println("Telefone editado com sucesso!");
		}
		
		aux = null;
		System.out.print("\nDeseja editar o endereco? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo endereco: ");
			forn.setEndereco(ler.nextLine());
			System.out.println("Endereco editado com sucesso!");
		}
		
		//TODO: adicionar ou remover produtos do fornecedor
		
		System.out.println("Edicoes realizadas com sucesso!");
	}
	
	public static void editarTema(ArrayList<Tema> t) {
		
		Tema tem;
		String aux = null;
		Scanner ler = new Scanner(System.in);
		Fornecedor fTemp;

		System.out.println("\n\n----Editar Tema---");


		do {//busca o tema que se quer editar
			tem = buscaTema(t);
			if(tem == null)
				System.out.println("Tema nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(tem == null);
		
		aux = null;
		System.out.print("\nDeseja editar o nome? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo nome: ");
			tem.setNome(ler.nextLine());
			System.out.println("Nome editado com sucesso!");
		}
			
		aux = null;
		System.out.print("\nDeseja editar a cor da tolha? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite a nova cor da tolha: ");
			tem.setCorToalha(ler.nextLine());
			System.out.println("Cor da tolha editada com sucesso!");
		}
		
		aux = null;
		System.out.print("\nDeseja editar o preco? (s)");
		aux = ler.nextLine();

		if (aux.equals("s") || aux.equals("S")){
			System.out.println("\nDigite o novo preco: ");
			tem.setPreco(ler.nextInt());
			System.out.println("Preco editado com sucesso!");
		}
		

//
//		while (true) {
//			System.out.print("\nDeseja adicionar um novo fornecedor? (s/n)");
//			aux = ler.nextLine();
//
//			if (aux.equals("s") || aux.equals("S")){
//				fTemp = buscaFornecedor(f);
//				if(fTemp != null) {
//					forn.add(fTemp);
//					System.out.println("Fornecedor adicionado com sucesso!");
//				}
//			}else if(aux.equals("n") || aux.equals("N"))
//				break;
//		}
//		
//		ArrayList<String> i = new ArrayList<String>();
//		ArrayList<Fornecedor> forn = new ArrayList<Fornecedor>();
//		String n = null;
//		String cT = null;
//		String aux = null;
//		int p = 0;
//
//		Scanner ler = new Scanner(System.in);
//
//		System.out.println("---Cadastro Tema---");
//		
//		System.out.print("\nDigite o nome: ");
//		n = ler.nextLine();
//
//		System.out.print("\nDigite a cor da toalha: ");
//		cT = ler.nextLine();
//
//		System.out.print("\nDigite o preco do tema: ");
//		p = ler.nextInt();
//
//		while (true) {
//			System.out.print("\nDeseja adicionar um novo fornecedor? (s/n)");
//			aux = ler.nextLine();
//
//			if (aux.equals("s") || aux.equals("S")){
//				fTemp = buscaFornecedor(f);
//				if(fTemp != null) {
//					forn.add(fTemp);
//					System.out.println("Fornecedor adicionado com sucesso!");
//				}
//			}else if(aux.equals("n") || aux.equals("N"))
//				break;
//		}
//				
//		for(Fornecedor temp: forn) {
//			i.addAll(temp.getProduto());
//		}
//
//		Tema tema = new Tema(n, i, cT, forn, p);
//		t.add(tema);		
		System.out.println("Edicoes realizadas com sucesso!");
	}
	
	public static void removerCliente(ArrayList<Cliente> c) {
		Cliente cli;
		
		do {//busca o cliente que se quer remover
			cli = buscaCliente(c);
			if(cli == null)
				System.out.println("Cliente nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(cli == null);
		
		c.remove(cli);
	}
	
	public static void removerFornecedor(ArrayList<Fornecedor> f) {
		Fornecedor forn;
		
		do {
			forn = buscaFornecedor(f);
			if(forn == null)
				System.out.println("Fornecedor nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(forn == null);
		
		f.remove(forn);
	}
	
	public static void removerTema(ArrayList<Tema> t) {
		Tema tem;
		
		do {//busca o tema que se quer remover
			tem = buscaTema(t);
			if(tem == null)
				System.out.println("Tema nao encontrado ou inexistente! Tente novamente.\n\n");
		}while(tem == null);
		
		t.remove(tem);
	}
	
	/**
	 * Metodo que desenha o menu no console
	 * 
	 * @return inteiro -> retorna o valor escolhido no menu
	 */
	public static int menu() {

		int x = 0;
		Scanner ler = new Scanner(System.in);
		System.out.println("\n\n---MENU---\n");
		System.out.println("1) Cadastrar Cliente");
		System.out.println("2) Cadastrar Fornecedor");
		System.out.println("3) Cadastrar Temas");
		System.out.println("4) Cadastrar uma locacao");
		System.out.println("5) Finalizar uma locacao");
		System.out.println("6) Listar todos os clientes");
		System.out.println("7) Listar todos os fornecedores");
		System.out.println("8) Listar todos os temas");
		System.out.println("9) Listar todas as locacoes");
		System.out.println("10) Listar temas locados e suas datas de uso");
		System.out.println("11) Editar cliente");
		System.out.println("12) Editar tema");
		System.out.println("13) Editar fornecedor");
		System.out.println("14) Remover cliente");
		System.out.println("15) Remover tema");
		System.out.println("16) Remover fornecedor");




		
		
		System.out.print("Escolha uma opcao: ");


		x = ler.nextInt();
		System.out.println("\n\n\n\n");

		return x;

	}
	
	
	public static void inicializaTestes(ArrayList<Cliente> c, ArrayList<Fornecedor> f, ArrayList<Aluguel> a, ArrayList<Tema> t, ArrayList<TemaLocado> tL) {
		
		

		//add clientes teste
		Cliente cli1 = new Cliente("Rebeca Souza","11971712345", "Rua Paraiso, 301", "12-10-2018");
		c.add(cli1);
		Cliente cli2 = new Cliente("Hugo Harada","2199756789", "Avenida da Conquista 3451", "15-06-2018");
		c.add(cli2);
		Cliente cli3 = new Cliente("Rodolfo Santini","119767456", "Avenida dos Estados 55", "30-11-2018");
		c.add(cli3);
		Cliente cli4 = new Cliente("Joao Felipe dos Santos","1155674356", "Rua da Alagoa 33", "04-03-2018");
		c.add(cli4);
		Cliente cli5 = new Cliente("Mario Pereira","1278906788", "Avenida Ajarani 204", "26-01-2018");
		c.add(cli5);
		Cliente cli6 = new Cliente("Flavio Freitas","4567890234", "Rua Waldemar 432", "28-04-2018");
		c.add(cli6);
		Cliente cli7 = new Cliente("Ana Paula dos Santos","1176853446", "Rua dos Perdizes, 102", "08-07-2018");
		c.add(cli7);
		
		//add fornecedores teste
		ArrayList<String> p1 = new ArrayList<String>();
		p1.add("Lenco");
		p1.add("Papel");
		p1.add("Copo");
		ArrayList<String> p2 = new ArrayList<String>();
		p2.add("Prato");
		p2.add("Talher");
		p2.add("Louca");
		ArrayList<String> p3 = new ArrayList<String>();
		p3.add("Potes");
		p3.add("Lembracas");
		p3.add("Embalagens");
		
		Fornecedor forn1 = new Fornecedor("Doces e cia", "1176612345","Rua Fernandes, 402",p1);
		f.add(forn1);
		Fornecedor forn2 = new Fornecedor("Emabalagens e cia", "1176554433","Avenida Mariana, 5567",p2);
		f.add(forn2);
		Fornecedor forn3 = new Fornecedor("Descartaveis e cia", "11765543878","Rua das Pedras, 897",p3);
		f.add(forn3);
		
		//add temas teste
		
		ArrayList<String> ps1 = new ArrayList<String>() ;
		ps1.addAll(forn1.getProduto());
		ps1.addAll(forn2.getProduto());
		
		ArrayList<Fornecedor> f1 = new ArrayList<Fornecedor>();
		f1.add(forn1);
		f1.add(forn2);
		
		ArrayList<String> ps2 = new ArrayList<String>() ;
		ps2.addAll(forn3.getProduto());
		ps2.addAll(forn2.getProduto());
		
		ArrayList<Fornecedor> f2 = new ArrayList<Fornecedor>();
		f2.add(forn3);
		f2.add(forn2);		
		
		Tema tema1 = new Tema("Festa colorida", ps1,"Branco", f1, 100);
		t.add(tema1);
		Tema tema2 = new Tema("Festa sem cor", ps2,"Cinza", f2, 200);
		t.add(tema2);
		Tema tema3 = new Tema("Festa Princesa", ps2,"Rosa", f2, 300);
		t.add(tema3);
		Tema tema4 = new Tema("Festa Bruxa", ps2,"Roxa", f2, 400);
		t.add(tema4);
		Tema tema5 = new Tema("Festa Carro", ps2,"Vermelho", f2, 500);
		t.add(tema4);
		Tema tema6 = new Tema("Festa Heroi", ps2,"Verde", f2, 600);
		t.add(tema6);
		
		//add aluguel teste
		Aluguel a1 = new Aluguel(cli1,tema1,tema1.getPreco()*0.8,"29/12","9am","18pm","Avenida Paulista",80,false);
		a.add(a1);
		Aluguel a2 = new Aluguel(cli3,tema2,tema2.getPreco()*0.8,"04/12","9am","18pm","Avenida Reboucas",80,false);
		a.add(a2);
		Aluguel a3 = new Aluguel(cli3,tema3,tema3.getPreco()*0.8,"15/12","9am","18pm","Avenida Reboucas",80,false);
		a.add(a3);
		Aluguel a4 = new Aluguel(cli3,tema4,tema4.getPreco()*0.8,"13/12","9am","18pm","Avenida Paulista",80,false);
		a.add(a4);
		Aluguel a5 = new Aluguel(cli3,tema5,tema5.getPreco()*0.8,"05/12","9am","18pm","Avenida Paulista",80,false);
		a.add(a5);
		Aluguel a6 = new Aluguel(cli3,tema6,tema6.getPreco()*0.8,"20/12","9am","18pm","Avenida Reboucas",80,false);
		a.add(a6);
		
		//add Temas locados
		TemaLocado tLoc1 = new TemaLocado(tema1,"29/12");
		TemaLocado tLoc2 = new TemaLocado(tema2,"04/12");
		TemaLocado tLoc3 = new TemaLocado(tema3,"15/12");
		TemaLocado tLoc4 = new TemaLocado(tema4,"13/12");
		TemaLocado tLoc5 = new TemaLocado(tema5,"05/12");
		TemaLocado tLoc6 = new TemaLocado(tema6,"20/12");

		tL.add(tLoc1);
		tL.add(tLoc2);
		tL.add(tLoc3);
		tL.add(tLoc4);
		tL.add(tLoc5);
		tL.add(tLoc6);
		
		
		
		
	}

}
