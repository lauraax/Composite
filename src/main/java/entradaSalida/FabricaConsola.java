package entradaSalida;

public class FabricaConsola extends FabricaEntradaSalida {
    @Override
    public Entrada generarEntrada() {
        return new EntradaConsola();
    }

    @Override
    public Salida generarSalida() {
        return new SalidaConsola();
    }
}
