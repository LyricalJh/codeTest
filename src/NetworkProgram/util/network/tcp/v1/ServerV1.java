package NetworkProgram.util.network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소캣 시작 - 리스닝 포인트 : "  + PORT);

        Socket socket = serverSocket.accept();
        log("소켓 연결 " + socket);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // 클라이언트 문자 받기
        String receiveMsg = in.readUTF();
        log("client -> server : " + receiveMsg);


        // 클라이언트에게 문자 보내기
        String toSend = receiveMsg + " World";
        out.writeUTF(toSend);
        log("client <- server : " + toSend);

        // 자원정리
        log("연결종료 : " + socket);
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}
