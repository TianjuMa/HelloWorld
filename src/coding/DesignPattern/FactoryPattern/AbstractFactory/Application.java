package LaiOffer.DesignPattern.FactoryPattern.AbstractFactory;

public class Application {
    private final GUIFactory factory;

    Application(GUIFactory f) {
        this.factory = f;
    }

    void run() {
        Button button = factory.createButton();
        button.paint();
    }
}
