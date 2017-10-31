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
public class Problema4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PositionList<Integer> problema3 = new PositionList<>();     //instancia la lista posicional
        Position<Integer> pos1,pos2,pos3;       //posiciones
        
    pos1 =problema3.addFirst(3);        //declaro la posicion 1
    pos2 = problema3.addLast(2);        //declaro la posicion 2
    pos3=problema3.addLast(5);          // declaro la posicion3
    System.out.println("la posicion es (valor en esa posicion) " + problema3.positionAtIndex(1).getElement());           //busca la posicion que se ponga como parametro en el metodo
     do{
            System.out.println(problema3.remove(pos1));
            System.out.println(problema3.remove(pos2));
            System.out.println(problema3.remove(pos3));
        }while(!problema3.isEmpty());
        
       
          
        
    }
    
}
