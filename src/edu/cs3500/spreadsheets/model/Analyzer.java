package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SBoolean;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SString;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.Collections;
import java.util.List;

public class Analyzer extends Cell {

  public Analyzer(Coord coord, Sexp sexp) {
    super(coord, sexp);

  }

  public static String analyzeCell(Cell cell) {

    Sexp sexp = Parser.parse(cell.getItem().toString());
    String finalString = analyzeHelper(sexp).toString();
    return finalString.toString();
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

    Sexp sexp = Parser.parse(item.toString());
    return sexp;
  }

  public static Object analyzeHelper(SList item) {
    Sexp sexp = Parser.parse(item.toString());
    return sexp;
  }


  private static Object SSymnbolHelper(SSymbol s) {
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

  private double productHelper(List<Double> values) {
    double prod = 0;
    for (int i = 0; i < values.size(); i++) {
      prod = prod * values.get(i);
    }
    return prod;
  }

  private boolean compareLessHelper(double smaller, double larger) {
    return smaller < larger;
  }

  private double sumHelper(List<Double> values) {
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

  public void referenceCell(String symbol) {
    String[] symbolArray = symbol.split(":");

  }


}
