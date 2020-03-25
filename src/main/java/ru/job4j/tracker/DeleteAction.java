package ru.job4j.tracker;

public class DeleteAction implements UserAction {

  @Override
  public String name() {
    return "=== Delete Item ====";
  }

  @Override
  public boolean execute(Input input, Tracker tracker) {
    String id = input.askStr("Enter id removable item: ");
    if (tracker.delete(id)) {
      System.out.println("Success");
    } else {
      System.out.println("Error");
    }
    return true;
  }
}
