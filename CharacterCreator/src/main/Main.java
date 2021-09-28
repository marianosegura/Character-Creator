/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gamelib.AbstractCharacter;
import gamelib.AbstractWeapon;
import gamelib.JsonData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        JsonData j = new JsonData();
        List<AbstractWeapon> weapons = new ArrayList<AbstractWeapon>();
        weapons = j.loadWeapon();
        //GamePrototypes<AbstractWeapon> Weapons = new ()
        System.out.println("Weapons loaded.");
        
        List<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
        characters = j.loadCharacter();
        System.out.println("characters loaded.");
        
        
    }
    
}
