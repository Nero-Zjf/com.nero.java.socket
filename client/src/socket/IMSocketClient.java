package socket;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

/**
 * socket客户端(及时通信)
 *
 * @created nero
 * @date 2018/9/19 17:59
 */
public class IMSocketClient {
    public static void run() throws IOException {
        System.out.println("打开socket客户端");
        //实例化socket对象，指定socket服务器的地址端口
        Socket socket = new Socket("localhost", 8085);
        readSocketMsg(socket);
    }

    public static void readSocketMsg(Socket socket) throws IOException {
        //获取输出流，向服务器发送信息
        OutputStream os = socket.getOutputStream();//输出字节流
        PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
        pw.write("custId:1;");
        pw.flush();
        socket.shutdownOutput();

        //获取输入流，并读取服务端的响应信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String info = null;

        try {
            while (!socket.isClosed() && (info = br.readLine()) != null) {
                if (info.substring(0, 5).equals("code-")) {
                    String code = info.substring(5, 6);
                    switch (code) {
                        case "1":
                            System.out.println("服务端：" + info.substring(6));
                            break;
                        case "9":
                            System.out.println("用车结束，关闭客户端");
                            socket.close();
                            break;
                        default:
                            System.out.println("服务端：" + info.substring(6));
                            break;
                    }
                } else {
                    System.out.println("服务端：" + info.substring(6));
                }
            }
        } catch (SocketException |SocketTimeoutException ex) {
            System.out.println(ex.getMessage());
            System.out.println("重新连接服务器");
            socket =  new Socket("localhost", 8085);
            readSocketMsg(socket);
        }
    }
}
