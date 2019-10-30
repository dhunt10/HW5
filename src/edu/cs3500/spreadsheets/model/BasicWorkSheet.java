package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.Collections;
import java.util.List;


public class BasicWorkSheet implements Spreadsheet {

  final int height;
  final int width;
  private final Cell[][] currSpreadSheet;

  public BasicWorkSheet(int height, int width, Cell[][] worksheet) {
    this.height = height;
    this.width = width;
    currSpreadSheet = worksheet;
  }

  /*
  Will be used at a later date
   */
  public static Builder defaultBuilder() {
    return new Builder();
  }

  @Override
  public Cell getCellAt(int x, int y) {
    return currSpreadSheet[x][y];
  }

  @Override
  public void analyzeCell(Cell cell) {
    if (cell.getItem().toString().charAt(0) == '=') {
      cell.setWorldItem(analyzeHelper(cell.getItem()));
    } else {
      cell.setWorldItem(cell.getItem());
    }
  }


  public Sexp analyzeHelper(Sexp item) {
    Sexp sexp = Parser.parse(item.toString());
    return sexp;
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

  public static final class Builder implements WorksheetBuilder<Spreadsheet> {

    private int height = 26;
    private int width = 26;
    private Cell[][] currSpreadSheet;

    public Builder setHeight(int height) {
      if (height < 0) {
        throw new IllegalArgumentException("Height cannot be negative");
      }
      this.height = height;
      return this;
    }

    public Builder setWidth(int width) {
      if (height < 0) {
        throw new IllegalArgumentException("Height cannot be negative");
      }
      this.width = width;
      return this;
    }

    @Override
    public Builder createCell(int col, int row, String contents) {
      Coord coord = new Coord(col, row);
      Sexp sexp = Parser.parse(contents);
      Cell cell = new Cell(coord, sexp);
      currSpreadSheet[col][row] = cell;
      return this;
    }

    @Override
    public BasicWorkSheet createWorksheet() {
      if (this.height < 0 || this.width < 0) {
        throw new IllegalArgumentException("Null width or height");
      }
      return new BasicWorkSheet(height, width, currSpreadSheet);
    }

  }


}
