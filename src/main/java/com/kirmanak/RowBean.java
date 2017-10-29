package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;

@ManagedBean
@RequestScoped
public class RowBean implements Serializable {
    private double X;
    private double Y;
    private double R = 2;
    private boolean result;

    public void process() {
      // x,y,z should be alredy initialized
      // because that method in JSF after user's input
      result = ((X*X+Y*Y <= R*R/4) && (X <= 0) && (Y >= 0)) ||
        ((X <= 0) && (X >= -R/2) && (Y <= 0) && (Y >= -R)) ||
        ((X >= 0) && (Y <= 0) && (Y <= X * 2 + R));
      // connect to database and insert new data
      // sort of ORM.insert(this);
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
      if (!Double.isNaN(X) && Double.isFinite(X)) this.X = X;
    }

    public void setY (double Y) {
      if (!Double.isNaN(Y) && Double.isFinite(Y)) this.Y = Y;
    }

    public void setR (double R) {
      if (!Double.isNaN(R) && Double.isFinite(R)) this.R = R;
    }
}
