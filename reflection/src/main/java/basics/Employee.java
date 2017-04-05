package basics;


public class Employee extends Person {
    private String title;
    public String phoneNumber;

    public Employee(final String name, final int age, final boolean isMale, final String title, final String phoneNumber, final String... nickNames) {
        super(name, age, isMale, nickNames);
        this.title = title;
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
