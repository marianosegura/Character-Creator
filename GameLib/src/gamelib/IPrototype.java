/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Basic interface for a clonable object.
 * @author Luis Mariano Ramírez Segura
 * @param <T> Type of the class implementing this interface.
 */
public interface IPrototype {
    public IPrototype shallowClone();
    public IPrototype deepClone();
}