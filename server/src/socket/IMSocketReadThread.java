package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class IMSocketReadThread implements Runnable {
    private Socket socket;

    public IMSocketReadThread(Socket socket) throws SocketException {
        this.socket = socket;
        System.out.println("default SoTimeout" + socket.getSoTimeout());
        ;
        socket.setSoTimeout(4000);
    }

    @Override
    public void run() {
        try {
            //获取socket输入流，并读取客户端信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println(info);
                Thread.sleep(200);
            }
            System.out.println("socket退出");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
