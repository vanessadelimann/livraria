package Janelas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JInfor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInfor frame = new JInfor();
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
	public JInfor() {
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
		
		JLabel lblNewLabel = new JLabel("VANESSA DE LIMA NASCIMENTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(203, 176, 363, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblWeslyMatheusDos = new JLabel("WESLY MATHEUS DOS SANTOS LOBO");
		lblWeslyMatheusDos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeslyMatheusDos.setBounds(203, 218, 363, 57);
		contentPane.add(lblWeslyMatheusDos);
		
		JLabel lblE = new JLabel("EQUIPE:");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblE.setBounds(203, 127, 363, 57);
		contentPane.add(lblE);
		
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
