package RMI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileClient{
    

    public static void main(String[] args) throws RemoteException
    {
        String cts = "cts"; //client to server
        String stc = "stc"; //server to client
        try
        {
            
            Registry creg = LocateRegistry.getRegistry("127.0.0.1", 9004);
            FileTransfer obj = (FileTransfer)creg.lookup("remoteObj");
            
            if(cts.equals(args[0]))
            {
            File fileName = new File("C:\\Users\\SONY\\Downloads\\barc.txt");
            FileInputStream fis = new FileInputStream(fileName);
            byte[] b = new byte[(int) fileName.length()];

            fis.read(b, 0, b.length);
            obj.setFile(b, "E:\\storage\\barc.txt", b.length);

            fis.close();
            }

            if(stc.equals(args[0]))
            {
                File fileName = new File("E:\\Java\\Client");
                byte[] b = obj.getFile("C:\\Users\\SONY\\Downloads\\barc.txt");
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(b, 0, b.length);
                fos.flush();
                fos.close();

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}