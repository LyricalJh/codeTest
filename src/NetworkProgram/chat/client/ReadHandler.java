package NetworkProgram.chat.client;

import NetworkProgram.util.network.tcp.v6.ClientV6;

import java.io.DataInputStream;
import java.io.IOException;

import static NetworkProgram.util.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream input;
    private final Client client;
    public boolean closed = false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    public synchronized void close() {
        if (closed) {
            return;
        }
        closed = true;
        log("readHandler closed");
    }

    @Override
    public void run() {

        try {
            while (true) {
                String received = input.readUTF();
                System.out.println(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }

    }
}
