package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.List;
/*
We will be using these in future implementations with the controller
 */
public class Evaluate implements SexpVisitor<Double> {


  @Override
  public Double visitBoolean(boolean b) throws IllegalArgumentException {
    throw new IllegalArgumentException("You cant add a boolean");
  }

  @Override
  public Double visitNumber(double d) {
    return d;
  }

  @Override
  public Double visitSymbol(String s) {

    if (s == "SUM") {

      sp.accept(this);
    }

    else if (s == "PROD") {

    }

    else if (s == "<") {

    }

    else if (s == "ORG") {

    }

    else {

    }

  }

  @Override
  public Double visitString(String s) throws IllegalArgumentException{
    throw new IllegalArgumentException("You cannot add strings!");
  }

  @Override
  public Double visitSList(List<Sexp> l) {
    List<Double> answer = new ArrayList<>();
    for(int i =0; i < l.size(); i++){
      Sexp s = (Sexp)l.get(i);
      answer.add(s.accept(this));
    }

    return answer;
  }

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
  public String referenceCell(String symbol) {
    return null;
  }
}
