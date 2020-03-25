package ru.job4j.tracker;

public class FindAllAction implements UserAction {

  @Override
  public String name() {
    return "=== Show all items ====";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    Item[] items = tracker.findAll();
    for (Item item : items) {
      System.out.print(item + " ");
    }
    System.out.println();
    return true;
  }
}
