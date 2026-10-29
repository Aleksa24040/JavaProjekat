import java.util.ArrayList;

public class Game {
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<String> eventLog;

	public Game(Player player) {
		this.player = player;
		this.enemies = new ArrayList<>();
		this.eventLog = new ArrayList<>();
	}

	public Player getIgraca() {
		return player;
	}

	public ArrayList<Enemy> getNeprijatelje() {
		return enemies;
	}

	public ArrayList<String> getDnevnik() {
		return eventLog;
	}

	private void dodajDogadjaj(String poruka) {
		eventLog.add(poruka);
	}

	public static boolean checkCollision(Player p, Enemy e) {
		return p.intersects(e);
	}

	public void decreaseHealth(Player p, Enemy e) {
		int staroZdravlje = p.getHealth();
		int steta = e.izracunajStetu();
		int novoZdravlje = staroZdravlje - steta;

		if (novoZdravlje < 0) {
			novoZdravlje = 0;
		}

		p.setHealth(novoZdravlje);

		dodajDogadjaj("UDARAC: " + p.getName() + ", neprijatelj " + e.getType() + ", steta " + steta
				+ " -> HP " + staroZdravlje + " -> " + novoZdravlje);
	}

	public void addEnemy(Enemy e) {
		if (e != null) {
			enemies.add(e);

			dodajDogadjaj("DODAT: " + e.getType() + " na poziciji (" + e.getX() + "," + e.getY() + ")");
		} else {
			System.out.println("Neprijatelj nije dodat jer ne postoji.");
		}
	}

	public ArrayList<Enemy> findByType(String query) {
		ArrayList<Enemy> rezultat = new ArrayList<>();
		String trazeno = query.trim().toLowerCase();

		for (int i = 0; i < enemies.size(); i++) {
			String tip = enemies.get(i).getType().toLowerCase();
			if (tip.contains(trazeno)) {
				rezultat.add(enemies.get(i));
			}
		}
		return rezultat;
	}

	public ArrayList<Enemy> collidingWithPlayer() {
		ArrayList<Enemy> rezultat = new ArrayList<>();

		for (int i = 0; i < enemies.size(); i++) {
			if (checkCollision(player, enemies.get(i))) {
				rezultat.add(enemies.get(i));
			}
		}
		return rezultat;
	}

	public void resolveCollisions() {
		ArrayList<Enemy> sudari = collidingWithPlayer();

		dodajDogadjaj("PROVJERA: broj sudara sa igracem " + player.getName() + ": " + sudari.size());

		for (Enemy e : sudari) {
			decreaseHealth(player, e);
		}
	}



	public static void ispisiNeprijatelje(ArrayList<Enemy> lista) {
		if (lista.size() == 0) {
			System.out.println("  (nema neprijatelja)");
		}
		for (Enemy e : lista) {
			System.out.println("  " + e);
		}
	}

	public static void main(String[] args) {

		Player igrac = new Player("  peTar petrovic ", 9, 7, 34, 34, 85);
		Game igra = new Game(igrac);

		System.out.println("Igrac: " + igrac);
		System.out.println();

		Enemy ork = new MeeleEnemy("   Orc ", 100, 100, 40, 40, 65, 50);
		igra.addEnemy(ork);


		Enemy kostur = new MeeleEnemy("Skeleton", 30, 20, 15, 15, 25, 60);
		igra.addEnemy(kostur);

		System.out.println("Svi neprijatelji:");
		ispisiNeprijatelje(igra.getNeprijatelje());
		System.out.println();

		System.out.println("Neprijatelji ciji tip sadrzi gob:");
		ispisiNeprijatelje(igra.findByType("gob"));
		System.out.println("Neprijatelji ciji tip sadrzi ORC (velika slova):");
		ispisiNeprijatelje(igra.findByType("ORC"));
		System.out.println();

		System.out.println("Neprijatelji koji se sudaraju sa igracem:");
		ispisiNeprijatelje(igra.collidingWithPlayer());
		System.out.println();

		System.out.println("Stanje igraca prije: " + igrac);
		igra.resolveCollisions();
		System.out.println("Stanje igraca poslije: " + igrac);
		System.out.println();

		System.out.println("DNEVNIK DOGADJAJA:");
		ArrayList<String> dnevnik = igra.getDnevnik();
		for (int i = 0; i < dnevnik.size(); i++) {
			System.out.println("  " + (i + 1) + ". " + dnevnik.get(i));
		}
	}
}


