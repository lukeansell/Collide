import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjMaker {

    public static Obj[] makeFromFile(String file) {
        try {
            Scanner scFile = new Scanner(new File(file));
            ArrayList<Obj> obs = new ArrayList<>();
            while (scFile.hasNextLine()) {
                Scanner scLine = new Scanner(scFile.nextLine());
                scLine.next();
                String px = scLine.next();
                px = px.substring(1, px.length() - 1);
                // System.out.println(px);
                String py = scLine.next();
                py = py.substring(0, py.length() - 1);
                // System.out.println(py);
                scLine.next();
                String vx = scLine.next();
                vx = vx.substring(1, vx.length() - 1);
                // System.out.println(vx);
                String vy = scLine.next();
                vy = vy.substring(0, vy.length() - 1);
                // System.out.println(vy);
                scLine.next();
                String r = scLine.next();
                scLine.next();
                String mass = scLine.next();
                scLine.close();

                Vector pos = new Vector(Double.parseDouble(px.trim()), Double.parseDouble(py.trim()));
                Vector vel = new Vector(Double.parseDouble(vx.trim()), Double.parseDouble(vy.trim()));
                Obj ob = new Obj(pos, vel, Double.parseDouble(r.trim()), Double.parseDouble(mass.trim()));
                obs.add(ob);
                // System.out.println(ob);
            }

            scFile.close();
            Obj[] objs = new Obj[obs.size()];
            for (int i = 0; i < objs.length; i++) {
                objs[i] = obs.get(i);
                // System.out.println(ob);
            }
            return objs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
