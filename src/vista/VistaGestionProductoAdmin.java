package vista;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class VistaGestionProductoAdmin extends VistaGestionProductoOp{
	public VistaGestionProductoAdmin() {
		setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel label = new JLabel("");
		add(label);
		
		JPanel panel = new JPanel();
		add(panel);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		panel.add(btnAgregarProducto);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		panel_1.add(btnEliminarProducto);
	}

}
