import java.util.*;
import java.io.*;

public class StudentRecordProcessor{
    public static void main(String[] args)throws IOException{
        File myFile = new File("student_record.txt");
        File sortedFile = new File("bscs_sorted.txt");
        File failedFile = new File("bscs_failed.txt");

        LinkedList<Integer> id = new LinkedList<>();
        LinkedList<String> name = new LinkedList<>();
        LinkedList<String> course = new LinkedList<>();
        LinkedList<Integer> grade = new LinkedList<>();

        Scanner fileScanner = new Scanner(myFile);
        while(fileScanner.hasNext()){
            String words = fileScanner.nextLine();
            String[] parts = words.split(",");

            if(parts[2].equalsIgnoreCase("BSCS")){
                id.add(Integer.parseInt(parts[0]));
                name.add(parts[1]);
                course.add(parts[2]);
                grade.add(Integer.parseInt(parts[3]));
            }
        }
        fileScanner.close();

        double result = 0;
        for(int i = 0; i < grade.size(); i++){
            result += grade.get(i);
        }
        double average = result / grade.size();

        for(int i = 0; i < name.size() - 1; i++){
            for(int j = 0; j < name.size() - 1 - i; j++){
                if(grade.get(j) < grade.get(j + 1)){

                    int temp1 = id.get(j);
                    id.set(j, id.get(j + 1));
                    id.set(j + 1, temp1);

                    String temp2 = name.get(j);
                    name.set(j, name.get(j + 1));
                    name.set(j + 1, temp2);

                    String temp3 = course.get(j);
                    course.set(j, course.get(j + 1));
                    course.set(j + 1, temp3);

                    int temp = grade.get(j);
                    grade.set(j, grade.get(j + 1));
                    grade.set(j + 1, temp);
                }
            }
        }

        FileWriter fw = new FileWriter(sortedFile);
        for(int i = 0; i < name.size(); i++){
            fw.write(id.get(i) + " - ");
            fw.write(name.get(i) + " - ");
            fw.write(course.get(i) + " - ");
            fw.write(grade.get(i) + "\n");
        }
        fw.close();

        FileWriter fw2 = new FileWriter(failedFile);
        for(int i = 0; i < grade.size(); i++){
            if(grade.get(i) < 80){
                fw2.write(id.get(i) + " - ");
                fw2.write(name.get(i) + " - ");
                fw2.write(course.get(i) + " - ");
                fw2.write(grade.get(i) + "\n");
            }
        }
        fw2.close();

        System.out.println("Filtered BSCS Students: " + name.size());
        System.out.println("Average Grade of BSCS Students: " + average);
        System.out.println();
        System.out.println("Successfully Written to:");
        System.out.println("- " + sortedFile);
        System.out.println("- " + failedFile);
    }
}