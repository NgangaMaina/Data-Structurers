public class Person {
    int age;
    String name;
    String blood_type;

    public Person(String name, int age, String blood_type) {
        this.name = name;
        this.age = age;
        this.blood_type = blood_type;
    }


    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0]= new Person ("Patrick", 20, "AB");
        people[1]= new Person ("Jerry", 22, "O");
        people[2]= new Person ("Joan", 19, "A");
        for (Person person : people) {
            System.out.println("Name: " + person.name + ",Age: " + person.age + ", Blood type: " + person.blood_type);
        }
    }
}