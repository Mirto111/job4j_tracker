package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Tracker tracker = new Tracker();
    new StartUI().init(scanner, tracker);
  }

  public void init(Scanner scanner, Tracker tracker) {
    boolean run = true;
    while (run) {
      this.showMenu();
      System.out.print("Select: ");
      int select = Integer.valueOf(scanner.nextLine());
      if (select == 0) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);

      } else if (select == 1) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item item : items) {
          System.out.print(item + " ");
        }
        System.out.println();
      } else if (select == 2) {
        System.out.println("=== Edit Item ====");
        System.out.print("Enter name new item: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        System.out.print("Enter id editable item: ");
        String id = scanner.nextLine();
        if (tracker.replace(id, item)) {
          System.out.println("Success");
        } else {
          System.out.println("Error");
        }
      } else if (select == 3) {
        System.out.println("=== Delete Item ====");
        System.out.print("Enter id removable item: ");
        String id = scanner.nextLine();
        if (tracker.delete(id)) {
          System.out.println("Success");
        } else {
          System.out.println("Error");
        }
      } else if (select == 4) {
        System.out.println("=== Find item by Id ====");
        System.out.print("Enter id wanted item: ");
        String id = scanner.nextLine();
        System.out.println(tracker.findById(id));
      } else if (select == 5) {
        System.out.println("=== Find items by name ====");
        System.out.print("Enter name wanted item: ");
        String name = scanner.nextLine();
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
          System.out.print(item + " ");
        }
        System.out.println();
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
