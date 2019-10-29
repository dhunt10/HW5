package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.io.File;

/**
 * The main class for our program.
 */
public class BeyondGood {
  /**
   * The main entry point.
   * @param args any command-line arguments
   */
  public static void main(String[] args) {

    File infile = null;
    Cell incell = null;
    for(int i = 0; i < args.length; i++){
      switch(args[i]){
        case("-in"):
          if(i == args.length -1){
            throw new IllegalArgumentException("You need to give me an input file you dumb-dumb");
          }
            infile = new File(args[i+1]);
            i++;
            break;
        case("-eval"):
          if(i == args.length -1){
            throw new IllegalArgumentException("You need to give me a cell you silly nugget");
          }
          incell = new Cell(new Coord(Integer.parseInt(args[i+1]) , Integer.parseInt(args[i+2])));
          i++;
          break;
        default:
          throw new IllegalArgumentException("This is not how you use our application tough guy");
      }
    }
    if(incell == null || incell == null){
      throw new IllegalArgumentException("bro give us some inputs to work with");
    }

    createSpreadSheet();

    /*
      TODO: For now, look in the args array to obtain a filename and a cell name,
      - read the file and build a model from it,
      - evaluate all the cells, and
      - report any errors, or print the evaluated value of the requested cell.
    */
  }

  //Need helper function to create the actual spreadsheet
  public static void createSpreadSheet(){
    //do some logic
    //need to report any errors while evaluating and so on
  }
}
