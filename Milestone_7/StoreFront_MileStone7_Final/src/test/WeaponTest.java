package test;

import model.Weapon;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WeaponTest {

    @Test
    public void testWeaponCreation() {
        Weapon weapon = new Weapon("Axe", "Heavy blade", 35.0, 2);
        assertEquals("Axe", weapon.getName());
        assertEquals("Heavy blade", weapon.getDescription());
        assertEquals(35.0, weapon.getPrice(), 0.001);
        assertEquals(2, weapon.getQuantity());
    }
}
