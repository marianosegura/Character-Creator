/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import gamelib.Direction;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yosua Andres Blanco Diaz y Paula Mariana Bustos Vargas
 */
public class JsonData {
    private List<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
    private List<AbstractWeapon> weapons = new ArrayList<AbstractWeapon>();
    public JsonData(){ 
    }
    public List<AbstractCharacter> loadCharacter(){
        JSONParser parser = new JSONParser();
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
                    Weapon nuevo = new Weapon((int)(long)jsonObject1.get("scope"),
                            (int)(long)jsonObject1.get("explosionRange"),
                            (int)(long)jsonObject1.get("maxSupplies"),
                            (int)(long)jsonObject1.get("levelMultiplier"),
                            (String)jsonObject1.get("image"),
                            (boolean)jsonObject1.get("levelDependant"),
                            (String)jsonObject1.get("name"),
                            (int)(long)jsonObject1.get("damage"),
                            (int)(long)jsonObject1.get("level"),
                            (int)(long)jsonObject1.get("x"),
                            (int)(long)jsonObject1.get("y"));
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
                                              
                //equipedWeapon
                JSONObject equiped = (JSONObject) jsonChar1.get("equipedWeapon");
                               
                Weapon equipedWeapon = new Weapon((int)(long)equiped.get("scope"),
                        (int)(long)equiped.get("explosionRange"),
                        (int)(long)equiped.get("maxSupplies"),
                        (int)(long)equiped.get("levelMultiplier"),
                        (String)equiped.get("image"),
                        (boolean)equiped.get("levelDependant"),
                        (String)equiped.get("name"),
                        (int)(long)equiped.get("damage"),
                        (int)(long)equiped.get("level"),
                        (int)(long)equiped.get("x"),
                        (int)(long)equiped.get("y"));
                
                Character newChar = new Character((int)(long)jsonChar1.get("size"),
                                (int)(long)jsonChar1.get("maxHealth"),
                                (int)(long)jsonChar1.get("hitsPerTimeUnit"),
                                (int)(long)jsonChar1.get("cost"),
                                (int)(long)jsonChar1.get("unlockLevel"),
                                (int)(long)jsonChar1.get("moveSteps"),
                                (String)jsonChar1.get("spriteState"),
                                //HashMap<Integer, SpriteSet> spriteSets,
                                sprites,
                                //ArrayList<AbstractWeapon> weapons
                                weaponsCharter,
                                //AbstractWeapon equipedWeapon, 
                                equipedWeapon,
                                //Direction direction, 
                                directionChar,
                                (String)jsonChar1.get("name"),
                                (int)(long)jsonChar1.get("damage"),
                                (int)(long)jsonChar1.get("level"),
                                (int)(long)jsonChar1.get("x"),
                                (int)(long)jsonChar1.get("y"));
                characters.add(newChar);               
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        } 
        return characters;
    }
    
    public List<AbstractWeapon> loadWeapon(){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("PrototypeBasicWeapons.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("weapons");
            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                Weapon nuevo = new Weapon((int)(long)jsonObject1.get("scope"),
                        (int)(long)jsonObject1.get("explosionRange"),
                        (int)(long)jsonObject1.get("maxSupplies"),
                        (int)(long)jsonObject1.get("levelMultiplier"),
                        (String)jsonObject1.get("image"),
                        (boolean)jsonObject1.get("levelDependant"),
                        (String)jsonObject1.get("name"),
                        (int)(long)jsonObject1.get("damage"),
                        (int)(long)jsonObject1.get("level"),
                        (int)(long)jsonObject1.get("x"),
                        (int)(long)jsonObject1.get("y"));
                weapons.add(nuevo);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }   
    return weapons;
    }
}
