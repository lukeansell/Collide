import java.awt.Color;

public class App {
    private static int[] scale = { 0, 100 };
    private static Stopwatch updated;
    private static Stopwatch sw;
    private static int updates = 0;

    public static void main(String[] args) throws Exception {
        initDraw();
        Obj ob = new Obj(new Vector(80.0, 50.0), new Vector(5.0, 8.0), 4.0);
        Obj ob2 = new Obj(new Vector(60.0, 50.0), new Vector(0.0, 0.0), 4.0);
        ObjD[] obs = new ObjD[2];
        obs[0] = new ObjD(ob, StdDraw.BLUE);
        obs[1] = new ObjD(ob2, StdDraw.GREEN);
        Obj[] objs = new Obj[2];
        objs[0] = ob;
        objs[1] = ob2;
        Color[] colors = { StdDraw.BLUE, StdDraw.GREEN };

        updated = new Stopwatch();
        sw = new Stopwatch();

        while (!StdDraw.isKeyPressed(27)) {
            // info(obs);
            StdDraw.pause(5);
            update(objs, colors);
        }
        double t = sw.elapsedTime();
        System.out.println("Ended");
        System.out.println("Time: " + t + " Updates: " + updates);
        System.out.println("Avg fps: " + (updates / t));
        StdDraw.pause(50);
        System.exit(0); 
    }

    public static void info(ObjD[] obs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < obs.length; i++)
            sb.append(i + " " + obs[i] + "\n");
        System.out.println(sb);
    }

    public static void initDraw() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(scale[0], scale[1]);
        StdDraw.show();
    }

    public static void update(Obj[] obs, Color[] colors) {
        // double t = updated.elapsedTime();
        // add velocity to pos
        updateV(obs);
        // collisons
        updateC(obs);

        // update display
        updateDraw(obs, colors);
        // reset update time
        updated = new Stopwatch();
        updates++;
    }

    public static void updateC(Obj[] obs) {
        // wall collisons
        for (Obj ob : obs)
            if (ob.collideWallX(scale[1]))
                ob.getVel().setX(ob.getVel().getX() * -1);
            else if (ob.collideWallY(scale[1]))
                ob.getVel().setY(ob.getVel().getY() * -1);

        // obj collisons

    }

    public static void updateV(Obj[] obs) {
        double t = updated.elapsedTime();
        // add velocity to pos
        for (Obj ob : obs) {
            Vector dc = Vector.times(ob.getVel(), t);
            ob.getPos().add(dc);
        }
    }

    public static void updateDraw(Obj[] obs, Color[] colors) {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledSquare(50, 50, 50);
        drawGridLines();
        drawObj(obs, colors);
        StdDraw.show();
    }

    public static void drawGridLines() {
        int s = 10;
        double d = scale[1] / s;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < s; i++) {
            StdDraw.line(i * d, 0, i * d, 100);
            StdDraw.line(0, i * d, 100, i * d);
        }
    }

    public static void drawObj(Obj ob, Color c) {
        double x = ob.getPos().getX();
        double y = ob.getPos().getY();
        StdDraw.setPenColor(c);
        StdDraw.filledCircle(x, y, ob.getR());
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(x, y, 0.2);
    }

    public static void drawObj(Obj[] obs, Color[] colors) {
        for (int i = 0; i < obs.length; i++)
            drawObj(obs[i], colors[i]);
    }
}
