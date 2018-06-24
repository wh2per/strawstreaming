import java.io.*;
import java.net.Socket;

public class SlaveThread extends Thread {
    private Socket sock;

    public void run(){
        try{

            //socket
            sock = new Socket("127.0.0.1",9999);
            // In & out streams.
            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();
            // PrintWriter & bufferReader.
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            // Properties.
            String msg = null;

            Control control = new Control(out,in,pw,br);
            control.ServerToSlave();

            pw.close();
            br.close();
            sock.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}