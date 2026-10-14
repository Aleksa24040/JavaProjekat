
public class Game {
	private Player player ;
	private Enemy[] neprijatelja;
	private int brojNeprijatelja;
	private String eventLog;
	
	public Game(Player playerP) {
		player = playerP;
		neprijatelja = new Enemy[10];
		brojNeprijatelja = 0;
		eventLog = "";
	}
	
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
	        
	        String poruka = "HIT: " + p.getIme() + " by " + e.getType() + " for " + e.getDamage()
            + " -> HP " + stariHP + "->" + noviHP;
	        eventLog = eventLog + poruka + "\n";
	}
	public void addEnemy(Enemy e) {
        if (brojNeprijatelja < neprijatelja.length) {
            neprijatelja[brojNeprijatelja] = e;
            brojNeprijatelja++;
            eventLog = eventLog + "ADD: " + e.toString() + "\n";
        } else {
            System.out.println("Greska: niz neprijatelja je pun.");
        }
    }

   
    public Enemy[] findByType(String query) {
        String trazeno = query.trim().toLowerCase();

     
        int brojPronadjenih = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (neprijatelja[i].getType().toLowerCase().contains(trazeno))
                brojPronadjenih++;
        }


        Enemy[] pronadjeni = new Enemy[brojPronadjenih];
        int j = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (neprijatelja[i].getType().toLowerCase().contains(trazeno)) {
                pronadjeni[j] = neprijatelja[i];
                j++;
            }
        }
        return pronadjeni;
    }


    public Enemy[] collidingWithPlayer() {
        // 1) prebrojimo
        int brojSudara = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (checkCollision(player, neprijatelja[i]))
                brojSudara++;
        }

       
        Enemy[] sudaraju = new Enemy[brojSudara];
        int j = 0;
        for (int i = 0; i < brojNeprijatelja; i++) {
            if (checkCollision(player, neprijatelja[i])) {
                sudaraju[j] = neprijatelja[i];
                j++;
            }
        }
        return sudaraju;
    }


    public void resolveCollisions() {
        Enemy[] sudaraju = collidingWithPlayer();
        for (int i = 0; i < sudaraju.length; i++) {
            decreaseHealth(player, sudaraju[i]);
        }
    }


    public void ispisiNeprijatelje() {
        System.out.println("Neprijatelji (" + brojNeprijatelja + "):");
        for (int i = 0; i < brojNeprijatelja; i++) {
            System.out.println("  " + neprijatelja[i].toString());
        }
    }

 
    public void ispisiEventLog() {
        System.out.println("=== Event log ===");
        System.out.print(eventLog);
    }

    public static void main(String[] args) {

     
        Player player = new Player("  player   one ", 10, 5, 32, 32, 85);
        Game game = new Game(player);

       
        Enemy orc = new Enemy("Orc", 50, 50, 16, 16, 30);
        game.addEnemy(orc);

        String opis = "Goblin;12,5;16x16;20";
        String[] dio = opis.split(";");             
        String tip = dio[0];
        String[] pozicija = dio[1].split(",");       
        int ex = Integer.parseInt(pozicija[0]);
        int ey = Integer.parseInt(pozicija[1]);
        String[] dimenzije = dio[2].split("x");      
        int ew = Integer.parseInt(dimenzije[0]);
        int eh = Integer.parseInt(dimenzije[1]);
        int dmg = Integer.parseInt(dio[3]);
        Enemy goblin = new Enemy(tip, ex, ey, ew, eh, dmg);
        game.addEnemy(goblin);

     
        game.ispisiNeprijatelje();

        
        Enemy[] pronadjeni = game.findByType("gob");
        System.out.println("Neprijatelji ciji tip sadrzi \"gob\" (" + pronadjeni.length + "):");
        for (int i = 0; i < pronadjeni.length; i++) {
            System.out.println("  " + pronadjeni[i].toString());
        }

   
        System.out.println("Prije: " + player.toString());

     
        Enemy[] sudaraju = game.collidingWithPlayer();
        System.out.println("Broj neprijatelja u sudaru sa igracem: " + sudaraju.length);
        game.resolveCollisions();

        
        System.out.println("Poslije: " + player.toString());

        game.ispisiEventLog();
	
    }

}
