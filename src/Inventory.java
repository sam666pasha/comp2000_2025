import java.util.*;

public class Inventory<T extends Item> {
  private final List<T> items = new ArrayList<>();
  public void add(T item) { items.add(item); }
  public List<T> all() { return Collections.unmodifiableList(items); }
  public boolean has(Class<? extends Item> type) {
    return items.stream().anyMatch(type::isInstance);
  }
}
