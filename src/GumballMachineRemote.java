import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cjm on 9/7/16.
 * 糖果机远程接口
 */
public interface GumballMachineRemote extends Remote {
    String getLocation() throws RemoteException;
    int getCount() throws RemoteException;
    String getState() throws RemoteException;
}
