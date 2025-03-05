package NetworkProgram.util.network.tcp.v5;

import NetworkProgram.util.network.tcp.SocketCloseUtil;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static NetworkProgram.util.MyLogger.log;
import static NetworkProgram.util.network.tcp.SocketCloseUtil.*;


public class ClientV5 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            log("소켓 연결 : " + socket);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("전송 문자: ");
                String toSend = scanner.nextLine();

                // 서버에게 문자 보내기
                out.writeUTF(toSend);
                log("client -> server: " + toSend);
                if (toSend.equals("exit")) {
                    break;
                }
                // 서버로부터 문자 받기
                String received = in.readUTF();
                log("client <- server: " + received);
            }
        } catch (IOException e) {
            log(e);
        }
    }
}
