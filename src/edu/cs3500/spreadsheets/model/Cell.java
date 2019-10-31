package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.SBoolean;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SString;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import javax.swing.SpinnerDateModel;

public class Cell implements iCell {

  final int col;
  final int row;
  private String item;
  private String worldItem;


  public void cellCheck(Coord coord) {
    if (coord == null) {
      throw new IllegalArgumentException("Null coordinate");
    }

    if (coord.row < 0 || coord.col < 0) {
      throw new IllegalArgumentException("Invalid (negative) row/column");
    }
  }


  public Cell(Coord coord, Sexp sexp) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.item = sexp.toString();
    this.worldItem = Analyzer.analyzeCell(new Cell(coord, sexp));
  }


  public String getItem() {
    return this.item;
  }

  @Override
  public void setItem(String o) {
    this.item = o;
  }

  public void setWorldItem(String o) {
    this.worldItem = o;
  }

  public void resetCell() {
    this.item = null;
    this.worldItem = null;
  }

}
