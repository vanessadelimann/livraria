package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.Venda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JCancelarVenda extends JFrame {
	
	//JANELA PARA CANCELAR UMA VENDA
	private JPanel contentPane;
	private JTextField textFieldConfirmacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCancelarVenda frame = new JCancelarVenda();
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
	public JCancelarVenda() {
		Venda venda = new Venda();
		
		//JANELA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//DADOS
		JLabel lblNewLabel = new JLabel("Digite o codigo da venda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(129, 48, 247, 41);
		contentPane.add(lblNewLabel);
		
		textFieldConfirmacao = new JTextField();
		textFieldConfirmacao.setBounds(114, 100, 213, 41);
		contentPane.add(textFieldConfirmacao);
		textFieldConfirmacao.setColumns(10);
		
		JButton bOk = new JButton("OK");
		bOk.setBounds(117, 166, 89, 36);
		contentPane.add(bOk);
		bOk.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						venda.atualizarVenda(Integer.parseInt(textFieldConfirmacao.getText()),"Cancelada");
						JFrame frame = new JFrame("Alerta");
					    JOptionPane.showMessageDialog(frame, "Venda Cancelada!","Confirmacao",JOptionPane.INFORMATION_MESSAGE);
					}  
				}  
		);
		
		JButton bCancelar = new JButton("Cancelar");
		bCancelar.setBounds(232, 166, 89, 36);
		contentPane.add(bCancelar);
		bCancelar.addActionListener(  
				new ActionListener(){  
					public void actionPerformed(ActionEvent evento){
						dispose();
					}  
				}  
		);
	}
}
