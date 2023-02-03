

class HashTableX {
    private NodeX[] mass = new NodeX[10];
    private final double factor = 0.75;
    private int count; //количество эллементов без учета удалленных
    private int delCount;


    HashTableX(){
        count = 0;
        delCount = 0;
        for(int i = 0; i < mass.length; i++){
            mass[i] = null;
        }
    }


    public void add(int key, String value){
        if (checkMemory()) reSizeMass();
        int index = getIndex(key);
        if(mass[index] == null) mass[index] = new NodeX(key, value, index, null);
        else {
            NodeX temp = mass[index];
            mass[index] = new NodeX(key, value, index, temp);
        }

        count++;
    }

    public void delete(int key, String value){
        boolean flag = false;
        NodeX temp = mass[getIndex(key)];

        while (!flag){


            if(temp.getValue().equals(value)){
                temp.setExist();
                System.out.println( temp.getValue());
                flag = true;
            }else{

                temp = temp.next;

            }

        }


    }

    public String find(int key, String value){
        String ans = "Данного объекта нет";
        NodeX tempr = new NodeX(key,value,-1,null);
           if(mass[getIndex(key)].getIsExist() && mass[getIndex(key)].getValue().equals(value)) ans = "Данный объект существует";
            else{
                NodeX temp = mass[getIndex(key)];

                while (temp != null){
                    if(temp.getIsExist() && tempr.getValue().equals(temp.getValue())){
                        ans = "Данный объект существует";
                        temp = null;
                    }
                    else{
                        temp = temp.next;
                    }
                }
            }


        return ans;
    }

    private static int getHash(int key){

        return key;
    }

    private int getIndex(int key){
        int hash = getHash(key);


        return hash % mass.length;
    }

    private boolean checkMemory(){
        return (double)count/mass.length >= factor;
    }

    private void reSizeMass(){
        int counter = 0;
        NodeX[] oldMass = mass;
        mass = new NodeX[++count];

        for (int i = 0; i < mass.length; i++){
            for (int j = 0; j < oldMass.length; j++){
                add(oldMass[i].getKey(), oldMass[i].getValue());
            }
        }

    }
}

