package effctive_java.item_16;

public class PointV3 {

    private final int x;
    private final int y;

    public PointV3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointV3 getCurrentPosition() {
        return this;
    }

    public String getPositionMessage() {
        StringBuilder sb = new StringBuilder();
        return sb.append(x).append(", ").append(y).toString();
    }

    private int getX() {
        return x;
    }
    private int getY() {
        return y;
    }
}
