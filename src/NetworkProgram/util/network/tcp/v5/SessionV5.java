
package NetworkProgram.util.network.tcp.v5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class SessionV5 implements Runnable {

    private final Socket socket;

    public SessionV5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
       try (socket;
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

           while (true) {
               String received = in.readUTF();
               log("client -> server : " + received);

               if (received.equals("exit")) {
                   break;
               }

               String toSend = received + " World!";
               out.writeUTF(toSend);
               log("client <- server : " + toSend);
           }

       } catch (Exception e) {
           throw new RuntimeException(e);
       }

       log("연결종료 : " + socket + "isClosed" + socket.isClosed());
    }
}
