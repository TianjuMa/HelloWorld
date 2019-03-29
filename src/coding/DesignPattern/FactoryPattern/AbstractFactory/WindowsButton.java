package coding.DesignPattern.FactoryPattern.AbstractFactory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("I'm Windows button.");
    }
}
