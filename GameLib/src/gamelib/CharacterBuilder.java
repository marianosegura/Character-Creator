/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.HashMap;

/**
 * Generic character builder.
 * @author Luis Mariano Ramírez Segura
 */
public class CharacterBuilder extends AbstractCharacterBuilder<Character, CharacterBuilder>{    
    @Override
    public Character build() {
        return new Character(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, spriteSets, weapons, equipedWeapon, direction, name, damage, level, x, y);
    }
    public CharacterBuilder (Character oldCharacter){
        this.x = oldCharacter.getX();
        this.y = oldCharacter.getY();
        this.name = oldCharacter.getName();
        this.damage = oldCharacter.getDamage();
        this.level = oldCharacter.getLevel();
        this.size = oldCharacter.getSize();
        this.maxHealth = oldCharacter.getMaxHealth();
        this.health = oldCharacter.getHealth();
        this.hitsPerTimeUnit = oldCharacter.getHitsPerTimeUnit();
        this.cost = oldCharacter.getCost();
        this.unlockLevel = oldCharacter.getUnlockLevel();
        this.spriteState = oldCharacter.getSpriteState();
        this.spriteSets = oldCharacter.getSpriteSets();
        this.weapons = oldCharacter.getWeapons();
        this.direction = oldCharacter.getDirection();
        this.moveSteps = oldCharacter.getMoveSteps();
    }
    public CharacterBuilder(){
    }
    public HashMap<Integer, SpriteSet> getSpriteSets(){
        return this.spriteSets;
    }
}
