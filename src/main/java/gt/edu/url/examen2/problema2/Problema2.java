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
public class Problema2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            
        DemostracionLista d1 = new DemostracionLista();
        List<Integer> temp = d1.crearDemoLista();
      
        
        do{
            System.out.println(temp.remove(0));
        }while(!temp.isEmpty());
        
    }
    
}
