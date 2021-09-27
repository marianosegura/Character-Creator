/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gamelib.Character;
import gamelib.CharacterBuilder;
import gamelib.Weapon;
import gamelib.WeaponBuilder;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author esteban
 */
public class ViewController {
    
    private ArrayList<Character> characterList;
    private ArrayList<Weapon> weaponList;
    private CharacterBuilder actualCharacter;
    private WeaponBuilder actualWeapon;
    private Character dataCharacter;
    private Weapon dataWeapon;

    public ViewController() {
        characterList = new ArrayList<Character>();
        weaponList = new ArrayList<Weapon>();
        actualCharacter = new CharacterBuilder();
        actualWeapon = new WeaponBuilder();
    }
    
    public DefaultListModel getListModelCharacters(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < characterList.size(); i++) {
            listModel.addElement(characterList.get(i).getName() + " Level:" +
                    characterList.get(i).getLevel());
        }
        return listModel;
    }
    public DefaultListModel getListModelWeapon(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < weaponList.size(); i++) {
            listModel.addElement(weaponList.get(i).getName());
        }
        return listModel;
    }
    public void setCharacter(int index){
        dataCharacter = characterList.get(index);
        //...
    }
    public void setWeapon(int index){
        dataWeapon = weaponList.get(index);
        //...
    }
    
    
    
}
