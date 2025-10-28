package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heladeria {

    private int capacidad;
    private List<ProductoHeladeria> productos;

    public Heladeria() {
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Heladeria(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    public boolean sonIguales(ProductoHeladeria p) {
        for (ProductoHeladeria prod : productos) {
            if (prod.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void agregar(ProductoHeladeria p) {
        if (productos.size() >= capacidad) {
            System.out.println("No se puede agregar el producto, no hay capacidad.");
        } else if (sonIguales(p)) {
            System.out.println("El producto ya se encuentra en la heladería.");
        } else {
            productos.add(p);
            System.out.println("Producto agregado: " + p.getNombre());
        }
    }

    public void ordenarPorNombre() {
        Collections.sort(productos);
    }

    public double getPrecioProductos(TipoProducto tipo) {
        double total = 0.0;

        for (ProductoHeladeria p : productos) {
            if (p instanceof IVendible) {
                switch (tipo) {
                    case HELADOS:
                        if (p instanceof Helado) {
                            total += ((IVendible) p).getPrecioTotal();
                        }
                        break;
                    case POSTRES:
                        if (p instanceof Postre) {
                            total += ((IVendible) p).getPrecioTotal();
                        }
                        break;
                    case TODOS:
                        total += ((IVendible) p).getPrecioTotal();
                        break;
                }
            }
        }

        return total;
    }
    
    public double getPrecioDeHelados() {
        double total = 0.0;

        for (ProductoHeladeria p : productos) {
            if (p instanceof Helado && p instanceof IVendible) {
                total += ((IVendible) p).getPrecioTotal();
            }
        }

        return total;
    }
    
    public double getPrecioDePostres() {
        double total = 0.0;

        for (ProductoHeladeria p : productos) {
            if (p instanceof Postre && p instanceof IVendible) {
                total += ((IVendible) p).getPrecioTotal();
            }
        }

        return total;
    }
    
    
    public double getPrecioTotal() {
        double total = 0.0;

        for (ProductoHeladeria p : productos) {
            if (p instanceof IVendible) {
                total += ((IVendible) p).getPrecioTotal();
            }
        }

        return total;
    }

@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Heladería\n");
        sb.append("Cantidad de productos: ").append(productos.size()).append("\n");

        List<ProductoHeladeria> ordenados = new ArrayList<>(productos);
        Collections.sort(ordenados);

        sb.append("\nProductos ordenados por nombre:\n");
        for (ProductoHeladeria p : ordenados) {
            sb.append("------------------------------\n");
            sb.append(p.toString()).append("\n");
        }

        sb.append("\nPrecios totales:\n");
        sb.append("Helados: $").append(getPrecioDeHelados()).append("\n");
        sb.append("Postres: $").append(getPrecioDePostres()).append("\n");
        sb.append("Total general: $").append(getPrecioTotal()).append("\n");

        return sb.toString();
    }

    
  
}