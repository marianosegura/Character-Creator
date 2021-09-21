/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Generic builder interface.
 * @author Luis Mariano Ramírez Segura
 * @param <T> Concrete built class
 */
public interface IBuilder<T> {
    public T build();
}
