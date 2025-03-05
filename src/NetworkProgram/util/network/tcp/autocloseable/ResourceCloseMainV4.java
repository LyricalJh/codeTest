package NetworkProgram.util.network.tcp.autocloseable;

public class ResourceCloseMainV4 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외처리");

            // 념겨받은 부가 예외 처리들
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressed: " + throwable);
            }

            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외처리 ");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        try (ResourceV2 resource1 = new ResourceV2("resource1");
             ResourceV2 resource2 = new ResourceV2("resource2")) {

            resource1.call();
            resource2.callEx(); // callException 자원 정리 예외는 해당 라인 코드에 넘겨준다.

        } catch (CallException e) {
            System.out.println("ex " + e);
            throw e;
        }
    }
}
