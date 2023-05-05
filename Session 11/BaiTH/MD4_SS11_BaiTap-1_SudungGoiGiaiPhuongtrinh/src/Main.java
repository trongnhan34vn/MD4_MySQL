import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập c:");
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println("Kết quả: " + DegreeEquation.result(a,b,c));
    }
}