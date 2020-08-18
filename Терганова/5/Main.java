import static java.lang.String.valueOf;

public class Main {

    public static void main(String[] args) {
        UI scene = new UI();
        System.out.println("Определение координат и кнопки...");
        Text textA = new Text(7,5, 19, 8, "X", "0");
        Text textB = new TextField(7,15, 19, 8, "Y", "0");
        Button addElementButton = new Button(7, 14, 21, 28, "Добавить элемент", new ClickAddButton(scene, textA, textB));
        try {
            scene.addElement(textA);
            scene.addElement(textB);
            scene.addElement(addElementButton);
        } catch (Exception1 ex){
            System.out.println(""Элемент не добавлен": " + ex.getMessage());
            return;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Добавление случайного элемента "+i+"..");
            String randomX = valueOf(Element.random.nextInt(UI.UI_WIDTH));
            String randomY = valueOf(Element.random.nextInt(UI.UI_HEIGHT));
            try {
                textA.setText(randomX);
                textB.setText(randomY);
            } catch (Exception2 Exception2) {
                System.out.println("Случайные координаты ошибочны");
            }
            addElementButton.click();
        }

        System.out.println("Список элементов:");
        for (Element element: scene.getElementsList()){
            System.out.println(element);
        }

        System.out.println("Пробуем клик:");
        for (Element element : scene.getElementsList()){
            if (element instanceof Click){
                if(element.equals(addElementButton)){
                    System.out.println("-пропускаем кнопку "+addElementButton.getCaption());
                } else{
                    ((Click) element).click();
                    if(element instanceof CheckBox){
                        String checked = ((CheckBox)element).isChecked ? "выбран" : "не выбран";
                        System.out.println("Элемент "+element.getCaption()+"имеет новое состояние после клика: "+checked);
                    }
                }
            }
        }

        System.out.println("Текст:");
        for (Element element : scene.getElementsList()){
            if (element instanceof Text){
                System.out.println("Поле "+element.getCaption()+" содержит текст='"+((Text)element).getText()+"'");
            }
        }
    }

}