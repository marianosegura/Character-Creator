/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Generic weapon builder class.
 * @author Luis Mariano Ramírez Segura
 */
public class WeaponBuilder extends AbstractWeaponBuilder<Weapon, WeaponBuilder> {
    @Override
    public Weapon build() {
        return new Weapon(scope, explosionRange, maxSupplies, levelMultiplier, image, levelDependant, name, damage, level, x, y);
    }
}
