package RMI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Transfer extends UnicastRemoteObject implements FileTransfer{
    private static final long serialVersionUID = -8151462725610737781L;

    public Transfer(String s) throws RemoteException
    {
        File st = new File(s);
        st.mkdir();
    }

    public void setFile(byte[] b, String fileName, int length) throws RemoteException
    {
        try
        {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(b);
        fos.flush();
        fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("File transfer sucessfull");

    }

    public byte[] getFile(String fileName) throws RemoteException
    {
        File ts = new File(fileName);
        byte[] b = new byte[(int) ts.length()];
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            

            fis.read(b, 0, b.length);
            fis.close();
            

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return b;
    }

    

}