package edu.cs3500.spreadsheets.model;

import java.util.List;

public interface Spreadsheet {


  public Cell getCellAt(int x, int y);

  public List<Cell> getRow(int row);

  public List<Cell> getColumn(int column);

  public String analyzeCell(Cell cell);
}
