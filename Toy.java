import java.io.Serializable;

public class Toy implements Serializable {
    private final int toyID;
    String toyName;
    private static int toysCounter;
    static final long serialVersionUID = 1L;

    public Toy(String toyName) {
        this.toyID = toysCounter++;
        this.toyName = toyName;
    }

    @Override
    public String toString() {
        return toyName;
    }
}
