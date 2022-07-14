public class Balls {

    public static void main(String[] args) {
        double gap = 0.4;
        Obj[] obs = new Obj[5];
        Obj ob1 = new Obj(new Vector(50.0, 30.0), new Vector(0.0, 40.0), 2.0, 1.0);
        // obs[0] = ob1;
        // obs[1] = new Obj(new Vector(50.0, 60.0), new Vector(), 2.0, 1.0);
        // obs[2] = new Obj(new Vector(55.0 + gap, 60.0 + 8.660254 + gap), new Vector(),
        // 2.0, 1.0); 
        // obs[3] = new Obj(new Vector(45.0 - gap, 60.0 + 8.660254 + gap), new Vector(),
        // 2.0, 1.0);

        obs[0] = new Obj(new Vector(30.0, 50.0), new Vector(20.0, 0.0), 2.0, 1.0);
        obs[1] = new Obj(new Vector(40.0, 50.0), new Vector(), 2.0, 1.0);
        obs[2] = new Obj(new Vector(50.0, 50.0), new Vector(), 2.0, 1.0);
        obs[3] = new Obj(new Vector(60.0, 50.0), new Vector(), 2.0, 1.0);
        obs[4] = new Obj(new Vector(70.0, 50.0), new Vector(), 2.0, 1.0);

        Sim sim = new Sim(obs);
        sim.start();
    }

}
