package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;

import java.io.Serializable;

@ManagedBean
@RequestScoped
public class RowBean implements Serializable {
    @NotNull(message = "X can't be empty.")
    @DecimalMin(value = "-2.0", message = "X should be -2 or more.")
    @DecimalMax(value = "2.0", message = "X should be 2 or less.")
    private double X = 0.0;

    @NotNull(message = "Y can't be empty.")
    @DecimalMin(value = "-5.0", message = "Y should be -5 or more.")
    @DecimalMax(value = "5.0", message = "Y should be 5 or less.")
    private double Y = 0.0;

    @NotNull(message = "R can't be empty.")
    @DecimalMin(value = "2.0", message = "R should be 2 or more.")
    @DecimalMax(value = "5.0", message = "R should be 5 or less.")
    private double R = 2.0;

    private boolean result = false;

    public void process() {
      setResult();
      // connect to database and insert new data
      // sort of ORM.insert(this);
    }

    public void setResult() {
      this.result = ((X*X+Y*Y <= R*R/4) && (X <= 0) && (Y >= 0)) ||
        ((X <= 0) && (X >= -R/2) && (Y <= 0) && (Y >= -R)) ||
        ((X >= 0) && (Y <= 0) && (Y <= X * 2 + R));
    }

    public boolean getResult() {
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

    public void setX (double X) {
      this.X = X;
    }

    public void setY (double Y) {
      this.Y = Y;
    }

    public void setR (double R) {
      this.R = R;
    }
}