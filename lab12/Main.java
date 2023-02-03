public class Main {
    public static void main(String[] args) {
        Transformator tr = new Transformator();
        String input = "Написать приложение, выводящее в виде «рваного» двумерного массива слова, содержащие заданную букву. В выводе строка — это номер предложения, столбцы – это слова, содержащие требуемую подстроку (если нужных слов в предложении нет, то строка выводится пустой)";
        String charr = "и";

        tr.transform(input,charr);
    }
}
