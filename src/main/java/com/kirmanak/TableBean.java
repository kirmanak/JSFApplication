package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

@ManagedBean(name="tableBean")
@SessionScoped
public class TableBean implements Serializable {
    private final List<Double> X_LIST;
    private final List<Double> Y_LIST;
    private final List<Double> R_LIST;
    private final List<Boolean> RESULT_LIST;
    private String table;

    public TableBean () {
      X_LIST = new ArrayList();
      Y_LIST = new ArrayList();
      R_LIST = new ArrayList();
      RESULT_LIST = new ArrayList();
      table = getTable(); 
    }

    public String getTable () {
      final int SIZE =  X_LIST.size();

      if (SIZE == 0) return "";
      if (Y_LIST.size() != SIZE || R_LIST.size() != SIZE || RESULT_LIST.size() != SIZE) {
        throw new RuntimeException("It can't be!");
      }

      final StringBuilder builder = new StringBuilder();

      builder.append("<table>");
      builder.append("<tr>");
      builder.append("<td> Координата X </td>");
      builder.append("<td> Координата Y </td>");
      builder.append("<td> Коэффициент R </td>");
      builder.append("<td> Вхождение </td>");
      builder.append("</tr>");
      for (int i = 0; SIZE > i; i++) {
        builder.append("<tr>");
        builder.append("<td>").append(X_LIST.get(i)).append("</td>");
        builder.append("<td>").append(Y_LIST.get(i)).append("</td>");
        builder.append("<td>").append(R_LIST.get(i)).append("</td>");
        builder.append("<td>").append(RESULT_LIST.get(i)).append("</td>");
        builder.append("</tr>");
      }
      builder.append("</table>");
      return builder.toString();
    }

    public boolean addRow(final double x, final double y, 
        final double r, final boolean result) {
      // checks new values
      if (Double.isNaN(x) || Double.isInfinite(x)
          || Double.isNaN(y) || Double.isInfinite(y)
          || Double.isNaN(r) || Double.isInfinite(r)) {
        return false;
      }

      if (!X_LIST.add(x)) return false;

      if (!Y_LIST.add(y)) {
        X_LIST.remove(x);
        return false;
      }

      if (!R_LIST.add(r)) {
        X_LIST.remove(x);
        Y_LIST.remove(y);
        return false;
      }

      if (!RESULT_LIST.add(result)) {
        X_LIST.remove(x);
        Y_LIST.remove(y);
        R_LIST.remove(r);
        return false;
      }

      return true;
    }
}
