package NetworkProgram.util.network.tcp.v6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class ServerV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        SessionManagerV6 sessionManager = new SessionManagerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소캣 시작 - 리스닝 포인트 : "  + PORT);

        // shutdown hook 등록
        ShutDownHook shutDownHook = new ShutDownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutDownHook, "shutdown"));

        try {
            while (true) {
                Socket socket = serverSocket.accept(); // 블록킹 메서드 (클라이언트 요청이 올때 까지 블록킹)
                log("소켓 연결: " + socket);

                SessionV6 session = new SessionV6(socket, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료");
        }

    }

    static class ShutDownHook implements Runnable {
        private final ServerSocket serverSocket;
        private final SessionManagerV6 sessionManager;

        public ShutDownHook(ServerSocket serverSocket, SessionManagerV6 sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("셧다운 훅 실행!");
            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000); // 자원 정리 대기
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            }
        }
    }
}
