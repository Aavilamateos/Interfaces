package ejemplo1ventana;

import javax.swing.JFrame;

public class CrearVentana {
	private static JFrame ventana;

	public static void main(String[] args) {
		crearVentana();

	}

	public static void crearVentana() {
		JFrame ventana2 = new JFrame();
		ventana2.setBounds(500, 300, 600, 400); // coordenadas x, y altura y anchura
		ventana2.setVisible(true);
		ventana2.setTitle("La otra ventana");
		ventana = new JFrame("Ventana vacia");
		ventana.setLocationRelativeTo(null); // centrar
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Q SE CIERRE CUANDO SE CIERRE EL PROGRAMA
		ventana.setSize(500, 500);
		ventana.setVisible(true);
	}
}
