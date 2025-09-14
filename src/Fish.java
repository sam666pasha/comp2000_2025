import java.awt.Color;

public class Fish extends Item {
  @Override public String name() { return "Fish"; }
  @Override public String symbol() { return "F"; }
  @Override public Color color() { return Color.PINK; }
}
