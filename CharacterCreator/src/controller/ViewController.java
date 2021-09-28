/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gamelib.AbstractCharacter;
import gamelib.AbstractWeapon;
import gamelib.Character;
import gamelib.CharacterBuilder;
import gamelib.Direction;
import gamelib.Weapon;
import gamelib.CharacterPrototypes;
import gamelib.GamePrototypes;
import gamelib.WeaponPrototypes;
import gamelib.WeaponBuilder;
import gamelib.JsonData;
import java.util.ArrayList;
import java.util.List;
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
        loadPrototypes();
        setListNames();
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
    public DefaultListModel getListModelWeapons(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < weaponList.size(); i++) {
            listModel.addElement(weaponList.get(i));
        }
        return listModel;
    }
    public Character setCharacter(int index){
        System.out.println("characterList["+index+"]: "+characterList.get(index));
        dataCharacter = characterPrototypes.
                getPrototypeDeepClone(characterList.get(index));
        System.out.println("Character loaded: " + dataCharacter);
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
    
    public void setEquipedWeapon(int index){
        actualCharacter.setEquipedWeapon(index);
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
        if(dataCharacter == null || dataCharacter.getWeapons().isEmpty()){
           String[] result = {"No hay armas aún"};
            return result; 
        }
        return dataCharacter.getWeapons().toArray(new String[0]);
    }
    
    public boolean save(boolean isCharacter){
        try{
            if(isCharacter){
                Character newCharacter = actualCharacter.build();
                characterPrototypes
                        .addPrototype(newCharacter.getName(), newCharacter);
                actualCharacter = new CharacterBuilder();
            } else {
                Weapon newWeapon = actualWeapon.build();
                weaponPrototypes
                        .addPrototype(newWeapon.getName(), newWeapon);
                actualWeapon = new WeaponBuilder();
                
            }
            //Guardar el archivo
            setListNames();
            return true;
        }catch(Exception e){
            System.out.println("Error al guardar, e: " + e);
            return false;
        }
    }
    
    public void newGameObject(boolean isCharacter){
        if(isCharacter){
            actualCharacter = new CharacterBuilder();
        } else {
            actualWeapon = new WeaponBuilder();
        }
    }
    
    public void delete(boolean isCharacter){
        //Actualmente no hay opción de eliminar prototipos
        newGameObject(isCharacter);
        setListNames();
    }

    private void setListNames() {
        characterList = new ArrayList<String>(
                characterPrototypes.getObjects().keySet());
        weaponList = new ArrayList<String>(
                weaponPrototypes.getObjects().keySet());
    }

    private void loadPrototypes() {
        JsonData j = new JsonData();
        List<AbstractWeapon> weapons = j.loadWeapon();
        System.out.println("Weapons:");
        System.out.println(weapons);
        for (AbstractWeapon weapon : weapons ){
            weaponPrototypes
                    .addPrototype(weapon.getName(), (Weapon)weapon);
        }
        List<AbstractCharacter> characters = j.loadCharacter();
        System.out.println("Characters:");
        for (AbstractCharacter character : characters ){
            System.out.println(character);
            characterPrototypes
                    .addPrototype(character.getName(), (Character)character);
        }
    }
    
    public Character getDataCharacter(){
        return dataCharacter;
    }
    
    public Weapon getDataWeapon(){
        return dataWeapon;
    }
}
