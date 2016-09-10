package myremotetest;

import java.rmi.Naming;

/**
 * Created by cjm on 9/6/16.
 */
public class MyRemoteClient {

    public static void main(String[] args) {
        new MyRemoteClient().go();

    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            int c = service.calcCount(3, 9);
            System.out.println(s + ", the count is: " + c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
