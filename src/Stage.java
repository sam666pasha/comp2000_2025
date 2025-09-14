import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random ;
public class Stage {
  Grid grid;
  List<Actor> actors;
  Player  player;
  private final Random rnd = new  Random(42);
  private final Map<Cell, Item> items = new HashMap<>();



  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(6, 4).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get()));    
  player = new Player(grid.cellAtColRow(0, 0).get(), PlayerType.DOG);
    actors.add(player);



       // Scatter items randomly (no overlap)
      for(int i=0;i<=5;i++){
    placeRandomItem(new Boat());
    placeRandomItem(new Fish());
    placeRandomItem(new Seed());
      }

  }

  public void paint(Graphics g, Point mouseLoc) {
 grid.paint(g, mouseLoc);

for (Map.Entry<Cell, Item> e : items.entrySet()) {
  Cell c = e.getKey();
  Item it = e.getValue();

  // background colored box
  g.setColor(it.color());
  g.fillRect(c.x + 10, c.y + 10, 15, 15);

  g.setColor(Color.BLACK);
  g.drawRect(c.x + 10, c.y + 10, 15, 15);

  // symbol letter
  g.drawString(it.symbol(), c.x + 15, c.y + 22);
}

   
    for(Actor a: actors) {
      a.paint(g);
    }
    
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }


    g.setColor(Color.BLACK);
    g.drawString("Inventory: " + player.inventory().all().stream().map(Item::name).toList(), 740, 50);
  }




   public void tryMovePlayer(int dc, int dr) {
    Cell here = player.getLoc();
    char nextCol = (char) (here.col + dc);
    int nextRow = here.row + dr;

    grid.cellAtColRow(nextCol, nextRow).ifPresent(target -> {
      if (player.canEnter(target, player.inventory())) {
        player.setLoc(target);
        pickUpIfAny(target);
      }
    });
  }

  
 private void pickUpIfAny(Cell cell) {
    Item it = items.remove(cell);
    if (it != null) {
      player.inventory().add(it);
      System.out.println("Picked up: " + it.name());
    }
  }


private void placeRandomItem(Item item) {
    while (true) {
      int col = rnd.nextInt(20); // 0..19
      int row = rnd.nextInt(20);
      Optional<Cell> maybe = grid.cellAtColRow(col, row);
      if (maybe.isEmpty()) continue;
      Cell cell = maybe.get();

      // avoid player start & existing items
      if (cell.equals(player.getLoc())) continue;
      if (items.containsKey(cell)) continue;

      items.put(cell, item);
      return;
    }
  }

}
