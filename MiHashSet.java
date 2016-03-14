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
}