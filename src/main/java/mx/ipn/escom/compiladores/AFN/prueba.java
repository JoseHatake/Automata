package mx.ipn.escom.compiladores.AFN;

public class prueba {
	public static void main(String[] args) {
		AFN inicial = new AFN();
		inicial.setTransicion(new Transicion(new Simbolo('a')));
		AFN inicial2 = new AFN();
		inicial2.setTransicion(new Transicion(new Simbolo('b')));
		inicial.unir(inicial2);
		inicial.cerraduraKleene();
		inicial.imprimirAFN();
		inicial2 = new AFN();
		inicial2.setTransicion(new Transicion(new Simbolo('c')));
		inicial2.cerraduraPositiva();
		inicial.concatenar(inicial2);
		inicial.imprimirAFN();
	}
}