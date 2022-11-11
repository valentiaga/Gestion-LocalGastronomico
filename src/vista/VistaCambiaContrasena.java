package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VistaCambiaContrasena extends JPanel implements IVistaCambiaContrasena {

	/**
	 * Create the panel.
	 */
//	public VistaCambiaContrasena() {
//		setLayout(new BorderLayout(0, 0));
//		
//		JLabel lblNewLabel = new JLabel("Cambia la contraseña");
//		add(lblNewLabel, BorderLayout.NORTH);
//
//	}

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	
	@Override
	public String getContrasena() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public VistaCambiaContrasena() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_125158342663200");
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JLabel LabelContrsena = new JLabel("Nueva contraseña");
		LabelContrsena.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap(75, Short.MAX_VALUE)
					.addComponent(LabelContrsena)
					.addGap(57))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(49)
					.addComponent(LabelContrsena)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUsuario.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(66)
					.addComponent(textFieldUsuario)
					.addGap(68))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel LabelContrasena = new JLabel("Confirme su nueva contraseña");
		LabelContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(LabelContrasena)
					.addGap(33))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(50)
					.addComponent(LabelContrasena)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldContrasena.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(textFieldContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(66))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(48)
					.addComponent(textFieldContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);
		
		JLabel LabelIniciaSesion = new JLabel("Cambie la contraseña");
		panel_3.add(LabelIniciaSesion);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_7.add(btnAceptar);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}
}
