
public class Game {
	private Player player ;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean checkCollision(Player p, Enemy e) {
		boolean preklapanjeX = p.getX() < e.getX() + e.getWidth() && e.getX() < p.getX() + p.getWidth();
        boolean preklapanjeY = p.getY() < e.getY() + e.getHeight() && e.getY() < p.getY() + p.getHeight();
        return preklapanjeX && preklapanjeY;
	}
	
	public void decreaseHealth(Player p, Enemy e) {
		 int stariHP = p.getHealth();
	        int noviHP = stariHP - e.getDamage();
	        if (noviHP < 0)
	            noviHP = 0;
	        p.setHealth(noviHP);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
