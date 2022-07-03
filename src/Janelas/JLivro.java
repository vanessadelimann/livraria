package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Livro;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JLivro extends JFrame {
	
	//JANELA CADASTRO DOS LIVROS
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldIsbn;
	private JTextField textFieldEdicao;
	private JTextField textFieldAno;
	private JTextField textFieldAutor;
	private JTextField textFieldPreco;
	private JTextField textFieldPag;
	private JTextField textFieldEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLivro frame = new JLivro();
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
	public JLivro() {
		Livro livro = new Livro();
		
		//JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar Novo Livro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(288, 75, 178, 36);
		contentPane.add(lblNewLabel);
		
		JLabel ltitulo = new JLabel("Livraria Cafe Books");
		ltitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ltitulo.setBounds(38, 424, 207, 37);
		contentPane.add(ltitulo);
		
		//CADASTRO
		
		//NOME
		textFieldNome = new JTextField();
		textFieldNome.setBounds(305, 139, 215, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lNome = new JLabel("Nome:");
		lNome.setBounds(232, 142, 46, 14);
		contentPane.add(lNome);
		
		//ISBN
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBounds(305, 170, 215, 20);
		contentPane.add(textFieldIsbn);
		textFieldIsbn.setColumns(10);

		JLabel lIsbn = new JLabel("ISBN:");
		lIsbn.setBounds(232, 173, 46, 14);
		contentPane.add(lIsbn);
		
		//EDIÇÃO
		textFieldEdicao = new JTextField();
		textFieldEdicao.setBounds(305, 201, 131, 20);
		contentPane.add(textFieldEdicao);
		textFieldEdicao.setColumns(10);

		JLabel lEdicao = new JLabel("Edicao:");
		lEdicao.setBounds(232, 204, 63, 14);
		contentPane.add(lEdicao);
		
		//ANO
		textFieldAno = new JTextField();
		textFieldAno.setBounds(305, 232, 70, 20);
		contentPane.add(textFieldAno);
		textFieldAno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ano:");
		lblNewLabel_2.setBounds(232, 235, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		//AUTOR
		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(305, 263, 215, 20);
		contentPane.add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		JLabel lAutor = new JLabel("Autor:");
		lAutor.setBounds(232, 266, 46, 14);
		contentPane.add(lAutor);
		
		//PREÇO
		JLabel lPreco = new JLabel("Pre\u00E7o:");
		lPreco.setBounds(232, 328, 46, 14);
		contentPane.add(lPreco);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(305, 325, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		//QUANTIDADE DE PAGINAS
		JLabel lQtdPag = new JLabel("Qtd paginas:");
		lQtdPag.setBounds(232, 294, 86, 14);
		contentPane.add(lQtdPag);
		
		textFieldPag = new JTextField();
		textFieldPag.setBounds(305, 294, 86, 20);
		contentPane.add(textFieldPag);
		textFieldPag.setColumns(10);
		
		//QUANTIDADE EM ESTOQUE
		JLabel lblNewLabel_1 = new JLabel("Qtd em Estoque:");
		lblNewLabel_1.setBounds(232, 353, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldEstoque = new JTextField();
		textFieldEstoque.setBounds(328, 350, 86, 20);
		contentPane.add(textFieldEstoque);
		textFieldEstoque.setColumns(10);
		
		JButton bConfirma = new JButton("Criar cadastro");
		bConfirma.setBounds(305, 444, 131, 23);
		contentPane.add(bConfirma);
		bConfirma.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						livro.cadastrarLivro(textFieldNome.getText(), textFieldIsbn.getText(), textFieldEdicao.getText(), textFieldAno.getText(),textFieldAutor.getText(),Integer.parseInt(textFieldPag.getText()), Double.valueOf(textFieldPreco.getText()).doubleValue(),Integer.parseInt(textFieldEstoque.getText()));
						JFrame frame = new JFrame("Alerta");
					    JOptionPane.showMessageDialog(frame, "Livro cadastrado com sucesso!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
					    textFieldNome.setText("");
					    textFieldIsbn.setText("");
					    textFieldEdicao.setText("");
					    textFieldAno.setText("");
					    textFieldAutor.setText("");
					    textFieldPag.setText("");
					    textFieldPreco.setText("");
					    textFieldEstoque.setText("");
					}  
				}  
		);
		
		//VOLTAR AO INICIO
		JButton bHome = new JButton("Tela Inicial");
		bHome.setBounds(537, 25, 131, 23);
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
