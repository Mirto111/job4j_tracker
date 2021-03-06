package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

  @Override
  public String name() {
    return "=== Edit Item ====";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    String name = input.askStr("Enter name new item: ");
    Item item = new Item(name);
    String id = input.askStr("Enter id editable item: ");
    if (tracker.replace(id, item)) {
      System.out.println("Success");
    } else {
      System.out.println("Error");
    }
    return true;
  }
}
