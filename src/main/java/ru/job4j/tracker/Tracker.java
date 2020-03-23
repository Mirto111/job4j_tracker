package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

  private final Item[] items = new Item[100];
  private int ids = 1;
  private int size = 0;

  public Item add(Item item) {
    item.setId(generateId());
    items[size++] = item;
    return item;
  }

  private String generateId() {
    return String.valueOf(ids++);
  }

  private int indexOf(String id) {
    int rsl = -1;
    for (int index = 0; index < size; index++) {
      if (items[index].getId().equals(id)) {
        rsl = index;
        break;
      }
    }
    return rsl;
  }

  public Item findById(String id) {
    int index = indexOf(id);
    return index != -1 ? items[index] : null;
  }

  public Item[] findByName(String key) {
    Item[] rsl = new Item[size];
    int count = 0;
    for (int index = 0; index < size; index++) {
      Item item = items[index];
      if (item.getName().equals(key)) {
        rsl[count] = item;
        count++;
      }
    }
    rsl = Arrays.copyOf(rsl, count);
    return rsl;
  }

  public Item[] findAll() {
    Item[] itemsWithoutNull = Arrays.copyOf(items, size);
    return itemsWithoutNull;
  }

  public boolean replace(String id, Item item) {
    int index = indexOf(id);
    boolean rsl = false;
    if (index != -1) {
      item.setId(id);
      items[index] = item;
      rsl = true;
    }
    return rsl;
  }
}