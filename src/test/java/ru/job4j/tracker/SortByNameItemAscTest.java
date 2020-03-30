package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SortByNameItemAscTest {

  @Test
  public void compare() {
    Item ivan = new Item("Ivan");
    Item petr = new Item("Petr");
    Item andrey = new Item("Andrey");
    Item boris = new Item("Boris");
    List<Item> items = Arrays.asList(ivan, petr, andrey, boris);
    items.sort(new SortByNameItemAsc());
    List<Item> sorted = Arrays.asList(andrey, boris, ivan, petr);
    assertThat(items, is(sorted));
  }
}