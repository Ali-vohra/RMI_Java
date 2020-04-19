package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileTransfer extends Remote
{
    public void setFile(byte[] b, String fileName, int length) throws RemoteException;
    public byte[] getFile(String fileName) throws RemoteException;
}