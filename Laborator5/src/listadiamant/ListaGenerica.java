package listadiamant;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ListaGenerica<T> implements Iterable<T> {
    public int dimensiune;
    public static class Element<T>{
        private T info;
        private Element<T> urm;
        Element(T info, Element<T> urm) {
            this.info = info;
            this.urm = urm;
        }
        public Element<T> getUrm() {
            return urm;
        }
        public T getInfo() {
            return info;
        }
        protected void setUrm(Element<T> elem) {
            urm = elem;
        }
    } // sfarsit static class Element<T>

    private Element<T> primul=null;
    private Element<T> ultimul=null;
    public ListaGenerica() {
    }
    @Override
    public Iterator<T> iterator() {
        return new IteratorLst(primul);
    }
    public void insertInFata (T x){
        primul = new Element (x, primul);
        if ( ultimul == null)
            ultimul=primul;
        dimensiune++;
    }
    public void insertLaUrma ( T x ) {
        Element<T> elem = new Element(x, null);
        if(ultimul == null) {
            primul = ultimul = elem;
        } else {
            ultimul.urm = elem;
            ultimul = elem;
        }
        dimensiune++;
    }

    public int size(){
        return dimensiune;
    }
    protected Element<T> getPrimul() {
        return primul;
    }
    protected Element<T> getUltimul() {
        return ultimul;
    }
    public ListaGenerica<T> copiere() {
        ListaGenerica<T> listaCopie = new ListaGenerica<>();
        for (Element<T> elem = primul; elem != null; elem = elem.urm) {
            listaCopie.insertLaUrma(elem.info);
        }
        return listaCopie;
    }

    protected void setPrimul(Element<T> elem) {
        primul = elem;
    }
    protected void setUltimul(Element<T> elem) {
        ultimul = elem;
    }
    public T get(int index) {
        if (index < 0 || index >= dimensiune) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + dimensiune);
        }
        Element<T> current = primul;
        for (int i = 0; i < index; i++) {
            current = current.urm;
        }
        return current.info;
    }
    public void eliminaToateElementele ( ) {
        primul = ultimul = null;
        dimensiune = 0;
    }
    @Override
    public String toString() {
        StringBuilder rez=new StringBuilder("[");
        for (Element<T> elemCrt = primul; elemCrt != null;
             elemCrt = elemCrt.urm) {
            rez.append(elemCrt.info);
            if ( elemCrt.urm != null) rez.append(", ");
        }
        return rez.append("]").toString();
    }private class IteratorLst<T> implements Iterator<T> {
        private Element<T> pcrt;
        public IteratorLst(Element<T> prim) {
            this.pcrt = prim;
        }
        @Override
        public boolean hasNext(){
            return pcrt != null;
        }
        @Override
        public T next() throws NoSuchElementException {
            Element<T> el = pcrt;
            if(el==null) throw new NoSuchElementException();
            pcrt = pcrt.urm;
            return el.info;
        }
    } // sfarsit private class IteratorLst<T> implements Iterator<T>
} // sfarsit class ListaGenerica<T> implements Iterable<T>
