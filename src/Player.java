import java.awt.Graphics;

public class Player extends Actor implements Movable {
  private final Inventory<Item> inventory = new Inventory<>();
  private final Actor avatar;   // Dog, Cat, or Bird depending on choice
  private final PlayerType type;

 public Player(Cell start, PlayerType type) {
  this.loc = start;
  this.type = type;
  switch (type) {
    case DOG:
      avatar = new Dog(start);
      break;
    case CAT:
      avatar = new Cat(start);
      break;
    case BIRD:
      avatar = new Bird(start);
      break;
    default:
      avatar = new Dog(start);
      break;
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
  // draw the underlying avatar
  avatar.setLoc(loc);
  avatar.paint(g);

  // overlay distinguishing marker
  g.setColor(java.awt.Color.ORANGE);
  // ring around cell
  g.drawOval(loc.x + 2, loc.y + 2, Cell.size - 4, Cell.size - 4);

  // optional "P" text
  g.setColor(java.awt.Color.BLACK);
  g.drawString("P", loc.x + Cell.size / 2 - 3, loc.y + Cell.size / 2 + 4);
}


}
