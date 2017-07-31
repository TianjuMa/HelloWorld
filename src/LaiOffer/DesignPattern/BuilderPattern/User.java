package LaiOffer.DesignPattern.BuilderPattern;

/**
 * Created by matinaju on 7/17/17.
 */
public class User {
    private final String firstName;
    private final String lastName;
    private int phoneNumber;
    private String address;
    private int age;

    private User(UserBuilder ub) {
        this.firstName = ub.firstName;
        this.lastName = ub.lastName;
        this.phoneNumber = ub.phoneNumber;
        this.address = ub.address;
        this.age = ub.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    private static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int phoneNumber = 123456789;
        private String address = "";
        private int age = 18;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder phone(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User newUser = new UserBuilder("Wang", "Lao").address("111").age(12).phone(12345).build();
        System.out.println(newUser.getFirstName());
        System.out.println(newUser.getLastName());
        System.out.println(newUser.getAddress());
        System.out.println(newUser.getAge());
        System.out.println(newUser.getPhoneNumber());
    }
}
