package coding.Supplements.NestedClass;

public class OuterClassTest {
    public static void main(String[] args) {
        OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();
        printer.printMessage();

        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();

        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();
        innerObject.display();
        OuterClass outer2 = innerObject.getOuterClass();
        System.out.println(outer2.equals(outer));
    }
}
