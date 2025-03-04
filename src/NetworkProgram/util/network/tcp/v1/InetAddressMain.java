package NetworkProgram.util.network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println("google = " + google);

        //1. hosts 파일을 찾아 ip 와 매핑되는것을 찾는다
        //2. hosts 파일에 없는 ip 라면 dns 서버에 요청해서 Ip 주소를 얻는다.

    }
}
