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
    
    
    public static final int capacidad = 1;
    private E[] valor;
    private int tamanio = 0;
    
    
    

    public ArrayList() {
        this(capacidad);
    }

    public ArrayList(int capacidad) {
        valor = (E[]) new Object[capacidad];
    }

    protected void validar(int i, int n) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    protected void redimensionar(int capacidad) {
        E[] temp = (E[]) new Object[capacidad];
        for (int k = 0; k < tamanio; k++)
            temp[k] = valor[k];
            valor = temp;
        
    }

    @Override
    public int size() {
        return tamanio;
    }

    @Override
    public boolean isEmpty() {
        return tamanio == 0;
    }

    @Override
    public E get(int i) {
        validar(i, tamanio);
        return valor[i];
    }

    @Override
    public E set(int i, E e) {
        validar(i, tamanio);
        E temp = valor[i];
        valor[i] = e;
        return temp;
    }

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
