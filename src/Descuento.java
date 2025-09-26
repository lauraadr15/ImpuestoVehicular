abstract class Descuento {
    protected String nombre;
    protected double valor;

    public Descuento(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public abstract double aplicarDescuento(double monto);

    public String getNombre() { return nombre; }
    public double getValor() { return valor; }
}