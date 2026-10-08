
public class Player {
	private String ime;
	private int x;
	private int y;
	private int width;
	private int height;
	private int health;
	
	
	public Player(String ime, int x, int y, int width, int height, int health) {
		this.ime = ime;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
	}
	
	public String getIme() {
		return ime;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public int getHealth() {
		return health;
	}

	public void setIme(String ime) {
		String bezRazmaka = ime.trim();
		
		if (bezRazmaka.length() == 0) {
            System.out.println("Ime igraca ne smije biti prazno.");
            
		}
		
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public void setHealth(int health) {
		if (health < 0 && health > 100) {
			this.health = health;
		}else {
			System.out.println("Health mora biti izmedju 0 i 100");
		}
	}

	public String toString() {
        return "Player[" + ime + "] @ (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
