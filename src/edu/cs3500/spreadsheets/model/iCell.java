package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;

public interface iCell {
  public Object getItem();

  public  void setRawItem(String o);

  public void setEvalItem(String o);

  public void resetCell();

  public void referenceCell(String symbol);

  public int getRow();

  public int getCol();
  public Sexp getSexp();
  public void setSexp(Sexp sexp);
  public boolean getBoolean();
  public String getString();
  public double getDouble();
  public String getFormula();
  public void setBoolean(boolean b);
  public void setString(String s);
  public void setDouble(double d);
  public void setFormula(String formula);

}