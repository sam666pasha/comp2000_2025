public interface Movable {
  boolean canEnter(Cell target, Inventory<? extends Item> inv);
}
