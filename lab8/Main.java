public class Main {
    public static void main(String[] args) {
        HashTableX ht = new HashTableX();
        ht.add(5, "banana");
        ht.add(12, "clown");
        ht.add(1, "flow");
        ht.add(5,"fish");
        ht.add(5, "pop");

        ht.delete(5, "banana");



        System.out.println(ht.find(5,"banana"));
    }
}
