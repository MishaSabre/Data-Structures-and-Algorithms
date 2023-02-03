class NodeX {
    private final int key;
    private final int hash;
    private String value;
    private boolean isExist;
    public NodeX next = null;


    NodeX(int key, String value, int hash,NodeX next){

        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
        isExist = true;

    }

    public int getHash() {
        return hash;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public NodeX getNext() {
        return next;
    }

    public boolean getIsExist(){
        return isExist;
    }

    public void setExist(){
        isExist = false;
    }

}
