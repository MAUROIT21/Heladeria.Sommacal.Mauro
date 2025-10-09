package entidades;

import java.util.Random;

public abstract class ProductoHeladeria implements Comparable<ProductoHeladeria> {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int puntaje;
    protected static Random generadorPuntaje;

    static {
        generadorPuntaje = new Random();
    }

    public ProductoHeladeria(String nombre, String precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = Double.parseDouble(precio);
        this.fabricante = fabricante;
        this.puntaje = 0;
    }

    public ProductoHeladeria(String nombre, String precio, String nombreFabricante, String paisFabricante) {
        this(nombre, precio, new Fabricante(nombreFabricante, paisFabricante));
    }

    public String getNombre() {
        return this.nombre;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }

    public int getPuntaje() {
        if (this.puntaje == 0) {
            this.puntaje = generadorPuntaje.nextInt(10) + 1;
        }
        return this.puntaje;
    }

    protected static String mostrar(ProductoHeladeria p) {
        return "\n - Producto: " + p.nombre + " / Fabricante: " + p.fabricante.getFabricante() +
               " / Precio: $" + p.precio + " / Puntaje: " + p.getPuntaje();
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    } else if (obj == null || this.getClass() != obj.getClass()) {
        return false;
    }

    ProductoHeladeria otro = (ProductoHeladeria) obj;

    return this.nombre.equals(otro.nombre) &&
           Fabricante.sonIguales(this.fabricante, otro.fabricante);
}

    @Override
    public int compareTo(ProductoHeladeria otro) {
        return this.nombre.compareTo(otro.nombre);
    }
    

}