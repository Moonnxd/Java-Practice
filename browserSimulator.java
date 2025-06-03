import java.util.*;

public class browserSimulator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        LinkedList <String> sites = new LinkedList<>();
        LinkedList <String> back = new LinkedList<>();

        System.out.println("\nWelcome to Browser History Simulator");
        while(true){

            System.out.println();
            System.out.println("Choose an action:");
            System.out.println("[1] Visit a new page");
            System.out.println("[2] Back");
            System.out.println("[3] Forward");
            System.out.println("[4] View Current Page");
            System.out.println("[5] Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                sc.nextLine();
                System.out.print("Enter new page to visit: ");
                String visitPage = sc.nextLine();

                if(back.isEmpty()){
                    sites.push(visitPage);
                    System.out.println();
                    System.out.println("Visited: " + sites.peekFirst());
                    continue;
                }else{
                    for(int i = 0; i < back.size(); i++){
                        sites.push(back.get(i));
                    }
                    back.clear();
                    sites.push(visitPage);

                    System.out.println();
                    System.out.println("Visited: " + sites.peekFirst());
                    continue;
                }
                case 2:
                String get1 = sites.peekFirst();

                back.push(get1);
                sites.pop();

                System.out.println();
                System.out.println("Back to: " + sites.peekFirst());
                continue;

                case 3:
                String get2 = back.peekFirst();

                sites.push(get2);
                back.pop();

                System.out.println();
                System.out.println("Forward to: " + sites.peekFirst());
                continue;

                case 4:
                System.out.println();
                System.out.println("Current page: " + sites.peekFirst());
                continue;

                case 5:
                System.out.println();
                System.out.println("Exiting...");
                System.exit(0);
                continue;

                default:
                System.out.println("Invalid Choice.");
            }
        }
    }
}