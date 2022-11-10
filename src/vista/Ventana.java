package vista;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	private JPanel contentPane;
	
	private ActionListener actionListener;
	private VistaInicial vistaInicial;
	private VistaGestionMozoOp vistaGestionMozoOp;
	private VistaGestionMozoAdmin vistaGestionMozoAdmin;
	private VistaGestionMesaOp vistaMesaOp;
	private VistaGestionMesaAdmin vistaMesaAdmin;
	private VistaCambiaContrasena vistaCambiaContrasena;
	private VistaOperario vistaOp;
	private VistaAdmin vistaAdmin;

	
	

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
	public Ventana(VistaInicial vistaInicial, VistaGestionMozoOp vistaMozoOp, VistaGestionMozoAdmin vistaMozoAdmin, VistaGestionMesaOp vistaMesaOp, VistaGestionMesaAdmin vistaMesaAdmin, VistaCambiaContrasena vistaCambiaContrasena, VistaOperario vistaOp, VistaAdmin vistaAdmin) {
		this.vistaGestionMozoOp = vistaMozoOp;
		this.vistaGestionMozoAdmin = vistaMozoAdmin;
		this.vistaAdmin = vistaAdmin;
		this.vistaCambiaContrasena = vistaCambiaContrasena;
		this.vistaInicial = vistaInicial;
		this.vistaMesaAdmin = vistaMesaAdmin;
		this.vistaMesaOp = vistaMesaOp;
		this.vistaOp = vistaOp;
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 354);
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(vistaMozoAdmin);
		contentPane.add(vistaMozoOp);
		contentPane.add(vistaMesaAdmin);
		contentPane.add(vistaMesaOp);
		contentPane.add(vistaOp);
		contentPane.add(vistaAdmin);
		contentPane.add(vistaCambiaContrasena);
		//contentPane.add(vistaInicial); AHRE		
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}

	public VistaInicial getVistaInicial() {
		return vistaInicial;
	}

	public VistaGestionMozoOp getVistaGestionMozoOp() {
		return vistaGestionMozoOp;
	}

	public VistaGestionMozoAdmin getVistaGestionMozoAdmin() {
		return vistaGestionMozoAdmin;
	}

	public VistaGestionMesaOp getVistaMesaOp() {
		return vistaMesaOp;
	}

	public VistaGestionMesaAdmin getVistaMesaAdmin() {
		return vistaMesaAdmin;
	}

	public VistaCambiaContrasena getVistaCambiaContrasena() {
		return vistaCambiaContrasena;
	}

	public VistaOperario getVistaOp() {
		return vistaOp;
	}

	public VistaAdmin getVistaAdmin() {
		return vistaAdmin;
	}


}
