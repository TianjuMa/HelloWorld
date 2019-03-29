package LaiOffer.Supplements.NestedClass;

class OuterClass {
    private static String msg = "message";

    static class NestedStaticClass {
        void printMessage() {
            System.out.println("Message from nested static class: " + msg);
        }

        private static void printOut() {
        }
    }

    class InnerClass {
        void display() {
            System.out.println("Message from non-nested static class: " + msg);
        }

        OuterClass getOuterClass() {
            return OuterClass.this;
        }
    }
}
