import edu.cs3500.spreadsheets.model.BasicWorkSheet;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import edu.cs3500.spreadsheets.sexp.SBoolean;
import edu.cs3500.spreadsheets.sexp.SList;
import edu.cs3500.spreadsheets.sexp.SNumber;
import edu.cs3500.spreadsheets.sexp.SString;
import edu.cs3500.spreadsheets.sexp.SSymbol;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

  //the .getItem methods get the item of type Sexp, and used .toString method to return string form
  //of the Sexp object
  @Test
  public void testCellSBoolean(){
    Sexp test = new SBoolean(false);
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "=false").createCell(1, 2, "world").createWorksheet();
    assertEquals(test, s.getCellAt(1, 1).getSexp());
  }

  @Test
  public void testCellBoolean(){
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "false").createCell(1, 2, "world").createWorksheet();
    assertEquals(false, s.getCellAt(1, 1).getBoolean());
  }



  @Test
  public void testCellSNumber(){
    Sexp test = new SNumber(2.0);
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "=2").createCell(1, 2, "world").createWorksheet();
    assertEquals(test, s.getCellAt(1, 1).getSexp());
  }

  @Test
  public void testCellNumber(){
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "2.0").createCell(1, 2, "world").createWorksheet();
    assertEquals(2.0, s.getCellAt(1, 1).getDouble(), 0.001);
  }



  @Test
  public void testCellSSymbol(){
    Sexp test = new SSymbol("SUM");
    Cell test2 = new Cell(new Coord(1, 1), test.toString());
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "=SUM").createCell(1, 2, "world").createWorksheet();
    assertEquals(test.toString(), s.getCellAt(1, 1).getItem());
    assertEquals(test, s.getCellAt(1, 1).getSexp());
  }

  @Test
  public void testCellSList(){
    ArrayList<Sexp> contents = new ArrayList<>();
    contents.add(new SSymbol("SUM"));
    contents.add(new SNumber(2.0));
    contents.add(new SNumber(4.0));
    Sexp test = new SList(contents);
    Cell test2 = new Cell(new Coord(1, 1), test.toString());
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "=(SUM 2 4)").createCell(1, 2, "world").createWorksheet();
    assertEquals(test.toString(), s.getCellAt(1, 1).getItem());
    assertEquals(test, s.getCellAt(1, 1).getSexp());
  }

  @Test
  public void testCellSString(){
    Sexp test = new SString("hello");
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "=\"hello\"").createCell(1, 2, "world").createWorksheet();
    assertEquals(test.toString(), s.getCellAt(1, 1).getItem());
    assertEquals(test, s.getCellAt(1, 1).getSexp());
  }

  @Test
  public void testCellString(){
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "hello").createCell(1, 2, "world").createWorksheet();
    assertEquals("hello", s.getCellAt(1, 1).getString());
  }

  //Test blank cell
  @Test
  public void testBlankCell(){
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "hello").blankCell(1, 2).createWorksheet();
    assertEquals("hello", s.getCellAt(1, 1).getString());
  }

  //Test PRODUCTs

  //Test SUM

  //Test <

  //Test alphabetize

  //Test formula that refers to a cell twice (SUM A1 A1)

  //Test region (SUM A1:A5)

  //Test (SUM TRUE 5)

  //Test toString of values



}

