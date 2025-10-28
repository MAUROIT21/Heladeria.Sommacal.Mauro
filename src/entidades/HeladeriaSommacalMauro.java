
package entidades;

public class HeladeriaSommacalMauro {

 
    public static void main(String[] args) {

        Heladeria miHeladeria = new Heladeria(5);
        Fabricante f1 = new Fabricante("FríoMix", "Argentina");
        Fabricante f2 = new Fabricante("DolceLatte", "Italia");
        Fabricante f3 = new Fabricante("SweetArt", "Uruguay");
        Helado h1 = new Helado("Chocolate Belga", 1500.00, f1, CategoriaHelado.GOURMET,SaborHelado.CHOCOLATE);
        Helado h2 = new Helado("Vainilla Clásica", 1200.00, f2,CategoriaHelado.CLASICO,SaborHelado.VAINILLA);
        Helado h3 = new Helado("Helado Vegano de Almendra", 1800.00, f3,CategoriaHelado.VEGANO,SaborHelado.DULCE_DE_LECHE);
        Postre p1 = new Postre("Copa Brownie", 2000.00, "Daniel","Argentina", TipoPostre.COPA_BROWNIE);
        Postre p2 = new Postre("Torta Helada Oreo", 2500.00, "Freddo","Argentina", TipoPostre.TORTA_HELADA);
        Postre p3 = new Postre("Sundae Tropical", 1800.00, "Lucciano","Argentina", TipoPostre.SUNDAE);
        // Agregados
        miHeladeria.agregar(h1);
        miHeladeria.agregar(p1);
        miHeladeria.agregar(h2);
        // Intento de agregar repetido
        System.out.println("\n Intentando agregar producto repetido...");
        miHeladeria.agregar(h1);
        // Agregados
        miHeladeria.agregar(p2);
        miHeladeria.agregar(h3);
        // Intento de agregar sin lugar
        System.out.println("\n Intentando agregar producto sin lugar...");

        miHeladeria.agregar(p3);
        // Pruebas de equals
        Helado h4 = new Helado("Chocolate Belga", 1500.00, f1, CategoriaHelado.GOURMET,SaborHelado.CHOCOLATE);
        Postre p4 = new Postre("Copa Brownie", 2000.00, "Daniel", "Argentina", TipoPostre.COPA_BROWNIE);
        System.out.println("\n Pruebas equals:");
        System.out.println(h1.equals(h1)); // TRUE
        System.out.println(h1.equals(h4)); // TRUE
        System.out.println(h1.equals(h2)); // FALSE
        System.out.println(p1.equals(p3)); // FALSE
        System.out.println(p1.equals(p2)); // FALSE
        System.out.println(p1.equals(p4)); // TRUE
        // Mostrar heladería completa
        System.out.println("\n Información de la Heladería:\n");
        System.out.println(miHeladeria);
        
    }
    
}
