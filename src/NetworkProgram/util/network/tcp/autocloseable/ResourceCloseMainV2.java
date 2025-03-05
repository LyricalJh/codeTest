package NetworkProgram.util.network.tcp.autocloseable;

public class ResourceCloseMainV2 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외처리 ");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {

        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("resource1"); // ex
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // callException 핵심 예외 발생
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            if (resource2 != null) {
                resource2.closeEx(); // closeException 하지만 closeEx 때문에 핵심예외를 삼겨버림
            }

            if (resource1 != null) {
                resource1.closeEx();
            }
        }
    }
}
