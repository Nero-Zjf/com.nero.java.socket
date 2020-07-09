import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) {
        try {
            /* 百度可能有多个IP地址，解析回来，所以我们可以用一个数组装起来 */
            InetAddress[] addrs = InetAddress.getAllByName("www.baidu.com");
            if (addrs != null && addrs.length > 0) {
                for (InetAddress addr : addrs) {
                    System.out.println("--->" + addr.getHostAddress());
                }
            }
            System.out.println(InetAddress.getByAddress(new byte[]{14, (byte) 215, (byte) 177, 38}).getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
