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
        return new Weapon(scope, explosionRange, maxSupplies, levelMultiplier, sprites, levelDependant, name, damage, level, x, y);
    }
    
    public WeaponBuilder(Weapon oldWeapon){
        this.x = oldWeapon.getX();
        this.y = oldWeapon.getY();
        this.name = oldWeapon.getName();
        this.damage = oldWeapon.getDamage();
        this.level = oldWeapon.getLevel();
        this.sprites = oldWeapon.getSprites();
        this.scope = oldWeapon.getScope();
        this.explosionRange = oldWeapon.getExplosionRange();
        this.maxSupplies = oldWeapon.getMaxSupplies();
        this.levelMultiplier = oldWeapon.getLevelMultiplier();
        this.levelDependant = oldWeapon.isLevelDependant();
    }
    
    public WeaponBuilder(){
    }
}
