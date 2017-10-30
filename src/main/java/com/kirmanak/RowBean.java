package com.kirmanak;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.Session;

import java.io.Serializable;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL, dynamicUpdate = true)

@ManagedBean
@RequestScoped
public class RowBean implements Serializable {
    private static final long serialVersionUID = -1798070786993154676L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @NotNull(message = "X can't be empty.")
    @Min(value = -2, message = "X should be -2 or more.")
    @Max(value = 2, message = "X should be 2 or less.")
    @Column(name = "x", unique = true, nullable = false)
    private int X = 0;

    @NotNull(message = "Y can't be empty.")
    @DecimalMin(value = "-5.0", message = "Y should be -5 or more.")
    @DecimalMax(value = "5.0", message = "Y should be 5 or less.")
    @Column(name = "y", unique = true, nullable = false, length = 100)
    private double Y = 0.0;

    @NotNull(message = "R can't be empty.")
    @DecimalMin(value = "2.0", message = "R should be 2 or more.")
    @DecimalMax(value = "5.0", message = "R should be 5 or less.")
    @Column(name = "r", unique = false, nullable = false, length = 100)
    private double R = 2.0;

    @Column(name = "res", unique = false, nullable = false, length = 100)
    private boolean result = false;

    public void process() {
      setResult();
      final Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.save(this);
      session.getTransaction().commit();
      HibernateUtil.shutdown();
    }

    public void setResult() {
      this.result = ((X*X+Y*Y <= R*R/4) && (X <= 0) && (Y >= 0)) ||
        ((X <= 0) && (X >= -R/2) && (Y <= 0) && (Y >= -R)) ||
        ((X >= 0) && (Y <= 0) && (Y <= X * 2 + R));
    }

    public boolean getResult() {
      setResult();
      return result; 
    }

    public int getX () {
      return X;
    }

    public double getY () {
      return Y;
    }

    public double getR () {
      return R;
    }

    public void setX (int X) {
      this.X = X;
    }

    public void setY (double Y) {
      this.Y = Y;
    }

    public void setR (double R) {
      this.R = R;
    }
}
