public class MiHashSet
{
    private int[] coleccion;
    
    public MiHashSet()
    {
        coleccion = new int[0];
    }
    
     /**
     * añade el elemento al conjunto si no estaba. Prueba
     * Devuelve verdadero en caso de que el elemento no estuviera presente en el conjunto y falso en caso contrario.
     */
    public boolean add(int valor)
    {
        boolean noContenido = true;      
        int[] newColeccion = new int[coleccion.length+1];

        for(int i = 0; i < coleccion.length && noContenido; i++){
            if(coleccion[i] == valor){
                noContenido = false;
            }
            else{
                newColeccion[i] = coleccion[i];
            }
        }

        if(noContenido){
            newColeccion[newColeccion.length-1] = valor;
            coleccion = newColeccion;
        }

        return noContenido;
    }
    
    /**
     *  vacía el conjunto.
     */
    public void clear()
    {
        coleccion = new int[0];
    }
    
    /**
     *  devuelve verdadero si el conjunto contiene el elemento, falso en caso contrario.
     */
    public boolean contains(int elemento)
    { 
        boolean contains = false;

        for(int i = 0; i < coleccion.length && !contains; i++){
            if(coleccion[i] == elemento){
                contains = true;
            }
        }

        return contains;
    }
    
    /**
     *  devuelve verdadero si el conjunto no contiene elementos.
     */
    public boolean isEmpty()
    {
        return coleccion.length==0;

    }
    
     /**
     * elimina del conjunto el elemento dado. Si no existiera devuelve falso; si existía en el conjunto devuelve verdadero.
     */
    public boolean remove(int elemento)
    {
        boolean eliminar = false;
        if(coleccion.length != 0)
        {
            int[] newColeccion  = new int[coleccion.length - 1];
            for(int index = 0; index < coleccion.length ; index++ )
            {
                if (coleccion[index] == elemento){
                     eliminar = true;
                }
                else if(!eliminar){
                    if(index != coleccion.length - 1 ){
                        newColeccion[index]   = coleccion[index];
                    }
                } 
                else{
                    newColeccion[index - 1]   = coleccion[index];
                }
            }
            if(eliminar){ 
                coleccion   = newColeccion;
            }
        }
        return eliminar;
    }
    
    /**
     * devuelve el número de elementos del conjunto.
     */
    public int size(){
        return coleccion.length;
    }

}