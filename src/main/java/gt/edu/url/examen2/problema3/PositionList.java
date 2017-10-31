/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema3;

/**
 *
 * @author fabia
 */
public class PositionList<E> implements PositionalList<E> {
/**
 * Nodo para crear la lista posicional
 * @param <E> 
 */
    private static class Nodo<E> implements Position<E> {
		private E elemento;
		private Nodo<E> previo;// Anterior
		private Nodo<E> siguiente;// Siguiente

		public Nodo(E e, Nodo<E> p, Nodo<E> n) {
			elemento = e;
			previo = p;
			siguiente = n;
		}

		public E getElement() throws IllegalStateException {
			if (siguiente == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
			return elemento;
		}
		
		public void setElement(E e) {
			elemento = e;
		}

		public Nodo<E> getPrev() {
			return previo;
		}

		public void setPrev(Nodo<E> prev) {
			this.previo = prev;
		}

		public Nodo<E> getNext() {
			return siguiente;
		}

		public void setNext(Nodo<E> next) {
			this.siguiente = next;
		}

	}
    
    private Nodo<E> header = null;// Referencia
	private Nodo<E> trailer = null;
	private int tamanio = 0;
        
        public PositionList() {
		header = new Nodo<>(null, null, null);
		trailer = new Nodo<>(null, header, null);
		header.setNext(trailer);
	}
        
        private Nodo<E> validar(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Nodo))
			throw new IllegalArgumentException("La posicion P es inexistente");     //Cuando no encuentra la posicion
		Nodo<E> node = (Nodo<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("P dejo de existir");            // no encuntra la posicion
		return node;
	}
        
        private Position<E> position(Nodo<E> nodo) {        //obtener la posicion
		if (nodo == header || nodo == trailer)
			return null; // do not expose user to the sentinels
		return nodo;
	}
               
        //Devuelve la cantidad
    @Override
    public int size() {
       return tamanio;
    }
//Esta vacia o no
    @Override
    public boolean isEmpty() {
       return tamanio==0;
    }

    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
      return position(trailer.getPrev());
    }
    
    	private Position<E> addBetween(E e, Nodo<E> prede, Nodo<E> suce) {
		Nodo<E> nuevo = new Nodo<>(e, prede, suce);
		suce.setPrev(nuevo);
		prede.setNext(nuevo);
                tamanio++;
		return nuevo;
	}

    @Override
    public Position<E> addFirst(E e) {
      return addBetween(e, header, header.getNext());                    
    }

    @Override
    public Position<E> addLast(E e) {
       return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Nodo<E> n1 = validar(p);
		return position(n1.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Nodo<E> n1 = validar(p);
		return position(n1.getNext());
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
       Nodo<E> n1 = validar(p);
		return addBetween(e, n1.getPrev(), n1);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Nodo<E> n2 = validar(p);
		return addBetween(e, n2, n2.getNext());
    }
//establecer la posicion nueva
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
                Nodo<E> n1 = validar(p);
		E re = n1.getElement();
		n1.setElement(e);
		return re;
    }
/**
 * remover la posicion que le de al usuario
 * @param p
 * @return
 * @throws IllegalArgumentException 
 */
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
       Nodo<E> n2 = validar(p);
		Nodo<E> predecessor = n2.getPrev();
		Nodo<E> successor = n2.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		tamanio--;
		E res = n2.getElement();
		n2.setElement(null);
		n2.setNext(null);
		n2.setPrev(null);
		return res;
    }

    /**
     * Cambia posiciones y nodos
     * @param p
     * @param q 
     */
    @Override
    public void swap(Position<E> p, Position<E> q) {
        
     E temp = null;     //obtendra el valor a cambiar en el segundo
        
     
      temp= set(p,q.getElement());      //Establece el el valor obtenido en temp
      set(q,temp);      //poner en la segunda posicion el valor temp
             
    }
    
    
    
}
