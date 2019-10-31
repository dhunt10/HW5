package edu.cs3500.spreadsheets.model.Cells;

import edu.cs3500.spreadsheets.sexp.Sexp;

public class BooleanCell implements iCell{
  final int col;
  final int row;
  private Boolean item;
  private Sexp sexp;
  private String worldItem;


  @Override
  public Object getItem() {
    return null;
  }

  @Override
  public void setItem(String o) {

  }

  @Override
  public void setWorldItem(String o) {

  }

  @Override
  public void resetCell() {

  }

  @Override
  public void referenceCell(String symbol) {

  }
}
