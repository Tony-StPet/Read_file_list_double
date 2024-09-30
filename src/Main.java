import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //прочитать строки из файла в список строк

        List<String> txt = loadText("a.txt");
        System.out.println(txt);
        //    сформировал список значений, убрал " ; "
        List<String> txt1 =loadCSV("a.txt");
        System.out.println(txt1);

    }




//__________________________________________________________функции
    private static List<String> loadText(String filename) {
        //создаем пустой список
        List<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) { //открываем сканером файл
            //циклом вычитываем строки и добавляем в список
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                lines.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не открылся");
            System.out.println(e.getMessage());
        }

        return lines;
    }

    //Нужно получить из файла список . в файле они разделяются символом ;
    private static List<String> loadCSV(String filename) {
        //создаем пустой список
        List<String> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) { //открываем сканером файл
            //циклом вычитываем строки и добавляем в список
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] massiv = s.split(";");
                for (String str : massiv) {
                    String trimmedStr = str.trim();
                    numbers.add(trimmedStr);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не открылся");
            System.out.println(e.getMessage());
        }
        return numbers;
    }


}

