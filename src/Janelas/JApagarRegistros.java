package Janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Cliente;
import Objetos.Livro;
import Objetos.Venda;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JApagarRegistros extends JFrame {
	
	//JANELA PARA REDEFINIR O PROGRAMA
	
	private JPanel contentPane;
	private JTextField textFieldCpf;
	private JTextField textFieldLivro;
	private JTextField textFieldVendas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JApagarRegistros frame = new JApagarRegistros();
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
	public JApagarRegistros() {
		Cliente cliente = new Cliente();
		Venda venda = new Venda();
		Livro livro = new Livro();
		
		
		//JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ltitulo = new JLabel("Livraria Cafe Books");
		ltitulo.setBounds(38, 424, 207, 37);
		ltitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(ltitulo);
		
		JLabel lblNewLabel_4 = new JLabel("Apagar dados dos relatorios");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(234, 40, 256, 37);
		contentPane.add(lblNewLabel_4);

		//OPÇÃO DE APAGAR DADOS DOS CLIENTES
		JPanel panel = new JPanel();
		panel.setBounds(22, 119, 196, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setBounds(60, 55, 65, 14);
		panel.add(lblNewLabel);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(69, 100, 86, 20);
		panel.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF: ");
		lblNewLabel_1.setBounds(25, 103, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton bExcluirCliente = new JButton("Apagar");
		bExcluirCliente.setBounds(49, 160, 89, 23);
		panel.add(bExcluirCliente);
		bExcluirCliente.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JFrame frame = new JFrame("Alerta");
						String message = "Deseja continuar?";
						String title = "Confirmação";
						int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
						  if (reply == JOptionPane.YES_OPTION){
							  cliente.apagarCliente(textFieldCpf.getText());
							  JOptionPane.showMessageDialog(frame, "Registro apagado!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
						  }	
					}  
				}  
		);
		
		//OPÇÃO DE APAGAR DADOS DOS LIVROS
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(241, 119, 196, 222);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLivros = new JLabel("Livros");
		lblLivros.setBounds(76, 56, 65, 14);
		panel_1.add(lblLivros);
		
		textFieldLivro = new JTextField();
		textFieldLivro.setBounds(76, 98, 86, 20);
		panel_1.add(textFieldLivro);
		textFieldLivro.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN: ");
		lblNewLabel_2.setBounds(20, 101, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JButton bExcluirLivro = new JButton("Apagar");
		bExcluirLivro.setBounds(56, 164, 89, 23);
		panel_1.add(bExcluirLivro);
		bExcluirLivro.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JFrame frame = new JFrame("Alerta");
						String message = "Deseja continuar?";
						String title = "Confirmação";
						int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
						  if (reply == JOptionPane.YES_OPTION){
							  livro.apagarLivro(textFieldLivro.getText());
							  JOptionPane.showMessageDialog(frame, "Registro apagado!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
						  }	
					}  
				}  
		);
		
		//OPÇÃO DE APAGAR DADOS DAS VENDAS
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(458, 119, 196, 222);
		contentPane.add(panel_1_1);
		
		JLabel Vendas = new JLabel("Vendas");
		Vendas.setBounds(72, 57, 65, 14);
		panel_1_1.add(Vendas);
		
		textFieldVendas = new JTextField();
		textFieldVendas.setBounds(86, 94, 86, 20);
		panel_1_1.add(textFieldVendas);
		textFieldVendas.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("N venda: ");
		lblNewLabel_3.setBounds(10, 97, 66, 14);
		panel_1_1.add(lblNewLabel_3);
		
		JButton bExcluirVenda = new JButton("Apagar");
		bExcluirVenda.setBounds(58, 165, 89, 23);
		panel_1_1.add(bExcluirVenda);
		bExcluirVenda.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JFrame frame = new JFrame("Alerta");
						String message = "Deseja continuar?";
						String title = "Confirmação";
						int reply = JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION);
						  if (reply == JOptionPane.YES_OPTION){
							  venda.apagarVenda(Integer.parseInt(textFieldVendas.getText()));
							  JOptionPane.showMessageDialog(frame, "Registro apagado!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
						  }	
					}  
				}  
		);
		
		//BOTÃO PARA VOLTAR AO INICIO
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
