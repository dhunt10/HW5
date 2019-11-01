package edu.cs3500.spreadsheets.model;

import com.sun.jdi.BooleanValue;
import edu.cs3500.spreadsheets.model.Cells.Cell;
import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
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

  public int getHeight(){
    return this.height;
  }

  public int getWidth(){
    return this.width;
  }

  public static Builder defaultBuilder() {
    return new Builder();
  }

  @Override
  public Cell getCellAt(int x, int y) {
    return currSpreadSheet[x-1][y-1];
  }

  public static final class Builder implements WorksheetBuilder<Spreadsheet> {

    //set to zero to test empty worksheet
    private int height = 0;
    private int width = 0;
    private Cell[][] currSpreadSheet = new Cell[height][width];

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

    public Builder setGrid() {
      currSpreadSheet = new Cell[width][height];
      return this;
    }

    @Override
    public Builder createCell(int col, int row, String contents) {
      Coord coord = new Coord(col, row);
      if(contents.charAt(0) == '=') {
        Sexp sexp = Parser.parse(contents.substring(1));
        Cell cell = new Cell(coord, sexp);
        currSpreadSheet[col-1][row-1] = cell;
        return this;
      }
      else{
        Object value;
        try {
          Boolean.parseBoolean(contents);
          value = new BooleanValue(contents);
          Cell
        } catch (IllegalArgumentException e) {

        }
        try {
          Double.parseDouble(contents);
          value = new DoubleValue(contents);
        }
        catch (IllegalArgumentException e){

        }
        try {
          value = contents;
        }
        catch (IllegalArgumentException e) {

        }

        Cell cell = new Cell(coord, value);
        currSpreadSheet[col-1][row-1] = cell;
        return this;
      }
    }

    public Builder blankCell(int col, int row) {
      Coord coord = new Coord(col, row);
      Cell cell = new Cell(coord);
      currSpreadSheet[col-1][row-1] = cell;
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
