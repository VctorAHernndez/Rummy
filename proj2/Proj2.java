package proj2;

import java.util.Arrays;
import java.util.List;

import proj2.ui.Table;

public class Proj2 {
  
  // TODO: IMPROVEMENT, USE A LOGGING CLASS INSTEAD
  // TODO: IMPROVEMENT, USE A SPECIALIZED CLASS FOR PARSING ARGUMENTS
  public static void main(String args[]) {

    // Only allow a max of two arguments
    if (args.length > 2) {
      System.out.println("Usage is java proj2.Proj2 [-h] [{-0, -1, -2}]");
      return;
    }

    // Pre-parse arguments
    List<String> arguments = Arrays.asList(args);
    boolean containsAtLeastH = arguments.contains("-h");
    boolean containsAtLeastOneValidNumber = arguments.contains("-0") || arguments.contains("-1") || arguments.contains("-2");

    // Default Flags
    boolean p1IsCPU = false;
    boolean p2IsCPU = false;
    boolean loggingEnabled = false;
    int numberOfInteractivePlayers = 2;

    // Check if logging is enabled
    // NOTE: HERE WE'RE ASSUMING THE OTHER ARGUMENT IS CLEAN
    if (containsAtLeastH) {
      loggingEnabled = true;
    }

    // Check the number of interactive players
    // NOTE: HERE WE'RE ASSUMING IT'S THE SECOND ARGUMENT
    // NOTE: HERE WE'RE ASSUMING THE OTHER ARGUMENT IS CLEAN
    if (containsAtLeastOneValidNumber) {
      String arg = arguments.get(1);
      if (arg.equals("-0")) {
        numberOfInteractivePlayers = 0;
      } else if (arg.equals("-1")) {
        numberOfInteractivePlayers = 1;
      } else if (arg.equals("-2")) {
        numberOfInteractivePlayers = 2;
      } else {
        System.out.println("Invalid number of interactive players: " + arg);
        return;
      }
    }

    // Switch flags accordingly
    switch (numberOfInteractivePlayers) {
      case 0:
        p1IsCPU = true;
        p2IsCPU = true;
        break;
      case 1:
        p2IsCPU = true;
        break;
      case 2:
      default:
    }

    // TODO: Actually implement logging
    // TODO: Actually implement 0 interactive players
    // TODO: Actually switch between 1 and 2 interactive players
    Table t = new Table();
    t.setVisible(true);

  }

}
