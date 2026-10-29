
public class Enemy extends GameObject {
	private String type;
	private int damage;
	private int health;

	public Enemy(String type, int x, int y, int width, int height, int damage, int health) {
		super(x, y, width, height);
		this.type = "Nepoznat";
		setType(type);
		setDamage(damage);
		setHealth(health);
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		String sredjeniTip = type.trim();
		if (!sredjeniTip.equals("")) {
			this.type = sredjeniTip;
		} else {
			System.out.println("Tip neprijatelja ne smije biti prazan.");
		}
	}

	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		if (damage >= 0 && damage <= 100) {
			this.damage = damage;
		} else {
			System.out.println("Steta mora biti izmedju 0 i 100.");
		}
	}

	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if (health >= 0 && health <= 100) {
			this.health = health;
		} else {
			System.out.println("Zdravlje neprijatelja mora biti izmedju 0 i 100.");
		}
	}

	
	public int izracunajStetu() {
		return damage;
	}

	@Override
	public String toString() {
		return "Enemy[" + type + "] " + opisPolozaja() + " DMG=" + damage + " HP=" + health;
	}
}
