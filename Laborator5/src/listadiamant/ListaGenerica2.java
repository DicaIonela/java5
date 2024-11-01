package listadiamant;

import java.util.NoSuchElementException;

public class ListaGenerica2<T> extends ListaGenerica<T> {
    public ListaGenerica2() {
        super();
    }
    /*
    public ListaGenerica2<String> copiere() {
        ListaGenerica2<T> listaCopie = new ListaGenerica<>();
        for (Element<T> elem = getPrimul(); elem != null; elem = elem.getUrm()) {
            listaCopie.insertLaUrma(elem.getInfo());
        }
        return listaCopie;
    }*/
    public ListaGenerica2<T> copiereDinListaGenerica(ListaGenerica<T> lista) {
        ListaGenerica2<T> copia = new ListaGenerica2<>();
        for (T element : lista) {
            copia.insertLaUrma(element);
        }
        return copia;
    }
    public T eliminaPrimul() {
        if (getPrimul() == null) {
            throw new NoSuchElementException("Lista este goala, nu se poate elimina elementul.");
        }
        T infoPrim = getPrimul().getInfo();
        setPrimul(getPrimul().getUrm());
        if (getPrimul() == null) setUltimul(null);
        dimensiune--; //
        return infoPrim;
    }
    public T eliminaUltimul() {
        if (getPrimul() == null) {
            throw new NoSuchElementException("Lista este goala, nu se poate elimina elementul.");
        }

        // Dacă lista are un singur element
        if (getPrimul() == getUltimul()) {
            T infoUlt = getUltimul().getInfo();
            eliminaToateElementele(); // Resetează lista
            return infoUlt;
        }

        // Parcurgem lista pentru a ajunge la penultimul element
        Element<T> current = getPrimul();
        while (current.getUrm() != getUltimul()) {
            current = current.getUrm();
        }

        // Obținem informația ultimului element
        T infoUlt = getUltimul().getInfo();
        // Setăm ultimul element la penultimul
        setUltimul(current);
        // Facem legătura penultimului element la null
        current.setUrm(null);
        dimensiune--;

        return infoUlt;
    }
}
