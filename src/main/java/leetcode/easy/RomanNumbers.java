package leetcode.easy;

public enum RomanNumbers {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);
    private int arab;

    RomanNumbers(int arab) {
        this.arab = arab;
    }

    public int getArab() {
        return arab;
    }
}
