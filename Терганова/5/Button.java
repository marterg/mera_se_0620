public class Button extends Element implements Click {
    ClickCallback callback;

    public Button(int x, int y, int width, int height, String caption, ClickCallback callback) {
        super(x, y, width, height, caption);
        this.callback = callback;
    }

    public Button(int x, int y, String caption, ClickCallback callback) {
        super(x, y, caption);
        this.callback = callback;
    }

    @Override
    public void click() {
        callback.onButtonClick();
    }

    @Override
    public String getTypeName() {
        return "Button";
    }

    @Override
    public String toString() {
        String state = isEnabled() ? "вкл" : "выкл";
        return getTypeName() +" '"+ getCaption() +"' {" +
                "x=" + getX() +
                ", y=" + getY() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", " + state +
                '}';
    }
}
