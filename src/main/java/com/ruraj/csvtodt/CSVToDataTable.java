package com.ruraj.csvtodt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ruraj on 3/13/17.
 */
public class CSVToDataTable {
  public static DataTable toDataTable(File file) throws IOException {
    FileReader fileReader = new FileReader(file);
    BufferedReader reader = new BufferedReader(fileReader);

    return toDataTable(reader);
  }

  public static DataTable toDataTable(BufferedReader reader) throws IOException {
    String[] heading = reader.readLine().split(",");

    DataTable table = new DataTable(heading);

    String line;

    while ((line = reader.readLine()) != null) {
      String[] values = line.split(",");
      if (values.length != heading.length) {
        continue;
      }

      DataRow row = new DataRow(table);
      for (int idx = 0; idx < values.length; idx++) {
        row.set(heading[idx], values[idx]);
      }
      table.addRow(row);
    }

    return table;
  }
}
