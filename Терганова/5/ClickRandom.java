public class ClickRandom implements ClickCallback {
    String buttonIndex;

    public ClickRandom(String buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    @Override
    public void onButtonClick() throws NumberFormatException {
        System.out.println("Нажата случайная кнопка с №=" + buttonIndex);
    }
}