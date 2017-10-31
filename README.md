# examen2
Espacio resolucion examen 2

#Solucion examen Parcial 2
-------------------------
Comentario Adicional: Se me dificulta un poco entender un poco lo de la calificacion en un demo, por lo que en cada problema hay un main, 
con el cual al probarlo se verifica que cada problema esta resuelto de la manera correcta

#Problema 2
-----------
![ ](https://image.ibb.co/eFYWfm/Problema2.jpg)
Codigo que fue agregado:
Se implemento una clase ArrayList que se redimensiona por si llega a un tope, esa clase arrayList implementa la interfaz List, para poderla usar
despues y declarar nuestra lista de tipo arraylist, y usar los metodos de add.
El orden de impresion es el siguiente:
imprimir 8,2,6,5,7,3,1,4

------------------
-------------------
#Problema 3
-----------
![ ](https://image.ibb.co/gRya6R/Problema3.jpg)
Codigo agregado: 
Se implemento de igual forma una lista posicional, aplicando la interfaces proveidas, y luego se programo el metodo swap para sus respectivos cambios
de la siguiente manera.

     E temp = null;     //obtendra el valor a cambiar en el segundo
        
     
      temp= set(p,q.getElement());      //Establece el el valor obtenido en temp
      set(q,temp);      //poner en la segunda posicion el valor temp
             
    }
 ---------------
 --------------
 #Problema 4
 -----------
 ![ ](https://image.ibb.co/gLYWfm/Problema4.jpg)
 Codigo Agregado:
 Se utilizo la misma clase que el ejercicio anterior solo que se le agrega el metodo de PositionatIndex, que devuelve la posicion que el usuario ingreso
 y asi puede evaluar si existe o no esa posicion proveida.
  Nodo<E> pivote=header.getNext();    //Nodo para recorrer la lista posicional
            
            for (int j = 0; j <= i-1; j++) {            //cambiando cada posicion
                pivote=pivote.getNext();
            }
            
            return position(pivote);        //retorna el valor
            
 -----------
 ----------
 #Problema 5
 ---------
 ![ ](https://image.ibb.co/cdEhmR/Problema5.jpg)
 Codigo agregado:
 Se hizo uso de una lista doble enlazada para poder darle un uso al remove last, ya que la funcion de una pila, es que siempre obtenga el ultimo
 que ingreso, a diferencia de un arrayList, es posible, pero hay que manipular bien la posicion y su insercion, ademas que que la lista doble enlazada
 maneja dinamica su tamanio, asi que no tendra un limite, y evitar tener que usar la funcion de redimensionar.
 
 
