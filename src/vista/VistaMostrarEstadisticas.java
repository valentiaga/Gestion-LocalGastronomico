package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import modelo.Enumerados;
import modelo.Mozo;
import negocio.GestionMozos;
import negocio.Sistema;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VistaMostrarEstadisticas extends JPanel implements ItemListener, IVistaMostrarEstadisticas{
	
	private ActionListener actionListener;
	private JButton btnVolver;
	private Mozo mozo;
	private JTextPane textPaneMenorVolumenVentas;
	private JTextPane textPaneMayorVolumenVentas;
	private JTextPane textPaneConsumoProm;
	private JComboBox<String> comboBoxMozo;
	private GestionMozos gestionMozos = new GestionMozos();
	
	public VistaMostrarEstadisticas() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mostrar Estadisticas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("Empleado con mayor volumen de ventas");
		panel_6.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		textPaneMayorVolumenVentas = new JTextPane();
		textPaneMayorVolumenVentas.setEditable(false);
		panel_5.add(textPaneMayorVolumenVentas);
		this.textPaneMayorVolumenVentas.setText(this.gestionMozos.mejorVendedor());
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado con menor volumen de ventas");
		panel_7.add(lblNewLabel_1);
		
		JPanel panelMenorVolumenVentas = new JPanel();
		panel_2.add(panelMenorVolumenVentas);
		
		textPaneMenorVolumenVentas = new JTextPane();
		textPaneMenorVolumenVentas.setEditable(false);
		panelMenorVolumenVentas.add(textPaneMenorVolumenVentas);
		this.textPaneMayorVolumenVentas.setText(this.gestionMozos.peorVendedor());
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_14 = new JPanel();
		panel_3.add(panel_14);
		
		JLabel lblSeleccionaMozo = new JLabel("Seleccione Mozo");
		panel_14.add(lblSeleccionaMozo);
		lblSeleccionaMozo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_3.add(panel_13);
		
		comboBoxMozo = new JComboBox<String>();
		HashMap<String, Mozo> mozos = Sistema.getInstance().getMozos();
		String nombre="";
		for (HashMap.Entry<String, Mozo> entry : mozos.entrySet()) {
			nombre = entry.getKey();//mozos.get(entry.getKey());
			this.comboBoxMozo.addItem(nombre);	
		}
		panel_13.add(comboBoxMozo);
		comboBoxMozo.setEditable(true);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		
		JLabel lblNewLabel_2 = new JLabel("Consumo promedio por mesa");
		panel_11.add(lblNewLabel_2);
		
		JPanel panel_12 = new JPanel();
		panel_8.add(panel_12);
		
		textPaneConsumoProm = new JTextPane();
		textPaneConsumoProm.setEditable(false);
		panel_12.add(textPaneConsumoProm);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JPanel panel_9 = new JPanel();
		panel_10.add(panel_9);
		
		btnVolver = new JButton("Volver");
		panel_9.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		mozo = Sistema.getInstance().getMozos().get(this.comboBoxMozo.getSelectedItem().toString());
		this.textPaneConsumoProm.setText(String.valueOf(this.gestionMozos.consumoPromedioPorMesa(mozo)));
		
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
		
	}

}