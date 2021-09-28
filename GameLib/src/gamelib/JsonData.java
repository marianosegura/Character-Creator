/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Yosua Blanco Diaz
 */
public class JsonData {
    private List<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
    private List<AbstractWeapon> weapons = new ArrayList<AbstractWeapon>();
    public JsonData(){ 
    }
    public List<AbstractCharacter> loadCharacter(){
        try{
        }catch(Exception e){
            System.out.println("Error"+e);
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
