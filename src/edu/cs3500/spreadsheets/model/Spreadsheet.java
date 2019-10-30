package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import java.util.List;

public interface Spreadsheet extends WorksheetBuilder {

  public Cell getCellAt(int x, int y);

  void analyzeCell(Cell cell);

  void referenceCell(String symbol);
}
