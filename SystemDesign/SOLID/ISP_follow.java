// ISP FIXED — Small focused interfaces, each class implements only what it needs

interface Workable  { void work(); }
interface Eatable   { void eat(); }
interface Sleepable { void sleep(); }

// Human implements all three — it can do all
class HumanWorker implements Workable, Eatable, Sleepable {
    public void work()  { System.out.println("Human working"); }
    public void eat()   { System.out.println("Human eating"); }
    public void sleep() { System.out.println("Human sleeping"); }
}

// Robot only implements what it actually does
class RobotWorker implements Workable {
    public void work() { System.out.println("Robot working"); }
    // no eat(), no sleep() — no broken promises
}

public class ISP_follow {
    public static void main(String[] args) {
        Workable human = new HumanWorker();
        human.work(); // works

        Workable robot = new RobotWorker();
        robot.work(); // works — no useless methods forced on it
    }
}