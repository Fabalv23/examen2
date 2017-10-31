/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema5;

/**
 *
 * @author fabia
 */
public class DynamicStack<E> implements Stack<E> {

   
    private E[] valor;
    private int tamanio = 0;
    /**
     * NODO PARA NAVEGAR
     * @param <E> 
     */
    private static class Nodo<E> {
		private E elemento;
		private Nodo<E> previo;//Anterior
		private Nodo<E> siguiente;//Siguiente

		public Nodo(E e, Nodo<E> p, Nodo<E> n) {
			elemento = e;
			previo = p;
			siguiente = n;
		}

		public E getElement() {
			return elemento;
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

	private Nodo<E> header = null;//Referencia
	private Nodo<E> trailer = null;
	
        /**
         * crear el constructor
         */
        public DynamicStack() {
		header = new Nodo<>(null, null, null);
		trailer = new Nodo<>(null, header, null);
		header.setNext(trailer);
	}
        /**
         * agregar entre los indicados
         * @param e
         * @param predecessor
         * @param successor 
         */
        private void addBetween(E e, Nodo<E> predecessor, Nodo<E> successor) {
		Nodo<E> newest = new Nodo<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		tamanio++;
	}
        
        private E remove(Nodo<E> node) {
		Nodo<E> predecessor = node.getPrev( );
		Nodo<E> successor = node.getNext( );
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		tamanio--;
		return node.getElement( );
	}
        
   public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
   
   

    @Override
    public int size() {
       return tamanio;
    }

    @Override
    public boolean isEmpty() {
        return tamanio==0;
    }
/**
 * insertar en pila
 * @param e 
 */
    @Override
    public void push(E e) {
       addBetween(e, trailer.getPrev(), trailer);
    }
/**
 * obetener el ultimo
 * @return 
 */
    public E last() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getElement();
	}
    
    public E removeLast() {
		if (isEmpty())
			return null;
		return remove(trailer.getPrev());
	}
  /**
   * obtener el ultimo de la pila
   * @return 
   */  
    @Override
    public E top() {
       return removeLast();
    }
/**
 * sacar el ultimo de la pila
 * @return 
 */
    @Override
    public E pop() {
        return removeLast();
    }
    
    
    
    
    
}
