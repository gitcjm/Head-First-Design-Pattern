package myremote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by cjm on 9/6/16.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {}

    public String sayHello() throws RemoteException {
        return "Server says, 'Hey'";
    }

    public int calcCount(int num1, int num2) throws RemoteException {
        return num1 + num2;
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
