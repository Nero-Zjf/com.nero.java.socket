package socket;

import java.io.*;
import java.net.Socket;

/**
 * socket客户端基础
 * @created nero
 * @date 2018/9/19 17:58
 */
public class SocketClient {
    public static void run() throws IOException, InterruptedException {
        System.out.println("打开socket客户端");
        //实例化socket对象，指定socket服务器的地址端口
        Socket socket = new Socket("localhost", 9065);

        //获取输出流，向服务器发送信息
        OutputStream os = socket.getOutputStream();//输出字节流
        PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流

//        while (true) {
//            pw.println("1");
//            pw.flush();
//            Thread.sleep(3000);
//        }
        for (int i = 0; i < 1000; i++) {
            pw.println(i+"fsadfaaaaaaaaaaaaaaaaaaaaaaeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeesssssssssssssssssdffewrwtafdsf");
            pw.flush();
//            Thread.sleep(1000);
        }

        socket.close();


//        socket.shutdownOutput();

//        socket.shutdownOutput();//关闭输出流
//
//        //获取输入流，并读取服务端的响应信息
//        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//
//        String info = null;
//
//        while ((info = br.readLine()) != null) {
//            System.out.println("服务端：" + info);
//        }

        //关闭资源
//        os.close();
//        pw.close();
//        is.close();
//        isr.close();
//        br.close();
//        socket.close();
    }
}
