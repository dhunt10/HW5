package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;

public class Analyzer extends Cell {

  public Analyzer(Coord coord, Sexp sexp) {
    super(coord, sexp);
  }

  public static String analyzeCell(Cell cell) {
    Sexp sexp = Parser.parse(cell.getItem().toString());
    String finalString = "";
    

    return finalString;
  }
}
