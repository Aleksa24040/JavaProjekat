
public class BossEnemy extends Enemy{
	public BossEnemy(String type, int x, int y, int width, int height, int damage, int health) {
		super(type, x, y, width, height, damage, health);
	}

	
	@Override
	public int izracunajStetu() {
		return getDamage() * 2;
	}

	@Override
	public String toString() {
		return "BossEnemy[" + getType() + "] " + opisPolozaja() + " DMG=" + getDamage() + "x2 HP=" + getHealth();
	}
}

