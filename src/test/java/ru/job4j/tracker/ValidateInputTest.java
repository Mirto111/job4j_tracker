package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.Test;

public class ValidateInputTest {

  @Test
  public void whenInvalidInput() {
    ByteArrayOutputStream mem = new ByteArrayOutputStream();
    PrintStream out = System.out;
    System.setOut(new PrintStream(mem));
    List<String> data = List.of("one", "1");
    ValidateInput input = new ValidateInput(new StubInput(data));
    input.askInt("Enter");
    assertThat(
        mem.toString(),
        is(String.format("Please enter validate data again.%n"))
    );
    System.setOut(out);
  }

  @Test
  public void whenMoreMaxInput() {
    ByteArrayOutputStream mem = new ByteArrayOutputStream();
    PrintStream out = System.out;
    System.setOut(new PrintStream(mem));
    List<String> data = List.of("8", "1");
    ValidateInput input = new ValidateInput(new StubInput(data));
    input.askInt("Enter", 2);
    assertThat(
        mem.toString(),
        is(String.format("Please select key from menu.%n"))
    );
    System.setOut(out);
  }
}