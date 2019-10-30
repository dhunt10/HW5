package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SBoolean;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SString;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.util.Collections;
import java.util.List;


public class SpreadsheetModel implements Spreadsheet {

  Cell[][] currSpreadSheet;
  public SpreadsheetModel() {

  }

  public static final class Builder implements WorksheetBuilder<Spreadsheet> {


    @Override
    public WorksheetBuilder<Spreadsheet> createCell(int col, int row, String contents) {
      return null;
    }

    @Override
    public Spreadsheet createWorksheet() {
      return null;
    }
  }

  @Override
  public Cell getCellAt(int x, int y) {
    return currSpreadSheet[x][y];
  }

  @Override
  public void analyzeCell(Cell cell) {

    SexpVisitor visitor = visitorGet(cell);
    if (cell.getItem().toString().charAt(0) == '=') {
      cell.setWorldItem(analyzeHelper(cell.getItem().toString(), visitor));
    } else {
      cell.setWorldItem(cell.getItem());
    }
  }


  public SexpVisitor visitorGet(Cell cell) {
    SexpVisitor visitor = new SexpVisitor() {
      @Override
      public Object visitBoolean(boolean b) {
        return this.visitBoolean((boolean) cell.getItem());
      }

      @Override
      public Object visitNumber(double d) {
        return this.visitNumber((Double) cell.getItem());
      }

      @Override
      public Object visitSList(List l) {
        return this.visitSList((List) cell.getItem());
      }

      @Override
      public Object visitSymbol(String s) {
        return this.visitSymbol(cell.getItem().toString());
      }

      @Override
      public Object visitString(String s) {
        return this.visitString(cell.getItem().toString());
      }
    };
    return visitor;
  }

  public String analyzeHelper(String item, SexpVisitor visitor) {
    Sexp sexp = Parser.parse(item);
    sexp.accept(visitor);
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

  private List<String> revHelper(List<String> values) {
    Collections.sort(values);
    return values;
  }

  public void referenceCell(String symbol) {
    String[] symbolArray = symbol.split(":");

  }






  @Override
  public WorksheetBuilder createCell(int col, int row, String contents) {
    return null;
  }

  @Override
  public Object createWorksheet() {
    return null;
  }



}
