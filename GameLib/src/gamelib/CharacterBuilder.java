/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Generic character builder.
 * @author Luis Mariano Ramírez Segura
 */
public class CharacterBuilder extends AbstractCharacterBuilder<Character, CharacterBuilder>{    
    @Override
    public Character build() {
        return new Character(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, spriteSets, weapons, null, direction, name, damage, level, x, y);
    }
    
}
