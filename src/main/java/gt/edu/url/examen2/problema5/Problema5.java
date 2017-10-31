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
public class Problema5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //crear una pila dinamica
        DynamicStack<Integer> d1 = new DynamicStack<>();
        d1.push(15);
        d1.push(25);
        d1.push(35);
        d1.push(45);
        d1.push(55);
        d1.push(65);
        d1.push(75);
        
        //imprime la pila, con la caracteristica de una pila
        do{
            System.out.println(d1.pop());
        }while(!d1.isEmpty());
        
        
        
        
        
    }
    
}
