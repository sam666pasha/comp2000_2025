import java.awt.Graphics;

public class Player extends Actor implements Movable {
  private final Inventory<Item> inventory = new Inventory<>();
  private final Actor avatar;   // Dog, Cat, or Bird depending on choice
  private final PlayerType type;

  public Player(Cell start, PlayerType type) {
    this.loc = start;
    this.type = type;
    switch (type) {
      case DOG -> avatar = new Dog(start);
      case CAT -> avatar = new Cat(start);
      case BIRD -> avatar = new Bird(start);
      default -> avatar = new Dog(start);
    }
  }


  public Inventory<Item> inventory() { return inventory; }
  public PlayerType getType() { return type; }

  @Override
  public boolean canEnter(Cell target, Inventory<? extends Item> inv) {
    if (target instanceof Terrain t) {
      if (!t.isPassable()) {
        
        if (type == PlayerType.BIRD) return true;
        return inv.has(Boat.class);
      }
      return true;
    }
    return true;
  }

  @Override
  public void paint(Graphics g) {
    
    avatar.setLoc(loc);
    avatar.paint(g);

  }
}
