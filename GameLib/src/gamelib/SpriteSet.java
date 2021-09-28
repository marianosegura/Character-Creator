/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Structure that holds a different sprites based on states (jumping, attacking etc), meant to be used for different levels of a character.
 * @author Luis Mariano Ramírez Segura
 */
public class SpriteSet  implements IPrototype {
    private HashMap<String, String> sprites = new HashMap<>();  // maps string state to string image url
 
    /**
     * Adds a sprite for a given state
     * @param state Character state (jumping, attacking etc)
     * @param sprite Sprite url
     */
    public void addSprite(String state, String sprite) {
        sprites.put(state, sprite);
    }
    
    /**
     * Retrieves a sprite given a state.
     * @param state Character state (jumping, attacking etc)
     * @return Sprite url
     */
    public String getSprite(String state) {
        return sprites.get(state);
    }
    
    public ArrayList<String> getKeys(){
        return new ArrayList<String>(sprites.keySet());
    }

    @Override
    public IPrototype shallowClone() {
        return new SpriteSet();  // empty sprites
    }

    @Override
    public IPrototype deepClone() {
        SpriteSet set = new SpriteSet();
        for(String state: sprites.keySet()) {  // copy sprites
            set.addSprite(state, sprites.get(state));
        }
        return set;
    }
}
