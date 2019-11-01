package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.awt.geom.Rectangle2D.Double;
import java.util.List;
/*
We will be using these in future implementations with the controller
 */
public class Sum implements SexpVisitor<Double> {


  @Override
  public Double visitBoolean(boolean b) throws IllegalArgumentException {
    throw new IllegalArgumentException("You cant add a boolean");
  }

  @Override
  public Double visitNumber(double d) {
    return null;
  }

  @Override
  public Double visitSymbol(String s) {
    return null;
  }

  @Override
  public Double visitString(String s) throws IllegalArgumentException{
    throw new IllegalArgumentException("You cannot SUM strings!");
  }

  @Override
  public Double visitSList(List<Sexp> l) {
    for(int i =0; i < l.size(); i++){
      Sexp s = (Sexp)l.get(i);
      s.accept(this);
    }

    return null;
  }

}