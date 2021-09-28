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
        System.out.println("Hi!");
        JSONParser parser = new JSONParser();
        
        try{
            Object obj = parser.parse(new FileReader("weapon.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO:" + jsonObject.get("weapons"));
            JSONArray array = (JSONArray) jsonObject.get("weapons");
            
            
          
            
             for(int i = 0 ; i < array.size() ; i++) {
                System.out.println("Game Lib FOR"); 
                JSONObject jsonObject1 = (JSONObject) array.get(i);

                System.out.println("DATOS DEL ARMA: " + i);
                System.out.println("name: " + jsonObject1.get("name"));
                System.out.println("damage: " + jsonObject1.get("damage"));
                System.out.println("level: " + jsonObject1.get("level"));
                
                System.out.println("x: " + jsonObject1.get("x"));

                System.out.println("sdfasdfasdfas");
                
                Weapon nuevo = new Weapon(1, 1, 1, 1, "sadfasdf", true, (String)jsonObject1.get("name"),(int)(long)jsonObject1.get("damage"), (int)(long)jsonObject1.get("level"),(int)(long)jsonObject1.get("x"),1);
                weapons.add(nuevo);
                System.out.println("holi XD" + weapons);
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println(weapons);    
    return weapons;
    }
}
