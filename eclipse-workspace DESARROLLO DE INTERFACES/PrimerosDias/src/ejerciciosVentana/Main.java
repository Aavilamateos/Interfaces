package ejerciciosVentana;

public class Main {
public static void main(String[] args) {
	MiVentana ventana=new MiVentana();
	ventana.inicializar();
	Ejercicio01 ej1=new Ejercicio01();
	ej1.Ejercicio1Texto();

	//CAMBIAR ESTILO CON EL LOOKANDFEEL
//	try{
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//    } catch(Exception e){
//        System.out.println(e);
//    }
	
	Ejercicio02 ej2=new Ejercicio02();
	ej2.Ejercicio2Texto();
	
	Ejercicio03Y04 ej3=new Ejercicio03Y04();
	ej3.Ejercicio3Texto();
	
	
	
	
}

}
