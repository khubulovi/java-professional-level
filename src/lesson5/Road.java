package lesson5;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " metres";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " Started: " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
            System.out.println(c.getName() + " End: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

