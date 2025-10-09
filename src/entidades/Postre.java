package entidades;

public class Postre extends ProductoHeladeria implements IVendible {

    private final TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double incremento = 0.0;

        switch (tipoPostre) {
            case TORTA_HELADA:
                incremento = 0.15;
                break;
            case COPA_BROWNIE:
                incremento = 0.25;
                break;
            case SUNDAE:
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

        Postre otro = (Postre) obj;

        return super.equals(otro) && this.tipoPostre == otro.tipoPostre;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTipo de Postre: " + tipoPostre +
               "\nPrecio Total: $" + getPrecioTotal();
    }
}