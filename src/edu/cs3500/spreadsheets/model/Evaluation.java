package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.util.List;

public class Evaluation implements SexpVisitor  {


  @Override
  public Object visitBoolean(boolean b) {
    return b;
  }

  @Override
  public Object visitNumber(double d) {
    return d;
  }

  @Override
  public Object visitSymbol(String s) {
    return null;
  }

  @Override
  public Object visitString(String s) {
    return null;
  }

  @Override
  public Object visitSList(List l) {

    return null;
  }


  public int product(double n1, double n2){
    return 1;
  }
}
