import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person[] m = new Person[2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++){
            m[i] = new Person();
            System.out.println("Введите ID");
            m[i].setId(Integer.parseInt(scanner.nextLine()));
            System.out.println("Введите Фамилию");
            m[i].setSurname(scanner.nextLine());
            System.out.println("Введите Имя");
            m[i].setName(scanner.nextLine());
            System.out.println("Введите Почтовый индекс");
            m[i].setMailInd(Integer.parseInt(scanner.nextLine()));
            System.out.println("Введите Номер телефона");
            m[i].setNumber(Long.parseLong(scanner.nextLine()));
        }
        massPerson mp = new massPerson();
        mp.pers = m;
        for(Person a : m) System.out.println(a.getId());

        for(Person a : mp.pers) System.out.println(a.getName());
        mp.sort("name");
        for(Person a : mp.pers) System.out.println(a.getName());
        m[0].check("");
    }
}
