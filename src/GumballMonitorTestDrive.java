import java.rmi.Naming;

/**
 * Created by cjm on 9/10/16.
 */
public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        String[] location =
                {"rmi://10.14.209.230/gumballmachine",
                "rmi://10.14.209.232/gumballmachine"};

        GumballMonitor[] monitors = new GumballMonitor[location.length];

        for (int i=0; i<location.length; i++) {
            try {
                GumballMachineRemote machine =
                        (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i] = new GumballMonitor(machine);
                System.out.println(monitors[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (GumballMonitor monitor : monitors) {
            monitor.report();
        }
    }
}
