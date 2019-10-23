package edu.cs3500.spreadsheets.model;

import java.util.List;

public interface Spreadsheet {


  public Cell getCellAt(int x, int y);

  public List<Cell> getRow(int row);

  public List<Cell> getColumn(int column);

  public void getOperation(Cell cell);

  public void booleanDealer(String action);

  public void numberDealer(String action);

  public void listDealer(String action);

  public void stringDealer(String action);

  public void symbolDealer(String action);
}
