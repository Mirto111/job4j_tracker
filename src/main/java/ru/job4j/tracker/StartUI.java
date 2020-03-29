package ru.job4j.tracker;


import java.util.List;

public class StartUI {

  public static void main(String[] args) {
    Input input = new ConsoleInput();
    Input validate = new ValidateInput(input);
    Tracker tracker = new Tracker();
    List<UserAction> actions = List.of(
        new CreateAction(),
        new FindAllAction(),
        new ReplaceAction(),
        new DeleteAction(),
        new FindByIdAction(),
        new FindByNameAction(),
        new ExitAction());
    new StartUI().init(validate, tracker, actions);
  }

  public void init(Input input, Tracker tracker, List<UserAction> actions) {
    boolean run = true;
    while (run) {
      this.showMenu(actions);
      int select = input.askInt("Select: ", actions.size());
      UserAction action = actions.get(select);
      run = action.execute(input, tracker);
    }
  }

  private void showMenu(List<UserAction> actions) {
    System.out.println("Menu.");
    for (int index = 0; index < actions.size(); index++) {
      System.out.println(index + ". " + actions.get(index).name());
    }
  }

}
