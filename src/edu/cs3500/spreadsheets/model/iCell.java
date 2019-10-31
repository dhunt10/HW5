package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;

public interface iCell {
  Object getItem();

  void setItem(String o);

  void setWorldItem(String o);

  void resetCell();
}
