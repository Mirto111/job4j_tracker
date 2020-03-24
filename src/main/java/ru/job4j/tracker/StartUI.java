package ru.job4j.tracker;


public class StartUI {

  public static void main(String[] args) {
    Input input = new ConsoleInput();
    Tracker tracker = new Tracker();
    new StartUI().init(input, tracker);
  }

  public static void createItem(Input input, Tracker tracker) {
    System.out.println("=== Create a new Item ====");
    String name = input.askStr("Enter name: ");
    Item item = new Item(name);
    tracker.add(item);
  }

  public static void showAllItems(Tracker tracker) {
    System.out.println("=== Show all items ====");
    Item[] items = tracker.findAll();
    for (Item item : items) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public static void replaceItem(Input input, Tracker tracker)  {
    System.out.println("=== Edit Item ====");
    String name = input.askStr("Enter name new item: ");
    Item item = new Item(name);
    String id = input.askStr("Enter id editable item: ");
    if (tracker.replace(id, item)) {
      System.out.println("Success");
    } else {
      System.out.println("Error");
    }
  }

  public static void deleleItem(Input input, Tracker tracker)  {
    System.out.println("=== Delete Item ====");
    String id = input.askStr("Enter id removable item: ");
    if (tracker.delete(id)) {
      System.out.println("Success");
    } else {
      System.out.println("Error");
    }
  }

  public static void findItemById(Input input, Tracker tracker)  {
    System.out.println("=== Find item by Id ====");
    String id = input.askStr("Enter id wanted item: ");
    System.out.println(tracker.findById(id));
  }

  public static void findItemByName(Input input, Tracker tracker)  {
    System.out.println("=== Find items by name ====");
    String name = input.askStr("Enter name wanted item: ");
    Item[] items = tracker.findByName(name);
    for (Item item : items) {
      System.out.print(item + " ");
    }
    System.out.println();
  }

  public void init(Input input, Tracker tracker) {
    boolean run = true;
    while (run) {
      this.showMenu();
      int select = input.askInt("Select: ");
      if (select == 0) {
        StartUI.createItem(input, tracker);
      } else if (select == 1) {
        StartUI.showAllItems(tracker);
      } else if (select == 2) {
        StartUI.replaceItem(input, tracker);
      } else if (select == 3) {
        StartUI.deleleItem(input, tracker);
      } else if (select == 4) {
        StartUI.findItemById(input, tracker);
      } else if (select == 5) {
        StartUI.findItemByName(input, tracker);
      } else if (select == 6) {
        run = false;
      }
    }
  }

  private void showMenu() {
    System.out.println("Menu.");
    System.out.println("0. Add new Item");
    System.out.println("1. Show all items");
    System.out.println("2. Edit item");
    System.out.println("3. Delete item");
    System.out.println("4. Find item by Id");
    System.out.println("5. Find items by name");
    System.out.println("6. Exit Program");
  }

}
