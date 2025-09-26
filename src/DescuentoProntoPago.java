class DescuentoProntoPago extends Descuento {
    public DescuentoProntoPago(double porcentaje) {
        super("Pronto Pago", porcentaje);
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - (monto * (valor / 100));
    }
}

class DescuentoServicioPublico extends Descuento {
    public DescuentoServicioPublico(double montoFijo) {
        super("Servicio Público", montoFijo);
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - valor;
    }
}

class DescuentoTrasladoCuenta extends Descuento {
    public DescuentoTrasladoCuenta(double porcentaje) {
        super("Traslado de Cuenta", porcentaje);
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - (monto * (valor / 100));
    }
}
