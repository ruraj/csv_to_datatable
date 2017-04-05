package com.ruraj.csvtodt;

import java.util.*;

/**
 * Created by ruraj on 3/13/17.
 */
public class DataTable {
  private HashMap<Integer, String> keyMap = new HashMap<>();
  private LinkedList<DataRow> dataTable = new LinkedList<>();

  DataTable(String ... keys) {
    for (int i = 0; i < keys.length; i++) {
      keyMap.put(i, keys[i]);
    }
  }

  String getKey(int idx) {
    return keyMap.get(idx);
  }

  void addRow(DataRow row) {
    this.dataTable.addLast(row);
  }

  public DataRow nextRow() {
    return this.dataTable.pollFirst();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DataTable)) {
      return false;
    }

    DataTable table = (DataTable) obj;

    if (table.dataTable.size() != dataTable.size()) {
      return false;
    }

    // TODO Also check if the structure is similar at all

    for (int i = 0; i < dataTable.size(); i++) {
      if (!table.dataTable.get(i).equals(dataTable.get(i))) {
        return false;
      }
    }

    return true;
  }

  public String toString(int rows) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      builder.append(dataTable.get(i).toString()).append("\n");
    }

    return builder.toString();
  }

  @Override
  public String toString() {
    return toString(dataTable.size());
  }
}
