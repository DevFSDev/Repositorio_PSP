package florida;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;

/**
 * Clase Vista
 * 
 * @author lopez
 *
 */
public class Vista {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textFieldJamon;
	private JTextField textFieldPollo;
	private JTextField textFieldQueso;
	private JTextField textFieldBacalao;
	private JButton btnHacerCroquetas;
	private JTextField textFieldPrioridadJamon;
	private JTextField textFieldPrioridadPollo;
	private JTextField textFieldPrioridadQueso;
	private JTextField textFieldPrioridadBacalao;
	private JLabel lblNewLabel_4;

	/**
	 * Metodo constructor de la clase Vista, se inicializan todos los elementos de
	 * la interfaz grafica
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Metodo en el que se recogen todos los elementos de la interfaz
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 792, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		login();

		this.frame.setVisible(true);
	}

	private void login() {

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(192, 192, 192));
		desktopPane.setBounds(0, 0, 776, 535);
		frame.getContentPane().add(desktopPane);

		lblNewLabel = new JLabel("Introduce la croquetas de Jamón:");
		lblNewLabel.setBounds(36, 71, 250, 14);
		desktopPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Introduce las croquetas de Pollo:");
		lblNewLabel_1.setBounds(36, 102, 250, 14);
		desktopPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Introduce las croquetas de Queso:");
		lblNewLabel_2.setBounds(36, 133, 250, 14);
		desktopPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Introduce las croquetas de Bacalao:");
		lblNewLabel_3.setBounds(36, 164, 250, 14);
		desktopPane.add(lblNewLabel_3);

		textFieldJamon = new JTextField();
		textFieldJamon.setBounds(270, 68, 86, 20);
		desktopPane.add(textFieldJamon);
		textFieldJamon.setColumns(10);

		textFieldPollo = new JTextField();
		textFieldPollo.setBounds(270, 99, 86, 20);
		desktopPane.add(textFieldPollo);
		textFieldPollo.setColumns(10);

		textFieldQueso = new JTextField();
		textFieldQueso.setBounds(270, 130, 86, 20);
		desktopPane.add(textFieldQueso);
		textFieldQueso.setColumns(10);

		textFieldBacalao = new JTextField();
		textFieldBacalao.setBounds(270, 161, 86, 20);
		desktopPane.add(textFieldBacalao);
		textFieldBacalao.setColumns(10);

		btnHacerCroquetas = new JButton("Hacer croquetas");
		btnHacerCroquetas.setBounds(522, 124, 159, 23);
		desktopPane.add(btnHacerCroquetas);

		textFieldPrioridadJamon = new JTextField();
		textFieldPrioridadJamon.setBounds(393, 68, 86, 20);
		desktopPane.add(textFieldPrioridadJamon);
		textFieldPrioridadJamon.setColumns(10);

		textFieldPrioridadPollo = new JTextField();
		textFieldPrioridadPollo.setBounds(393, 99, 86, 20);
		desktopPane.add(textFieldPrioridadPollo);
		textFieldPrioridadPollo.setColumns(10);

		textFieldPrioridadQueso = new JTextField();
		textFieldPrioridadQueso.setBounds(393, 130, 86, 20);
		desktopPane.add(textFieldPrioridadQueso);
		textFieldPrioridadQueso.setColumns(10);

		textFieldPrioridadBacalao = new JTextField();
		textFieldPrioridadBacalao.setBounds(393, 161, 86, 20);
		desktopPane.add(textFieldPrioridadBacalao);
		textFieldPrioridadBacalao.setColumns(10);

		lblNewLabel_4 = new JLabel("Prioridad:");
		lblNewLabel_4.setBounds(393, 43, 102, 14);
		desktopPane.add(lblNewLabel_4);

	}

	public JTextField getTextFieldJamon() {
		return textFieldJamon;
	}

	public JTextField getTextFieldPollo() {
		return textFieldPollo;
	}

	public JTextField getTextFieldQueso() {
		return textFieldQueso;
	}

	public JTextField getTextFieldBacalao() {
		return textFieldBacalao;
	}

	public JButton getBtnHacerCroquetas() {
		return btnHacerCroquetas;
	}

	public JTextField getTextFieldPrioridadJamon() {
		return textFieldPrioridadJamon;
	}

	public JTextField getTextFieldPrioridadPollo() {
		return textFieldPrioridadPollo;
	}

	public JTextField getTextFieldPrioridadQueso() {
		return textFieldPrioridadQueso;
	}

	public JTextField getTextFieldPrioridadBacalao() {
		return textFieldPrioridadBacalao;
	}
}
