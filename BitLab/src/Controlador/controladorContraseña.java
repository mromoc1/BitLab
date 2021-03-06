package Controlador;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.BaseDeDatos;
import Vista.Administrador;
import Vista.Contraseņa;

public class controladorContraseņa implements ActionListener {
	
	Contraseņa ventanaContraseņa;

	public controladorContraseņa(Contraseņa ventanaContraseņa) {
		this.ventanaContraseņa = ventanaContraseņa;
		
		this.ventanaContraseņa.botonIngresarContraseņa.addActionListener(this);
		
	}
	
	public void iniciarVentana() {
		ImageIcon icono = new ImageIcon(getClass().getResource("/Imagen/businessman-with-shield.png"));
		Image imagen = icono.getImage();
		
		ventanaContraseņa.setIconImage(imagen);
		ventanaContraseņa.setTitle("");
		ventanaContraseņa.setSize(400, 150);
		ventanaContraseņa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaContraseņa.setLocationRelativeTo(null);
		ventanaContraseņa.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ventanaContraseņa.botonIngresarContraseņa) {
			if(BaseDeDatos.coincide(String.copyValueOf(ventanaContraseņa.passwordField.getPassword()))) {
				ventanaContraseņa.dispose();
				Administrador ventanaAdministrador = new Administrador();
				controladorAdministrador controlador = new controladorAdministrador(ventanaAdministrador);
				controlador.iniciarVentana();
			}else {
				JOptionPane.showMessageDialog(null, "Contraseņa Erronea","Error",JOptionPane.ERROR_MESSAGE);
				ventanaContraseņa.passwordField.setText("");
			}
		}
		
	}
	
	
	
}
