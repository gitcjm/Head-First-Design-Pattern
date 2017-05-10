import java.rmi.Naming;

/**
 * Created by cjm on 9/10/16.
 */
public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        String[] location =
                {"rmi://127.0.0.1/gumballmachine",
                "rmi://127.0.0.1/gumballmachine"};

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
