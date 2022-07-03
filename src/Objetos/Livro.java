package Objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import Janelas.JTabelaRelatorio;

public class Livro {
	
	DefaultTableModel modeloEstoque = new DefaultTableModel();
	JTabelaRelatorio janela = new JTabelaRelatorio(modeloEstoque);
	{	
		definerModelo();
	}
	
	private int id;
	private String nome;
	private String isbn;
	private String edicao;
	private String ano;
	private String autor;
	private int pag;
	private double preco;
	private int quant;
	private String data;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getPag() {
		return pag;
	}
	public void setPag(int pag) {
		this.pag = pag;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void definerModelo() {
		modeloEstoque.addColumn("NOME");
		modeloEstoque.addColumn("ISBN");
		modeloEstoque.addColumn("EDICAO");
		modeloEstoque.addColumn("ANO");
		modeloEstoque.addColumn("AUTOR");
		modeloEstoque.addColumn("PAGINAS");
		modeloEstoque.addColumn("PRECO");
		modeloEstoque.addColumn("QUANTIDADE");
	}
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "V@nessa1";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	
	/*ALTERA A CLASSE VENDA*/
	
	public void listaLivro(String valor) {
		conectar();
		try {
			String query = valor;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				setNome(this.resultset.getString("nome"));
				setIsbn(this.resultset.getString("isbn"));
				setEdicao(this.resultset.getString("edicao"));
				setAno(this.resultset.getString("ano"));
				setAutor(this.resultset.getString("autor"));
				setPag(Integer.parseInt(this.resultset.getString("pag")));
				setPreco(Double.valueOf(this.resultset.getString("preco")));
				setQuant(Integer.parseInt(this.resultset.getString("quant")));
				
				String[] linha = new String[8];
				linha[0] = getNome();
				linha[1] = getIsbn();
				linha[2] = getEdicao();
				linha[3] = getAno();
				linha[4] = getAutor();
				linha[5] = Integer.toString(getPag());
				linha[6] = Double.toString(getPreco());
				linha[7] = Integer.toString(getQuant());
				
				modeloEstoque.addRow(linha);
			}
			janela.setVisible(true);
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void cadastrarLivro(String nome,String isbn, String edicao,String ano,String autor,int pag, double preco, int quant) {
		Date dataHoraAtual = new Date();
		this.setData(new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual).toString());
		conectar();
		try {
			String query = "INSERT INTO livro VALUES ('"+nome+"','"+isbn+"','"+edicao+"','"+ano+"','"+autor+"','"+pag+"','"+preco+"','"+quant+"','"+this.data+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void atualizarLivro(String nome,String isbn, String edicao,String ano,String autor,int pag, double preco, int quant) {
		conectar();
		try {
			String query = "UPDATE livro SET nome='"+nome+"',isbn='"+isbn+"',edicao='"+edicao+"',ano='"+ano+"',autor='"+autor+"',pag='"+pag+"',preco='"+preco+"',quant='"+quant+"' WHERE isbn= ('"+isbn+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void apagarLivro(String isbn) {
		conectar();
		try {
			String query = "DELETE FROM livro WHERE isbn='"+isbn+"';";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void buscaLivro(String isbn) {
		conectar();
		try {
			String query = "SELECT * FROM livro where isbn='"+isbn+"';";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				setNome(this.resultset.getString("nome"));
				setIsbn(this.resultset.getString("isbn"));
				setEdicao(this.resultset.getString("edicao"));
				setAno(this.resultset.getString("ano"));
				setAutor(this.resultset.getString("autor"));
				setPag(Integer.parseInt(this.resultset.getString("pag")));
				setPreco(Double.valueOf(this.resultset.getString("preco")));
				setQuant(Integer.parseInt(this.resultset.getString("quant")));
			}
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
		
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
