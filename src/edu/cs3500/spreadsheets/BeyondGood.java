package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicWorkSheet;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Evaluation;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Builder;

/**
 * The main class for our program.
 */
public class BeyondGood {
  /**
   * The main entry point.
   * @param args any command-line arguments
   */
  public static void main(String[] args) {

    /*File infile = null;
    String incell = null;
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
          incell = args[i+1];
          i++;
          break;
        default:
          throw new IllegalArgumentException("This is not how you use our application tough guy");
      }
    }
    if(infile == null || incell == null){
      throw new IllegalArgumentException("bro give us some inputs to work with");
    }

    createSpreadSheet();*/
    Sexp sexp = Parser.parse("(SUM (PROD 10 3) (SUM 10 8) )");
    List<Sexp> sexps = new ArrayList<>();
    sexps.add(new SSymbol("SUM"));
    sexps.add(new SNumber(10));
    sexps.add(new SNumber(1));
    SList compare = new SList(sexps);
    //tests = test.split(" ");

    //EUREKA!
    //for a list we need to use visitor to take this list, and do something with it, specifically
    //accessing the "contents" of the SList and doing stuff based on the elements...
    //visitor can do something with the contents (without modifying list! this is awesome


    /*
    so we do sexp.accept(SexpVisitor<R> visitor)
    this visitor object calls visitSList on the contents of sexp. Now we have to code the logic
    now that we have access. We also have to figure out what the R is for. In this case
    it would be a double (SexpVisitor<Double> visitor) since we are returning a double,
    but we need cases for boolean, string, and cell too! This may be the class that
    we are missing? We need a class that implements SexpVisitor like we kind of suggessted before.
    Like a Sum class, a Product class, a < class, and a function that returns a string (reverse).
    */

    SexpVisitor<Double> eval = new Evaluation();
    sexp.accept(eval);

    System.out.println(sexp);
    System.out.println(sexp.getClass().getSimpleName() == compare.getClass().getSimpleName());
    System.out.println(sexp.getClass().getSimpleName());
    System.out.println(sexp.toString().split(" ")[0]);





    /*
      TODO: For now, look in the args array to obtain a filename and a cell name,
      - read the file and build a model from it,
      - evaluate all the cells, and
      - report any errors, or print the evaluated value of the requested cell.
    */
  }

  //Need helper function to create the actual spreadsheet
  public static void createSpreadSheet(File file, String cell) throws FileNotFoundException {
    FileReader fileReader = new FileReader(file);
    Spreadsheet s = WorksheetReader.read(BasicWorkSheet.defaultBuilder(), fileReader);
  }
}
