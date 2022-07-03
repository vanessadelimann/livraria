package Janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Cliente;
import Objetos.Livro;
import Objetos.Venda;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class JRelatorios extends JFrame {
	
	//JANELA PARA RELATÓRIO
	
	/*
	 * NÃO CONSEGUI GERAR FAZER CONSULTAS COMPLEXAS :( APENAS CONSULTAS COM 1 CHAVE
	 * */
	
	private JPanel contentPane;
	protected String Vendas;
	protected String opcao;
	private JTextField textFieldCpf;
	private JTextField textFieldDataI;
	private JTextField textFieldDataF;
	private JTextField textFieldLivro;
	private JTextField textFieldAutor;
	private JTextField textFieldCodVenda;
	private JTextField textFieldIsbn;
	private JTextField textFieldPMin;
	private JTextField textFieldPMax;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRelatorios frame = new JRelatorios();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JRelatorios() throws ParseException {
		
		Cliente cliente = new Cliente();
		Livro livro = new Livro();
		Venda venda = new Venda();
		
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
		
		JLabel lblNewLabel_3 = new JLabel("Gerar Relatorio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(306, 11, 119, 79);
		contentPane.add(lblNewLabel_3);
		
		//CPF
		JLabel lblNewLabel_1 = new JLabel("cpf");
		lblNewLabel_1.setBounds(67, 112, 46, 14);
		contentPane.add(lblNewLabel_1);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(123, 109, 86, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		//CAMPOS DE DATA
		JLabel lblNewLabel_5 = new JLabel("Data Inicial");
		lblNewLabel_5.setBounds(247, 101, 67, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Data Final");
		lblNewLabel_6.setBounds(247, 126, 67, 14);
		contentPane.add(lblNewLabel_6);

		textFieldDataI = new JTextField();
		textFieldDataI.setBounds(316, 95, 86, 20);
		contentPane.add(textFieldDataI);
		textFieldDataI.setColumns(10);
		
		textFieldDataF = new JTextField();
		textFieldDataF.setBounds(316, 120, 86, 20);
		contentPane.add(textFieldDataF);
		textFieldDataF.setColumns(10);
		
		//NOME DO LIVRO
		JLabel lblNewLabel_7 = new JLabel("Livro");
		lblNewLabel_7.setBounds(67, 199, 46, 14);
		contentPane.add(lblNewLabel_7);

		textFieldLivro = new JTextField();
		textFieldLivro.setBounds(123, 196, 86, 20);
		contentPane.add(textFieldLivro);
		textFieldLivro.setColumns(10);
		
		//AUTOR
		JLabel lblNewLabel_8 = new JLabel("Autor");
		lblNewLabel_8.setBounds(67, 224, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(123, 221, 86, 20);
		contentPane.add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		//COD DA VENDA
		JLabel lblNewLabel_2 = new JLabel("Codigo da Venda");
		lblNewLabel_2.setBounds(38, 322, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldCodVenda = new JTextField();
		textFieldCodVenda.setBounds(123, 319, 86, 20);
		contentPane.add(textFieldCodVenda);
		textFieldCodVenda.setColumns(10);
		
		//ISBN
		JLabel lblNewLabel_9 = new JLabel("ISBN");
		lblNewLabel_9.setBounds(67, 249, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setBounds(123, 246, 86, 20);
		contentPane.add(textFieldIsbn);
		textFieldIsbn.setColumns(10);
		
		//CAMPOS DE PREÇO
		textFieldPMin = new JTextField();
		textFieldPMin.setBounds(316, 196, 86, 20);
		contentPane.add(textFieldPMin);
		textFieldPMin.setColumns(10);
		
		textFieldPMax = new JTextField();
		textFieldPMax.setToolTipText("");
		textFieldPMax.setBounds(316, 221, 86, 20);
		contentPane.add(textFieldPMax);
		textFieldPMax.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Preco minimo");
		lblNewLabel.setBounds(247, 199, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_10 = new JLabel("Preco maximo");
		lblNewLabel_10.setBounds(247, 224, 74, 14);
		contentPane.add(lblNewLabel_10);
		
		//TIPOS DE RELATORIO
		JLabel lblNewLabel_11 = new JLabel("Tipo de relatorio:");
		lblNewLabel_11.setBounds(442, 112, 131, 14);
		contentPane.add(lblNewLabel_11);
		
		JRadioButton rVenda = new JRadioButton("Vendas");
		rVenda.setBounds(442, 138, 109, 23);
		contentPane.add(rVenda);
		
		JRadioButton rCliente = new JRadioButton("Cliente");
		rCliente.setBounds(442, 164, 109, 23);
		contentPane.add(rCliente);
		
		JRadioButton rEstoque = new JRadioButton("Estoque");
		rEstoque.setBounds(442, 190, 109, 23);
		contentPane.add(rEstoque);
		
		//STATUS DA VENDA
		JComboBox comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Nenhum","Aprovada","Cancelada"}));
		comboBoxStatus.setBounds(123, 376, 86, 22);

		JLabel lblNewLabel_13 = new JLabel("Status");
		lblNewLabel_13.setBounds(38, 380, 46, 14);
		contentPane.add(lblNewLabel_13);
		contentPane.add(comboBoxStatus);
		
		//TIPO DE PAGAMENTO
		JLabel lblNewLabel_12 = new JLabel("Pagamento");
		lblNewLabel_12.setBounds(38, 347, 75, 14);
		contentPane.add(lblNewLabel_12);
		
		JComboBox comboBoxPag = new JComboBox();
		comboBoxPag.setModel(new DefaultComboBoxModel(new String[] {"Nenhum","Dinheiro","Cartao debito","Cartão credito"}));
		comboBoxPag.setBounds(123, 343, 86, 22);
		contentPane.add(comboBoxPag);
		
		//NOME DO LIVRO
		textFieldNome = new JTextField();
		textFieldNome.setBounds(123, 167, 86, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Nome");
		lblNewLabel_14.setBounds(67, 168, 59, 14);
		contentPane.add(lblNewLabel_14);
		

		JButton bConfirma = new JButton("Gerar relatorio");
		bConfirma.setBounds(305, 444, 131, 23);
		contentPane.add(bConfirma);
		bConfirma.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						//APRESENTA ERRO QUANDO NÃO DEFINE QUAL O TIPO DE RELATORIO
						String mensagem = "Selecione apenas um tipo de relatorio.";
						if(rVenda.isSelected() && rCliente.isSelected() && rEstoque.isSelected()) {
							JFrame frame = new JFrame("Alerta");
						    JOptionPane.showMessageDialog(frame, mensagem,"Erro",JOptionPane.INFORMATION_MESSAGE);
						}else if(rVenda.isSelected() && rCliente.isSelected()) {
							JFrame frame = new JFrame("Alerta");
						    JOptionPane.showMessageDialog(frame, mensagem,"Erro",JOptionPane.INFORMATION_MESSAGE);
						}else if(rCliente.isSelected() && rEstoque.isSelected()) {
							JFrame frame = new JFrame("Alerta");
						    JOptionPane.showMessageDialog(frame, mensagem,"Erro",JOptionPane.INFORMATION_MESSAGE);
						}else if(rVenda.isSelected() && rEstoque.isSelected()) {
							JFrame frame = new JFrame("Alerta");
						    JOptionPane.showMessageDialog(frame, mensagem,"Erro",JOptionPane.INFORMATION_MESSAGE);
						}else{
							
							/*
							 * NÃO CONSEGUI LIMPAR AS TABELAS ENTÃO QUANDO FOR FAZER A MESMA CONSULTA 2 VEZES A TABELA FICA COM OS VALORES DUPLICADOS
							 * PARA FAZER NOVA CONSULTA É NECESSARIO REABRIR O PROGRAMA*/
							
							//RELATORIOS DE VENDAS
							if(rVenda.isSelected()) {
								if(!textFieldDataI.getText().isEmpty() && !textFieldDataF.getText().isEmpty() && comboBoxPag.getSelectedItem()!="Nenhum"){
									venda.listaVenda("Select * FROM venda WHERE pagamento='"+comboBoxPag.getSelectedItem().toString()+"' and data_registro BETWEEN '"+textFieldDataI.getText()+"' AND '"+textFieldDataF.getText()+"';");
								}else if(!textFieldDataI.getText().isEmpty() && !textFieldDataF.getText().isEmpty() && comboBoxStatus.getSelectedItem()!="Nenhum"){
									venda.listaVenda("Select * FROM venda WHERE statusVenda='"+comboBoxStatus.getSelectedItem().toString()+"' and data_registro BETWEEN '"+textFieldDataI.getText()+"' AND '"+textFieldDataF.getText()+"';");
								}else if(!textFieldDataI.getText().isEmpty() && !textFieldDataF.getText().isEmpty() && comboBoxPag.getSelectedItem()!="Nenhum" && comboBoxStatus.getSelectedItem()!="Nenhum"){
									venda.listaVenda("Select * FROM venda WHERE statusVenda='"+comboBoxStatus.getSelectedItem().toString()+"' and pagamento='"+comboBoxPag.getSelectedItem().toString()+"' and data_registro BETWEEN '"+textFieldDataI.getText()+"' AND '"+textFieldDataF.getText()+"';");
								}else if(comboBoxPag.getSelectedItem()!="Nenhum" && comboBoxStatus.getSelectedItem()!="Nenhum"){
									venda.listaVenda("Select * FROM venda WHERE statusVenda='"+comboBoxStatus.getSelectedItem().toString()+"' and pagamento='"+comboBoxPag.getSelectedItem().toString()+"';");
								}else {
									if(!textFieldDataI.getText().isEmpty() && !textFieldDataF.getText().isEmpty()) {
										venda.listaVenda("Select * FROM venda WHERE data_registro BETWEEN '"+textFieldDataI.getText()+"' AND '"+textFieldDataF.getText()+"';");
									}else if(!textFieldCodVenda.getText().isEmpty()){
										venda.listaVenda("Select * FROM Venda WHERE codVenda='"+Integer.valueOf(textFieldCodVenda.getText())+"';");
									}else if(!textFieldCpf.getText().isEmpty()){
										venda.listaVenda("Select * FROM venda WHERE FK_cpf='"+textFieldCpf.getText()+"';");
									}else if(comboBoxPag.getSelectedItem()!="Nenhum"){
										venda.listaVenda("Select * FROM venda WHERE pagamento='"+comboBoxPag.getSelectedItem().toString()+"';");
									}else if(comboBoxStatus.getSelectedItem()!="Nenhum") {
										venda.listaVenda("Select * FROM venda WHERE statusVenda='"+comboBoxStatus.getSelectedItem().toString()+"';");
									}else {
										venda.listaTVenda();
									}
								}
								
							//RELATORIOS DE CLIENTES
							}else if(rCliente.isSelected()) {
								if(!textFieldDataI.getText().isEmpty() && !textFieldDataF.getText().isEmpty()) {
									cliente.listaTClientes("Select * From cliente where data between '"+textFieldDataI.getText()+"' and '"+textFieldDataF.getText()+"';");
								}else if(!textFieldCpf.getText().isEmpty()) {
									cliente.listaTClientes("Select * From cliente where cpf='"+textFieldCpf.getText()+"';");
								}else {
									cliente.listaTClientes("Select * From cliente;");
								}

							//RELATORIOS DE ESTOQUE
							}else if(rEstoque.isSelected()) {
								if(!textFieldDataI.getText().isEmpty() && !textFieldDataF.getText().isEmpty()) {
									livro.listaLivro("Select * FROM livro WHERE data between '"+textFieldDataI.getText()+"' and '"+textFieldDataF.getText()+"';");
								}else if(!textFieldPMin.getText().isEmpty() && !textFieldPMax.getText().isEmpty()) {
									livro.listaLivro("Select * FROM livro WHERE preco > "+textFieldPMin.getText()+" AND preco < "+textFieldPMax.getText()+";");
								}else if(!textFieldNome.getText().isEmpty()){
									livro.listaLivro("Select * FROM livro WHERE nome LIKE '"+textFieldNome.getText()+"%';");
								}else if(!textFieldAutor.getText().isEmpty()){
									livro.listaLivro("Select * FROM livro WHERE autor LIKE '"+textFieldAutor.getText()+"%';");
								}else if(!textFieldIsbn.getText().isEmpty()){
									livro.listaLivro("Select * FROM livro WHERE isbn='"+textFieldIsbn.getText()+"';");
								}else {
									livro.listaLivro("Select * FROM livro;");
								}
							}else {
								JFrame frame = new JFrame("Alerta");
							    JOptionPane.showMessageDialog(frame, "Selecione o tipo de relatorio.","Erro",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					}

				}); 
		
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
