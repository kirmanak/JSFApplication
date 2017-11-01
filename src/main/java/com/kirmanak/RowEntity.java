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

    @Column(name = "y", unique = false, nullable = false, length = 100)
    private double Y = 0.0;

    @Column(name = "r", unique = false, nullable = false, length = 100)
    private double R = 2.0;

    @Column(name = "integerR", unique = false, nullable = false, length = 100)
    private int integerR = 200;

    @Column(name = "res", unique = false, nullable = false, length = 100)
    private boolean result = false;
}