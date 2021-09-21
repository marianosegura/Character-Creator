/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.HashMap;

/**
 * Prototype prototype registry based on user defined identifiers.
 * @author Luis Mariano Ramírez Segura
 * @author Esteban Guzmán Ramírez
 * @param <T> Class that implements IPrototype
 */
public class GamePrototypes<T extends IPrototype> {
    private HashMap<String, T> objects = new HashMap<>();  // hashmap of registered prototypes    
    
    /**
     * Returns a shallow clone of a prototype.
     * @param id Prototype identifier
     * @return Shallow clone of prototype
     */
    public T getPrototypeClone(String id){      
        return (T) objects.get(id).shallowClone(); 
    }
    
    /**
     * Returns a deep clone of a prototype.
     * @param id Prototype identifier
     * @return Deep clone of prototype
     */
    public T getPrototypeDeepClone(String id){      
        return (T) objects.get(id).deepClone(); 
    }       
    
    /**
     * Adds a prototype to the registry.
     * @param id Prototype identifier
     * @param object Prototype to be added
     */
    public void addPrototype(String id, T object){   
        objects.put(id, object);   
    }
}
