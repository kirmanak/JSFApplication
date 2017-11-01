package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import java.io.Serializable;

@ManagedBean
@RequestScoped
public class RowBean implements Serializable {
    private static final int accuracyR = 100;
    private final String sessionId;

    @NotNull(message = "X can't be empty.")
    @DecimalMin(value = "-2.0", message = "X should be -2 or more.")
    @DecimalMax(value = "2", message = "X should be 2 or less.")
    private double X = 0.0;

    @NotNull(message = "Y can't be empty.")
    @DecimalMin(value = "-5.0", message = "Y should be -5 or more.")
    @DecimalMax(value = "5.0", message = "Y should be 5 or less.")
    private double Y = 0.0;

    @NotNull(message = "R can't be empty.")
    @DecimalMin(value = "2.0", message = "R should be 2 or more.")
    @DecimalMax(value = "5.0", message = "R should be 5 or less.")
    private double R = 2.0;

    @NotNull(message = "R can't be empty.")
    @DecimalMin(value = "200", message = "IntegerR should be 200 or more.")
    @DecimalMax(value = "500", message = "IntegerR should be 500 or less.")
    private int integerR = 200;

    private boolean result = false;

    public RowBean () {
      sessionId = FacesContext.getCurrentInstance().getExternalContext().getSessionId(true);
    }

    public void process() {
      setResult();
      // ORM.insert(this);
    }

    public String getSessionId () {
      return this.sessionId;
    }

    public void setResult() {
      this.result = ((X*X+Y*Y <= R*R/4) && (X <= 0) && (Y >= 0)) ||
        ((X <= 0) && (X >= -R/2) && (Y <= 0) && (Y >= -R)) ||
        ((X >= 0) && (Y <= 0) && (Y >= X * 2 - R));
    }

    public boolean getResult() {
      setResult();
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
