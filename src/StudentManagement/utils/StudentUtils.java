package StudentManagement.utils;

import StudentManagement.StudentInfo.Student;

import java.util.ArrayList;

public class StudentUtils {
    private static ArrayList<Student> students;

    public StudentUtils() {
    }

    public StudentUtils(ArrayList<Student> students) {
        StudentUtils.students = students;
    }

    public static void sort(ArrayList<Student> students) {
        int current = students.size() - 1;
        int previous = current - 1;

        while (current > 0) {
            if (students.get(current).getId() < students.get(previous).getId()) {
                Student temp = students.get(current);
                students.set(current, students.get(previous));
                students.set(previous, temp);
            } else {
                break;
            }
            current = previous;
            previous--;
        }
    }

    public static Student binarySearch(int id, ArrayList<Student> students) {
        if (students.size() == 0) return null;

        int highest = students.size() - 1;
        int lowest = 0;

        while (lowest <= highest) {
            int middle = (lowest + highest) / 2;

            if (id > students.get(middle).getId()) {
                lowest = middle + 1;
            } else if (id < students.get(middle).getId()) {
                highest = middle - 1;
            } else {
                return students.get(middle);
            }
        }
        return null;
    }
}

// 8
// [1,2,3,4,5,6,7,8,9]
// highest = 6
// lowest = 4 -> 5
// middle = 3 -> 4