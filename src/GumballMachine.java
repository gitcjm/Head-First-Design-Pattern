import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by cjm on 9/9/16.
 */
public class GumballMachine
        extends UnicastRemoteObject implements GumballMachineRemote {

    final static int SOLD_OUT = 0;  // 售罄
    final static int NO_QUARTER = 1;    // 没硬币
    final static int HAS_QUARTER = 2;   // 有硬币
    final static int SOLD = 3;  // 正在出售糖果
    final static int WINNER = 4;   // 赢家状态,转动曲柄参与抽奖

    int state = SOLD_OUT;   // 糖果机的初始状态为售罄
    int count = 0;
    String location;    // 糖果机的位置,远程JVM的IP地址

    public GumballMachine(String location, int numberGumballs)
            throws RemoteException {
        this.location = location;
        this.count = numberGumballs;
        if (count > 0) {
            state = NO_QUARTER; // 待售
        }
    }

    // 实现接口的三个方法
    public String getLocation() throws RemoteException {
        return this.location;
    }

    public int getCount() throws RemoteException {
        return this.count;
    }

    public String getState() throws RemoteException {
        String result = "";
        switch (this.state) {
            case SOLD_OUT:
                result = "sold out";
                break;
            case SOLD:
                result = "sold";
                break;
            case NO_QUARTER:
                result = "waiting for quarter";
                break;
            case HAS_QUARTER:
                result = "has quarter";
                break;
        }
        return result;
    }

    // 糖果机的其他方法
    // 投入一枚硬币（25分钱）
    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You can't insert another quarter");
                break;
            case NO_QUARTER:
                System.out.println("You inserted a quarter");
                state = HAS_QUARTER;
                break;
            case SOLD_OUT:
                System.out.println("You can't insert a quarter, the machine is sold out");
                break;
            case SOLD:
                System.out.println("Please wait, we're already giving you a gumball");
                break;
            case WINNER:
                System.out.print("You can't insert another quarter");
                break;
        }
    }

    // 退回硬币
    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("Quarter returned");
                state = NO_QUARTER;
                break;
            case NO_QUARTER:
                System.out.println("You haven't inserted a quarter");
                break;
            case SOLD_OUT:
                System.out.println("You can't eject, you haven't inserted a quarter yet");
                break;
            case SOLD:
                System.out.println("Sorry, you already turned the crank");
                break;
            case WINNER:
                System.out.print("Sorry, you already turned the crank, and already get a winning!");
                break;
        }
    }

    // 转动曲柄，开始售出糖果, 同时也参与了抽奖
    public void turnCrank() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You turned...");
                state = SOLD;
                dispense();
                break;
            case NO_QUARTER:
                System.out.println("You turned but there's no quarter");
                break;
            case SOLD_OUT:
                System.out.println("You turned but there's no gumballs");
                break;
            case SOLD:
                System.out.println("Turning twice doesn't get you another gumball!");
                break;
            case WINNER:
                System.out.println("You turned..., and get a winning!");
                state = SOLD;
                dispense();
                break;
        }
    }

    // 发放糖果
    private void dispense() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("No gumball dispensed");
                break;
            case NO_QUARTER:
                System.out.println("You need to pay first");
                break;
            case SOLD_OUT:
                System.out.println("No gumball dispensed");
                break;
            case SOLD:
                System.out.println("A gumball comes rolling out the slot");
                count = count - 1;
                if (count == 0) {
                    System.out.println("Oops, out of gumballs");
                    state = SOLD_OUT;
                } else {
                    state = NO_QUARTER;
                }
                break;
            case WINNER:
                System.out.println("Two gumball comes rolling out the slot");
                count = count - 2;
                if (count <= 0) {
                    System.out.println("Oops, out of gumballs");
                    state = SOLD_OUT;
                } else {
                    state = NO_QUARTER;
                }
                break;
        }
    }

    // 填充糖果
    public void refill(int count) {
        this.count = this.count + count;
        if (count > 0) {
            state = NO_QUARTER;
            System.out.println("\nGumball machine is refilled " + count + " gumballs");
        }
    }

    public String toString() {
        String result = "\n";
        //result = result + "Mighty Gumball Inc.\n";
        //result = result + "Java-enabled Standing Gumball Model #2016\n";
        result = result + "Inventory: " + count + " gumballs\n";
        if (count > 0) {
            result = result + "Machine is waiting for quarter\n";
        } else {
            result = result + "Machine is sold out";
        }
        return result;
    }
}
