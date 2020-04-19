package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer{
    public static void main(String[] args) throws RemoteException
    {
        Registry reg = LocateRegistry.createRegistry(9004);
        Transfer impl = new Transfer("E://storage");
        try
        {
        reg.bind("remoteObj", impl);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Server running");


    }

}