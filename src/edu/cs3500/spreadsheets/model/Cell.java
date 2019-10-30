package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.util.List;

public class Cell {

  final int col;
  final int row;
  private Object item;
  private Object worldItem;

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

  public Object getItem() {
    return this.item;
  }

  public void setItem(Object o) {
    this.item = o.toString();
  }

  public void setWorldItem(Object o) {
    this.worldItem = o.toString();
  }

  public void resetCell() {
    this.item = "";
    this.worldItem = "";
  }

}
