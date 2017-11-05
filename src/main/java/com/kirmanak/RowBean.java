package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;

@ManagedBean
@RequestScoped
public class RowBean implements Serializable {
    private static final int accuracyR = 100;
    private double X = 0.0;
    private double Y = 0.0;
    private double R = 2.0;
    private int integerR = 200;

    private boolean result = false;

    public void process() {
      final RowEntity row = new RowEntity();
      row.setIntegerR(getIntegerR());
      row.setR(getR());
      row.setResult(getResult());
      row.setX(getX());
      row.setY(getY());
      ORM.insert(row);
    }

    public void countResult() {
      result = ((X*X+Y*Y <= R*R/4) && (X <= 0) && (Y >= 0)) ||
        ((X <= 0) && (X >= -R/2) && (Y <= 0) && (Y >= -R)) ||
        ((X >= 0) && (Y <= 0) && (Y >= X * 2 - R));
    }

    public boolean getResult() {
      countResult();
      return result; 
    }

    public double getX () {
      return X;
    }

    public double getY () {
      return Y;
    }

    public double getR () {
      return R;
    }

    public int getIntegerR () {
      return integerR;
    }

    public void setX (final double X) {
      this.X = X;
    }

    public void setY (final double Y) {
      this.Y = Y;
    }

    public void setIntegerR (final int R) {
      this.integerR = R;
      this.R = (double) integerR/accuracyR;
    }

    public void setR (final double R) {
      this.R = R;
      this.integerR = (int) Math.round(R*accuracyR);
    }
}
