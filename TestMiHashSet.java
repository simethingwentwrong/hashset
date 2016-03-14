/**
 * Testea la clase MiHashMap.
 * 
 * @author Miguel Bayón 
 * @version 1.0
 */
public class TestMiHashSet
{
    private int numeroTestsFallados;

    /**
     * Constructor for objects of class TestArrayListInt
     */
    public TestMiHashSet()
    {   
        numeroTestsFallados = 0;    
        
        //size y isEmpty
        System.out.println("Creando hashset vacio...");
        MiHashSet hashset = new MiHashSet();  
        numeroTestsFallados += testea(0, hashset.size(), "size()");
        numeroTestsFallados += testea(true, hashset.isEmpty(), "isEmpty()");
        
        //cointains
        System.out.println();
        System.out.println("Testeando contains en un hashset vacio...");
        numeroTestsFallados += testea(false, hashset.contains(5), "contains(5)");
        
        //clear
        System.out.println();
        System.out.println("Vaciando hashset vacio...");
        hashset.clear();
        numeroTestsFallados += testea(0, hashset.size(), "clear()");
        
        //toString
        System.out.println();
        System.out.println("Obteniendo la representacion en cadena del conjunto...")    ;   
        numeroTestsFallados += testea("[]", hashset.toString(), "toString");            
        
        //add
        System.out.println();
        System.out.println("Añadiendo 3 elementos...");
        numeroTestsFallados += testea(true, hashset.add(9), "add(9)");
        numeroTestsFallados += testea(true, hashset.add(3), "add(3)");
        numeroTestsFallados += testea(true, hashset.add(6), "add(6)");  
        
        //contains
        System.out.println();
        System.out.println("Comprobando si los elementos metidos pertenecen al hashset...");    
        numeroTestsFallados += testea(true, hashset.contains(9), "contains(9)");
        numeroTestsFallados += testea(true, hashset.contains(3), "contains(3)");
        numeroTestsFallados += testea(true, hashset.contains(6), "contains(6)"); 
 
        //contains
        System.out.println();
        System.out.println("Comprobando si elementos no metidos pertenecen al hashset...");    
        numeroTestsFallados += testea(false, hashset.contains(12), "contains(12)");
        numeroTestsFallados += testea(false, hashset.contains(0), "contains(0)");
        numeroTestsFallados += testea(false, hashset.contains(1000), "contains(1000)");         
              
        //add
        System.out.println();
        System.out.println("Añadiendo elementos que ya estaban...");
        numeroTestsFallados += testea(false, hashset.add(9), "add(9)");
        numeroTestsFallados += testea(false, hashset.add(3), "add(3)");
        numeroTestsFallados += testea(false, hashset.add(6), "add(6)");

        //size y isEmpty    
        numeroTestsFallados += testea(3, hashset.size(), "size()");    
        numeroTestsFallados += testea(false, hashset.isEmpty(), "isEmpty()");
              
        //clear
        System.out.println();
        System.out.println("Vaciando hashset con elementos...");
        hashset.clear();
        numeroTestsFallados += testea(0, hashset.size(), "clear()");        

        //add
        System.out.println();
        System.out.println("Añadiendo 3 elementos...");
        numeroTestsFallados += testea(true, hashset.add(9), "add(9)");
        numeroTestsFallados += testea(true, hashset.add(3), "add(3)");
        numeroTestsFallados += testea(true, hashset.add(6), "add(6)");      
        
        //toString
        System.out.println();
        System.out.println("Obteniendo la representacion en cadena del conjunto...")    ;   
        numeroTestsFallados += testea("[9, 3, 6]", hashset.toString(), "toString");     
        
        //equals
        System.out.println();
        System.out.println("Comprobando si un conjunto es igual a otro...")    ;   
        MiHashSet otroHashSet = new MiHashSet();
        otroHashSet.add(3);
        otroHashSet.add(6);
        otroHashSet.add(9);
        MiHashSet hashSetVacio = new MiHashSet();
        numeroTestsFallados += testea(true, hashset.equals(otroHashSet), "equals(otroHashSet)");     
        numeroTestsFallados += testea(false, hashset.equals(hashSetVacio), "equals(hashSetVacio)");  
        otroHashSet.add(12);
        numeroTestsFallados += testea(false, hashset.equals(otroHashSet), "equals(otroHashSet)");    

        //remove
        System.out.println();
        System.out.println("Borrando elementos no existentes...")    ;   
        numeroTestsFallados += testea(false, hashset.remove(600), "remove(600)"); 
        numeroTestsFallados += testea(false, hashset.remove(60), "remove(60)"); 
        numeroTestsFallados += testea(false, hashset.remove(6000), "remove(6000)");        
        
        //size y isEmpty    
        numeroTestsFallados += testea(3, hashset.size(), "size()");    
        numeroTestsFallados += testea(false, hashset.isEmpty(), "isEmpty()");        
        
        //remove
        System.out.println();
        System.out.println("Borrando elementos existentes...")    ;   
        numeroTestsFallados += testea(true, hashset.remove(6), "remove(6)"); 
        numeroTestsFallados += testea(true, hashset.remove(3), "remove(3)"); 
        numeroTestsFallados += testea(true, hashset.remove(9), "remove(9)");         
        
        //size y isEmpty    
        numeroTestsFallados += testea(0, hashset.size(), "size()");    
        numeroTestsFallados += testea(true, hashset.isEmpty(), "isEmpty()");   
        
        //toString
        System.out.println();
        System.out.println("Obteniendo la representacion en cadena del conjunto...")    ;   
        numeroTestsFallados += testea("[]", hashset.toString(), "toString");        
        
        //equals
        System.out.println();
        System.out.println("Comprobando si un conjunto es igual a otro...")    ;   
        otroHashSet = new MiHashSet();
        otroHashSet.add(3);
        otroHashSet.add(6);
        otroHashSet.add(9);
        hashSetVacio = new MiHashSet();
        numeroTestsFallados += testea(false, hashset.equals(otroHashSet), "equals(otroHashSet)");     
        numeroTestsFallados += testea(true, hashset.equals(hashSetVacio), "equals(hashSetVacio)");         
        
        System.out.println();
        if (numeroTestsFallados == 0) {
            System.out.println("Todos los test se han pasado correctamente!!");
        }
        else {
            System.out.println("Han fallado " + numeroTestsFallados + " tests!!!");
        }
    }


    /**
     * Testea que el valorEsperado sea igual al valorObtenido; si no
     * son iguales devuelve 1 y muestra un mensaje por pantalla; si
     * son iuales devuelve 0 e informa por pantalla de que el test
     * indicado en nombreFuncion se ha pasado correctamente
     */
    public int testea(Object valorEsperado, Object valorObtenido, 
                          String nombreFuncion)
    {
        int valorDevuelto = 0;
        if (valorEsperado.equals(valorObtenido)) {
            System.out.println("OK: " + nombreFuncion);
        }
        else {
            System.out.println("ERROR!!!!! " + nombreFuncion);
            System.out.println("Valor obtenido: " + valorObtenido + 
                               " / Valor esperado: " + valorEsperado);
            valorDevuelto = 1;
        }
        return valorDevuelto;
    }

}

