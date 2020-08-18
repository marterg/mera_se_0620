public class CheckBox extends Element implements Click {
    boolean isChecked;

    public CheckBox(int x, int y, String caption) {
        super(x, y, caption);
        isChecked = true;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) throws Exception2 {
        if (!isEnabled()) {
            throw new Exception2(Exception2.DEFAULT_READONLY_MESSAGE);
        }
        isChecked = checked;
    }

    @Override
    public void click() {
        isChecked = !isChecked;
    }

    @Override
    public String getTypeName() {
        return "Галочка";
    }

    @Override
    public String toString() {
        String state = isEnabled() ? "вкл" : "выкл";
        String checked = isChecked ? "выбран" : "не выбран";
        return getTypeName() +" '"+ getCaption() +"' {" +
                "x=" + getX() +
                ", y=" + getY() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", " + state +
                ", " + checked +
                '}';
    }
}