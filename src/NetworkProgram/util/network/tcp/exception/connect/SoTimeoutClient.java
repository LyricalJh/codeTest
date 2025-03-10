package NetworkProgram.util.network.tcp.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {
    public static void main(String[] args) throws IOException {
        Socket localhost = new Socket("localhost", 12345);
        InputStream in = localhost.getInputStream();
         try {
             localhost.setSoTimeout(3000); // 기본적으로 setSoTimeout을 설정하지 않는다면 무한 대기를 한다.
             int read = in.read();
             System.out.println("read = " + read);

         } catch (Exception e) {
             e.printStackTrace();
         }
         localhost.close();
    }
}
