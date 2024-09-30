import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //прочитать строки из файла в список строк

//        List<String> txt = loadText("a.txt");
//        System.out.println(txt);

        //    сформировал список значений, убрал " ; "
        List<Double> txt1 =loadCSV("a.txt");
        System.out.println(txt1);
//        Arrays.sort(txt1, new Comparator<Double>(){@Override public int coppare(Double n1, Double n2){return Double.compare(n1, n2);}});

//        txt1.stream().sorted((a,b)->{
//            if (a<0 && b<0){return Double.compare(a,b);}
//                else if (a<0) {return  -1;}
//                else if (b<0) {return 1;}
//                else {
//                    return Double.compare(a,b);}})
//                                                .forEach(num->System.out.printf("%.1f ", num));

//    List<Double> sortTxt1 = new ArrayList<>();
//    List<Double> sortTxt2 = new ArrayList<>();
//        int negIndex = 0;
//            for (Double num: txt1) {
//            if (num < 0) {
//                sortTxt1.add(negIndex++, num);
//
//            }
//            else
//                sortTxt2.add(negIndex++, num);
//        }
//        txt1=sortTxt1;
//        System.out.println(txt1);

        List<Double> sortTxt1 = new ArrayList<>();
        sortTxt1.addAll(txt1.stream().filter(num->num<0).collect(Collectors.toList()));
        sortTxt1.addAll(txt1.stream().filter(num->num>=0).collect(Collectors.toList()));
        txt1= sortTxt1;
        System.out.println(txt1);


   }




//__________________________________________________________функции
//    private static List<String> loadText(String filename) {
//        //создаем пустой список
//        List<String> lines = new ArrayList<>();
//
//        try (Scanner scanner = new Scanner(new File(filename))) { //открываем сканером файл
//            //циклом вычитываем строки и добавляем в список
//            while (scanner.hasNext()) {
//                String s = scanner.nextLine();
//                lines.add(s);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("файл не открылся");
//            System.out.println(e.getMessage());
//        }
//
//        return lines;
//    }

    //Нужно получить из файла список . в файле они разделяются символом ;
    private static List<Double> loadCSV(String filename) {
        //создаем пустой список
        List<String> numbers = new ArrayList<>();
        List<Double> list2 = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) { //открываем сканером файл
            //циклом вычитываем строки и добавляем в список
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] massiv = s.split(";");

                for (String str : massiv) {
                    String trimmedStr = str.trim();
                    String formatStr = trimmedStr.replace(",", ".");
                    Double num = Double.parseDouble(formatStr);
                    list2.add(num);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл не открылся");
            System.out.println(e.getMessage());
        }
        return list2;
    }


}

