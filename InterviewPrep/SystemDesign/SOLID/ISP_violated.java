// ISP VIOLATED — Classes forced to implement methods they don't use

interface Worker {
    void work();
    void eat();
    void sleep();
}

class HumanWorker implements Worker {
    public void work()  { System.out.println("Human working"); }
    public void eat()   { System.out.println("Human eating"); }
    public void sleep() { System.out.println("Human sleeping"); }
}

class RobotWorker implements Worker {
    public void work() { System.out.println("Robot working"); }

    // Robot doesn't eat or sleep — forced to implement useless methods
    public void eat()   { throw new UnsupportedOperationException("Robots don't eat!"); }
    public void sleep() { throw new UnsupportedOperationException("Robots don't sleep!"); }
}

public class ISP_violated {
    public static void main(String[] args) {
        Worker robot = new RobotWorker();
        robot.work();
        robot.eat();   // crashes — forced to implement but can't do it
    }
}