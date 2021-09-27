/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author esteban
 */
public class ViewController {
    

    public ViewController() {
    }
    
    public DefaultListModel getListModelCharacters(){
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<String> list = new ArrayList();//Cambiar por la lista de personajes
        for (int i = 0; i < list.size(); i++) {
            listModel.addElement(list.get(i));
        }
        return listModel;
    }
    
    
    
}
