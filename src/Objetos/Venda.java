package Objetos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import Janelas.JTabelaRelatorio;

public class Venda {
	
	private int codVenda;
	private String cpf;
	private String nomeCliente;
	private double valor_total;
	private String pagamento;
	private String data;
	private String statusVenda;
	private String itens;
	
	DefaultTableModel modeloVenda = new DefaultTableModel();
	JTabelaRelatorio janela = new JTabelaRelatorio(modeloVenda);
	{	
		definirModelo();
	}
	public String getStatusVenda() {
		return statusVenda;
	}
	public void setStatusVenda(String statusVenda) {
		this.statusVenda = statusVenda;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	
	public void setPagamento(String pagamento) {
		this.pagamento=pagamento;
	}

	public String getPagamento() {
		return pagamento;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public int getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}
	public String getItens() {
		return itens;
	}
	public void setItens(String itens) {
		this.itens = itens;
	}
	
	
	public void definirModelo() {
		modeloVenda.addColumn("COD DA VENDA");
		modeloVenda.addColumn("CPF");
		modeloVenda.addColumn("VALOR TOTAL");
		modeloVenda.addColumn("STATUS DA VENDA");
		modeloVenda.addColumn("DATA DA VENDA");
		modeloVenda.addColumn("PAGAMENTO");
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
	public void listaTVenda() {
		conectar();
		try {
			String query = "SELECT * FROM venda;";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				
				this.setCodVenda(this.resultset.getInt("codVenda"));
				this.setCpf(this.resultset.getString("FK_cpf"));
				this.setPagamento(this.resultset.getString("pagamento"));
				this.setValor_total(this.resultset.getDouble("valor_total"));
				this.setData(this.resultset.getString("data_registro"));
				this.setStatusVenda(this.resultset.getString("statusVenda"));
				
				String[] linha = new String[6];
				linha[0] = Integer.toString(getCodVenda());
				linha[1] = getCpf();
				linha[2] = Double.toString(getValor_total());
				linha[3] = getStatusVenda();
				linha[4] = getData();
				linha[5] = getPagamento();
				
				modeloVenda.addRow(linha);
			}
			
			janela.setVisible(true);
			
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();	
	}
	
	public void listaVenda(String valor) {
		conectar();
		try {
			
			String query = valor;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				
				this.setCodVenda(this.resultset.getInt("codVenda"));
				this.setCpf(this.resultset.getString("FK_cpf"));
				this.setPagamento(this.resultset.getString("pagamento"));
				this.setValor_total(this.resultset.getDouble("valor_total"));
				this.setData(this.resultset.getString("data_registro"));
				this.setStatusVenda(this.resultset.getString("statusVenda"));
				
				String[] linha = new String[6];
				linha[0] = Integer.toString(getCodVenda());
				linha[1] = getCpf();
				linha[2] = Double.toString(getValor_total());
				linha[3] = getStatusVenda();
				linha[4] = getData();
				linha[5] = getPagamento();
				
				modeloVenda.addRow(linha);
				
			}
			janela.setVisible(true);
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		
		desconectar();
	}
	
	
	public void cadastrarVenda(double valor_total, String pagamento, String cpf, String aprovada, String data) {
		conectar();
		try {
			String query = "INSERT INTO venda (valor_total, pagamento, FK_cpf, statusVenda, data_registro) VALUES ('"+valor_total+"','"+pagamento+"','"+cpf+"','"+aprovada+"','"+data+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
		
	}
	
	public void atualizarVenda(int codVenda, String cancelada) {
		conectar();
		try {
			String query = "UPDATE venda SET statusVenda='"+cancelada+"' WHERE codVenda = ('"+codVenda+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void apagarVenda(int codVenda) {
		conectar();
		try {
			String query = "DELETE FROM venda WHERE codVenda='"+codVenda+"';";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void listaUltimaVenda() {
		conectar();
		try {
			String query = "select * from venda where codVenda = (SELECT MAX(codVenda) FROM venda);";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				this.setCodVenda(this.resultset.getInt("codVenda"));				
			}
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
}
