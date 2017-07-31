package LaiOffer.Supplements.OverrideTest;

class A {
    String show(D obj) {
        return "A and D";
    }

    String show(A obj) {
        return "A and A";
    }
}
