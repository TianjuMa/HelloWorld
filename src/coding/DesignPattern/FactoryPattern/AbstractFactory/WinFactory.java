package coding.DesignPattern.FactoryPattern.AbstractFactory;

public class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
