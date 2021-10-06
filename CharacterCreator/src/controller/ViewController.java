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
import gamelib.SpriteSet;
import Data.JsonData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author esteban
 */
public class ViewController {
    
    private ArrayList<String> characterList;
    private ArrayList<String> weaponList;
    private ArrayList<Character> softCharacters;
    private ArrayList<Weapon> softWeapons;
    private CharacterBuilder actualCharacter;
    private WeaponBuilder actualWeapon;
    private Character dataCharacter;
    private Weapon dataWeapon;
    private CharacterPrototypes characterPrototypes;
    private WeaponPrototypes weaponPrototypes;
    private String path = "./";
    private int levelSprite;

    public ViewController() {
        characterPrototypes = new CharacterPrototypes();
        weaponPrototypes = new WeaponPrototypes();
        softCharacters = new ArrayList<Character>();
        softWeapons = new ArrayList<Weapon>();
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
    
    public DefaultListModel getListModelSpritsetLevels(){
        DefaultListModel listModel = new DefaultListModel();
        if(actualCharacter != null && 
                !actualCharacter.getSpriteSets().keySet().isEmpty()){
            ArrayList<String> list = 
                    new ArrayList(actualCharacter.getSpriteSets().keySet());
            for (int i = 0; i < list.size(); i++) {
                listModel.addElement(list.get(i));
            }
        } else {
            listModel.addElement("No hay Sprite sets");
        }
        return listModel;
    }
    
    public DefaultListModel getListModelSpritesetStates(int level){
        DefaultListModel listModel = new DefaultListModel();
        if(level == -1){//sin cargar nada
           listModel.addElement("Selecciona un nivel para cargar esta lista");
        } else {
            ArrayList<String> list = 
                    actualCharacter.getSpriteSet(level).getKeys();
            for (int i = 0; i < list.size(); i++) {
                    listModel.addElement(list.get(i));
            }
        }
        return listModel;
    }
    
    public boolean anySpriteSet(){
        if(actualCharacter == null || 
                actualCharacter.getSpriteSets().keySet().isEmpty()){
            return false;
        }
        return true;
    }
    
    public DefaultListModel getListModelWeapons(boolean isInventory){
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> list = new ArrayList();
        if (isInventory && dataCharacter != null ) {
            for (int i = 0; i < dataCharacter.getWeapons().size(); i++) {
                list.add(dataCharacter.getWeapons().get(i).getName());
            }
        } else if (!isInventory){
            list = weaponList;
        }
        if(list.isEmpty()){
            list.add("No hay armas aún");
        }
        for (int i = 0; i < list.size(); i++) {
                listModel.addElement(list.get(i));
        }
        return listModel;
    }
    
    public DefaultListModel getListModelSoftCharacters(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < softCharacters.size(); i++) {
            
            listModel.addElement(softCharacters.get(i).getName());
        }
        if(softCharacters.size() == 0){
            listModel.addElement("No hay personajes suaves");
        }
        return listModel;
    }
    
    public DefaultListModel getListModelSoftWeapons(){
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < softWeapons.size(); i++) {
            
            listModel.addElement(softWeapons.get(i).getName());
        }
        if(softCharacters.size() == 0){
            listModel.addElement("No hay armas suaves");
        }
        return listModel;
    }
    
    public boolean anySoft(boolean isCharacter){
        if(isCharacter){
            return softCharacters.isEmpty() ? false : true;
        } else {
            return softWeapons.isEmpty() ? false : true;
        }
    }
    
    
    public ListModel<String> getListModelSpriteWeapon() {
        DefaultListModel listModel = new DefaultListModel();
        ArrayList spriteKeys = 
                new ArrayList(actualWeapon.getSprites().keySet());
        for (int i = 0; i < spriteKeys.size(); i++) {
            listModel.addElement(String.valueOf(spriteKeys.get(i)));
        }
        return listModel;
    }
    
    
    public Character setCharacter(int index){
        dataCharacter = characterPrototypes.
                getPrototypeDeepClone(characterList.get(index));
        if(dataCharacter.getName().isEmpty()){
            dataCharacter.setName(characterList.get(index));
        }
        actualCharacter = new CharacterBuilder(dataCharacter);
        return dataCharacter;
    }
    
    public void setWeapon(int index,boolean isInventary){
        if(isInventary && dataCharacter != null){
            dataWeapon = (Weapon) dataCharacter.getWeapons().get(index);
        } else {
            dataWeapon = weaponPrototypes
                .getPrototypeDeepClone(weaponList.get(index));  
        }
        actualWeapon = new WeaponBuilder(dataWeapon);
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
    
    public void addStripteSet(int level,String state){
        ArrayList levels = 
                new ArrayList(actualCharacter.getSpriteSets().keySet());
        if(levels.contains(level)){
            actualCharacter.getSpriteSet(level).addSprite(state, path);
        } else {
            SpriteSet newSpriteSet = new SpriteSet();
            newSpriteSet.addSprite(state, path);
            actualCharacter.addSpriteSet(level, newSpriteSet);
        }
        
    }
    
    public void setEquipedWeapon(int index){
        actualCharacter.setEquipedWeapon(index);
        dataCharacter = actualCharacter.build();
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
        ArrayList<String> list = new ArrayList();
        for(AbstractWeapon weapon: dataCharacter.getWeapons()){
            list.add(weapon.getName());
        }
        return list.toArray(new String[0]);
    }
    
    public boolean save(boolean isCharacter, boolean isInventary, String name){
        try{
            if(isCharacter){
                actualCharacter.setName(name);
                Character newCharacter = actualCharacter.build();
                characterPrototypes
                        .addPrototype(newCharacter.getName(), newCharacter);
                actualCharacter = new CharacterBuilder();
            } else {
                Weapon newWeapon = actualWeapon.build();
                weaponPrototypes
                        .addPrototype(newWeapon.getName(), newWeapon);
                actualWeapon = new WeaponBuilder();
                if(isInventary){
                    actualCharacter.addWeapon(newWeapon);
                    dataCharacter = actualCharacter.build();
                }
            }
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
    
    public boolean anyWeapon(boolean isInventory){
        if(isInventory){
            if(dataCharacter == null || dataCharacter.getWeapons().isEmpty()){
                return false;
            }   
        } else {
            if(weaponList.isEmpty()){
                return false;
            }
        }
        return true;
    }

    private void setListNames() {
        characterList = new ArrayList<String>(
                characterPrototypes.getObjects().keySet());
        weaponList = new ArrayList<String>(
                weaponPrototypes.getObjects().keySet());
    }

    private void loadPrototypes() {
        JsonData j = JsonData.getInstance();
        List<AbstractWeapon> weapons = j.loadWeapon();
        System.out.println("Weapons in load:");
        for (AbstractWeapon weapon : weapons ){
            weaponPrototypes
                    .addPrototype(weapon.getName(), (Weapon)weapon);
            System.out.println(weapon);
        }
        List<AbstractCharacter> characters = j.loadCharacter();
        System.out.println("Characters:");
        for (AbstractCharacter character : characters ){
            System.out.println(character);
            characterPrototypes
                    .addPrototype(character.getName(), (Character)character);
            System.out.println(character);
        }
    }
    
    public Character getDataCharacter(){
        return dataCharacter;
    }
    
    public Weapon getDataWeapon(){
        return dataWeapon;
    }

    public int getLevelSprite(int indexLevel) {
        ArrayList list = 
                new ArrayList(actualCharacter.getSpriteSets().keySet());
        levelSprite = (int) list.get(indexLevel);
        return levelSprite;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ComboBoxModel<String> getListComboModelCharacters() {
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        for (int i = 0; i < characterList.size(); i++) {
            model.addElement(characterList.get(i));
        }
        return model;
    }

    public String getBuildCharacter(String name, int amount) {
        String result = "";
        ArrayList<Character> copies = 
                characterPrototypes.getPrototypeDeepClone(name, amount);
        for(Character character : copies){
            result += character.toString() + "\n";
        }
        return result;
    }
    
    public String getBuildWeapon(String name, int amount) {
        String result = "";
        ArrayList<Weapon> copies = 
                weaponPrototypes.getPrototypeDeepClone(name, amount);
        for(Weapon character : copies){
            result += character.toString();
        }
        return result;
    }

    public ComboBoxModel<String> getListComboModelWeapons() {
        DefaultComboBoxModel model= new DefaultComboBoxModel();
        for (int i = 0; i < weaponList.size(); i++) {
            model.addElement(weaponList.get(i));
        }
        return model;
    }

    public void savePrototype(boolean isCharacter) {
            JsonData j = JsonData.getInstance();
            try {
               if(!isCharacter){   
                    j.writeJsonWeapons((GamePrototypes) weaponPrototypes);
                } else {
                    j.writeJsonCharacters((GamePrototypes) characterPrototypes);
                } 
            } catch (IOException ex) {
            Logger.getLogger(
                    ViewController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
            
 
    }

    public void setSoftWeapon(int index) {
        actualWeapon = new WeaponBuilder(softWeapons.get(index));
        dataWeapon = actualWeapon.build();
    }

    public void setSoftCharacter(int index) {
        actualCharacter = new CharacterBuilder(softCharacters.get(index));
        dataCharacter = actualCharacter.build();
    }

    public void addWeaponInventory() {
        actualCharacter.addWeapon(actualWeapon.build());
    }

    public void saveSoftCharacter() {
        softCharacters.add(actualCharacter.build());
    }

    public void saveSoftWeapon() {
        softWeapons.add(actualWeapon.build());
    }

    public void addSpriteWeapon(int i) {
        actualWeapon.addSprite(i, path);
    }

    public String getWeaponSpritePath(int index) {
        ArrayList keySet = 
                new ArrayList(actualWeapon.getSprites().keySet());
        path = actualWeapon.getSprite((int) keySet.get(index));
        return path;
    }
    public String getCharacterSpritePath(int index) {
        ArrayList<String> keySet = 
                new ArrayList(actualCharacter.getSpriteSet(levelSprite).getKeys());
        path = actualCharacter.getSpriteSet(levelSprite).getSprite(keySet.get(index));
        return path;
    }
}
