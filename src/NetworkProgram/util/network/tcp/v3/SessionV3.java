package NetworkProgram.util.network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class SessionV3 implements Runnable {

    private final Socket socket;

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

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

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
