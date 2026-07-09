package StudentManagement.StudentInfo;

public class Student extends Person implements Grade {
    private int id;
    private String course;
    private double preLim = 0;
    private double midTerm = 0;
    private double finalExam = 0;
    private double average;
    private Status status;

    public Student() {
    }

    public Student(int id, String course, double preLim, double midTerm, double finalExam) {
        this.id = id;
        this.course = course;
        this.preLim = preLim;
        this.midTerm = midTerm;
        this.finalExam = finalExam;
        System.out.println("StudentManagement.Student successfully added!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getPreLim() {
        return preLim;
    }

    public void setPreLim(double preLim) {
        this.preLim = preLim;
    }

    public double getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(double midTerm) {
        this.midTerm = midTerm;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getAverage() {
        average = (preLim + midTerm + finalExam) / 3;
        return Math.round(average * 100) / 100.0;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public Status getStatus() {
        if (average > 100 || average < 0)
            System.out.println("Invalid Average!");
        else if (average < 75) {
            setStatus(Status.Fail);
        } else if (average >= 75 && average <= 100) {
            setStatus(Status.Pass);
        }

        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void computable() {

    }

    @Override
    public void show() {
        System.out.printf("%-5d %-20s %-10s %-8.2f %-5s%n",
                getId(),
                getName(),
                getCourse(),
                getAverage(),
                getStatus());
    }
}
