import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();
    Student(String name) {
        this.name = name;
    }
    void addGrade(int grade) {
        grades.add(grade);
    }
    float getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (float) sum / grades.size();
    }
    int getHighest() {
        int max = grades.get(0);
        for (int g : grades) {
            if (g > max) max = g;
        }
        return max;
    }
    int getLowest() {
        int min = grades.get(0);
        for (int g : grades) {
            if (g < min) min = g;
        }
        return min;
    }
}
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("\n------- Student Grade Tracker -----");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. View Summary Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    students.add(new Student(name));
                    System.out.println("Student added.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available! Add a student first.");
                        break;
                    }

                    System.out.println("Select student:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).name);
                    }
                    int index = sc.nextInt() - 1;

                    if (index < 0 || index >= students.size()) {
                        System.out.println("Invalid student number.");
                        break;
                    }

                    System.out.print("Enter grade to add: ");
                    int grade = sc.nextInt();
                    students.get(index).addGrade(grade);
                    System.out.println("Grade added successfully!");
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students to show");
                        break;
                    }
                    System.out.println("\n------- SUMMARY REPORT -------");
                    for (Student s : students) {
                        if (s.grades.isEmpty()) {
                            System.out.println("\n" + s.name + " No grades available");
                            continue;
                        }
                        System.out.println("\nStudent: " + s.name);
                        System.out.println("Grades: " + s.grades);
                        System.out.println("Average: " + s.getAverage());
                        System.out.println("Highest: " + s.getHighest());
                        System.out.println("Lowest: " + s.getLowest());
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
