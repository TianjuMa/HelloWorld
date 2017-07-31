package LaiOffer.Supplements.OverrideTest;

class B extends A {
    String show (B obj) {
        return "B and B";
    }

    String show(A obj) {
        return "B and A";
    }
}
