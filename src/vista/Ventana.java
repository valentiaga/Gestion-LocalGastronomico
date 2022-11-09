package vista;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	private JPanel contentPane;
	
	private ActionListener actionListener;
	private VistaInicial vistaInicial;
	private VistaGestionMozoOp vista;
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Ventana(VistaGestionMozoOp vistaMozo) {
		this.vista = vistaMozo;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 354);
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		contentPane.add(vistaMozo);
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}

}
