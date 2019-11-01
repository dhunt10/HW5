package edu.cs3500.spreadsheets.model;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;
import java.util.List;

public class Cell implements iCell {

  private int col;
  private int row;
  private String rawItem;
  private Sexp sexp;
  private String evalItem;
  private boolean b;
  private String s;
  private double d;



  public void cellCheck(Coord coord) {
    if (coord == null) {
      throw new IllegalArgumentException("Null coordinate");
    }

    if (coord.row < 1 || coord.col < 1) {
      throw new IllegalArgumentException("Invalid (negative) row/column, also must be strictly positive");
    }
  }


  public Cell(Coord coord, String item) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.rawItem = item;
    this.evalItem = "";
    try {
      this.setBoolean(Boolean.valueOf(item));
    } catch (NullPointerException e) {
      try {
        this.setDouble(Double.valueOf(item));
      } catch (NullPointerException ee) {
        this.setString(item);
      }
    }
    //this.worldItem = Analyzer.analyzeCell(new Cell(coord, sexp));
  }

  public Cell(Coord coord) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    //this.worldItem = Analyzer.analyzeCell(new Cell(coord, sexp));
  }




  @Override
  public String getItem() {
    return this.rawItem;
  }

  @Override
  public Sexp getSexp() {
    return this.sexp;
  }

  @Override
  public void setSexp(Sexp sexp) {
      this.sexp = sexp;
  }

  @Override
  public boolean getBoolean() {
    return this.b;
  }

  @Override
  public String getString() {
    return this.s;
  }

  @Override
  public double getDouble() {
    return this.d;
  }

  @Override
  public void setBoolean(boolean b) {
    this.b = b;
  }

  @Override
  public void setString(String s) {
      this.s = s;
  }

  @Override
  public void setDouble(double d) {
      this.d = d;
  }

  @Override
  public void setRawItem(String o) {
    this.rawItem = o;
  }

  public void setEvalItem(String o) {
    this.evalItem = o;
  }

  public void resetCell() {
    this.rawItem = null;
    this.evalItem = null;
  }

  @Override
  public void referenceCell(String symbol) {
    String[] symbolArray = symbol.split(":");
    List<String> values = new ArrayList<>();
    List<String> cellsToGet = referenceListMaker(symbolArray[0], symbolArray[1]);
    for (int i = 0; i < cellsToGet.size(); i++){
      //values.add(getCellAt(Coord.colNameToIndex(String.valueOf(cellsToGet.get(i).charAt(0))), cellsToGet.get(i).charAt(1)));
      //TODO how to get the cell at the given coordinates
    }
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getCol() {
    return this.col;
  }

  public List<String> referenceListMaker(String firstBound, String secondBound) {
    List<String> bounds = new ArrayList<>();

    int zeroDiff = Math.abs(firstBound.charAt(0) - secondBound.charAt(0)) + 1;
    int oneDiff = Math.abs(firstBound.charAt(1) - secondBound.charAt(1)) + 1;

    if (firstBound.charAt(0) == secondBound.charAt(0)) {
      for (int i = 0; i < oneDiff; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstBound.charAt(0));
        sb.append(firstBound.charAt(1) + i);
        bounds.add(sb.toString());
      }
    }

    else if (firstBound.charAt(1) == secondBound.charAt(1)) {
      for (int i = 0; i < zeroDiff; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstBound.charAt(0));
        sb.append(firstBound.charAt(1) + i);
        bounds.add(sb.toString());
      }
    }

    else {
      for (int i = 0; i < zeroDiff; i++) {
        for (int j = 0; j < oneDiff; j++) {
          StringBuilder sb = new StringBuilder();
          sb.append(firstBound.charAt(0) + j);
          sb.append(firstBound.charAt(1) + i);
          bounds.add(sb.toString());
        }
      }

    }

    return bounds;
  }

  @Override
  public String toString(){
    return this.rawItem;
  }


}