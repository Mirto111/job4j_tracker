package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

  private final List<Item> items = new ArrayList<>();
  private int ids = 1;

  public Item add(Item item) {
    item.setId(generateId());
    items.add(item);
    return item;
  }

  private String generateId() {
    return String.valueOf(ids++);
  }

  private int indexOf(String id) {
    int rsl = -1;
    for (int index = 0; index < items.size(); index++) {
      if (items.get(index).getId().equals(id)) {
        rsl = index;
        break;
      }
    }
    return rsl;
  }

  public Item findById(String id) {
    int index = indexOf(id);
    return index != -1 ? items.get(index) : null;
  }

  public List<Item> findByName(String key) {
    List<Item> rsl = new ArrayList<>();
    for (Item item : items) {
      if (item.getName().equals(key)) {
        rsl.add(item);
      }
    }
    return rsl;
  }

  public List<Item> findAll() {
    return items;
  }

  public boolean replace(String id, Item item) {
    int index = indexOf(id);
    boolean rsl = false;
    if (index != -1) {
      item.setId(id);
      items.set(index, item);
      rsl = true;
    }
    return rsl;
  }

  public boolean delete(String id) {
    int index = indexOf(id);
    boolean rsl = false;
    if (index != -1) {
      items.remove(index);
      rsl = true;
    }
    return rsl;
  }
}