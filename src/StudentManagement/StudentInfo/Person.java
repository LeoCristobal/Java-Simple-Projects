package StudentManagement.StudentInfo;

public abstract class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 100)
            throw new IllegalArgumentException("Age must be between 0 and 100");
        else
            this.age = age;
    }

    public abstract void show();
}
