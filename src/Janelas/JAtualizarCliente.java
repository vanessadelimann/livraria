package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Cliente;
import Objetos.Endereco;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JAtualizarCliente extends JFrame {
	
	//JANELA PARA ATUALIZAR O CADASTRO DOS CLIENTES EXISTENTES
	
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldRua;
	private JTextField textFieldNum;
	private JTextField textFieldCom;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAtualizarCliente frame = new JAtualizarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JAtualizarCliente() {
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		
		//JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ltitulo = new JLabel("Livraria Cafe Books");
		ltitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ltitulo.setBounds(38, 424, 207, 37);
		contentPane.add(ltitulo);
		
		JLabel lblNewLabel = new JLabel("Atualizar Cadastro de Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(212, 75, 254, 36);
		contentPane.add(lblNewLabel);
		
		//CADASTRO
		
		//NOME
		JLabel lNome = new JLabel("Nome:");
		lNome.setBounds(38, 142, 46, 14);
		contentPane.add(lNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(111, 139, 215, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		//CPF
		JLabel lCpf = new JLabel("CPF:");
		lCpf.setBounds(38, 173, 46, 14);
		contentPane.add(lCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(111, 170, 215, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		//TELEFONE
		JLabel lTelefone = new JLabel("Telefone:");
		lTelefone.setBounds(38, 204, 63, 14);
		contentPane.add(lTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(111, 204, 215, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		//EMAIL
		JLabel lEmail = new JLabel("E-mail:");
		lEmail.setBounds(38, 235, 46, 14);
		contentPane.add(lEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(111, 235, 215, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
				
		//RUA
		JLabel lblNewLabelRua = new JLabel("Rua:");
		lblNewLabelRua.setBounds(376, 142, 46, 14);
		contentPane.add(lblNewLabelRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(432, 139, 223, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		//NUMERO DA CASA
		JLabel lblNewLabelNum = new JLabel("Numero: ");
		lblNewLabelNum.setBounds(376, 173, 46, 14);
		contentPane.add(lblNewLabelNum);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(432, 170, 109, 20);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		//BAIRRO
		JLabel lblNewLabelBairro = new JLabel("Bairro: ");
		lblNewLabelBairro.setBounds(376, 229, 46, 14);
		contentPane.add(lblNewLabelBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(432, 226, 223, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		//CIDADE
		JLabel lblNewLabelCidade = new JLabel("Cidade:");
		lblNewLabelCidade.setBounds(376, 259, 46, 14);
		contentPane.add(lblNewLabelCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(432, 256, 223, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		//ESTADO
		JLabel lblNewLabelUf = new JLabel("UF:");
		lblNewLabelUf.setBounds(551, 173, 36, 14);
		contentPane.add(lblNewLabelUf);
		
		textFieldUf = new JTextField();
		textFieldUf.setBounds(584, 170, 71, 20);
		contentPane.add(textFieldUf);
		textFieldUf.setColumns(10);

		//COMPLEMENTO
		JLabel lblNewLabelCom = new JLabel("Complemento:");
		lblNewLabelCom.setBounds(376, 204, 79, 14);
		contentPane.add(lblNewLabelCom);
		
		textFieldCom = new JTextField();
		textFieldCom.setBounds(465, 201, 190, 20);
		contentPane.add(textFieldCom);
		textFieldCom.setColumns(10);
		
		JButton bConfirma = new JButton("Atualizar cadastro");
		bConfirma.setBounds(291, 383, 131, 23);
		contentPane.add(bConfirma);
		bConfirma.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						cliente.atualizarCliente(textFieldNome.getText(), textFieldTelefone.getText(), textFieldEmail.getText(), textFieldCpf.getText());
						endereco.atualizarEndereco(textFieldRua.getText(),textFieldNum.getText(),textFieldBairro.getText(),textFieldUf.getText(),textFieldCidade.getText(),textFieldCom.getText(),textFieldCpf.getText());
						
						JFrame frame = new JFrame("Alerta");
					    JOptionPane.showMessageDialog(frame, "Cliente cadastrado com sucesso!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
					}  
				}  
			);
		
		//VOLTAR AO INICIO
		JButton bHome = new JButton("Tela Inicial");
		bHome.setBounds(512, 25, 131, 23);
		contentPane.add(bHome);
		bHome.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JtelaInicial home = new JtelaInicial();
						home.setVisible(true);
						dispose();
					}  
				}  
			);
	}
}