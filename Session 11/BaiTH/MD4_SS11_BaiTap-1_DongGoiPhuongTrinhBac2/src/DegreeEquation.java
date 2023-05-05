public class DegreeEquation {
    public static double getDelta(int a, int b, int c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static String result(int a, int b, int c) {
        double delta = getDelta(a, b, c);
        if (a == 0) {
            return "Không phải phương trình bậc 2. ok chưa?";
        }
        if (delta == 0) {
            return "Phương trình có 1 nghiệm: x1 = x2 " + -b / (2 * a);
        }
        if (delta < 0) {
            return "vô nghiệm";
        }
        double root1 = (-b + Math.sqrt(delta)) / (2 * a);
        double root2 = (-b - Math.sqrt(delta)) / (2 * a);
        return "Phương trình có 2 nghiệm: x1= " + root1 + "; x2= " + root2;
    }
}
