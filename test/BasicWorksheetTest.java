import edu.cs3500.spreadsheets.model.BasicWorkSheet;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicWorksheetTest {

  private Spreadsheet test;


  //Test 1, create an empty Spreadsheet
  @Test
  public void createEmptyTest() {
    Spreadsheet s = BasicWorkSheet.defaultBuilder().createWorksheet();
    assertEquals(0, s.getWidth());
    assertEquals(0, s.getHeight());
  }

  //Test 2, add a cell or two and check if they exist
  @Test
  public void createCellTest() {
    Spreadsheet s = BasicWorkSheet.defaultBuilder().setHeight(3).setWidth(3).setGrid()
        .createCell(1, 1, "hello").createCell(1, 2, "world").createWorksheet();
    assertEquals("hello", s.getCellAt(1, 1).toString());
    assertEquals("world", s.getCellAt(1, 2).toString());
  }
}
