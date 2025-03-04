package NetworkProgram.util.network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;


public class ClientV1 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        log("소캣 연결  : " + socket);

        // 서버로 문자 보내기
        String toSend = "Hello";
        out.writeUTF(toSend);
        log("client -> server : " + toSend);

        // 서버로부터 문자 받기
        String received = in.readUTF();
        log("client <- server : " + received);

        // 자원정리
        log("연결 종료 " + socket);
        in.close();
        out.close();
        socket.close();
    }
}
