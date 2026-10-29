
public class MeeleEnemy extends Enemy{

	public MeeleEnemy(String type, int x, int y, int width, int height, int damage, int health) {
		super(type, x, y, width, height, damage, health);
	}

	
	@Override
	public int izracunajStetu() {
		return getDamage();
	}
}




