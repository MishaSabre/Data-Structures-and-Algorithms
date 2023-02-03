public class LinkList {

    private Elem first;

    LinkList(){
        first = null;
    }

    public boolean isEmpty(){

        return (first==null);
    }

    public void insertFirst(int id, double dd){
        Elem newElem = new Elem(id, dd);
        newElem.next = first;
        first = newElem;
    }

    public Elem deleteFirst() {
        Elem temp = first;
        first = first.next;
        return temp;
    }

    public void displayList()   {
        System.out.print("List (first-->last): ");
        Elem current = first;
        while(current != null) {
            System.out.print(current.displayElem());
            current = current.next;
        }
        System.out.println("");
    }

    public String findElem(Elem in){

        Elem tmp = first;


        while ( tmp != null){
            if (tmp.getIData() == in.getIData()){
                return String.valueOf(tmp.getIData());
            }
            tmp = tmp.next;
        }

        return null;
    }

    public int length(){

        int ans = 0;

        Elem current = first;
        while(current != null) {
            ans++;
            current = current.next;
        }

        return ans;
    }

    public Elem getFirst(){
        return first;
    }



}
