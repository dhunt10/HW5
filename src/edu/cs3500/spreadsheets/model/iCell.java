package edu.cs3500.spreadsheets.model;

public interface iCell {
  Object getItem();

  void setItem(String o);

  void setWorldItem(String o);

  void resetCell();
}
