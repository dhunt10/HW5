package edu.cs3500.spreadsheets.model;

import java.util.List;

public class SpreadsheetModel implements Spreadsheet{


  Cell[][] currSpreadSheet;
  public void SpreadsheetModel() {
    for (int i = 0; i < 999; i++) {
      for (int j = 0; j < 999; j++) {
        Coord coord = new Coord(i,j);
        Cell cell = new Cell(coord);
        currSpreadSheet[i][j] = cell;
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

}
