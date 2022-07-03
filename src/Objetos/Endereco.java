package Objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Endereco {
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void listaEndereco(String cpf) {
		conectar();
		try {
			String query = "SELECT * FROM endereco WHERE FK_cpf='"+cpf+"'";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				setRua(this.resultset.getString("rua"));
				setNumero(this.resultset.getString("numero"));
				setBairro(this.resultset.getString("bairro"));
				setCidade(this.resultset.getString("cidade"));
				setEstado(this.resultset.getString("uf"));
				setComplemento(this.resultset.getString("complemento"));
			}
		}catch(Exception e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	public void cadastrarEndereco(String rua, String numero, String bairro, String cidade, String uf, String complemento, String cpf) {
		conectar();
		try {
			String query = "INSERT INTO endereco VALUES (0,'"+rua+"','"+numero+"','"+bairro+"','"+complemento+"','"+uf+"','"+cidade+"','"+cpf+"');";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void atualizarEndereco(String rua, String numero, String bairro,  String uf, String cidade, String complemento, String cpf) {
		conectar();
		try {
			String query = "UPDATE endereco SET rua='"+rua+"',numero='"+numero+"',bairro='"+bairro+"',uf='"+uf+"',cidade='"+cidade+"',complemento='"+complemento+"' WHERE FK_cpf='"+cpf+"';";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Erro: "+ e.getMessage());
		}
		desconectar();
	}
	
	public void apagarEndereco(String cpf) {
		conectar();
		try {
			String query = "DELETE FROM endereco WHERE FK_cpf='"+cpf+"';";
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

}
