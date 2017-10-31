/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema2;

/**
 *
 * @author fabia
 */
public class ArrayList<E> implements List<E> {
    
    
    public static final int capacidad = 1;  //Capacidad a redimensionar 1
    private E[] valor;
    private int tamanio = 0;
    
    
    

    public ArrayList() {
        this(capacidad);
    }

    public ArrayList(int capacidad) {
        valor = (E[]) new Object[capacidad];
    }
    /**
     * valida una posicion para ver si si esta disponible
     * @param i
     * @param n 
     */
    protected void validar(int i, int n) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }
    
    /**
     * Para duplicar la cantidad de la capacidad
     * @param capacidad 
     */
    protected void redimensionar(int capacidad) {
        E[] temp = (E[]) new Object[capacidad];
        for (int k = 0; k < tamanio; k++)
            temp[k] = valor[k];
            valor = temp;
        
    }
/**
 * tamaño
 * @return 
 */
    @Override
    public int size() {
        return tamanio;
    }
/**
 * esta vacio o no
 * @return 
 */
    @Override
    public boolean isEmpty() {
        return tamanio == 0;
    }
/**
 * obtiene el valor
 * @param i
 * @return 
 */
    @Override
    public E get(int i) {
        validar(i, tamanio);
        return valor[i];
    }
/**
 * poner los valores en ciertas posiciones
 * @param i
 * @param e
 * @return 
 */
    @Override
    public E set(int i, E e) {
        validar(i, tamanio);
        E temp = valor[i];
        valor[i] = e;
        return temp;
    }
/**
 * agregar un nuevo elemento
 * @param i
 * @param e 
 */
    @Override
    public void add(int i, E e) {
      validar(i, tamanio + 1);
		if (tamanio == valor.length)
			redimensionar(2 * valor.length);
		for (int k = tamanio - 1; k >= i; k--)
			valor[k + 1] = valor[k];
		valor[i] = e; 
		tamanio++;
    }
/**
 * remover el valor en ciertas posiciones
 * @param i
 * @return
 * @throws IndexOutOfBoundsException 
 */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        	validar(i, tamanio);
		E temp = valor[i];
		for (int k = i; k < tamanio - 1; k++)
			valor[k] = valor[k + 1];
		valor[tamanio - 1] = null;
		tamanio--;
		return temp;
    }

    
}
