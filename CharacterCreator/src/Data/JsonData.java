/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import gamelib.AbstractCharacter;
import gamelib.AbstractWeapon;
import gamelib.Character;
import gamelib.CharacterBuilder;
import gamelib.Direction;
import gamelib.GamePrototypes;
import gamelib.SpriteSet;
import gamelib.Weapon;
import gamelib.WeaponBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
            Object obj = parser.parse(new FileReader("SaveCharacters.json"));
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
                newChar.equipWeapon(equiped);
                System.out.println(newChar);
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
            Object obj = parser.parse(new FileReader("SaveWeapons.json"));
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
    public void writeJsonWeapons(GamePrototypes<AbstractWeapon> Weapons) throws IOException{
        
        HashMap<String, AbstractWeapon> objects = Weapons.getObjects();
                
        JSONObject ObjectTotal = new JSONObject();
        
        JSONArray array = new JSONArray() ;
            
        for (String i : objects.keySet()) {
                             
            AbstractWeapon GPWeapon = objects.get(i);
            JSONObject weapon_i = new JSONObject();
            
            weapon_i.put("name",GPWeapon.getName() );
            weapon_i.put("damage",GPWeapon.getRealDamage() );
            weapon_i.put("level",GPWeapon.getLevel() );
            weapon_i.put("x",GPWeapon.getX() );
            weapon_i.put("y",GPWeapon.getY() );
            weapon_i.put("scope",GPWeapon.getScope() );
            weapon_i.put("explosionRange",GPWeapon.getExplosionRange());
            weapon_i.put("maxSupplies",GPWeapon.getMaxSupplies());
            weapon_i.put("supplies",GPWeapon.getSupplies() );
            weapon_i.put("levelMultiplier",GPWeapon.getLevelMultiplier() );
            weapon_i.put("image",GPWeapon.getImage() );
            weapon_i.put("levelDependant",GPWeapon.isLevelDependant());
            
            System.out.print(weapon_i);
            //Files.write(Paths.get("Prueba.json"), weapon_i.toJSONString().getBytes());
            array.add(weapon_i);
            
        }
        ObjectTotal.put("weapons",array );    
        Files.write(Paths.get("SaveWeapons.json"), ObjectTotal.toJSONString().getBytes());
    }
    
    public void writeJsonCharacters(GamePrototypes<AbstractCharacter> Characters) throws IOException{
        
        HashMap<String, AbstractCharacter> objects = Characters.getObjects();
        
        //Have all the atributes of characters
        JSONObject ObjectTotalCharacters = new JSONObject();
        //Create a JSONArray to all charcaters
        JSONArray AllCharcaters = new JSONArray() ;
        
        for (String i : objects.keySet()) {
                             
            AbstractCharacter GPCharacter = objects.get(i);
            JSONObject character_i = new JSONObject();
            
            character_i.put("name",GPCharacter.getName());
            character_i.put("damage",GPCharacter.getDamage());
            character_i.put("level",GPCharacter.getLevel());
            character_i.put("x",GPCharacter.getX() );
            character_i.put("y",GPCharacter.getY() );
            character_i.put("size",GPCharacter.getSize() );
            character_i.put("maxHealth",GPCharacter.getMaxHealth() );
            character_i.put("health",GPCharacter.getHealth() );
            character_i.put("hitsPerTimeUnit",GPCharacter.getHitsPerTimeUnit() );
            character_i.put("cost",GPCharacter.getCost() );
            character_i.put("unlockLevel",GPCharacter.getUnlockLevel() );
            character_i.put("moveSteps",GPCharacter.getMoveSteps() );
            character_i.put("spriteState",GPCharacter.getSprite() );
            
            
            //-----------------------------------------------------------
            //                   Sprite
            //-----------------------------------------------------------
            JSONArray arrayspriteSets = new JSONArray();
            
            HashMap<Integer, SpriteSet> ArrayspriteSets = GPCharacter.getSpriteSets(); 
            
            for (Integer s : ArrayspriteSets.keySet()){
                                
                JSONObject SpriteSet_s = new JSONObject();
                                
                SpriteSet_s.put("level",s);
                
                //------------------------
                SpriteSet GPCSpriteSet = ArrayspriteSets.get(s);
                
                JSONArray array_sprite = new JSONArray();
                
                ArrayList<String> Array_Keys_Sprite_Simple = GPCSpriteSet.getKeys(); 
                
                //----------Recorrer sprite  
                for (int u = 0; u < Array_Keys_Sprite_Simple.size(); u++){
                    
                    JSONObject Sprite_Simple = new JSONObject();
                    
                    String Statesprites = Array_Keys_Sprite_Simple.get(u);
                    String URLsprites = GPCSpriteSet.getSprite(Statesprites);
                    Sprite_Simple.put("state",Statesprites );
                    Sprite_Simple.put("URL",URLsprites );
                    
                    array_sprite.add(Sprite_Simple);
                }
                SpriteSet_s.put("Sprite",array_sprite);
                arrayspriteSets.add(SpriteSet_s);
            }  
                                   
            character_i.put("spriteSets",arrayspriteSets ); 
            
            //Create a JSONArray to all weapons
            JSONArray array = new JSONArray();
            
            ArrayList<AbstractWeapon> ArrayWeapons = GPCharacter.getWeapons(); 
                       
            for (int w = 0; w < ArrayWeapons.size(); w++){

                AbstractWeapon GPWeapon = ArrayWeapons.get(w);
                JSONObject weapon_i = new JSONObject();

                weapon_i.put("name",GPWeapon.getName() );
                weapon_i.put("damage",GPWeapon.getRealDamage() );
                weapon_i.put("level",GPWeapon.getLevel() );
                weapon_i.put("x",GPWeapon.getX() );
                weapon_i.put("y",GPWeapon.getY() );
                weapon_i.put("scope",GPWeapon.getScope() );
                weapon_i.put("explosionRange",GPWeapon.getExplosionRange());
                weapon_i.put("maxSupplies",GPWeapon.getMaxSupplies());
                weapon_i.put("supplies",GPWeapon.getSupplies() );
                weapon_i.put("levelMultiplier",GPWeapon.getLevelMultiplier() );
                weapon_i.put("image",GPWeapon.getImage() );
                weapon_i.put("levelDependant",GPWeapon.isLevelDependant());

                System.out.print(weapon_i);
                
                array.add(weapon_i);
            }
            
            character_i.put("weapons",array ); 
            int equiped = ArrayWeapons.indexOf(GPCharacter.getEquipedWeapon());
            character_i.put("equipedWeapon",equiped);
            
            String pez = GPCharacter.getDirection().toString().toUpperCase();
            character_i.put("direction",pez );
            
            System.out.print(character_i);
            
            AllCharcaters.add(character_i);
        }
        ObjectTotalCharacters.put("characters",AllCharcaters );    
        Files.write(Paths.get("SaveCharacters.json"), ObjectTotalCharacters.toJSONString().getBytes());
    }
}
