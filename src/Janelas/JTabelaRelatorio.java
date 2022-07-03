package Janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class JTabelaRelatorio extends JFrame {
	//PAINEL PARA ADICIONAR A TABELA
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTabelaRelatorio frame = new JTabelaRelatorio(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param modelo 
	 */
	public JTabelaRelatorio(DefaultTableModel modelo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTable tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(69, 206, 579, 145);
		tabela.setBounds(69, 206, 579, 145);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane);
		
	}

}
