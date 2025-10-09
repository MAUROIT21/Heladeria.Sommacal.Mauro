package entidades;

public class Helado extends ProductoHeladeria implements IVendible {

    private final SaborHelado sabor;
    private final CategoriaHelado categoriaHelado;

    public Helado(String nombre, Double precio, Fabricante fabricante, CategoriaHelado categoriaHelado, SaborHelado sabor) {
        super(nombre, precio, fabricante);
        this.categoriaHelado = categoriaHelado;
        this.sabor = sabor;
    }

    @Override
    public double getPrecioTotal() {
    double incremento = 0.0;

    switch (categoriaHelado) {
        case CLASICO:
            incremento = 0.05;
            break;
        case GOURMET:
            incremento = 0.20;
            break;
        case VEGANO:
            incremento = 0.10;
            break;
    }

    return this.precio + (this.precio * incremento);
}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Helado otro = (Helado) obj;

        return super.equals(otro) && this.sabor == otro.sabor;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nSabor: " + sabor +
               "\nCategoría: " + categoriaHelado +
               "\nPrecio Total: $" + getPrecioTotal();
    }
}