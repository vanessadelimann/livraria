package Objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import Janelas.JTabelaRelatorio;

public class Cliente {
	DefaultTableModel modeloCliente = new DefaultTableModel();
	JTabelaRelatorio janela = new JTabelaRelatorio(modeloCliente);
	{	
		defineModelo();
	}
	
	private String id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String data;
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getId() {
		return id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void defineModelo() {
		modeloCliente.addColumn("ID");
		modeloCliente.addColumn("NOME");
		modeloCliente.addColumn("CPF");
		modeloCliente.addColumn("TELEFONE");
		modeloCliente.addColumn("EMAIL");
		modeloCliente.addColumn("RUA");
		modeloCliente.addColumn("NUMERO");
		modeloCliente.addColumn("BAIRRO");
		modeloCliente.addColumn("CIDADE");
		modeloCliente.addColumn("UF");
		modeloCliente.addColumn("COMPLEMENTO");
		
	}
	

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
	
	public void listaTClientes(String valor) {
		conectar();
		try {
			String query = valor;
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				setNome(this.resultset.getString("nome"));
				setCpf(this.resultset.getString("cpf"));
				setTelefone(this.resultset.getString("telefone"));
				setEmail(this.resultset.getString("email"));
				
				Endereco endereco = new Endereco();
				endereco.listaEndereco(getCpf());
				
				String[] linha = new String[11];
				linha[0] = getId();
				linha[1] = getNome();
				linha[2] = getCpf();
				linha[3] = getTelefone();
				linha[4] = getEmail();
				linha[5] = endereco.getRua();
				linha[6] = endereco.getNumero();
				linha[7] = endereco.getBairro();
				linha[8] = endereco.getCidade();
				linha[9] = endereco.getCidade();
				linha[10] = endereco.getComplemento();
				
				modeloCliente.addRow(linha);
			}
			janela.setVisible(true);
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}	
	
	public void cadastrarCliente(String nome, String cpf, String telefone, String email,String rua, String numero, String bairro, String cidade, String uf, String complemento) {
		Endereco endereco = new Endereco();
		Date dataHoraAtual = new Date();
		this.setData(new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual).toString());
		conectar();
		try {
			String query = "INSERT INTO cliente VALUES ('"+nome+"','"+cpf+"','"+telefone+"','"+email+"','"+this.data+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		endereco.cadastrarEndereco(rua, numero, bairro, cidade, uf, complemento, cpf);
		desconectar();
	}
	
	public void atualizarCliente(String nome, String telefone, String email, String cpf) {
		conectar();
		try {
			String query = "UPDATE cliente SET nome='"+nome+"',telefone='"+telefone+"',email='"+email+"' WHERE cpf='"+cpf+"';";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void apagarCliente(String cpf) {
		conectar();
		try {
			String query = "DELETE FROM cliente WHERE cpf='"+cpf+"';";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
