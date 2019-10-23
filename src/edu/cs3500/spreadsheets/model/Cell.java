package edu.cs3500.spreadsheets.model;

public class Cell {

  int col;
  int row;
  String item;

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

}
