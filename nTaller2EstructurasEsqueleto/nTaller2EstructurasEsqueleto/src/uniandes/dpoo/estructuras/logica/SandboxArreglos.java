package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
        return java.util.Arrays.copyOf(arregloEnteros, arregloEnteros.length);
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
        return java.util.Arrays.copyOf(arregloCadenas, arregloCadenas.length);
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int n = arregloEnteros.length;
        int[] nuevo = new int[n + 1];
        System.arraycopy(arregloEnteros, 0, nuevo, 0, n);
        nuevo[n] = entero;
        arregloEnteros = nuevo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
        int n = arregloCadenas.length;
        String[] nuevo = new String[n + 1];
        System.arraycopy(arregloCadenas, 0, nuevo, 0, n);
        nuevo[n] = cadena;
        arregloCadenas = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int n = arregloEnteros.length;
        int contarNoIguales = 0;
        for (int i = 0; i < n; i++) {
            if (arregloEnteros[i] != valor) contarNoIguales++;
        }
        int[] nuevo = new int[contarNoIguales];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arregloEnteros[i] != valor) nuevo[j++] = arregloEnteros[i];
        }
        arregloEnteros = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        int n = arregloCadenas.length;
        int contarNoIguales = 0;
        for (int i = 0; i < n; i++) {
            String s = arregloCadenas[i];
            boolean iguales = (cadena == null ? s == null : cadena.equals(s));
            if (!iguales) contarNoIguales++;
        }
        String[] nuevo = new String[contarNoIguales];
        int j = 0;
        for (int i = 0; i < n; i++) {
            String s = arregloCadenas[i];
            boolean iguales = (cadena == null ? s == null : cadena.equals(s));
            if (!iguales) nuevo[j++] = s;
        }
        arregloCadenas = nuevo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
        int n = arregloEnteros.length;
        int pos = posicion;
        if (pos < 0) pos = 0;
        if (pos > n) pos = n;
        int[] nuevo = new int[n + 1];
        System.arraycopy(arregloEnteros, 0, nuevo, 0, pos);
        nuevo[pos] = entero;
        System.arraycopy(arregloEnteros, pos, nuevo, pos + 1, n - pos);
        arregloEnteros = nuevo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        int n = arregloEnteros.length;
        if (posicion < 0 || posicion >= n) return;
        int[] nuevo = new int[n - 1];
        System.arraycopy(arregloEnteros, 0, nuevo, 0, posicion);
        if (posicion < n - 1) {
            System.arraycopy(arregloEnteros, posicion + 1, nuevo, posicion, n - posicion - 1);
        }
        arregloEnteros = nuevo;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        if (valores == null) { arregloEnteros = new int[]{}; return; }
        int n = valores.length;
        int[] nuevo = new int[n];
        for (int i = 0; i < n; i++) {
            nuevo[i] = (int) valores[i]; // truncado hacia 0
        }
        arregloEnteros = nuevo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
        if (objetos == null) { arregloCadenas = new String[]{}; return; }
        int n = objetos.length;
        String[] nuevo = new String[n];
        for (int i = 0; i < n; i++) {
            Object o = objetos[i];
            nuevo[i] = (o == null) ? "null" : o.toString();
        }
        arregloCadenas = nuevo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) arregloEnteros[i] = -arregloEnteros[i];
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
        java.util.Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
        java.util.Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
        int c = 0;
        for (int v : arregloEnteros) {
            if (v == valor) c++;
        }
        return c;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        int c = 0;
        for (String s : arregloCadenas) {
            if (cadena == null ? s == null : (s != null && s.equalsIgnoreCase(cadena))) c++;
        }
        return c;

    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
        int n = arregloEnteros.length;
        int cuenta = 0;
        for (int i = 0; i < n; i++) {
            if (arregloEnteros[i] == valor) cuenta++;
        }
        int[] pos = new int[cuenta];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arregloEnteros[i] == valor) pos[j++] = i;
        }
        return pos;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        int n = arregloEnteros.length;
        if (n == 0) return new int[0];
        int min = arregloEnteros[0];
        int max = arregloEnteros[0];
        for (int i = 1; i < n; i++) {
            int v = arregloEnteros[i];
            if (v < min) min = v;
            if (v > max) max = v;
        }
        return new int[]{ min, max };
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
        HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        for (int v : arregloEnteros) {
            Integer c = mapa.get(v);
            mapa.put(v, c == null ? 1 : c + 1);
        }
        return mapa;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
        HashMap<Integer, Integer> mapa = calcularHistograma();
        int rep = 0;
        for (Integer k : mapa.keySet()) {
            Integer c = mapa.get(k);
            if (c != null && c > 1) rep++;
        }
        return rep;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (otroArreglo == null) return false;
        if (arregloEnteros.length != otroArreglo.length) return false;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) return false;
        }
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        if (otroArreglo == null) return false;
        if (arregloEnteros.length != otroArreglo.length) return false;
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int v : arregloEnteros) {
            Integer c = freq.get(v);
            freq.put(v, c == null ? 1 : c + 1);
        }
        for (int v : otroArreglo) {
            Integer c = freq.get(v);
            if (c == null || c == 0) return false;
            freq.put(v, c - 1);
        }
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        if (cantidad < 0) cantidad = 0;
        if (minimo > maximo) { int tmp = minimo; minimo = maximo; maximo = tmp; }
        arregloEnteros = new int[cantidad];
        int rango = maximo - minimo + 1;
        for (int i = 0; i < cantidad; i++) {
            int v = minimo + (int) Math.floor(Math.random() * rango);
            arregloEnteros[i] = v;
    }
    }
}
