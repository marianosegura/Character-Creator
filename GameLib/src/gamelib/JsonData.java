/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import gamelib.Direction;
import gamelib.WeaponBuilder;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yosua Andres Blanco Diaz y Paula Mariana Bustos Vargas
 */
public class JsonData {
    private static JsonData configurator;

    private JsonData(){ 
        
    }
    
    public static JsonData getInstance(){
        if(configurator == null)
            configurator = new JsonData();
        return configurator;
    }
    
    public List<AbstractCharacter> loadCharacter(){
        List<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
        JSONParser parser = new JSONParser();
        WeaponBuilder b = new WeaponBuilder();
        CharacterBuilder a = new CharacterBuilder();
        try{
            Object obj = parser.parse(new FileReader("data.json"));
            JSONObject jsonObject = (JSONObject) obj;
                 
            JSONArray chars = (JSONArray) jsonObject.get("characters");
            
            for(int i = 0 ; i < chars.size() ; i++) {
                JSONObject jsonChar1 = (JSONObject) chars.get(i);
                
                ArrayList<AbstractWeapon> weaponsCharter = new ArrayList<AbstractWeapon>();
                
                // weapons
                JSONArray array = (JSONArray) jsonChar1.get("weapons");
                for(int j = 0 ; j < array.size() ; j++) {
                    JSONObject jsonObject1 = (JSONObject) array.get(j);
                    Weapon nuevo = b.setScope((int)(long)jsonObject1.get("scope"))
                         .setExplosionRange((int)(long)jsonObject1.get("explosionRange"))
                         .setMaxSupplies((int)(long)jsonObject1.get("maxSupplies"))
                         .setLevelMultiplier((int)(long)jsonObject1.get("levelMultiplier"))
                         .setImage((String)jsonObject1.get("image"))
                         .setLevelDependant((boolean)jsonObject1.get("levelDependant"))
                         .setName((String)jsonObject1.get("name"))
                         .setDamage((int)(long)jsonObject1.get("damage"))
                         .setLevel((int)(long)jsonObject1.get("level"))
                         .setX((int)(long)jsonObject1.get("x"))
                         .setY((int)(long)jsonObject1.get("y"))
                         .build();
                    weaponsCharter.add(nuevo);
                }
                
                
                HashMap<Integer, SpriteSet> sprites = new HashMap<>();
                
                //sprites
                JSONArray spritesArray = (JSONArray) jsonChar1.get("spriteSets");
                 
                for(int n = 0 ; n < spritesArray.size() ; n++) {
                    
                    JSONObject jsonObject2 = (JSONObject) spritesArray.get(n);
                                                          
                    JSONArray spritesSetArray = (JSONArray) jsonObject2.get("Sprite");
                                                      
                    SpriteSet spritesSet = new SpriteSet();
                    
                    for(int m = 0 ; m < spritesSetArray.size() ; m++) {
                        
                        JSONObject set1 = (JSONObject) spritesSetArray.get(m);
                                              
                        String state = (String)set1.get("state");
                        String sprite = (String)set1.get("URL");
                        spritesSet.addSprite(state, sprite);
                                                                       
                    }
                    sprites.put((int)(long)jsonChar1.get("level"),spritesSet);
                    
                }
                
                //Direction
                Direction directionChar = Direction.valueOf((String)jsonChar1.get("direction"));
                System.out.println("ok");                              
                //equipedWeapon
                int equiped = (int)(long)jsonChar1.get("equipedWeapon");
                Character newChar = a.setSize((int)(long)jsonChar1.get("size"))
                        .setMaxHealth((int)(long)jsonChar1.get("maxHealth"))
                        .setHitsPerTimeUnit((int)(long)jsonChar1.get("hitsPerTimeUnit"))
                        .setCost((int)(long)jsonChar1.get("cost"))
                        .setUnlockLevel((int)(long)jsonChar1.get("unlockLevel"))
                        .setMoveSteps((int)(long)jsonChar1.get("moveSteps"))
                        .setSpriteState((String)jsonChar1.get("spriteState"))
                        .setSpriteSets(sprites)
                        .setWeapons(weaponsCharter)
                        .setEquipedWeapon(equiped)
                        .setDirection(directionChar)
                        .setName((String)jsonChar1.get("name"))
                        .setDamage((int)(long)jsonChar1.get("damage"))
                        .setLevel((int)(long)jsonChar1.get("level"))
                        .setX((int)(long)jsonChar1.get("x"))
                        .setY((int)(long)jsonChar1.get("y"))
                        .build();
                characters.add(newChar);               
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        } 
        return characters;
    }
    
    public List<AbstractWeapon> loadWeapon(){
        List<AbstractWeapon> weapons = new ArrayList<AbstractWeapon>();
        JSONParser parser = new JSONParser();
        WeaponBuilder b = new WeaponBuilder();
        try{
            Object obj = parser.parse(new FileReader("PrototypeBasicWeapons.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("weapons");
            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                Weapon nuevo = b.setScope((int)(long)jsonObject1.get("scope"))
                         .setExplosionRange((int)(long)jsonObject1.get("explosionRange"))
                         .setMaxSupplies((int)(long)jsonObject1.get("maxSupplies"))
                         .setLevelMultiplier((int)(long)jsonObject1.get("levelMultiplier"))
                         .setImage((String)jsonObject1.get("image"))
                         .setLevelDependant((boolean)jsonObject1.get("levelDependant"))
                         .setName((String)jsonObject1.get("name"))
                         .setDamage((int)(long)jsonObject1.get("damage"))
                         .setLevel((int)(long)jsonObject1.get("level"))
                         .setX((int)(long)jsonObject1.get("x"))
                         .setY((int)(long)jsonObject1.get("y"))
                         .build();                   
                weapons.add(nuevo);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }   
    return weapons;
    }
}
