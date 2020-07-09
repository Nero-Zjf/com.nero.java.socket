package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * soket服务端基础
 * @created nero
 * @date 2018/9/19 17:33
 */
public class SocketServer {
    public static void run() throws IOException, InterruptedException {
        System.out.println("开启socket服务端");
        //实例化服务器socket对象
        ServerSocket serverSocket = new ServerSocket(9065);

        //等待客户端连接
        System.out.println("等待客户端连接");
        Socket socket = serverSocket.accept();

        //获取socket输入流，并读取客户端信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String info = null;

        while ((info = br.readLine()) != null) {
            System.out.println("客户端："+ info);
        }
        //关闭socket输入流
        socket.shutdownInput();

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);

        //获取socket输出流，并向客户端返回信息
        Thread.sleep(5000);
        pw.write("行程状态：正在用车\n");
        pw.flush();

        //关闭资源
        pw.close();
        os.close();
        br.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
