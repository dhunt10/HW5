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
