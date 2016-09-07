import java.rmi.server.UnicastRemoteObject;

/**
 * Created by cjm on 9/7/16.
 */
public class GumballMachineRemoteImpl
        extends UnicastRemoteObject implements GumballMachineRemote {
    public String getLocation() {
        return this.location;
    }

    public int getCount() {
        return this.count;
    }

    public String getState() {
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


}
