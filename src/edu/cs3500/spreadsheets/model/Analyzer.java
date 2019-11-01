package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SBoolean;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SString;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyzer extends edu.cs3500.spreadsheets.model.Cells.Cell {

  public Analyzer(Coord coord, Sexp sexp) {
    super(coord, sexp);
  }

  public static String analyzeCell(edu.cs3500.spreadsheets.model.Cells.Cell cell) {

    Sexp sexp = Parser.parse(cell.getItem());
    return analyzerFunc(sexp);
  }

  public static String analyzerFunc(Sexp sexp) {
    String finalString;
    try {
      finalString = analyzeHelper((SBoolean) sexp).toString();
      return finalString;
    } catch (Exception e) {
      finalString = "";
    }

    try {
      finalString = analyzeHelper((SNumber) sexp).toString();
      return finalString;
    } catch (Exception e) {
      finalString = "";
    }

    try {
      finalString = analyzeHelper((SString) sexp).toString();
      return finalString;
    } catch (Exception e) {
      finalString = "";
    }

    try {
      finalString = analyzeHelper((SSymbol) sexp).toString();
      return finalString;
    } catch (Exception e) {
      finalString = "";
    }

    try {
      finalString = analyzeHelper((SList) sexp).toString();
      return finalString;
    } catch (Exception e) {
      finalString = "";
    }
    throw new IllegalArgumentException("Wrong");

  }

  public static Object analyzeHelper(SBoolean item) {
    Sexp sexp = Parser.parse(item.toString());
    return Boolean.parseBoolean(sexp.toString());
  }

  public static Object analyzeHelper(SNumber item) {
    Sexp sexp = Parser.parse(item.toString());
    return Integer.parseInt(sexp.toString());
  }

  public static Object analyzeHelper(SString item) {
    Sexp sexp = Parser.parse(item.toString());
    return sexp.toString();
  }

  public static Object analyzeHelper(SSymbol item) {
    Evaluate visit = new Evaluate();
    visit.visitSymbol(item.toString());
    Sexp sexp = Parser.parse(item.toString());
    return sexp;
  }

  public static Object analyzeHelper(SList item) {
    Sexp sexp = Parser.parse(item.toString());
    for (int i = 0; i < SList)
    String sexpList = Analyzer.listHelper((SList) sexp);
    return sexpList;
  }


  private static Object SSymbolHelper(SSymbol s) {
    switch (s.toString()) {
      case "PROD":

        break;
      case "SUM":

        break;

      case "SORT":

        break;

      case "<":

        break;

      default:
        try {

        }
        catch (Exception e) {
          throw new IllegalArgumentException("Not a valid symbol");
        }
    }
    return "test";
  }

  private static String listHelper(SList l) {
    List<String> sets = new ArrayList<>();
    SexpVisitor<SList> sexpvisitor = null;
    List<Sexp> listSexp = (List<Sexp>) l.accept(sexpvisitor);
    for (int i = 0; i < listSexp.size(); i++) {
      sets.add(Analyzer.analyzerFunc(listSexp.get(i)));
    }

    for (int i = 0; i < sets.size(); i++) {
      //TODO DONT JUST ADD THE NEXT TWO YOU NEED TO ADD ALL OF THEM BOZO
      switch (sets.get(i)) {
        case "PROD":
          List<Double> prods = new ArrayList<>();
          prods.add(Double.parseDouble(sets.get(i+1)));
          prods.add(Double.parseDouble(sets.get(i+2)));
          Analyzer.productHelper(prods);
          break;
        case "SUM":
          List<Double> sums = new ArrayList<>();
          sums.add(Double.parseDouble(sets.get(i+1)));
          sums.add(Double.parseDouble(sets.get(i+2)));
          Analyzer.productHelper(sums);
          break;

        case "SORT":
          List<Double> words = new ArrayList<>();
          //words.add(sets)
          break;

        case "<":
          compareLessHelper(Double.parseDouble(sets.get(i+1)), Double.parseDouble(sets.get(i+2)));
          break;

        default:
          try {

          } catch (Exception e) {
            throw new IllegalArgumentException("Not a valid symbol");
          }
      }
    }
    return "test";
  }

  private static double productHelper(List<Double> values) {
    double prod = 0;
    for (int i = 0; i < values.size(); i++) {
      prod = prod * values.get(i);
    }
    return prod;
  }

  private static boolean compareLessHelper(double smaller, double larger) {
    return smaller < larger;
  }

  private static double sumHelper(List<Double> values) {
    double sum = 0;
    for (int i = 0; i < values.size(); i++) {
      sum = sum + values.get(i);
    }
    return sum;
  }

  private List<String> sortHelper(List<String> values) {
    Collections.sort(values);
    return values;
  }

}