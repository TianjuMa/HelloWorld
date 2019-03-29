package LaiOffer.DesignPattern.FactoryPattern.AbstractFactory;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("I'm OSX button.");
    }
}
