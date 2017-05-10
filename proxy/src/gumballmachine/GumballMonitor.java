package gumballmachine;

/**
 * Created by cjm on 9/6/16.
 * 糖果机远程监视器
 */
public class GumballMonitor {
    GumballMachine machine;

    public GumballMonitor(GumballMachine machine) {
        this.machine = machine;
    }

    // 打印糖果机报告
    public void report() {
        System.out.println("\nGumball Machine: " + machine.getLocation());
        System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        System.out.println("Current state: " + machine.getState());
    }
}
