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
import gamelib.CharacterPrototypes;
import gamelib.WeaponPrototypes;
import gamelib.WeaponBuilder;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author esteban
 */
public class ViewController {
    
    private ArrayList<String> characterList;
    private ArrayList<String> weaponList;
    private CharacterBuilder actualCharacter;
    private WeaponBuilder actualWeapon;
    private Character dataCharacter;
    private Weapon dataWeapon;
    private CharacterPrototypes characterPrototypes;
    private WeaponPrototypes weaponPrototypes;

    public ViewController() {
        characterPrototypes = new CharacterPrototypes();
        weaponPrototypes = new WeaponPrototypes();
        //En este momento necesito los datos del json para mostrar las listas
        characterList = new ArrayList<String>(
                characterPrototypes.getObjects().keySet());
        weaponList = new ArrayList<String>(
                weaponPrototypes.getObjects().keySet());
        actualCharacter = new CharacterBuilder();
        actualWeapon = new WeaponBuilder();
    }
    
    public DefaultListModel getListModelCharacters(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < characterList.size(); i++) {
            
            listModel.addElement(characterList.get(i));
        }
        return listModel;
    }
    public DefaultListModel getListModelWeapon(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < weaponList.size(); i++) {
            listModel.addElement(weaponList.get(i));
        }
        return listModel;
    }
    public Character setCharacter(int index){
        dataCharacter = characterPrototypes.
                getPrototypeDeepClone(characterList.get(index));
        actualCharacter = new CharacterBuilder(dataCharacter);
        return dataCharacter;
    }
    public Weapon setWeapon(int index){
        dataWeapon = weaponPrototypes
                .getPrototypeDeepClone(weaponList.get(index));
        actualWeapon = new WeaponBuilder(dataWeapon);
        return dataWeapon;
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
        Weapon weapon = weaponPrototypes.getPrototypeDeepClone(name);
        actualCharacter.setEquipedWeapon(weapon);
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

    public void setName(String name, boolean character) {
        if(character){
            actualCharacter.setName(name);
        } else {
            actualWeapon.setName(name);
        }
    }

    public String[] getNameWeapons() {
        if(weaponList.size() == 0){
            String[] result = {"No hay armas aún"};
            return result;
        }
        return weaponList.toArray(new String[0]);
    }
}
