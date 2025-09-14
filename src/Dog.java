import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Dog extends Actor {
  public Dog(Cell inLoc) {
    loc = inLoc;
    color = Color.YELLOW;

  }
  

   @Override
  public void paint(Graphics g) {
    // Rebuild the polygons relative to current location
    display = new ArrayList<>();

    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);

    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 20, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 15);

    Polygon face = new Polygon();
    face.addPoint(loc.x + 8, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 25);
    face.addPoint(loc.x + 8, loc.y + 25);

    display.add(face);
    display.add(ear1);
    display.add(ear2);

    g.setColor(color);
    for (Polygon p : display) {
      g.fillPolygon(p);
    }
  g.setColor(Color.BLACK);
    for (Polygon p : display) {
      g.drawPolygon(p);
    }
   
  }
}
