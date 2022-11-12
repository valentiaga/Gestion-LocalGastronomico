package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import negocio.Sistema;
import java.awt.event.ActionEvent;

public class VistaGestionMesaOp extends JPanel implements IVistaGestionMesaOp, ItemListener, KeyListener {
	private JTextField textFieldNroMesa;
	private JButton btnCerrarMesa;
	private JButton btnSeteaMozo;
	private JButton btnModificaMesa;
	private JComboBox comboBox;
	private ActionListener actionListener;
	private JButton btnVolver ;
	private JButton btnAbrirMesa;
	private JButton btnAgregaPedido;
	private JTextField textFieldCantidad;
	private JTextField textFieldIdProd;
	/**
	 * Create the panel.
	 */
	public VistaGestionMesaOp(){
		setBorder(new TitledBorder(null, "Gestion Mesas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnModificaMesa = new JButton("Modificar Mesa");
		btnModificaMesa.setEnabled(false);
		btnModificaMesa.setActionCommand("MODIFICAR");
		panel_1.add(btnModificaMesa);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSeteaMozo = new JButton("Setear Mozo");
		btnSeteaMozo.setEnabled(false);
		btnSeteaMozo.setActionCommand("SETEAR");
		panel_2.add(btnSeteaMozo);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
		comboBox.setEditable(true);
		comboBox.addItem(Sistema.getInstance().getMozos().get("Marti").getNyA());
		comboBox.addItem(Sistema.getInstance().getMozos().get("Valen").getNyA());
		comboBox.addItem(Sistema.getInstance().getMozos().get("Pau").getNyA());
		comboBox.addItemListener(this);
		
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_7.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		
		
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCerrarMesa = new JButton("Cerrar Mesa");
		btnCerrarMesa.setEnabled(false);
		btnCerrarMesa.setActionCommand("CERRAR");
		btnCerrarMesa.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_3.add(btnCerrarMesa);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		btnAbrirMesa = new JButton("Abrir mesa");
		btnAbrirMesa.setEnabled(false);
		btnAbrirMesa.setActionCommand("ABRIR_MESA");
		panel_8.add(btnAbrirMesa);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		textFieldIdProd = new JTextField();
		textFieldIdProd.addKeyListener(this);
		textFieldIdProd.setText("id Producto");
		panel_9.add(textFieldIdProd);
		textFieldIdProd.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.addKeyListener(this);
		textFieldCantidad.setText("Cantidad");
		panel_9.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		btnAgregaPedido = new JButton("Agregar pedido");
		panel_9.add(btnAgregaPedido);
		btnAgregaPedido.setEnabled(false);
		btnAgregaPedido.setActionCommand("AGREGA_PEDIDO");
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		btnVolver = new JButton("Volver");
		panel_10.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
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
	public void addActionListener(ActionListener actionListener) {
		this.btnCerrarMesa.addActionListener(actionListener);
		this.btnModificaMesa.addActionListener(actionListener);
		this.btnSeteaMozo.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.btnAbrirMesa.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean condition = this.getNroMesa() >= 0 ;
		boolean condPedido = this.getIdProd()>=0 && this.getCant()>0 && condition;
		this.btnCerrarMesa.setEnabled(condition);
		this.btnModificaMesa.setEnabled(condition);
		this.btnSeteaMozo.setEnabled(condition);
		this.btnAbrirMesa.setEnabled(condition);
		this.comboBox.setEnabled(condition);
		this.btnAgregaPedido.setEnabled(condPedido);
	}
	public void keyTyped(KeyEvent e) {
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
			cant = Integer.parseInt(this.textFieldCantidad.getText());
		}
		catch (NumberFormatException e2) {
		}
		return cant;
	}
}
