import java.text.DecimalFormat;

class Impuesto {
    private Vehiculo vehiculo;
    private Descuento prontoPago;
    private Descuento servicioPublico;
    private Descuento trasladoCuenta;
    private double total;
    private DecimalFormat df = new DecimalFormat("#,###.00"); 

    public Impuesto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.total = vehiculo.getValorComercial();
    }

    public void setProntoPago(Descuento prontoPago) { this.prontoPago = prontoPago; }
    public void setServicioPublico(Descuento servicioPublico) { this.servicioPublico = servicioPublico; }
    public void setTrasladoCuenta(Descuento trasladoCuenta) { this.trasladoCuenta = trasladoCuenta; }

    public double calcularImpuesto() {
        double monto = vehiculo.getValorComercial();
        System.out.println("\n=== Detalle de cálculo ===");
        System.out.println("Valor comercial inicial: $" + df.format(monto)); 

        if (prontoPago != null) {
            monto = prontoPago.aplicarDescuento(monto);
            System.out.println("Aplicando descuento: " + prontoPago.getNombre() +
                               " → Nuevo valor: $" + df.format(monto)); 
        }

        if (servicioPublico != null) {
            monto = servicioPublico.aplicarDescuento(monto);
            System.out.println("Aplicando descuento: " + servicioPublico.getNombre() +
                               " → Nuevo valor: $" + df.format(monto)); 
        }

        if (trasladoCuenta != null) {
            monto = trasladoCuenta.aplicarDescuento(monto);
            System.out.println("Aplicando descuento: " + trasladoCuenta.getNombre() +
                               " → Nuevo valor: $" + df.format(monto)); 
        }

        this.total = monto;
        return this.total;
    }

    public double getTotal() { return total; }

    public String getTotalFormateado() { 
        return df.format(total);
    }
}
