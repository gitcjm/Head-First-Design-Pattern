package myremote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cjm on 9/6/16.
 */

public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
    public int calcCount(int num1, int num2) throws RemoteException;
}
