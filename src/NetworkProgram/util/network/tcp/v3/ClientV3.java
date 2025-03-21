package NetworkProgram.util.network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static NetworkProgram.util.MyLogger.log;


public class ClientV3 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        log("소캣 연결  : " + socket);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("전송문자 : ");
            String toSend = scanner.nextLine();

            // 서버에게 문자 보내기
            out.writeUTF(toSend);
            log("client -> server : " + toSend);

            if (toSend.equals("exit")) {
                break;
            }

            // 서버로부터 문자 받기
            String received = in.readUTF();
            log("client <- server : " + received);
        }

        // 자원정리
        log("연결 종료 " + socket);
        in.close();
        out.close();
        socket.close();
    }
}
