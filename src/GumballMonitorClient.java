import java.rmi.Naming;

/**
 * Created by cjm on 9/7/16.
 */
public class GumballMonitorClient {

    public static void main(String[] args) {
        new GumballMonitorClient().go();
    }

    public void go() {
        try {
            GumballMachineRemote gumballRemote =
                    (GumballMachineRemote) Naming.lookup("rmi://127.0.0.1/GumballRemote");
            report(gumballRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 打印糖果机报告
    public void report(GumballMachineRemote gumballRemote) {
        try {
            System.out.println("\nGumball Machine: " + gumballRemote.getLocation());
            System.out.println("Current inventory: " + gumballRemote.getCount() + " gumballs");
            System.out.println("Current state: " + gumballRemote.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
