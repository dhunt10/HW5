package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.Cells.StringCell;

public interface Spreadsheet {

  public StringCell getCellAt(int x, int y);

  public int getHeight();

  public int getWidth();

}
