package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VistaGestionMesaAdmin extends JPanel implements IVistaGestionMesaAdmin, KeyListener{
	private JTextField textFieldNroMesa;
	private JTextField textFieldCantSillas;
	private JButton btnVolver;
	private JButton btnSeteaMozo;
	private JComboBox comboBox;
	private JButton btnModificaMesa;
	private JButton btnAgrega;
	private JButton btnCerrarMesa;
	private JButton btnElimina;
	private ActionListener actionListener;
	
	
	/**
	 * Create the panel.
	 */
	public VistaGestionMesaAdmin() {
		
		setBorder(new TitledBorder(null, "Gestion Mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(7, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar la cantidad de sillas");
		panel_11.add(lblNewLabel_1);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		textFieldCantSillas = new JTextField();
		textFieldCantSillas.addKeyListener(this);
		panel_12.add(textFieldCantSillas);
		textFieldCantSillas.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		btnSeteaMozo = new JButton("Setear Mozo");
		btnSeteaMozo.setActionCommand("SETEAR");
		btnSeteaMozo.setEnabled(false);
		
		JPanel panel_7 = new JPanel();
		
		comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
		comboBox.setEditable(true);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_7.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(123)
					.addComponent(btnSeteaMozo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSeteaMozo)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnModificaMesa = new JButton("Modificar Mesa");
		btnModificaMesa.setEnabled(false);
		btnModificaMesa.setActionCommand("MODIFICA");
		panel_3.add(btnModificaMesa);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		btnCerrarMesa = new JButton("Cerrar Mesa");
		panel_8.add(btnCerrarMesa);
		btnCerrarMesa.setEnabled(false);
		btnCerrarMesa.setActionCommand("CERRAR");
		btnCerrarMesa.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		btnElimina = new JButton("Eliminar Mesa");
		btnElimina.setEnabled(false);
		btnElimina.setActionCommand("ELIMINA");
		panel_9.add(btnElimina);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		btnAgrega = new JButton("Agregar Mesa");
		btnAgrega.setEnabled(false);
		panel_10.add(btnAgrega);
		btnAgrega.setActionCommand("AGREGA");
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel_13.add(btnVolver);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Numero de Mesa");
		panel_6.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		textFieldNroMesa = new JTextField();
		textFieldNroMesa.addKeyListener(this);
		panel_5.add(textFieldNroMesa);
		textFieldNroMesa.setColumns(10);
		
//		setLayout(new GridLayout(0, 1, 0, 0));
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.PINK);
//		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
//		add(panel);
//		
//		JButton btnEliminaMesa = new JButton("Elimina Mesa");
//		panel.add(btnEliminaMesa);
//		
//		JPanel panel_1 = new JPanel();
//		add(panel_1);
//		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
//		
//		JPanel panel_5 = new JPanel();
//		panel_1.add(panel_5);
//		
//		JPanel panel_4 = new JPanel();
//		panel_5.add(panel_4);
//		
//		JLabel lblCantSillas = new JLabel("Ingresar Cantidad de sillas");
//		panel_4.add(lblCantSillas);
//		
//		JPanel panel_3 = new JPanel();
//		panel_5.add(panel_3);
//		
//		textField = new JTextField();
//		textField.setColumns(10);
//		panel_3.add(textField);
//		
//		JPanel panel_2 = new JPanel();
//		panel_1.add(panel_2);
//		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		
//		JButton btnAgregaMesa = new JButton("Agrega Mesa");
//		panel_2.add(btnAgregaMesa);
	}
	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnAgrega.addActionListener(actionListener);
		this.btnCerrarMesa.addActionListener(actionListener);
		this.btnElimina.addActionListener(actionListener);
		this.btnModificaMesa.addActionListener(actionListener);
		this.btnSeteaMozo.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
		
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean condition1 = this.getNroMesa()>=0, condition2 = this.getCantPax()>0;
		this.btnAgrega.setEnabled(condition2);
		this.btnCerrarMesa.setEnabled(condition1);
		this.btnElimina.setEnabled(condition1);
		this.btnModificaMesa.setEnabled(condition1);
		this.btnSeteaMozo.setEnabled(condition1);
		
	}
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public int getNroMesa() {
		int nroMesa=-1;
		try {
			nroMesa = Integer.parseInt(this.textFieldNroMesa.getText());
		}
		catch (NumberFormatException e2) {
			
		}
		return nroMesa;
	}
	@Override
	public int getCantPax() {
		int cantPax=-1;
		try {
			cantPax = Integer.parseInt(this.textFieldCantSillas.getText());
		}
		catch (NumberFormatException e2) {
		}
		return cantPax;
	}
	@Override
	public void limpiarVista() {
		this.textFieldNroMesa.setText("");
		
	}
	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje );
		
	}
}