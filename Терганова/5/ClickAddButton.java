import static java.lang.String.valueOf;

public class ClickAddButton implements ClickCallback {
    UI scene;
    Text textA;
    Text textB;

    ClickAddButton(UI sceneToAddElements, Text x, Text y) {
        scene = sceneToAddElements;
        textA = x;
        textB = y;
    }

    @Override
    public void onButtonClick() {
        Element adding = null;
        try {
            adding = generateRandomElement();
        } catch (NumberFormatException|ReadOnlyException exception){
            System.out.println(""Элемент не создан": " + exception.getMessage());
            return;
        }
        if(adding==null){
            return;
        }
        try {
            scene.addElement(adding);
        } catch (Exception1 Exception1) {
            System.out.println("Новый элемент " + adding.getTypeName() + " " + adding.getCaption() + " не добавлен:" + Exception1.getMessage());
        }
    }

    private Element generateRandomElement() throws NumberFormatException, Exception2 {
        int x = Integer.parseInt(textA.getText());
        int y = Integer.parseInt(textB.getText());
        if (x < 0 || y < 0 || x > UI.UI_WIDTH || y > UI.UI_HEIGHT) {
            throw new NumberFormatException("Координаты вне диапазона x[0," + UI.UI_WIDTH + "], y[0," + UI.UI_HEIGHT + "]");
        }
        String index = valueOf(UI.getNextId());
        switch (Element.random.nextInt(3)) {
            case 0:
                String caption1 = "Button:" + index;
                return new Button(x, y, caption1, new RandomButtonOnClick(index));
            case 1:
                String caption2 = "CheckBox:" + index;
                CheckBox checkBox = new CheckBox(x, y, caption2);
                if(!Element.random.nextBoolean()){
                    checkBox.setChecked(false);
                }
                return checkBox;
            case 2:
                String caption3 = "Text:" + index;
                String randomText = Text.getRandomString(Text.MAX_LENGTH_RANDOM_TEXT);
                return new Text(x, y, caption3, randomText);
            default:
                return null;
        }
    }
}