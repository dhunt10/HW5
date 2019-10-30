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
  private Sexp item;
  private Sexp worldItem;


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
    this.item = sexp;
    this.worldItem = null;
  }

  /*public Cell(Coord coord, SString s) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.item = s;
    this.worldItem = null;
  }

  public Cell(Coord coord, SBoolean b) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.item = b;
    this.worldItem = null;
  }

  public Cell(Coord coord, SNumber d) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.item = d;
    this.worldItem = null;
  }

  public Cell(Coord coord, SSymbol s) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.item = s;
    this.worldItem = null;
  }

  public Cell(Coord coord, SList l) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.item = l;
    this.worldItem = null;
  }*/

  public Sexp getItem() {
    return this.item;
  }

  @Override
  public void setItem(Sexp o) {
    this.item = o;
  }

  public void setWorldItem(Sexp o) {
    this.worldItem = o;
  }

  public void resetCell() {
    this.item = null;
    this.worldItem = null;
  }

}
