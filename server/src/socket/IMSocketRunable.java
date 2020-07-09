package socket;

import java.io.*;
import java.net.Socket;

public class IMSocketRunable implements Runnable {

    private Socket socket;

    private IMSocketRunable() {

    }

    public IMSocketRunable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            for (int i = 0; i < 10; i++) {
                pw.write("code-1行程状态:正在用车 " + i + "  " + System.currentTimeMillis() + "\n");
                pw.flush();
                Thread.sleep(2000);
            }
            pw.write("code-9\n");
            pw.flush();
            pw.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
