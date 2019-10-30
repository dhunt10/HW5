package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;

public interface iCell {
  Object getItem();

  void setItem(Sexp o);

  void setWorldItem(Sexp o);

  void resetCell();
}
