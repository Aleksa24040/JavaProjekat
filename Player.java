
public class Player extends GameObject{

		private String name;
		private int health;

		public Player(String name, int x, int y, int width, int height, int health) {
			super(x, y, width, height);
			this.name = "Nepoznat igrac";
			setName(name);
			setHealth(health);
		}

		private String srediIme(String ime) {
			String s = ime.trim();
			String rezultat = "";
			boolean pocetakRijeci = true;

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (c == ' ') {
					pocetakRijeci = true;
				} else {
					if (pocetakRijeci) {
						if (rezultat.length() > 0) {
							rezultat = rezultat + " ";
						}
						rezultat = rezultat + ("" + c).toUpperCase();
					} else {
						rezultat = rezultat + ("" + c).toLowerCase();
					}
					pocetakRijeci = false;
				}
			}
			return rezultat;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			String sredjenoIme = srediIme(name);
			if (!sredjenoIme.equals("")) {
				this.name = sredjenoIme;
			} else {
				System.out.println("Ime igraca ne smije biti prazno.");
			}
		}

		public int getHealth() {
			return health;
		}
		public void setHealth(int health) {
			if (health >= 0 && health <= 100) {
				this.health = health;
			} else {
				System.out.println("Zdravlje mora biti izmedju 0 i 100.");
			}
		}

		@Override
		public String toString() {
			return "Player[" + name + "] " + opisPolozaja() + " HP=" + health;
		}
	}

