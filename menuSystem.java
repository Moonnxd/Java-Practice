import java.util.*;
import java.io.*;

public class menuSystem{

    static Scanner sc = new Scanner(System.in);

    static LinkedList<String> names = new LinkedList<>();
    static LinkedList<Integer> age = new LinkedList<>();
    static LinkedList<String> gender = new LinkedList<>();

    static File myFile = new File("dsa.txt");
    public static void main(String[] args)throws IOException{
        Scanner fileScanner = new Scanner(myFile);

        while(fileScanner.hasNext()){
            String read = fileScanner.nextLine();
            String[] parts = read.split(",");
           
                names.add(parts[0]);
                age.add(Integer.parseInt(parts[1]));
                gender.add(parts[2]);
        }
        fileScanner.close();

        while(true){
            System.out.println("MENU SYSTEM");
            System.out.println("[1] Add Record to First");
            System.out.println("[2] Add Record to Last");
            System.out.println("[3] Remove First Record");
            System.out.println("[4] Remove Last Record");
            System.out.println("[5] Display All Records");
            System.out.println("[6] Display Specific Records");
            System.out.println("[7] Edit Record");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            System.out.println();
            sc.nextLine();

            switch(choice){
                case 1:
                addFirst();
                break;
                case 2:
                addLast();
                break;
                case 3:
                removeFirst();
                break;
                case 4:
                removeLast();
                break;
                case 5:
                displayAll();
                break;
                case 6:
                displaySpecific();
                break;
                case 7:
                editRecord();
                break;
            }
        }
    }
    public static void addFirst()throws IOException{
        System.out.print("Enter Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Age: ");
        int firstAge = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Gender: ");
        String firstGender = sc.nextLine();

        names.addFirst(firstName);
        age.addFirst(firstAge);
        gender.addFirst(firstGender);

        FileWriter fw = new FileWriter(myFile);
                
        for(int i = 0; i < names.size(); i++){
            fw.write(names.get(i) + "," + age.get(i) + "," + gender.get(i) + "\n");
        }
        fw.close();

        System.out.println();
    }
    public static void addLast()throws IOException{
        System.out.print("Enter Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Age: ");
        int lastAge = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Gender: ");
        String lastGender = sc.nextLine();

        names.addLast(lastName);
        age.addLast(lastAge);
        gender.addLast(lastGender);

        FileWriter fw2 = new FileWriter(myFile);

        for(int i = 0; i < names.size(); i++){
            fw2.write(names.get(i) + "," + age.get(i) + "," + gender.get(i) + "\n");
        }
        fw2.close();

        System.out.println();
    }
    public static void removeFirst()throws IOException{
        names.removeFirst();
        age.removeLast();
        gender.removeFirst();

        FileWriter fw3 = new FileWriter(myFile);

        for(int i = 0; i < names.size(); i++){
            fw3.write(names.get(i) + "," + age.get(i) + "," + gender.get(i) + "\n");
        }
        fw3.close();

        System.out.println();
    }
    public static void removeLast()throws IOException{
        names.removeLast();
        age.removeLast();
        gender.removeLast();

        FileWriter fw4 = new FileWriter(myFile);

        for(int i = 0; i < names.size(); i++){
            fw4.write(names.get(i) + "," + age.get(i) + "," + gender.get(i) + "\n");
        }
        fw4.close();

        System.out.println();
    }
    public static void displayAll()throws IOException{
        Scanner fileScanner1 = new Scanner(myFile);

        System.out.printf("%-10s %-10s %-10s\n", "Name", "Age", "Gender");
        while(fileScanner1.hasNext()){
            String finals = fileScanner1.nextLine();
            String[] fParts = finals.split(",");

            System.out.printf("%-10s %-10s %-10s\n", fParts[0], fParts[1], fParts[2]);
        }
        fileScanner1.close();

        System.out.println();
    }
    public static void displaySpecific()throws IOException{
        System.out.print("Enter Record Number: ");
        int index = sc.nextInt();

        if(index > 0 && index < names.size() + 1){
            System.out.printf("%-10s %-10s %-10s\n", "Name", "Age", "Gender");
            System.out.printf("%-10s %-10s %-10s\n", names.get(index - 1), age.get(index -1), gender.get(index - 1));
            System.out.println();
        }else{
            System.out.println();
            System.out.println("Invalid Number.");
        }
        System.out.println();
    }
    public static void editRecord()throws IOException{
        System.out.print("Enter Record Number to Edit: ");
        int edit = sc.nextInt();

        sc.nextLine();

        if(edit > 0 && edit < names.size() + 1){
            System.out.print("Enter New Name: ");
            String newName = sc.nextLine();

            System.out.print("Enter New Age: ");
            int newAge = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter New Gender: ");
            String newGender = sc.nextLine();

            names.set(edit - 1, newName);
            age.set(edit - 1, newAge);
            gender.set(edit - 1, newGender);

            FileWriter fw5 = new FileWriter(myFile);

            for(int i = 0; i < names.size(); i++){
                fw5.write(names.get(i) + "," + age.get(i) + "," + gender.get(i) + "\n");
            }
            fw5.close();
            System.out.println();
        }else{
            System.out.println();
            System.out.println("Invalid Number.");
        }
    }
}