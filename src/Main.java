import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingreso de datos del vehículo
        System.out.println("=== Sistema de Impuesto Vehicular ===");
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = sc.nextLine();

        System.out.print("Ingrese la línea del vehículo: ");
        String linea = sc.nextLine();

        System.out.print("Ingrese el modelo (año): ");
        int modelo = sc.nextInt();

        System.out.print("Ingrese el valor comercial del vehículo: ");
        double valorComercial = sc.nextDouble();

        Vehiculo vehiculo = new Vehiculo(marca, linea, modelo, valorComercial);
        Impuesto impuesto = new Impuesto(vehiculo);

        // ===== Selección de descuentos =====
        double porcentajeProntoPago = 0;
        double porcentajeTraslado = 0;

        System.out.println("\n¿Aplicar descuento por pronto pago? (s/n): ");
        char opcion1 = sc.next().toLowerCase().charAt(0);
        if (opcion1 == 's') {
            System.out.print("Ingrese el porcentaje de pronto pago: ");
            porcentajeProntoPago = sc.nextDouble();
            impuesto.setProntoPago(new DescuentoProntoPago(porcentajeProntoPago));
        }

        System.out.println("\n¿Aplicar descuento por servicio público? (s/n): ");
        char opcion2 = sc.next().toLowerCase().charAt(0);
        if (opcion2 == 's') {
            System.out.print("Ingrese el monto fijo de descuento: ");
            double montoFijo = sc.nextDouble();
            impuesto.setServicioPublico(new DescuentoServicioPublico(montoFijo));
        }

        System.out.println("\n¿Aplicar descuento por traslado de cuenta? (s/n): ");
        char opcion3 = sc.next().toLowerCase().charAt(0);
        if (opcion3 == 's') {
            System.out.print("Ingrese el porcentaje de traslado de cuenta: ");
            porcentajeTraslado = sc.nextDouble();

            // Validación: traslado debe ser mayor que pronto pago
            if (opcion1 == 's' && porcentajeTraslado <= porcentajeProntoPago) {
                System.out.println("⚠ Error: El porcentaje de traslado de cuenta debe ser mayor al de pronto pago.");
            } else {
                impuesto.setTrasladoCuenta(new DescuentoTrasladoCuenta(porcentajeTraslado));
            }
        }

        double total = impuesto.calcularImpuesto();
        System.out.println("\n=== Resultado Final ===");
        System.out.println("Impuesto total a pagar: $" + impuesto.getTotalFormateado());

        sc.close();
    }
}
