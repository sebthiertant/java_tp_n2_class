package thiertant.airbnb.users;

public class Host extends Person{
    private int answerDelay;

    public Host(String firstName, String lastName, int age, int answerDelay) {
        super(firstName, lastName, age);
        this.answerDelay = answerDelay;
    }

    @Override
    public void display() {
        System.out.println(this.getFirstName() + " " + this.getLastName() + " (" + this.getAge() +" years old) is answering in " + this.answerDelay + " hours.");
    }
}
