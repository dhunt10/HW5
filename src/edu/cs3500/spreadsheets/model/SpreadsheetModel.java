package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Parser;
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
        if (i == row - 1)
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
        if (j == column - 1)
          cols.add(currSpreadSheet[i][j]);
      }
    }
    return cols;
  }

  @Override
  public String analyzeCell(Cell cell) {

    if (cell.getItem().charAt(0) == '=') {
      return analyzeHelper(cell.getItem());
    } else {
      return cell.getItem();
    }
  }

  public String analyzeHelper(String item) {
    Sexp sexp = Parser.parse(item);

    return "test";
  }



}
