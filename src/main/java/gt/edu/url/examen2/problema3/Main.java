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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //crear la lista posicional
        PositionList<Integer> problema3 = new PositionList<>();
        Position<Integer> pos1,pos2,pos3;       //crea tres posiciones
        
        pos1 = problema3.addFirst(3);
        pos2 = problema3.addLast(4);
        pos3 = problema3.addLast(5);
        
          problema3.swap(pos2, pos3);           //metodo para hacer el cambio de posiciones
        do{
            System.out.println(problema3.remove(pos1));
            System.out.println(problema3.remove(pos2));
            System.out.println(problema3.remove(pos3));
        }while(!problema3.isEmpty());
        
      
        
        
        
    }
    
}
