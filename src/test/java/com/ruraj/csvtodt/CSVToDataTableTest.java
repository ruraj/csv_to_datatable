package com.ruraj.csvtodt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruraj on 3/13/17.
 */
public class CSVToDataTableTest {

  private static DataTable dataTable;
  private static File file;

  @BeforeClass
  public static void setup() throws URISyntaxException, IOException {
    file = new File(
            CSVToDataTableTest.class.getClassLoader().getResource("test.csv").toURI().getPath()
    );
  }

  @Test
  public void testCsvToTable() throws IOException {
    dataTable = CSVToDataTable.toDataTable(file);

    DataTable expectedTable = new DataTable("Education", "Sex", "Work_Hrs", "Class", "#ofRecs");
    List<DataRow> rows = new ArrayList<DataRow>() {{
      add(new DataRow(expectedTable).set("10th,M,40,20Y0N,20".split(",")));
      add(new DataRow(expectedTable).set("10th,M,30,0Y4N,4".split(",")));
      add(new DataRow(expectedTable).set("9th,M,30,0Y2N,2".split(",")));
      add(new DataRow(expectedTable).set("9th,F,30,0Y4N,4".split(",")));
      add(new DataRow(expectedTable).set("9th,F,40,0Y6N,6".split(",")));
      add(new DataRow(expectedTable).set("8th,F,30,0Y2N,2".split(",")));
      add(new DataRow(expectedTable).set("8th,F,40,0Y2N,2".split(",")));
    }};
    rows.forEach(expectedTable::addRow);

    System.out.println(expectedTable);
    System.out.println(dataTable);

    Assert.assertTrue("The resulting table is not as expected", expectedTable.equals(dataTable));
  }
}
