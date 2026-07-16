package StudentManagement;

import StudentManagement.StudentInfo.Student;
import StudentManagement.utils.StudentUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        boolean exists;
        int choice = 0;
        boolean isError;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
                choice = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                isError = true;
                System.out.println("Please enter a valid choice");
            } finally {
                br.close();
            }

            switch (choice) {
                // 1. Add StudentManagement.Student
                case 1:
                    try {
                        Student student = new Student();

                        do {
                            exists = false;
                            // ID
                            System.out.print("Student ID: ");
                            student.setId(Integer.parseInt(br.readLine()));

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
                        student.setName(br.readLine());

                        // Age
                        System.out.print("age: ");
                        student.setAge(Integer.parseInt(br.readLine()));

                        // Course
                        System.out.print("Course: ");
                        student.setCourse(br.readLine());

                        // PreLim
                        System.out.print("Prelim: ");
                        student.setPreLim(Double.parseDouble(br.readLine()));

                        // MidTerm
                        System.out.print("Mid Term: ");
                        student.setMidTerm(Double.parseDouble(br.readLine()));

                        // Final Exam
                        System.out.print("Final Exam: ");
                        student.setFinalExam(Double.parseDouble(br.readLine()));

                        students.add(student);
                        StudentUtils.sort(students);

                        System.out.println("Student successfully added!");

                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        br.close();
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
                            System.out.print("Enter Student ID: ");
                            int id = Integer.parseInt(br.readLine());

                            if (!students.isEmpty()) {
                                Student result = StudentUtils.binarySearch(id, students);
                                result.show();
                            } else {
                                System.out.println("Student ID not found!");
                            }
                        } catch (NumberFormatException e) {
                            isError = true;
                            System.out.println("Enter a valid Student ID!");
                        }
                    } while (isError);
                    break;
            }
        } while (choice != 7);
    }
}
