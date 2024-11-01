import listadiamant.ListaGenerica;
import listadiamant.ListaGenerica2;
public class AplicatieLista {
    public static void main(String[] args) {
        ListaGenerica<String> lst =
                new ListaGenerica<>();
        System.out.println(lst);
        lst.insertLaUrma("Bucuresti");
        lst.insertInFata("Suceava");
        lst.insertLaUrma("Iasi");
        System.out.println("Orasele din lista:");
        for (int i = 0; i < lst.size(); i++) {
            System.out.print(lst.get(i) + " ");
        }
        lst.eliminaToateElementele();
        for (int i = 0; i < 21; i++) {
            String o = Integer.toString(i); // o=""+i
            if (i % 2 != 0)
                lst.insertInFata(o);
            else lst.insertLaUrma(o);
        }
        System.out.println("\nNumerele din lista:" + lst);
        System.out.print("Intregii din lista x10: ");
        for (String el : lst) {
            System.out.print(Integer.valueOf(el) * 10 + ", ");
        }
        System.out.println("\nLungimea listei este:" + lst.size());
        ListaGenerica2<String> lst2 = new ListaGenerica2<>();
        lst2 = lst2.copiereDinListaGenerica(lst);
        ListaGenerica2<String> lst3 = new ListaGenerica2<>();
        lst3 = lst3.copiereDinListaGenerica(lst);
        ListaGenerica2<String> lst4 = new ListaGenerica2<>();
        lst4 = lst4.copiereDinListaGenerica(lst);
        System.out.println("==========Demo eliminaPrimul()===========");
        System.out.println("Numerele din lista(" + lst2.size() + "):" + lst2);
        for (int i = 0; i < lst.size(); i++) {
            lst2.eliminaPrimul();
            System.out.println("Numerele din lista(" + lst2.size() + "):" + lst2);
        }

        System.out.println("==========Demo eliminaUltimul()===========");
        System.out.println("Numerele din lista(" + lst3.size() + "):" + lst3);
        for (int i = 0; i < lst.size(); i++) {
            lst3.eliminaUltimul();
            System.out.println("Numerele din lista(" + lst3.size() + "):" + lst3);
        }
        System.out.println("==========Demo eliminaPrimul() si eliminaUltimul() alternativ===========");
        System.out.println("Numerele din lista(" + lst4.size() + "):" + lst4);
        for (int i = 0; i < lst.size(); i++) {
            if(i%2==0&&lst4.size() > 0) {
                lst4.eliminaPrimul();
                System.out.println("Numerele din lista(" + lst4.size() + "):" + lst4);
            }
            else {
                if(lst4.size() > 0) {
                    lst4.eliminaUltimul();
                    System.out.println("Numerele din lista(" + lst4.size() + "):" + lst4);
                }
            }

        }
    }
}



