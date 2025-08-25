package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman las valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        java.util.ArrayList<String> r = new java.util.ArrayList<String>(mapaCadenas.values());
        java.util.Collections.sort(r);
        return r;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        java.util.ArrayList<String> r = new java.util.ArrayList<String>(mapaCadenas.keySet());
        java.util.Collections.sort(r, java.util.Collections.reverseOrder());
        return r;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) return null;
        String min = null;
        for (String k : mapaCadenas.keySet()) {
            if (k == null) continue;
            if (min == null || k.compareTo(min) < 0) min = k;
        }
        return min;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) return null;
        String max = null;
        for (String v : mapaCadenas.values()) {
            if (v == null) continue;
            if (max == null || v.compareTo(max) > 0) max = v;
        }
        return max;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
        java.util.ArrayList<String> r = new java.util.ArrayList<String>();
        for (String k : mapaCadenas.keySet()) {
            if (k == null) r.add(null);
            else r.add(k.toUpperCase());
        }
        return r;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
        return new java.util.HashSet<String>(mapaCadenas.values()).size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
        String llave = invertir(cadena);
        mapaCadenas.put(llave, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
        java.util.Iterator<Map.Entry<String,String>> it = mapaCadenas.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,String> e = it.next();
            String v = e.getValue();
            if (valor == null ? v == null : valor.equals(v)) it.remove();
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        if (objetos == null) return;
        for (Object o : objetos) {
            String s = (o == null) ? "null" : o.toString();
            mapaCadenas.put(invertir(s), s);
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
        Map<String,String> nuevo = new HashMap<String,String>();
        for (Map.Entry<String,String> e : mapaCadenas.entrySet()) {
            String k = e.getKey();
            String v = e.getValue();
            String nk = (k == null) ? null : k.toUpperCase();
            nuevo.put(nk, v);
        }
        mapaCadenas = nuevo;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        if (otroArreglo == null) return false;
        Collection<String> vals = mapaCadenas.values();
        for (String s : otroArreglo) {
            if (!vals.contains(s)) return false;
        }
        return true;
    }

    private String invertir(String s)
    {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }
}

