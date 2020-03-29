package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

  @Override
  public String name() {
    return "=== Find items by name ====";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    String name = input.askStr("Enter name wanted item: ");
    List<Item> items = tracker.findByName(name);
    for (Item item : items) {
      System.out.print(item + " ");
    }
    System.out.println();
    return true;
  }
}
