import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Set A
        System.out.print("Enter elements of Set A separated by spaces: ");
        String[] elementsA = scanner.nextLine().split(" ");
        Set<String> setA = new HashSet<>();
        for (String element : elementsA) {
            setA.add(element);
        }

        // Input Set B
        System.out.print("Enter elements of Set B separated by spaces: ");
        String[] elementsB = scanner.nextLine().split(" ");
        Set<String> setB = new HashSet<>();
        for (String element : elementsB) {
            setB.add(element);
        }

        while (true) {
            // Display menu
            System.out.println("\nChoose an operation to perform:");
            System.out.println("1 - Union (A ∪ B)");
            System.out.println("2 - Intersection (A ∩ B)");
            System.out.println("3 - Difference (A − B and B − A)");
            System.out.println("4 - Subset Check (A ⊆ B and B ⊆ A)");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (choice) {
                case 1: // Union
                    Set<String> union = new HashSet<>(setA);
                    union.addAll(setB);
                    System.out.println("Union (A ∪ B): " + union);
                    break;

                case 2: // Intersection
                    Set<String> intersection = new HashSet<>(setA);
                    intersection.retainAll(setB);
                    System.out.println("Intersection (A ∩ B): " + intersection);
                    break;

                case 3: // Difference
                    Set<String> differenceA_B = new HashSet<>(setA);
                    differenceA_B.removeAll(setB);
                    Set<String> differenceB_A = new HashSet<>(setB);
                    differenceB_A.removeAll(setA);
                    System.out.println("Difference (A − B): " + differenceA_B);
                    System.out.println("Difference (B − A): " + differenceB_A);
                    break;

                case 4: // Subset Check
                    boolean isASubsetB = setB.containsAll(setA);
                    boolean isBSubsetA = setA.containsAll(setB);
                    System.out.println("Is A a subset of B? " + isASubsetB);
                    System.out.println("Is B a subset of A? " + isBSubsetA);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
