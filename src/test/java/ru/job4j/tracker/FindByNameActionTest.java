package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import org.junit.Test;

public class FindByNameActionTest {

  @Test
  public void whenCheckOutput() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream def = System.out;
    System.setOut(new PrintStream(out));
    Tracker tracker = new Tracker();
    Item item = new Item("fix bug");
    Item item1 = new Item("fix another bug");
    tracker.add(item);
    tracker.add(item1);
    FindByNameAction act = new FindByNameAction();
    act.execute(new StubInput(new String[]{"fix bug"}), tracker);
    String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
        .add(item.toString() + " ")
        .toString();
    assertThat(new String(out.toByteArray()), is(expect));
    System.setOut(def);
  }

}