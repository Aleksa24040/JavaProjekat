
public class GameObject {

	private int x;
	private int y;
	private int width;
	private int height;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = 1;
		this.height = 1;
		setWidth(width);
		setHeight(height);
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		if (width > 0) {
			this.width = width;
		} else {
			System.out.println("Sirina mora biti veca od nule.");
		}
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
		} else {
			System.out.println("Visina mora biti veca od nule.");
		}
	}

	public boolean intersects(GameObject other) {
		boolean preklapanjeX = getX() < other.getX() + other.getWidth()
				&& getX() + getWidth() > other.getX();

		boolean preklapanjeY = getY() < other.getY() + other.getHeight()
				&& getY() + getHeight() > other.getY();

		return preklapanjeX && preklapanjeY;
	}

	protected String opisPolozaja() {
		return "@ (" + x + "," + y + ") " + width + "x" + height;
	}


	@Override
	public String toString() {
		return "GameObject " + opisPolozaja();
	}
}



