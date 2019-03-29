package LaiOffer.DesignPattern.FactoryPattern.AbstractFactory;

public class AbstractFactoryDemo {

    private AbstractFactoryDemo() {
    }

    private void start(String OS) {
        GUIFactory factory;
        if (OS.equals("Windows")) {
            factory = new WinFactory();
        } else {
            factory = new OSXFactory();
        }
        Application app = new Application(factory);
        app.run();
    }

    public static void main(String[] args) {
        AbstractFactoryDemo ab = new AbstractFactoryDemo();
        String OS = "Windows";
        ab.start(OS);
    }
}
