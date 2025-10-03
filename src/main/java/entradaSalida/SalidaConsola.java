package entradaSalida;

public class SalidaConsola extends Salida{

    @Override
    public void mostrarString(String dato) {
        System.out.println("String: " + dato);
    }
    
    @Override
    public void mostrarBoolean(boolean dato) {
        System.out.println("Boolean: " + dato);
    }
    
    @Override
    public void mostrarInt(int dato) {
        System.out.println("Int: " + dato);
    }
    
    @Override
    public void mostrarFloat(float dato) {
        System.out.println("Float: " + dato);
    }
    
    @Override
    public void mostrarDouble(double dato) {
        System.out.println("Double: " + dato);
    }	
}
