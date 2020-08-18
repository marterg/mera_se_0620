public class Text extends Element {
    String text;
    public static final int MAX_LENGTH_RANDOM_TEXT = 10;

    public Text(int x, int y, int width, int height, String caption, String text) {
        super(x, y, width, height, caption);
        this.text = text;
    }

    public Text(int x, int y, String caption, String text) {
        super(x, y, caption);
        this.text = text;
    }

    @Override
    public String getTypeName(){
        return "Текст";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws Exception2 {
        if (!isEnabled()) {
            throw new Exception2(Exception2.DEFAULT_READONLY_MESSAGE);
        }
        this.text = text;
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
                ", текст='" + text +
                "'}";
    }

    public static String getRandomString(int length){
        StringBuilder str = new StringBuilder();
        if(length <= 0){
            return str.toString();
        }
        int codeLetterA = 'A';
        int codeLetterZ = 'Z';
        for (int i = 0; i < length; i++) {
            char c = (char)(Element.random.nextInt(codeLetterZ-codeLetterA+1)+codeLetterA);
            str.append(c);
        }
        return str.toString();
    }
}