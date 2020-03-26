package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import org.junit.Test;

public class FindAllActionTest {

  @Test
  public void whenCheckOutput() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream def = System.out;
    System.setOut(new PrintStream(out));
    Tracker tracker = new Tracker();
    Item item = new Item("fix bug");
    tracker.add(item);
    FindAllAction act = new FindAllAction();
    act.execute(new StubInput(new String[]{}), tracker);
    String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
        .add(item.toString() + " ")
        .toString();
    assertThat(new String(out.toByteArray()), is(expect));
    System.setOut(def);
  }

}