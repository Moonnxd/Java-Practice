import java.util.*;

public class NenSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<NenUser> hunter = new ArrayList<>();

        while (true) {
            System.out.println("==================================");
            System.out.print("Enter Nen User: ");
            String nenUser = sc.nextLine();
            System.out.println("==================================");

            hunter.add(new NenUser(nenUser));

            System.out.println();
            System.out.println("==================================");
            System.out.println("Water Divination Test ongoing!");
            System.out.println("==================================");
            System.out.println();
            System.out.println("==================================");
            System.out.println("Water Divination Test Complete!");
            System.out.println("==================================");
            System.out.println();

            NenUser latest = hunter.get(hunter.size() - 1);

            System.out.println("========== " + latest.getName() + " Stats ==========");
            latest.showStats();
            System.out.println();
            latest.waterDivination();
            latest.assignSubTypes();
            System.out.println("==================================");

            System.out.println();
            System.out.println("==================================");
            System.out.print("Try Again(Y/N): ");
            char choice = sc.next().charAt(0);
            System.out.println("==================================");
            System.out.println();

            sc.nextLine();

            if (choice == 'N' || choice == 'n') {
                break;
            }
        }
    }
}
