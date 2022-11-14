package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Enumerados.diasDePromo;
import modelo.Enumerados.formaDePago;
import modelo.PromocionProd;
import modelo.PromocionTemporal;
import negocio.Sistema;

public class VistaModificaPromocionTemporal extends JPanel implements IVistaAgregarPromocionTemporal, KeyListener{
	
	private JTextField textFieldNombre;
	private JTextField textFieldPorcentaje;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBoxDiasDePromo;
	private JComboBox comboBoxFormaDePago;
	private JButton btnConfirmar;
	private JButton btnVolver;
	private ActionListener actionListener;
	private JComboBox comboBoxAcumulable;
	private JComboBox comboBoxActiva;
	
	/**
	 * Create the panel.
	 */
	public VistaModificaPromocionTemporal() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modificar Promocion Temporal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(9, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		JLabel lblNewLabel = new JLabel("Nombre de la promocion");
		panel_9.add(lblNewLabel);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(this);
		panel_10.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JLabel lblNewLabel_1 = new JLabel("Dia de promocion");
		panel_11.add(lblNewLabel_1);
		
		JPanel panel_12 = new JPanel();
		panel_1.add(panel_12);
		
		comboBoxDiasDePromo = new JComboBox();
		comboBoxDiasDePromo.setEditable(true);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.DOMINGO);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.LUNES);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.MARTES);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.MIERCOLES);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.JUEVES);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.VIERNES);
		this.comboBoxDiasDePromo.addItem(Enumerados.diasDePromo.SABADO);
		panel_12.add(comboBoxDiasDePromo);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		
		JLabel lblNewLabel_2 = new JLabel("Forma de pago");
		panel_13.add(lblNewLabel_2);
		
		JPanel panel_14 = new JPanel();
		panel_2.add(panel_14);
		
		comboBoxFormaDePago = new JComboBox();
		comboBoxFormaDePago.setEditable(true);
		comboBoxFormaDePago.addItem(Enumerados.formaDePago.CTADNI);
		comboBoxFormaDePago.addItem(Enumerados.formaDePago.EFECTIVO);
		comboBoxFormaDePago.addItem(Enumerados.formaDePago.MERCPAGO);
		comboBoxFormaDePago.addItem(Enumerados.formaDePago.TARJETA);
		panel_14.add(comboBoxFormaDePago);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		
		JLabel lblNewLabel_6 = new JLabel("Promocion activa");
		panel_15.add(lblNewLabel_6);
		
		JPanel panel_25 = new JPanel();
		panel_3.add(panel_25);
		
		comboBoxActiva = new JComboBox<String>();
		comboBoxActiva.setEditable(true);
		comboBoxActiva.addItem("Si");
		comboBoxActiva.addItem("No");
		panel_25.add(comboBoxActiva);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_16 = new JPanel();
		panel_4.add(panel_16);
		
		JLabel lblNewLabel_7 = new JLabel("Promocion acumulable");
		panel_16.add(lblNewLabel_7);
		
		JPanel panel_26 = new JPanel();
		panel_4.add(panel_26);
		
		comboBoxAcumulable = new JComboBox<String>();
		comboBoxAcumulable.setEditable(true);
		comboBoxAcumulable.addItem("Si");
		comboBoxAcumulable.addItem("No");
		panel_26.add(comboBoxAcumulable);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JPanel panel_17 = new JPanel();
		panel_5.add(panel_17);
		
		JLabel lblNewLabel_3 = new JLabel("Porcentaje de descuento");
		panel_17.add(lblNewLabel_3);
		
		JPanel panel_18 = new JPanel();
		panel_5.add(panel_18);
		
		textFieldPorcentaje = new JTextField();
		panel_18.add(textFieldPorcentaje);
		textFieldPorcentaje.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		JPanel panel_19 = new JPanel();
		panel_6.add(panel_19);
		
		JLabel lblNewLabel_4 = new JLabel("Hora inicio");
		panel_19.add(lblNewLabel_4);
		
		JPanel panel_20 = new JPanel();
		panel_6.add(panel_20);
		
		textField_1 = new JTextField();
		panel_20.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		
		JPanel panel_21 = new JPanel();
		panel_7.add(panel_21);
		
		JLabel lblNewLabel_5 = new JLabel("Hora finalizacion");
		panel_21.add(lblNewLabel_5);
		
		JPanel panel_22 = new JPanel();
		panel_7.add(panel_22);
		
		textField_2 = new JTextField();
		panel_22.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		
		JPanel panel_23 = new JPanel();
		panel_8.add(panel_23);
		
		btnVolver = new JButton("Volver");
		panel_23.add(btnVolver);
		
		JPanel panel_24 = new JPanel();
		panel_8.add(panel_24);
		
		btnConfirmar = new JButton("Confirmar");
		panel_24.add(btnConfirmar);
	}
	
	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void limpiarVista() {
		this.textFieldNombre.setText("");
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.textFieldPorcentaje.setText("");
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);

	}

	@Override
	public boolean getActiva() {
		boolean res=true;
		if (this.comboBoxActiva.getSelectedItem().toString()=="No")
			res=false;
		return res;
	}

	@Override
	public diasDePromo getDiasDePromo() {
		// TODO Auto-generated method stub
		return (diasDePromo) this.comboBoxDiasDePromo.getSelectedItem();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.textFieldNombre.getText();
	}

	@Override
	public formaDePago getFormaDePago() {
		// TODO Auto-generated method stub
		return (formaDePago) this.comboBoxFormaDePago.getSelectedItem();
	}

	@Override
	public int getPorcentajeDesc() {
		int porcen=-1;
		try {
			porcen = Integer.parseInt(this.textFieldPorcentaje.getText());
		}
		catch (NumberFormatException e2) {
		}
		return porcen;
	}

	@Override
	public boolean isAcumulable() {
		boolean res=true;
		if (this.comboBoxAcumulable.getSelectedItem().toString()=="No")
			res=false;
		return res;
	}

	@Override
	public int getHoraInicio() {
		int hora=-1;
		try {
			hora = Integer.parseInt(this.textField_1.getText());
		}
		catch (NumberFormatException e2) {
		}
		return hora;
	}

	@Override
	public int getHoraFinal() {
		int hora=-1;
		try {
			hora = Integer.parseInt(this.textField_2.getText());
		}
		catch (NumberFormatException e2) {
		}
		return hora;
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean condition = this.getNombre().length()>0;
		String resActiva="Si", resAcum = "Si";
		if (condition) {
			for (int i=0; i<Sistema.getInstance().getPromocionesTemp().size(); i++) {
				PromocionTemporal promo = Sistema.getInstance().getPromocionesTemp().get(i);
				if (promo.getNombre().equalsIgnoreCase(this.getNombre())) {
					this.textField_1.setText(String.valueOf(promo.getHoraInicio()));
					this.textField_2.setText(String.valueOf(promo.getHoraFinal()));
					this.textFieldPorcentaje.setText(String.valueOf(promo.getPorcentajeDesc()));
					if (promo.isActiva()==false)
						resActiva = "No";
					if (promo.isEsAcumulable()==false)
						resAcum = "No";
					this.comboBoxActiva.setSelectedItem(resActiva);
					this.comboBoxAcumulable.setSelectedItem(resAcum);
					this.comboBoxDiasDePromo.setSelectedItem(promo.getDiasDePromo());
					this.comboBoxFormaDePago.setSelectedItem(promo.getFormaDePago());
				}
				else {
					this.textField_1.setText("");
					this.textField_2.setText("");
					this.textFieldPorcentaje.setText("");
				}
			}
			
			
		}
	}
	public void keyTyped(KeyEvent e) {
	}
}
