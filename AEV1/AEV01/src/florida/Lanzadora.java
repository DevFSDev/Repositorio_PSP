package florida;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Clase Lanzadora
 * 
 * @author lopez
 *
 */

public class Lanzadora {
	/**
	 * Objeto de la clase Vista
	 */
	public static Vista vista;
	public static ActionListener actionListenerCrearCroquetas;
	public static int Pollo = 0; 
	public static int Queso = 0;
	public static int Bacalao = 0;
	public static int Jamon = 0;
	public static int prioridadPollo;
	public static int prioridadQueso;
	public static int prioridadBacalao;
	public static int prioridadJamon;

	/**
	 * 
	 * @param Jamon Cantidas de croquetas de Jamon que pide el usuario
	 * @param Pollo Cantidas de croquetas de Pollo que pide el usuario
	 * @param Bacalao Cantidas de croquetas de Bacalao que pide el usuario
	 * @param Queso Cantidas de croquetas de Queso que pide el usuario
	 * @param prioridadJamon La prioridad de las croquetas de Jamon que pide el usuario
	 * @param prioridadPollo La prioridad de las croquetas de Pollo que pide el usuario
	 * @param prioridadBacalao La prioridad de las croquetas de Bacalao que pide el usuario
	 * @param prioridadQueso La prioridad de las croquetas de Queso que pide el usuario
	 * @throws IOException Gestion de errores entrada/salida
	 * @param lanzarCroquetas se utiliza para llamar a la clase main de Procesadora pasandole todos los parametros por argumentos
	 */
	public static void lanzarCroquetas(Integer Jamon, Integer Pollo, Integer Bacalao, Integer Queso, Integer prioridadJamon, Integer prioridadPollo, Integer prioridadBacalao, Integer prioridadQueso ) throws IOException {
		String clase = "florida.Procesadora";
		try {
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			System.out.println(classpath);
			String className = clase;
			
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(Jamon.toString());
			command.add(Pollo.toString());
			command.add(Bacalao.toString());
			command.add(Queso.toString());
			command.add(prioridadJamon.toString());
			command.add(prioridadPollo.toString());
			command.add(prioridadBacalao.toString());
			command.add(prioridadQueso.toString());
			
			ProcessBuilder builder = new ProcessBuilder(command);
			Process process = builder.inheritIO().start();
			process.waitFor();
			

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @param args Clase Main que ejecuta el codigo creando un nuevo objeto tipo
	 *             Vista
	 * @throws InterruptedException El error hace referencia a cuando el subproceso
	 *                              esta esperando u ocupado.
	 */
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * Llamamos a la clase Vista que recibe los elementos de la interfaz grafica
		 */
		vista = new Vista();

		try {
			/**
			 * ActionListener que se encarga de gestionar todos los posibles errores que
			 * pueda causar el usuario en la interfaz, como tambien llamar al metodo lanzar
			 * croquetas de la clase main Lanzadora pasandole los argumentos correspondientes
			 */
			actionListenerCrearCroquetas = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {

							Pollo = Integer.parseInt(vista.getTextFieldPollo().getText());
							Queso = Integer.parseInt(vista.getTextFieldQueso().getText());
							Bacalao = Integer.parseInt(vista.getTextFieldBacalao().getText());
							Jamon = Integer.parseInt(vista.getTextFieldJamon().getText());
							prioridadPollo = Integer.parseInt(vista.getTextFieldPrioridadPollo().getText());
							prioridadQueso = Integer.parseInt(vista.getTextFieldPrioridadQueso().getText());
							prioridadBacalao = Integer.parseInt(vista.getTextFieldPrioridadBacalao().getText());
							prioridadJamon = Integer.parseInt(vista.getTextFieldPrioridadJamon().getText());
							
							if(prioridadJamon > 10 || prioridadBacalao > 10 || prioridadPollo > 10 || prioridadQueso > 10) {
								JOptionPane.showMessageDialog(null, "La prioridad tiene que ser del 1 al 10",
										"Prioridades", JOptionPane.ERROR_MESSAGE);
								
							} else if (Pollo % 6 != 0 || Queso % 6 != 0 || Bacalao % 6 != 0 || Jamon % 6 != 0) {
								JOptionPane.showMessageDialog(null, "Los pedidos tienen que ser multiplos de 6", "Paquetes",
										JOptionPane.ERROR_MESSAGE);
							} else {
								lanzarCroquetas(Jamon, Pollo, Bacalao, Queso, prioridadJamon,
										prioridadPollo, prioridadBacalao, prioridadQueso);
							}
							
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Debes introducir todos los campos", "Croquetas",
									JOptionPane.ERROR_MESSAGE);
							
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
							
						


				}
			};
			vista.getBtnHacerCroquetas().addActionListener(actionListenerCrearCroquetas);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Campos", JOptionPane.ERROR_MESSAGE);
		}

	}

}
