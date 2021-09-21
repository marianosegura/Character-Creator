/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Directions based on the 8 basic directions.
 * @author Luis Mariano Ramírez Segura
 */
public enum Direction {
    RIGHT("Right", 1, 0),
    LEFT("Left", -1, 0),
    UP("Up", 0, -1),
    DOWN("Down", 0, 1),
    RIGHT_DOWN("Right Down", 1, 1),
    LEFT_DOWN("Left Down", -1, 1),
    RIGHT_UP("Right Up", 1, -1),
    LEFT_UP("Left Up",-1, 1),;
    
    private final String label;
    private final int unitaryX;  // unitary values to move in the direction
    private final int unitaryY;
    
    Direction(String label, int x, int y) {
        this.label = label;
        this.unitaryX = x;
        this.unitaryY = y;
    }
    
    public String toString() {
        return label;
    }

    public int getUnitaryX() {
        return unitaryX;
    }

    public int getUnitaryY() {
        return unitaryY;
    }
}
