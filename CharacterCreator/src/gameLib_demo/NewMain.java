/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLib_demo;

import gamelib.AbstractCharacter;
import gamelib.AbstractWeapon;
import gamelib.Character;
import gamelib.CharacterBuilder;
import gamelib.GamePrototypes;
import controller.JsonData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esteban
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        System.out.println("Using System Property: " + os);
        JsonData j = JsonData.getInstance();
        List<AbstractWeapon> weapons = new ArrayList<AbstractWeapon>();
        weapons = j.loadWeapon();
        GamePrototypes<AbstractWeapon> Weapons = new GamePrototypes<AbstractWeapon>();
        for (AbstractWeapon a : weapons ){
            Weapons.addPrototype(a.getName(), a);
        }
        System.out.println("Weapons loadeda.");
        
        List<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
        characters = j.loadCharacter();
        GamePrototypes<AbstractCharacter> Characters = new GamePrototypes<AbstractCharacter>();
        for (AbstractCharacter b : characters ){
            Characters.addPrototype(b.getName(), b);
            //System.out.println(b.getEquipedWeapon());
        }
        System.out.println("characters loaded.");
        String nameTest = "barbaro";
        AbstractCharacter test = Characters.getPrototypeDeepClone(nameTest);
        System.out.println("Weapons: "+test.getWeapons());
        System.out.println("Set weapon of index 0 :"+test.getWeapons().get(0));
        CharacterBuilder builder = new CharacterBuilder((Character) test);
        builder.setEquipedWeapon(0);
        System.out.println("Null when change equiped weapon: " + builder.build().getEquipedWeapon());
        
    }
    
}
