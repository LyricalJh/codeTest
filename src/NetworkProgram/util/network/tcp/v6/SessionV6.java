
package NetworkProgram.util.network.tcp.v6;

import NetworkProgram.util.network.tcp.SocketCloseUtil;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;
import static NetworkProgram.util.network.tcp.SocketCloseUtil.closeAll;

public class SessionV6 implements Runnable {

    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final SessionManagerV6 sessionManager;
    private volatile boolean closed = false;

    public SessionV6(Socket socket, SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out= new DataOutputStream(socket.getOutputStream());
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }

    @Override
    public void run() {
       try  {
           while (true) {
               String received = in.readUTF();
               log("client -> server : " + received); // 블랑킹 하다가 셧다운 훅이 오면 SocketException: Socket closed 예외 발생

               if (received.equals("exit")) {
                   break;
               }

               String toSend = received + " World!";
               out.writeUTF(toSend);
               log("client <- server : " + toSend);
           }
       } catch (Exception e) {
           log(e); // SocketException: Socket closed 예외 로그남김  Thread-0
       } finally {
           sessionManager.remove(this);
           close();
       }
    }
    // 세션 종료시, 서버 종료시 동시에 호출될 수 있다.
    // 원자적 메서드 (* 앞에 if 문을 걸어 객체 상태가 이상한 상태에 (* 중복호출 * ) 빠지지 않게 해준다.)
    public synchronized void close() {
        if (closed) return;

        closeAll(socket, in, out);
        closed = true;
        log("연결종료 : " + socket + "isClosed" + socket.isClosed());
    }
}
