
package entidades;

public class Fabricante {

    private String nombre;
    private String pais;

    public Fabricante(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getFabricante() {
        return this.nombre + " - " + this.pais;
    }

    public static boolean sonIguales(Fabricante f1, Fabricante f2) {
        if (f1 == null || f2 == null) {
            return false;
        }
        return f1.nombre.equals(f2.nombre) && f1.pais.equals(f2.pais);
    }

    @Override
    public String toString() {
        return getFabricante();
    }
}
