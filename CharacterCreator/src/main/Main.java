/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gamelib.AbstractCharacter;
import gamelib.AbstractWeapon;
import gamelib.GamePrototypes;
import controller.JsonData;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        JsonData j = JsonData.getInstance();
        List<AbstractWeapon> weapons = new ArrayList<AbstractWeapon>();
        weapons = j.loadWeapon();
        GamePrototypes<AbstractWeapon> Weapons = new GamePrototypes<AbstractWeapon>();
        for (AbstractWeapon a : weapons ){
//            System.out.println(a.getSprites());
            Weapons.addPrototype(a.getName(), a);
        }
        System.out.println("Weapons loaded.");
        
       
        
        List<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
        characters = j.loadCharacter();
        GamePrototypes<AbstractCharacter> Characters = new GamePrototypes<AbstractCharacter>();
        for (AbstractCharacter b : characters ){
            
            Characters.addPrototype(b.getName(), b);
//            System.out.println(b.getWeapons());
        }
        System.out.println("characters loaded.");
        
         //save
        j.writeJsonWeapons(Weapons);
        System.out.println("OK");
        j.writeJsonCharacters(Characters);
    }
    
}
