import java.awt.Color;

public class Boat extends Item {
  @Override public String name() { return "Boat"; }
  @Override public String symbol() { return "B"; }
  @Override public Color color() { return Color.CYAN; }
}
