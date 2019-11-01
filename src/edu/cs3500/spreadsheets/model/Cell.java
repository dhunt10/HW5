package edu.cs3500.spreadsheets.model;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;
import java.util.List;

public class Cell implements iCell {

  final int col;
  final int row;
  private String item;
  private Sexp sexp;
  private String worldItem;


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
    this.item = item;
    this.item = "";
    //this.worldItem = Analyzer.analyzeCell(new Cell(coord, sexp));
  }

  public Cell(Coord coord) {
    cellCheck(coord);
    this.row = coord.row;
    this.col = coord.col;
    this.sexp = null;
    //this.worldItem = Analyzer.analyzeCell(new Cell(coord, sexp));
  }




  public String getItem() {
    return this.item;
  }
  public Sexp getSexp() {
    return this.sexp;
  }

  @Override
  public void setItem(String o) {
    this.item = o;
  }

  public void setWorldItem(String o) {
    this.worldItem = o;
  }

  public void resetCell() {
    this.item = null;
    this.worldItem = null;
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
    return this.item;
  }


}