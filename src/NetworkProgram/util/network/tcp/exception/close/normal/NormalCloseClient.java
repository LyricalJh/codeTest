package NetworkProgram.util.network.tcp.exception.close.normal;

import java.io.*;
import java.net.Socket;

import static NetworkProgram.util.MyLogger.log;

public class NormalCloseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소캣 연결: " + socket);
        InputStream inputStream = socket.getInputStream();

        readByInputStream(inputStream, socket);
        readByBufferedReader(inputStream, socket);
        readByDataInputStream(inputStream, socket);

        log("연결 종료 = " + socket.isClosed());
    }

    private static void readByInputStream(InputStream inputStream, Socket socket) throws IOException {
        int read = inputStream.read();
        log("read = " + read);
        if (read == -1) {
            inputStream.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(InputStream inputStream, Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readString = bufferedReader.readLine();
        log("reading = " + readString);

        if (readString == null) {
            bufferedReader.close();
            socket.close();
        }
    }

    private static void readByDataInputStream(InputStream inputStream, Socket socket) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            dataInputStream.readUTF();
        } catch (EOFException e) {
            log(e);
        } finally {
            dataInputStream.close();
            socket.close();
        }
    }
}
