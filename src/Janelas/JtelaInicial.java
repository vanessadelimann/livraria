package Janelas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.Color;


@SuppressWarnings("serial")
public class JtelaInicial extends JFrame {
	
	//TELA INICIAL
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JtelaInicial frame = new JtelaInicial();
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
	public JtelaInicial() {
		
		//JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ltitulo = new JLabel("Livraria Cafe Books");
		ltitulo.setForeground(Color.WHITE);
		ltitulo.setFont(new Font("Gabriola", Font.PLAIN, 61));
		ltitulo.setBounds(146, 110, 435, 104);
		contentPane.add(ltitulo);
				
		//ABRE O CADASTRO DE CLIENTE
		JButton bNovoCliente = new JButton("Novo Cliente");
		bNovoCliente.setBounds(166, 197, 145, 23);
		contentPane.add(bNovoCliente);
		bNovoCliente.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JCliente cliente = new JCliente();
						cliente.setVisible(true);
						dispose();
					}  
				}  
		);
		
		//ABRE O CADASTRO DE VENDAS
		JButton bNovaVenda = new JButton("Nova Venda");
		bNovaVenda.setBounds(166, 249, 145, 23);
		contentPane.add(bNovaVenda);
		bNovaVenda.addActionListener(  
			new ActionListener(){  
				public void actionPerformed(ActionEvent evento){  
					JVendaItens venda = new JVendaItens();
					venda.setVisible(true);
					dispose();
				}  
			}  
		); 
		
		//ABRE O CADASTRO DE LIVROS
		JButton bNovoLivro = new JButton("Novo Livro");
		bNovoLivro.setBounds(166, 302, 145, 23);
		contentPane.add(bNovoLivro);
		bNovoLivro.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JLivro livro = new JLivro();
						livro.setVisible(true);
						dispose();
					}  
				}  
			);
		
		//ABRE OS RELATORIOS
		JButton bRelatorios = new JButton("Relatorios");
		bRelatorios.setBounds(261, 395, 145, 23);
		contentPane.add(bRelatorios);
		bRelatorios.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						JRelatorios relatorio;
						try {
							relatorio = new JRelatorios();
							relatorio.setVisible(true);
							dispose();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}  
				}  
			);
		
		//FECHA O PROGRAMA
		JButton bSair = new JButton("Sair");
		bSair.setBounds(512, 25, 131, 23);
		contentPane.add(bSair);
		bSair.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						dispose();
					}  
				}  
			);
		
		//ABRE A TELA PARA ATUALIZAR OS LIVROS
		JButton bAtualizarLivro = new JButton("Atualizar Livros");
		bAtualizarLivro.setBounds(345, 302, 145, 23);
		contentPane.add(bAtualizarLivro);
		bAtualizarLivro.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						JAtualizarLivros atualizarLivro = new JAtualizarLivros();
						atualizarLivro.setVisible(true);
						dispose();
					}  
				}  
			);
		
		//ABRE A TELA PARA ATUALIZAR O CADASTRO DE CLIENTE
		JButton bAtualizarCliente = new JButton("Atualizar Clientes");
		bAtualizarCliente.setBounds(345, 197, 145, 23);
		contentPane.add(bAtualizarCliente);
		bAtualizarCliente.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						JAtualizarCliente atualizarCliente = new JAtualizarCliente();
						atualizarCliente.setVisible(true);
						dispose();
					}  
				}  
			);
		
		//ABRE A TELA PARA CANCELAR UMA VENDA
		JButton cancelarVenda = new JButton("Cancelar venda");
		cancelarVenda.setBounds(345, 249, 145, 23);
		contentPane.add(cancelarVenda);
		cancelarVenda.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						JCancelarVenda cancelar = new JCancelarVenda();
						cancelar.setVisible(true);
					}  
				}  
			);
		
		//ABRE A TELA PARA REDEFINIR OS DADOS
		JButton bApagarRegistros = new JButton("Apagar Registros");
		bApagarRegistros.setBounds(261, 351, 145, 23);
		contentPane.add(bApagarRegistros);
		bApagarRegistros.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						JApagarRegistros apagarRegistros = new JApagarRegistros();
						apagarRegistros.setVisible(true);
						dispose();
					}  
				}  
			);
		
		//INFORMAÇÕES DOS ESTUDANTES
		JButton informacoes = new JButton("Sobre");
		informacoes.setBounds(261, 434, 145, 23);
		contentPane.add(informacoes);
		informacoes.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						JInfor informacoes = new JInfor();
						informacoes.setVisible(true);
						dispose();
					}  
				}  
			);

		Icon backgroud = new ImageIcon(getClass().getResource("/Imagens/backgroundLivro.png"));
		JLabel lbackgroud = new JLabel(backgroud);
		lbackgroud.setBounds(0, -67, 809, 635);
		contentPane.add(lbackgroud);
	}
	
	
}
