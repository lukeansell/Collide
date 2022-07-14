import java.awt.Color;

public class ObjD {
    private Obj obj;
    private Color c;

    public ObjD(Obj inOb, Color inC) {
        obj = inOb;
        c = inC;
    }

    public Obj getObj() {
        return obj;
    }

    public Color getC() {
        return c;
    }

    @Override
    public String toString() {
        return "( " + obj + ")";
    }
}
