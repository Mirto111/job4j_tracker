package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SortByNameItemDescTest {

  @Test
  public void compare() {

    Item ivan = new Item("Ivan");
    Item petr = new Item("Petr");
    Item andrey = new Item("Andrey");
    Item boris = new Item("Boris");
    List<Item> items = Arrays.asList(ivan, petr, andrey, boris);
    items.sort(new SortByNameItemDesc());
    List<Item> sorted = Arrays.asList(petr, ivan, boris, andrey);
    assertThat(items, is(sorted));
  }
}