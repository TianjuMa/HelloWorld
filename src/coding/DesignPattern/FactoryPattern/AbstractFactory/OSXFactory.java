package coding.DesignPattern.FactoryPattern.AbstractFactory;

public class OSXFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
}
