package NetworkProgram.util.network.tcp.exception.close.normal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class NormalCloseServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소캣연결: = " + socket);

        Thread.sleep(1000);
        socket.close();
        log("소캣 종료");
    }
}
