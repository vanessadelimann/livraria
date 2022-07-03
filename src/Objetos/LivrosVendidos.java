package Objetos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Janelas.JTabelaRelatorio;

public class LivrosVendidos {
	public DefaultTableModel modeloLivrosVendidos;
	
	private String isbn;
	private int codVenda;
	private int id;
	
	public void incluirLivros(@SuppressWarnings("rawtypes") ArrayList lista, int codVenda) {
		for(int i=0;i<lista.size();i++) {
			String valor = (String) lista.get(i);
			cadastrarVenda(codVenda, valor);
		}
	}
	
	public void definirModelo() {
		modeloLivrosVendidos.addColumn("ID");
		modeloLivrosVendidos.addColumn("CODIGO DA VENDA");
		modeloLivrosVendidos.addColumn("ISBN");
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
	public void livrosVendidos(int codVenda) {
		conectar();
		try {
			String query = "SELECT * FROM livrosVendidos Where codVenda='"+codVenda+"';";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				this.setCodVenda(this.resultset.getInt("FK_codVenda"));
				this.setId(this.resultset.getInt("id"));
				this.setIsbn(this.resultset.getString("FK_isbn"));
				
				String[] linha = new String[3];
				linha[0] = Integer.toString(getId());
				linha[1] = Integer.toString(getCodVenda());
				linha[2] = getIsbn();
				
				modeloLivrosVendidos.addRow(linha);
			}
			JTabelaRelatorio janela = new JTabelaRelatorio(modeloLivrosVendidos);
			janela.setVisible(true);
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();		
	}
	
	public void livrosVendidos() {
		conectar();
		try {
			String query = "SELECT * FROM livrosVendidos;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				this.setCodVenda(this.resultset.getInt("FK_codVenda"));
				this.setId(this.resultset.getInt("id"));
				this.setIsbn(this.resultset.getString("FK_isbn"));
				
				String[] linha = new String[3];
				linha[0] = Integer.toString(getId());
				linha[1] = Integer.toString(getCodVenda());
				linha[2] = getIsbn();
				
				modeloLivrosVendidos.addRow(linha);
			}
			JTabelaRelatorio janela = new JTabelaRelatorio(modeloLivrosVendidos);
			janela.setVisible(true);
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();		
	}
	
	
	public void cadastrarVenda(int codVenda, String isbn) {
		conectar();
		try {
			String query = "INSERT INTO livrosVendidos (FK_codVenda, FK_isbn) VALUES ('"+codVenda+"','"+isbn+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
				
				  
		}
		desconectar();
		
	}
	
	public void atualizarVenda(int codVenda, String isbn) {
		conectar();
		try {
			String query = "UPDATE livrosVendidos SET statusVenda='"+isbn+"' WHERE codVenda = ('"+codVenda+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void apagarVenda(int codVenda) {
		conectar();
		try {
			String query = "DELETE FROM livrosVendidos WHERE codVenda='"+codVenda+"';";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

