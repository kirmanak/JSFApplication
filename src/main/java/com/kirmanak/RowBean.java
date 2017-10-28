package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;

@ManagedBean(name="row")
@RequestScoped
public class RowBean implements Serializable {
  private String x;
  private String y;
  private String r;

  public RowBean () {
  }

  public void setX (String x) {
    this.x = x;
  }

  public void setY (String y) {
    this.y = y;
  }

  public void setR (String r) {
    this.r = r;
  }

  public String getX () {
    return this.x;
  }

  public String getY () {
    return this.y;
  }

  public String getR () {
    return this.r;
  }
}
