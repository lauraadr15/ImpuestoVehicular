

class Vehiculo {
    private String marca;
    private String linea;
    private int modelo;
    private double valorComercial;

    public Vehiculo(String marca, String linea, int modelo, double valorComercial) {
        this.marca = marca;
        this.linea = linea;
        this.modelo = modelo;
        this.valorComercial = valorComercial;
    }

    public String getMarca() { return marca; }
    public String getLinea() { return linea; }
    public int getModelo() { return modelo; }
    public double getValorComercial() { return valorComercial; }
}