package edu.cs3500.spreadsheets.model;

public class Cell {

  final int col;
  final int row;
  private String item;

  public Cell(Coord coord) {

    if (coord == null) {
      throw new IllegalArgumentException("Null coordinate");
    }

    if (coord.row < 0 || coord.col < 0) {
      throw new IllegalArgumentException("Invalid (negative) row/column");
    }
    this.row = coord.row;
    this.col = coord.col;
    this.item = "";
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public void resetCell() {
    this.item = "";
  }

}
