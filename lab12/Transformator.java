import java.util.Locale;

public class Transformator {
    private String input;
    private String[] i;
    private String[] j;
    private String[][] ij = new String[100][100];
    private String[][] ans = new String[100][100];
    private String temp;

    public void transform(String input, String c){
        this.input = input;
        i = input.split("\\.");
        for(int a = 0; a < i.length; a++){
            i[a] = i[a].replaceAll("\\p{P}", "");
            j = i[a].split(" ");
            for (int b = 0; b < j.length; b++) {

                ij[a][b] = j[b];
            }
        }

        for(int a = 0; a < ij.length; a++){
            for(int b = 0; b < ij.length; b++){
                String[] temp;

               if(ij[a][b] != null) {
                   temp = ij[a][b].split("");

                   for (String o : temp) {
                       if (c.toLowerCase().equals(o)) {
                           ans[a][b] = ij[a][b];
                       }
                   }
               }

            }
        }

        for(int a = 0; a < i.length; a++){
            System.out.println("\n");
            temp ="";

            for (int b = 0; b < ans.length; b++){
                if (ans[a][b] != null){
                    System.out.printf(temp + " %-30s", ans[a][b]);
                }
            }

        }
    }
}
