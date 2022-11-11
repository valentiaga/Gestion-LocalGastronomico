package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VistaInicial extends JPanel implements IVistaInicial, KeyListener{
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private JButton btnAceptar;
	
	public VistaInicial() {
		setBorder(new TitledBorder(null, "Iniciar Sesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panelNorte = new JPanel();
		add(panelNorte);
		panelNorte.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panelNorte.add(panel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(89)
					.addComponent(lblUsuario)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addComponent(lblUsuario)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panelNorte.add(panel_1);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.addKeyListener(this);
		textFieldUsuario.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(59)
					.addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(textFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panelCentro = new JPanel();
		add(panelCentro);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panelCentro.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(84, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(79))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panelCentro.add(panel_3);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.addKeyListener(this);
		textFieldContrasena.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(61)
					.addComponent(textFieldContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(35)
					.addComponent(textFieldContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panelSur = new JPanel();
		add(panelSur);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		GroupLayout gl_panelSur = new GroupLayout(panelSur);
		gl_panelSur.setHorizontalGroup(
			gl_panelSur.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSur.createSequentialGroup()
					.addGap(183)
					.addComponent(btnAceptar)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_panelSur.setVerticalGroup(
			gl_panelSur.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSur.createSequentialGroup()
					.addContainerGap(36, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addGap(33))
		);
		panelSur.setLayout(gl_panelSur);
	}

	@Override
	public void limpiarVista() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsuario() {
		return this.textFieldUsuario.getText();
	}

	@Override
	public String getContrasena() {
		// TODO Auto-generated method stub
		return this.textFieldContrasena.getText();
	}

	@Override
	public void ventanaEmergente(String mensaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		boolean condition = this.getContrasena().length()>0 && this.getUsuario().length()>0;
		this.btnAceptar.setEnabled(condition);
	}
	public void keyTyped(KeyEvent e) {
	}
}
