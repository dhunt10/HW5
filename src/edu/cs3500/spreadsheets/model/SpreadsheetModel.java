package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.SBoolean;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SString;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.List;


public class SpreadsheetModel implements Spreadsheet {

  Cell[][] currSpreadSheet;
  public void SpreadsheetModel() {
    for (int i = 0; i < 999; i++) {
      for (int j = 0; j < 999; j++) {
        Coord coord = new Coord(i,j);
        currSpreadSheet[i][j] = new Cell(coord);
        currSpreadSheet[i][j].setItem("test");
      }
    }

  }

  @Override
  public Cell getCellAt(int x, int y) {
    return currSpreadSheet[x][y];
  }

  @Override
  public List<Cell> getRow(int row) {
    List<Cell> rows = null;
    for (int i = 0; i < 999; i++) {
      for (int j = 0; j < 999; j++) {
        if (i == row)
        rows.add(currSpreadSheet[i][j]);
      }
    }
    return rows;
  }

  @Override
  public List<Cell> getColumn(int column) {
    List<Cell> cols = null;
    for (int i = 0; i < 999; i++) {
      for (int j = 0; j < 999; j++) {
        if (j == column)
          cols.add(currSpreadSheet[i][j]);
      }
    }
    return cols;
  }

  @Override
  public void getOperation(Cell cell) {
    Sexp expr = Parser.parse(cell.getItem());

    if (expr instanceof SBoolean) {

    } else if (expr instanceof SString) {

    } else if (expr instanceof SSymbol) {

    } else if (expr instanceof SList) {

    } else if (expr instanceof SNumber) {

    } else {
        throw new IllegalStateException("Invalid type");
    }
  }

  @Override
  public void booleanDealer(String action) {

  }

  @Override
  public void numberDealer(String action) {

  }

  @Override
  public void listDealer(String action) {

  }

  @Override
  public void stringDealer(String action) {

  }

  @Override
  public void symbolDealer(String action) {

  }
}
