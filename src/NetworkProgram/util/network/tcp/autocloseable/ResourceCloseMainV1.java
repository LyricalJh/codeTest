package NetworkProgram.util.network.tcp.autocloseable;

public class ResourceCloseMainV1 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외처리");
        } catch (CloseException e) {
            System.out.println("CloseException 예외처리 ");
        }
    }

    private static void logic() throws CallException {
        ResourceV1 resourceV1 = new ResourceV1("resource1");
        ResourceV1 resourceV2 = new ResourceV1("resource2");

        resourceV1.call();
        resourceV2.callEx(); // callException

        System.out.println("자원 정리 ");
        resourceV2.close();
        resourceV1.close();
    }
}
