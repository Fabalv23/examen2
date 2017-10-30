/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.examen2.problema2;

import java.util.Iterator;

/**
 *
 * @author fabia
 */
public class DemostracionLista<E> implements DemoList  {
    
    @Override
    public List<Integer> crearDemoLista() {
        List<Integer> Problema2 = new ArrayList<>();
        Problema2.add(0,4);
        Problema2.add(0,3);
        Problema2.add(0,2);
        Problema2.add(2,1);
        Problema2.add(1,5);
        Problema2.add(1,6);
        Problema2.add(3,7);
        Problema2.add(0,8);
        
        
        
        return Problema2;
        
    }

}
