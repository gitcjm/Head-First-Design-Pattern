package gumballmachine;

/**
 * Created by cjm on 9/6/16.
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        int count = 0;

        if (args.length < 2) {
            System.out.println("gumballmachine.GumballMachine <name> <inventory>");
            System.exit(1);
        }

        // 糖果机
        count = Integer.parseInt(args[1]);
        GumballMachine gumballMachine = new GumballMachine(args[0], count);
        // 糖果机监视器
        GumballMonitor monitor = new GumballMonitor(gumballMachine);

        gumballMachine.insertQuarter();

        monitor.report();
    }
}
