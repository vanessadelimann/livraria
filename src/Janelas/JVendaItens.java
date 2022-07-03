package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Objetos.Cliente;
import Objetos.Livro;
import Objetos.LivrosVendidos;
import Objetos.Venda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class JVendaItens extends JFrame {
	
	//CADASTRA VENDA
	private JPanel contentPane;
	private JTextField textFieldCodLivro;
	private JTextField textFieldcpf;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVendaItens frame = new JVendaItens();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JVendaItens() {
		Venda venda = new Venda();
		Cliente cliente = new Cliente();
		ArrayList itens = new ArrayList();
		
		//JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// RODAPE
		JLabel ltitulo = new JLabel("Livraria Cafe Books");
		ltitulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ltitulo.setBounds(36, 448, 207, 37);
		contentPane.add(ltitulo);
		
		// INF COD DA VENDA
		JLabel lblNewLabel_7 = new JLabel("Numero da Venda:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(54, 91, 159, 30);
		contentPane.add(lblNewLabel_7);
		
		venda.listaUltimaVenda();
		JLabel lNvenda = new JLabel("Num venda");
		lNvenda.setText(Integer.toString(venda.getCodVenda()+1));
		lNvenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lNvenda.setBounds(207, 92, 94, 28);
		contentPane.add(lNvenda);
		
		// TITULO	
		JLabel lblNewLabel = new JLabel("Adicionar Itens a venda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(240, 119, 202, 36);
		contentPane.add(lblNewLabel);
		
		// APRESENTA O VALOR A PAGAR
		JLabel lblNewLabel_9 = new JLabel("Valor a Pagar:");
		lblNewLabel_9.setBounds(387, 364, 89, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel total = new JLabel("R$: "+venda.getValor_total());
		total.setBounds(486, 364, 131, 14);
		contentPane.add(total);		
		
		
		
		// TABELA DE ITENS DA VENDA	
		DefaultTableModel modelo = new DefaultTableModel() {			
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
					
					default:
						return String.class;
				}
				
			}
		};
		
		modelo.addColumn("Item");
		modelo.addColumn("Codigo");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Nome do Livro");
		modelo.addColumn("Valor Unitário");
		modelo.addColumn("Valor Total");
		
		JTable tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(69, 206, 579, 145);
		tabela.setBounds(69, 206, 579, 145);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane);
		
		// SELECIONAR LIVROS
		JLabel lItem = new JLabel("Codigo do Livro:");
		lItem.setBounds(69, 166, 116, 14);
		contentPane.add(lItem);
		
		textFieldCodLivro = new JTextField();
		textFieldCodLivro.setToolTipText("");
		textFieldCodLivro.setBounds(168, 163, 215, 20);
		contentPane.add(textFieldCodLivro);
		textFieldCodLivro.setColumns(10);
		textFieldCodLivro.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
		        if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
		        	//CRIA O LIVRO
		        	Livro livro = new Livro();
		        	//BUSCA
	        		livro.setIsbn(textFieldCodLivro.getText());
		            livro.buscaLivro(livro.getIsbn());
		            //ADICIONA O LIVRO SELECIONADO A TABELA
		            modelo.addRow(new Object[]{false, livro.getIsbn(), 1,livro.getNome(),livro.getPreco(),livro.getPreco()});
		            //ATUALIZA O VALOR A PAGAR DA JANELA
		            double totalAPagar = venda.getValor_total();
		            venda.setValor_total(totalAPagar+livro.getPreco()); 
		            total.setText("R$ "+String.valueOf(venda.getValor_total()));
		            //ARMAZENA EM UMA LISTA TODOS OS DADOS QUE ESTÃO VISUALMENTE NA TABELA
		            itens.add(textFieldCodLivro.getText());
		            textFieldCodLivro.setText("");
		        }
		    }
		});
	    
		
		//BOTOES PARA EXCLUIR ITENS DA TABELA
		JButton bExcluir = new JButton("Excluir Item");
		bExcluir.setBounds(157, 403, 108, 23);
		contentPane.add(bExcluir);
		bExcluir.addActionListener(  
			new ActionListener(){  
				public void actionPerformed(ActionEvent evento){  
					for(int i=0; i<tabela.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(tabela.getValueAt(i, 0).toString());						
						if(checked) {
							double totalAPagar = venda.getValor_total();
							venda.setValor_total(totalAPagar-Double.valueOf(tabela.getValueAt(i, 5).toString()).doubleValue());
							//REMOVE O ITEM DA TABELA
							modelo.removeRow(tabela.convertColumnIndexToView(i));
							//ATUALIZANDO O VALOR A PAGAR APÓS A EXCLUSÃO DO ITEM DA TABELA
							total.setText("R$ "+String.valueOf(venda.getValor_total()));
							//REMOVE O ITEM DA LISTA
							itens.remove(i);
						}
					}						
				}  
			}  
		);
			
		
		
		//SELECIONAR E ATRELA O CLIENTE A VENDA
		JLabel lblNewLabel_6 = new JLabel("CPF:");
		lblNewLabel_6.setBounds(69, 29, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldcpf = new JTextField();
		textFieldcpf.setBounds(105, 26, 147, 20);
		contentPane.add(textFieldcpf);
		textFieldcpf.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Cliente: ");
		lblNewLabel_8.setBounds(89, 66, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lNomeCliente = new JLabel();
		lNomeCliente.setBounds(145, 66, 202, 14);
		contentPane.add(lNomeCliente);
		
		JLabel lCpfCliente = new JLabel();
		lCpfCliente.setBounds(396, 66, 173, 14);
		contentPane.add(lCpfCliente);
		
		JButton bBuscar = new JButton("Buscar");
		bBuscar.setBounds(272, 25, 89, 23);
		contentPane.add(bBuscar);
		bBuscar.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){  
						cliente.listaTClientes("Select * From cliente where cpf='"+textFieldcpf.getText()+"';");
						String clienteNome = cliente.getNome();
						String cpfCliente = cliente.getCpf();
						lNomeCliente.setText(clienteNome);
						lCpfCliente.setText(cpfCliente);
						venda.setCpf(cliente.getCpf());
						venda.setNomeCliente(cliente.getNome());
						textFieldcpf.setText("");
					}  
				}  
		);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cartão Débito","Cartão Crédito","Dinheiro"}));
		comboBox.setBounds(498, 162, 147, 22);
		contentPane.add(comboBox);
		venda.setPagamento(comboBox.getName());
		
				
		// APRESENTA A DATA DA VENDA
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		
		JLabel lblNewLabel_10 = new JLabel("Data da Venda: ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(387, 94, 122, 24);
		contentPane.add(lblNewLabel_10);
		
		JLabel data_vend = new JLabel(data.toString());
		data_vend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		data_vend.setBounds(513, 94, 88, 24);
		contentPane.add(data_vend);
		
		// BOTAO FINALIZAR VENDA
		JButton bConfirma = new JButton("Finalizar");
		bConfirma.setBounds(457, 403, 131, 23);
		contentPane.add(bConfirma);
		bConfirma.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){ 
						venda.setStatusVenda("Aprovada");
						venda.setPagamento(comboBox.getSelectedItem().toString());
						venda.setData(new SimpleDateFormat("yyyy/MM/dd").format(dataHoraAtual).toString());
												
						venda.cadastrarVenda(venda.getValor_total(),venda.getPagamento(),venda.getCpf(),venda.getStatusVenda(),venda.getData());
						
						JFrame frame = new JFrame("Alerta");
						venda.listaUltimaVenda();
					    JOptionPane.showMessageDialog(frame, "Venda "+venda.getCodVenda()+" cadastrada com sucesso!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
					    lNvenda.setText(Integer.toString(venda.getCodVenda()+1));
					    
					    LivrosVendidos vendidos = new LivrosVendidos();
					    int numVenda = venda.getCodVenda();
						vendidos.incluirLivros(itens, numVenda++);			    
					}  
				}  
		);
		
		
		// RETORNA AO INICIO
		JButton bHome = new JButton("Tela Inicial");
		bHome.setBounds(512, 25, 131, 23);
		contentPane.add(bHome);		
		JLabel lblNewLabel_1 = new JLabel("Pagamento:");
		lblNewLabel_1.setBounds(396, 166, 80, 14);
		contentPane.add(lblNewLabel_1);
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
