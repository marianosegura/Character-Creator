/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gamelib.Character;
import gamelib.CharacterBuilder;
import gamelib.Direction;
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

    public void setDamage(int value, boolean character) {
        if(character){
            actualCharacter.setDamage(value);
        } else {
            actualWeapon.setDamage(value);
        }
    }

    public void setLevel(int value, boolean character) {
        if(character){
            actualCharacter.setLevel(value);
        } else {
            actualWeapon.setLevel(value);
        }
    }
    
    public void setX(int value, boolean character) {
        if(character){
            actualCharacter.setX(value);
        } else {
            actualWeapon.setX(value);
        }
    }
    
    
    public void setY(int value, boolean character) {
        if(character){
            actualCharacter.setY(value);
        } else {
            actualWeapon.setY(value);
        }
    }
    
    public void setSize(int value){
        actualCharacter.setSize(value);
    }
    
    public void setMaxHealth(int value) {
        actualCharacter.setMaxHealth(value);
    }
    
    public void setHealth(int value){
        actualCharacter.setHealth(value);
    }
    
    public void setHitsPerTimeUnit(int value){
        actualCharacter.setHitsPerTimeUnit(value);
    }
    
    public void setCost(int value){
        actualCharacter.setCost(value);
    }
    
    public void setUnlockLevel(int value){
        actualCharacter.setUnlockLevel(value);
    }
    
    public void setSpriteState(String state){
        actualCharacter.setSpriteState(state);
    }
    
    public void setEquipedWeapon(String name){
        Weapon w = new Weapon(1,2,5,2,"tengo que cambiar",true);//tengo que sacarlo de la fotocopiadora
        actualCharacter.setEquipedWeapon(w);
    }
    
    public void setDirection(String dir){
        switch(dir){
            case "Arriba":
                actualCharacter.setDirection(Direction.UP);
                break;
            case "Abajo":
                actualCharacter.setDirection(Direction.DOWN);
                break;
            case "Derecha":
                actualCharacter.setDirection(Direction.RIGHT);
                break;
            case "Izquierda":
                actualCharacter.setDirection(Direction.LEFT);
                break;
            default:
                break;
        }
    }
    
    public void setMoveSteps(int value){
        actualCharacter.setMoveSteps(value);
    }
    
    public void setScope(int value){
        actualWeapon.setScope(value);
    }
    
    public void setExplosionRange(int value){
        actualWeapon.setExplosionRange(value);
    }
    
    public void setMaxSupplies(int value){
        actualWeapon.setMaxSupplies(value);
    }
    
    public void setSupplies(int value){
        actualWeapon.setSupplies(value);
    }
    
    public void setLevelMultiplier(int value){
        actualWeapon.setLevelMultiplier(value);
    }
    
    public void setImage(String path){
        actualWeapon.setImage(path);
    }
    
    public void setLevelDependant(boolean depent){
        actualWeapon.setLevelDependant(depent);
    }
}
