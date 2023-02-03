public class Elem {

    public int iData;
    public double dData;
    public Elem next;

    Elem(int i, double d){
        this.iData = i;
        this.dData = d;
    }

    public int getIData(){
        return this.iData;
    }

    public double getDData(){
        return this.dData;
    }

    public Elem getNext(){
        return next;
    }

    public String displayElem(){
        return "{" + iData + "," + dData + "}";
    }


}
