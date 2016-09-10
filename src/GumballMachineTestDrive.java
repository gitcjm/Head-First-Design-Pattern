import java.rmi.Naming;

/**
 * Created by cjm on 9/9/16.
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        GumballMachineRemote gumballMachine = null;
        int count;      // 糖果数量
        count = Integer.parseInt(args[1]);

        try {
            gumballMachine =
                    new GumballMachine(args[0], count);
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
