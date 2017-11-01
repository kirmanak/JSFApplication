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
    private double X = 0.0;

    @Column(name = "y", unique = false, nullable = false)
    private double Y = 0.0;

    @Column(name = "r", unique = false, nullable = false)
    private double R = 2.0;

    @Column(name = "integerR", unique = false, nullable = false)
    private int integerR = 200;

    @Column(name = "res", unique = false, nullable = false)
    private boolean result = false;

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
    }

    public void setR (final double R) {
      this.R = R;
    }
}