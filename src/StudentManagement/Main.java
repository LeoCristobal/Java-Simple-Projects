package StudentManagement;

import StudentManagement.StudentInfo.Student;
import StudentManagement.utils.StudentUtils;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static void main(String[] args) {
        ArrayList<git init Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean exists = false;
        int choice = 0;
        boolean isError = false;
        boolean isFound = false;
        // Interface
        do {

            System.out.println("===========================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println("===========================");
            System.out.println("1. Add StudentManagement.Student");
            System.out.println("2. View Students");
            System.out.println("3. Search StudentManagement.Student");
            System.out.println("4. Update StudentManagement.Student");
            System.out.println("5. Delete StudentManagement.Student");
            System.out.println("6. Compute StudentManagement.Student.Grade");
            System.out.println("7. Exit\n");

            try {

                System.out.print("Choice: ");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                isError = true;
                System.out.println("Please enter a valid choice");
            }

            switch (choice) {
                // 1. Add StudentManagement.Student
                case 1:
                    try {
                        Student student = new Student();

                        do {
                            exists = false;
                            // ID
                            System.out.print("StudentManagement.Student ID: ");
                            student.setId(Integer.parseInt(sc.nextLine()));

                            for (Student s : students) {
                                if (student.getId() == s.getId()) {
                                    System.out.println("StudentManagement.Student ID already exists");
                                    exists = true;
                                    break;
                                }
                            }
                        } while (exists);

                        // Name
                        System.out.print("Name: ");
                        student.setName(sc.nextLine());

                        // Age
                        System.out.print("age: ");
                        student.setAge(Integer.parseInt(sc.nextLine()));

                        // Course
                        System.out.print("Course: ");
                        student.setCourse(sc.nextLine());

                        // PreLim
                        System.out.print("Prelim: ");
                        student.setPreLim(Double.parseDouble(sc.nextLine()));

                        // MidTerm
                        System.out.print("Mid Term: ");
                        student.setMidTerm(Double.parseDouble(sc.nextLine()));

                        // Final Exam
                        System.out.print("Final Exam: ");
                        student.setFinalExam(Double.parseDouble(sc.nextLine()));

                        students.add(student);
                        StudentUtils.sort(students);

                        System.out.println("StudentManagement.Student successfully added!");

                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("ID    NAME     COURSE    AVG      STATUS");
                    System.out.println("---------------------------------------------------------");

                    if (!students.isEmpty()) {
                        for (Student s : students) {
                            s.show();
                        }
                        System.out.println("---------------------------------------------------------");
                    } else {
                        System.out.println("No student found!");
                    }
                    break;

                case 3:
                    do {
                        isError = false;
                        try {
                            System.out.print("Enter StudentManagement.Student ID: ");
                            int id = Integer.parseInt(sc.nextLine());

                            if (!students.isEmpty()) {
                                Student result = StudentUtils.binarySearch(id, students);
                                result.show();
                            } else {
                                System.out.println("StudentManagement.Student ID not found!");
                            }
                        } catch (NumberFormatException e) {
                            isError = true;
                            System.out.println("Enter a valid StudentManagement.Student ID!");
                        }
                    } while (isError);
                    break;
            }
        } while (choice != 7);
    }
}
