package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    /*createSpreadSheet();
    Sexp sexp = Parser.parse("(SUM (PROD 10 3) (SUM 10 8) )");
    List<Sexp> sexps = new ArrayList<>();
    sexps.add(new SSymbol("SUM"));
    sexps.add(new SNumber(10));
    sexps.add(new SNumber(1));
    SList compare = new SList(sexps);
    //tests = test.split(" ");
    System.out.println(sexp.getClass().getSimpleName() == compare.getClass().getSimpleName());
    System.out.println(sexp.toString().split(" ")[0]);*/




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
