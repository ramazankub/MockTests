package Unknown.mocks;

public class Person {
    private Computer computer;

    public Person(Computer computer) {
        this.computer = computer;
    }

    public String getComputer() {
        return computer.getModel();
    }

}
