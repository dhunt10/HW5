package edu.cs3500.spreadsheets.model;

public class Cell implements iCell {

  final int col;
  final int row;
  private String item;
  private String worldItem;

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
    this.worldItem = "";
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String o) {
    this.item = o.toString();
  }

  public void setWorldItem(String o) {
    this.worldItem = o.toString();
  }

  public void resetCell() {
    this.item = "";
    this.worldItem = "";
  }

}
