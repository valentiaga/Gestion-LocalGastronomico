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
	private JTextField textFieldCantSillas;
	private JButton btnVolver;
	private JButton btnSeteaMozo;
	private JComboBox comboBox;
	private JButton btnModificaMesa;
	private JButton btnAgrega;
	private JButton btnCerrarMesa;
	private JButton btnElimina;
	private JButton btnAbrirMesa;
	private ActionListener actionListener;
	private JTextField textFieldNroMesa;
	private JTextField textFieldIdProd;
	private JTextField textFieldCant;
	private JButton btnAgregaPedido;
	
	
	/**
	 * Create the panel.
	 */
	public VistaGestionMesaAdmin() {
		
		setBorder(new TitledBorder(null, "Gestion Mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(10, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Numero de Mesa");
		panel_1.add(lblNewLabel);
		
		textFieldNroMesa = new JTextField();
		textFieldNroMesa.addKeyListener(this);
		panel_1.add(textFieldNroMesa);
		textFieldNroMesa.setColumns(10);
		
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
		
		btnAbrirMesa = new JButton("Abre Mesa");
		btnAbrirMesa.setEnabled(false);
		btnAbrirMesa.setActionCommand("ABRE_MESA");
		panel_3.add(btnAbrirMesa);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		textFieldIdProd = new JTextField();
		textFieldIdProd.addKeyListener(this);
		panel_8.add(textFieldIdProd);
		textFieldIdProd.setText("id Producto");
		textFieldIdProd.setColumns(10);
		
		textFieldCant = new JTextField();
		textFieldCant.addKeyListener(this);
		panel_8.add(textFieldCant);
		textFieldCant.setText("Cantidad");
		textFieldCant.setColumns(10);
		
		btnAgregaPedido = new JButton("Agregar pedido");
		panel_8.add(btnAgregaPedido);
		btnAgregaPedido.setEnabled(false);
		btnAgregaPedido.setActionCommand("AGREGA_PEDIDO");
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		btnCerrarMesa = new JButton("Cerrar Mesa");
		panel_9.add(btnCerrarMesa);
		btnCerrarMesa.setEnabled(false);
		btnCerrarMesa.setActionCommand("CERRAR");
		btnCerrarMesa.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		btnElimina = new JButton("Eliminar Mesa");
		panel_10.add(btnElimina);
		btnElimina.setEnabled(false);
		btnElimina.setActionCommand("ELIMINA");
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		btnModificaMesa = new JButton("Modificar Mesa");
		panel_13.add(btnModificaMesa);
		btnModificaMesa.setEnabled(false);
		btnModificaMesa.setActionCommand("MODIFICA");
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Ingresar la cantidad de sillas");
		panel_4.add(lblNewLabel_1);
		
		textFieldCantSillas = new JTextField();
		panel_4.add(textFieldCantSillas);
		textFieldCantSillas.addKeyListener(this);
		textFieldCantSillas.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnAgrega = new JButton("Agregar Mesa");
		panel_5.add(btnAgrega);
		btnAgrega.setEnabled(false);
		btnAgrega.setActionCommand("AGREGA");
		
		JPanel panel_9_1 = new JPanel();
		panel.add(panel_9_1);
		
		btnVolver = new JButton("Volver");
		panel_9_1.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
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
		this.btnAbrirMesa.addActionListener(actionListener);
		this.btnAgregaPedido.addActionListener(actionListener);
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean conditionNroMesa = this.getNroMesa()>=0;
		boolean conditionPedido = conditionNroMesa && this.getCant()>0 && this.getIdProd()>=0;
		boolean condition2 = this.getCantPax()>0;
		this.btnCerrarMesa.setEnabled(conditionNroMesa);
		this.btnElimina.setEnabled(conditionNroMesa);
		this.btnModificaMesa.setEnabled(conditionNroMesa);
		this.btnSeteaMozo.setEnabled(conditionNroMesa);
		this.btnAbrirMesa.setEnabled(conditionNroMesa);
		this.btnAgrega.setEnabled(condition2);	
		this.btnAgregaPedido.setEnabled(conditionPedido);
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
		this.textFieldCantSillas.setText("");
		this.textFieldCant.setText("");
		this.textFieldIdProd.setText("");
	}
	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje );
	}
	@Override
	public int getIdProd() {
		int id=-1;
		try {
			id = Integer.parseInt(this.textFieldIdProd.getText());

		}
		catch (NumberFormatException e2) {
		}
		return id;
	}

	@Override
	public int getCant() {
		int cant=-1;
		try {
			cant = Integer.parseInt(this.textFieldCant.getText());
		}
		catch (NumberFormatException e2) {
		}
		return cant;
	}
}