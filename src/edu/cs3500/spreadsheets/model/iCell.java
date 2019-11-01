package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;

public interface iCell {
  Object getItem();

  void setRawItem(String o);

  void setEvalItem(String o);

  void resetCell();

  void referenceCell(String symbol);
}