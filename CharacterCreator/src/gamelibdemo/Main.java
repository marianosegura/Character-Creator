/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelibdemo;

import gamelib.Direction;
import gamelib.GamePrototypes;
import gamelib.SpriteSet;
import gamelib.Weapon;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class Main {
    public static void main(String[] args) {
        // Builders
        Gun gun = new GunBuilder()  
            .setName("Gun #1")
            .setImage("url")
            .setDamage(5)
            .setLevel(3)
            .setX(0)
            .setY(0)
            .setScope(2)
            .setExplosionRange(1)
            .setMaxSupplies(12)
            .setLevelMultiplier(2)
            .setLevelDependant(true)
            .setRecoil(3)
            .build();
        
        SpriteSet gunnerBasicSprites = new SpriteSet();
        gunnerBasicSprites.addSprite("idle", "url #1");
        gunnerBasicSprites.addSprite("shooting", "url #2");
        
        Gunner gunner = new GunnerBuilder()
            .setName("Gunner #1")
            .addWeapon(gun)  // adding created weapon
            .addSpriteSet(1, gunnerBasicSprites)  // adding sprites for level 1
            .setDamage(10)
            .setLevel(1)
            .setX(0)
            .setY(0)
            .setSize(4)
            .setMaxHealth(20)
            .setHitsPerTimeUnit(2)
            .setCost(5)
            .setUnlockLevel(1)
            .setMoveSteps(3)
            .setDirection(Direction.LEFT)
            .build();
        
        // Prototypes
        GamePrototypes<Weapon> weapons = new GamePrototypes<>();  // general weapons
        weapons.addPrototype(gun.getName(), gun);
        
        GamePrototypes<Gun> guns = new GamePrototypes<>();  // concrete guns
        guns.addPrototype(gun.getName(), gun);
        
        Gun gun2 = (Gun) weapons.getPrototypeDeepClone(gun.getName());  // needs casting
        Gun gun3 = guns.getPrototypeDeepClone(gun.getName());  // doesn't need casting
        
        GamePrototypes<Gunner> gunners = new GamePrototypes<>();  // concrete gunner
        gunners.addPrototype(gunner.getName(), gunner);
        
        Gunner gunner2 = gunners.getPrototypeDeepClone(gunner.getName());
                        
        System.out.println("gamelib demo done!");
    }
}
