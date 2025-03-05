
package NetworkProgram.util.network.tcp.v4;

import NetworkProgram.util.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;
import static NetworkProgram.util.network.tcp.SocketCloseUtil.closeAll;

public class SessionV4 implements Runnable {

    private final Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

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
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, in, out);
            log("연결종료 : " + socket);
        }

    }
}
