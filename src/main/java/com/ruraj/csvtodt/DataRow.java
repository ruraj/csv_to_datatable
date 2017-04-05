package com.ruraj.csvtodt;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ruraj on 3/13/17.
 */
public class DataRow {
  private DataTable table;
  private HashMap<String, Object> dataMap = new HashMap<>();

  DataRow(DataTable table) {
    this.table = table;
  }

  DataRow set(int idx, Object value) {
    this.dataMap.put(table.getKey(idx), value);
    return this;
  }

  DataRow set(String key, Object value) {
    this.dataMap.put(key, value);
    return this;
  }

  DataRow set(Object[] objects) {
    for (int i = 0; i < objects.length; i++) {
      // TODO Check for data type and assign using appropriate function
      set(i, objects[i]);
    }
    return this;
  }

  Object getObject(int idx) {
    return this.dataMap.get(table.getKey(idx));
  }

  Object getString(String key) {
    return this.dataMap.get(key);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof DataRow)) {
      return false;
    }

    DataRow row = (DataRow) obj;
    for (String s : dataMap.keySet()) {
      if (!dataMap.get(s).equals(row.dataMap.get(s))) {
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Object o : dataMap.values()) {
      builder.append(o).append(",");
    }

    return builder.substring(0, builder.length() - 1);
  }
}
