package Week1Stories;

import java.util.*;

public class MainProgram {

    // 1️⃣ Problem 1: The Efficient Traveler
    public static int farthestCity(int nums[], int initialEnergy) {
        int energy = initialEnergy;
        for (int i = 0; i < nums.length; i++) {
            energy -= nums[i];
            if (energy < 0) {
                return i;
            }
        }
        return nums.length - 1;
    }

    // 2️⃣ Problem 2: The Sum That Stands Out
    public static int findBalanceIndex(int nums[]) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int prefix = 0;
        for (int j = 0; j < nums.length; j++) {
            int suffix = totalSum - prefix - nums[j];
            if (prefix == suffix) return j;
            prefix += nums[j];
        }
        return -1;
    }

    // 3️⃣ Problem 3: Flip the Switch
    public static int flipSwitch(int nums[]) {
        int count0 = 0, count1 = 0;
        for (int n : nums) {
            if (n == 0) count0++;
            else count1++;
        }
        return Math.min(count0, count1);
    }

    // 4️⃣ Problem 4: The Odd One Out
    public static int findSingleElement(int nums[]) {
        int xor = 0;
        for (int n : nums) xor ^= n;
        return xor;
    }

    // 5️⃣ Problem 5: Smart Pair Finder
    public static boolean smartPairFinder(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) return true;
            }
        }
        return false;
    }

    // 6️⃣ Problem 6: The Minimalist Painter
    public static int minimalistFinder(int arr[]) {
        int larg = 0, sum = 0;
        for (int a : arr) {
            sum += a;
            larg = Math.max(larg, a);
        }
        return sum - larg;
    }

    // 7️⃣ OOP Section
    static class coordinate {
        int x, y;
        coordinate(int x, int y) { this.x = x; this.y = y; }
    }

    static class Base {
        private int x, y;
        Base() { x = 0; y = 0; }
        Base(int x, int y) { this.x = x; this.y = y; }
        double distance(int x, int y) {
            return Math.sqrt(((this.x - x) * (this.x - x)) + ((this.y - y) * (this.y - y)));
        }
        coordinate translate(int x, int y) {
            return new coordinate((x + this.x), (y + this.y));
        }
    }

    static class Shape extends Base {
        double area(double pi, int radius) { return pi * radius * radius; }
        double area(int side) { return side * side; }
    }

    static class Circle extends Shape {
        double area;
        Circle(double pi, int radius) { this.area = area(pi, radius); }
    }

    static class Square extends Shape {
        double area;
        Square(int side) { this.area = area(side); }
    }

    // 🚀 MAIN MENU PROGRAM (loops until exit)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==============================================");
            System.out.println("🔹 Choose a problem to run:");
            System.out.println("1. Efficient Traveler");
            System.out.println("2. The Sum That Stands Out");
            System.out.println("3. Flip the Switch");
            System.out.println("4. The Odd One Out");
            System.out.println("5. Smart Pair Finder");
            System.out.println("6. The Minimalist Painter");
            System.out.println("7. Operation on Points (OOP)");
            System.out.println("0. Exit");
            System.out.println("==============================================");
            System.out.print("Enter choice (0–7): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("✅ Exiting program. Goodbye!");
                break;
            }

            System.out.println("\n----------------------------------------------");

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Enter distances:");
                    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                    System.out.print("Enter initial energy: ");
                    int energy = sc.nextInt();
                    System.out.println("Farthest city index: " + farthestCity(arr, energy));
                }
                case 2 -> {
                    int[] arr = {2, 3, -1, 8, 4};
                    System.out.println("Input: " + Arrays.toString(arr));
                    System.out.println("Balance index: " + findBalanceIndex(arr));
                }
                case 3 -> {
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Enter 0s and 1s:");
                    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                    System.out.println("Minimum flips needed: " + flipSwitch(arr));
                }
                case 4 -> {
                    int[] nums = {2, 3, 5, 4, 5, 3, 2};
                    System.out.println("Input: " + Arrays.toString(nums));
                    System.out.println("Odd one out: " + findSingleElement(nums));
                }
                case 5 -> {
                    int[] arr = {3, 5, 1, 7};
                    System.out.print("Enter k: ");
                    int k = sc.nextInt();
                    System.out.println("Smart pair exists: " + smartPairFinder(arr, k));
                }
                case 6 -> {
                    System.out.print("Enter number of walls: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Enter time for each wall:");
                    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                    System.out.println("Minimum total time after skipping one wall: " + minimalistFinder(arr));
                }
                case 7 -> {
                    Base point = new Base(0, 0);
                    double dist = point.distance(3, 4);
                    System.out.println("Distance between points: " + dist);
                    coordinate t = point.translate(3, 4);
                    System.out.println("Translated coordinate: (" + t.x + ", " + t.y + ")");
                    Circle c = new Circle(3.1415, 5);
                    System.out.printf("Area of circle: %.2f%n", c.area);
                    Square s = new Square(2);
                    System.out.println("Area of square: " + s.area);
                }
                default -> System.out.println("❌ Invalid choice! Please enter 0–7.");
            }

            System.out.println("----------------------------------------------");
            System.out.println("✨ Task completed.");
        }

        sc.close();
    }
}

