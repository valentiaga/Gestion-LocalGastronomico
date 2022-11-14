package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaGestionPromociones extends JPanel implements IVistaGestionPromociones {
	private JTextField textFieldIDModif;
	private JTextField textFieldIDelim;
	private JTextField textFieldModifTemp;
	private JTextField textFieldElimTemp;
	private JButton btnAgregarProdProm;
	private JButton btnVolver;
	private JButton btnModificarPromo;
	private JButton btnEliminaPromo;
	private JButton btnAgregaPromoTemporal;
	private JButton btnModificaTemp;
	private JButton btnEliminaTemp;
	private ActionListener actionListener;
	

	/**
	 * Create the panel.
	 */
	public VistaGestionPromociones() {
		setBorder(new TitledBorder(null, "Gestion de Promociones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(7, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		btnAgregarProdProm = new JButton("Agregar promocion");
		btnAgregarProdProm.setActionCommand("AGREGA_PROMO");
		panel_8.add(btnAgregarProdProm);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		
		btnModificarPromo = new JButton("Modificar promocion");
		btnModificarPromo.setActionCommand("MODIF_PROMO");
		panel_9.add(btnModificarPromo);
		
		JLabel lblNewLabel_1 = new JLabel("Id promocion");
		panel_1.add(lblNewLabel_1);
		
		textFieldIDModif = new JTextField();
		textFieldIDModif.setColumns(10);
		panel_1.add(textFieldIDModif);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10);
		
		btnEliminaPromo = new JButton("Eliminar promocion");
		btnEliminaPromo.setActionCommand("ELIM_PROMO");
		panel_10.add(btnEliminaPromo);
		
		JLabel lblNewLabel_2 = new JLabel("Id promocion");
		panel_2.add(lblNewLabel_2);
		
		textFieldIDelim = new JTextField();
		textFieldIDelim.setColumns(10);
		panel_2.add(textFieldIDelim);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		
		btnAgregaPromoTemporal = new JButton("Agregar promocion temporal");
		btnAgregaPromoTemporal.setActionCommand("AGREGA_PROMO_TEMP");
		panel_11.add(btnAgregaPromoTemporal);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		
		btnModificaTemp = new JButton("Modificar promocion temporal");
		btnModificaTemp.setActionCommand("MODIF_PROMO_TEMP");
		panel_12.add(btnModificaTemp);
		
		JLabel lblNombrePromocion = new JLabel("Nombre promocion");
		panel_4.add(lblNombrePromocion);
		
		textFieldModifTemp = new JTextField();
		textFieldModifTemp.setColumns(10);
		panel_4.add(textFieldModifTemp);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		btnEliminaTemp = new JButton("Eliminar promocion temporal");
		btnEliminaTemp.setActionCommand("ELIM_PROMO_TEMP");
		panel_13.add(btnEliminaTemp);
		
		JLabel lblNombrePromocion_1 = new JLabel("Nombre promocion");
		panel_5.add(lblNombrePromocion_1);
		
		textFieldElimTemp = new JTextField();
		textFieldElimTemp.setColumns(10);
		panel_5.add(textFieldElimTemp);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		
		JPanel panel_14_1 = new JPanel();
		panel_6.add(panel_14_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panel_14_1.add(btnVolver);

	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		this.btnAgregaPromoTemporal.addActionListener(actionListener);
		this.btnAgregarProdProm.addActionListener(actionListener);
		this.btnEliminaPromo.addActionListener(actionListener);
		this.btnEliminaTemp.addActionListener(actionListener);
		this.btnModificarPromo.addActionListener(actionListener);
		this.btnModificaTemp.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void limpiarVista() {
		this.textFieldIDModif.setText("");
		this.textFieldIDelim.setText("");
		this.textFieldModifTemp.setText("");
		this.textFieldElimTemp.setText("");
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
		
	}

	@Override
	public int getIdModif() {
		int id=-1;
		try {
			id = Integer.parseInt(this.textFieldIDModif.getText());
		}
		catch (NumberFormatException e2) {
		}
		return id;
	}

	@Override
	public int getIdElim() {
		int id=-1;
		try {
			id = Integer.parseInt(this.textFieldIDelim.getText());
		}
		catch (NumberFormatException e2) {
		}
		return id;
	}

	@Override
	public String getNameModif() {
		// TODO Auto-generated method stub
		return this.textFieldModifTemp.getText();
	}

	@Override
	public String getNameElim() {
		// TODO Auto-generated method stub
		return this.textFieldElimTemp.getText();
	}

}
