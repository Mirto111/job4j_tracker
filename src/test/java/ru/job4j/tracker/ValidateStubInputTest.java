package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class ValidateStubInputTest {

  @Test
  public void whenInvalidInput() {
    ByteArrayOutputStream mem = new ByteArrayOutputStream();
    PrintStream out = System.out;
    System.setOut(new PrintStream(mem));
    String[] data = {"one", "1"};
    ValidateInput input = new ValidateStubInput(data);
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
    String[] data = {"8", "1"};
    ValidateInput input = new ValidateStubInput(data);
    input.askInt("Enter", 2);
    assertThat(
        mem.toString(),
        is(String.format("Please select key from menu.%n"))
    );
    System.setOut(out);
  }
}