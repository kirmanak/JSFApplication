package com.kirmanak;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OptimisticLockType;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL, dynamicUpdate = true)
public class RowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
	
    @Column(name = "x", unique = false, nullable = false)
    private double X;

    @Column(name = "y", unique = false, nullable = false)
    private double Y;

    @Column(name = "r", unique = false, nullable = false)
    private double R;

    @Column(name = "integerR", unique = false, nullable = false)
    private int integerR;

    @Column(name = "result", unique = false, nullable = false)
    private boolean result;

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

    public int getIntegerR () {
      return integerR;
    }

    public void setResult(final boolean result) {
      this.result = result;
    }


    public void setX (final double X) {
      this.X = X;
    }

    public void setY (final double Y) {
      this.Y = Y;
    }

    public void setIntegerR (final int R) {
      this.integerR = R;
    }

    public void setR (final double R) {
      this.R = R;
    }
}