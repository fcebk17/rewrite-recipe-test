package ntou.cse.soselab;

public class TernaryExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // 未简化的三元运算符示例
        boolean isAGreaterThanB = (a > b) ? true : false;
        boolean isALessThanOrEqualToB = (a <= b) ? false : true;

        System.out.println("Is A greater than B? " + isAGreaterThanB);
        System.out.println("Is A less than or equal to B? " + isALessThanOrEqualToB);
    }
}

