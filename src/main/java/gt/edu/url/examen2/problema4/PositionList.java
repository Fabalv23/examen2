/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema4;

/**
 *
 * @author fabia
 */
public class PositionList<E> implements PositionalList<E> {

    @Override
    public Position<E> positionAtIndex(int i) {
       int cont = 0;
        if (i>tamanio) {
            throw new IndexOutOfBoundsException();
        }else if(i==0){
            return first();
        }else{
      
            Nodo<E> pivote=header.getNext();
            
            for (int j = 0; j <= i-1; j++) {
                pivote=pivote.getNext();
            }
            
            return position(pivote);
            
            
        }
                  
        }
        
        
        
    

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
			throw new IllegalArgumentException("La posicion P es inexistente");
		Nodo<E> node = (Nodo<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("P dejo de existir");
		return node;
	}
        
        private Position<E> position(Nodo<E> nodo) {
		if (nodo == header || nodo == trailer)
			return null; // do not expose user to the sentinels
		return nodo;
	}
               
        
    @Override
    public int size() {
       return tamanio;
    }

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

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
      Nodo<E> n1 = validar(p);
		E re = n1.getElement();
		n1.setElement(e);
		return re;
    }

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

   
    
    
    
}

