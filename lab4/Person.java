public class Person {

    static int count = 0;
    private int id;
    private String name;
    private String surname;
    private int mailInd;
    private long number;

    Person(){
        count++;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setMailInd(int mailInd){
        this.mailInd = mailInd;
    }
    public void setNumber(long number){
        this.number = number;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public int getMailInd(){
        return this.mailInd;
    }
    public long getNumber(){
        return this.number;
    }

    public void check(String a){
        switch (a) {
            case "id" -> System.out.println(this.id);
            case "name" -> System.out.println(this.name);
            case "surname" -> System.out.println(this.surname);
            case "mailInd" -> System.out.println(mailInd);
            case "number" -> System.out.println(this.number);
            default -> System.out.println(this.id + "\n" + this.name + "\n" + this.surname + "\n" + this.mailInd + "\n" + this.number);
        }
    }


}
