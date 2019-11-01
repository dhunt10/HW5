package edu.cs3500.spreadsheets.model;

public interface Spreadsheet {

  public edu.cs3500.spreadsheets.model.Cells.Cell getCellAt(int x, int y);

  public int getHeight();

  public int getWidth();

}
