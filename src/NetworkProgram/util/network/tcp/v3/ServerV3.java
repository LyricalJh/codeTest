package NetworkProgram.util.network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class ServerV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소캣 시작 - 리스닝 포인트 : "  + PORT);

        while (true) {
            Socket socket = serverSocket.accept(); // 블록킹 메서드 (클라이언트 요청이 올때 까지 블록킹)
            log("소켓 연결: " + socket);

            SessionV3 session = new SessionV3(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
}
