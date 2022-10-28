import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        main2();
    }
    public static void main1(){
        Pattern compile = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ip: ");
        String s = scanner.nextLine();
        Matcher matcher = compile.matcher(s);
        if(matcher.find()){
            System.out.println("valid");
        }else{
            System.out.println("no valid");
        }
    }

    public static void main2(){
        System.out.println("Введите кол-во файлов для прочтения: ");
        Scanner scanner1 = new Scanner(System.in);
        int n = scanner1.nextInt();
        String s = "";
        try {
            for (int i = 0; i < n; i++) {
                readSmallFiles();
            }
        }catch (IOException e){

        }
    }

    public static void readSmallFiles() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь: ");
        String s = scanner.nextLine();
        Path path = Paths.get(s);
        System.out.println(Files.find(path, 1, (p, a) -> a.isRegularFile() && p.getFileName().toString().endsWith(".txt")).collect(Collectors.toList()));
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите нужный файл: ");
        String k = scan.nextLine();
        Path path1 = Paths.get(k);
        List<String> strings = Files.readAllLines(path1);
        Pattern compile = Pattern.compile("\\d{4}-\\w{3}-\\d{4}-\\w{3}-\\d\\w\\d\\w");
        Matcher matcher = compile.matcher(strings.toString());
        Pattern compile1 = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}");
        Matcher matcher1 = compile1.matcher(strings.toString());
        Pattern compile2 = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher matcher2 = compile2.matcher(strings.toString());
        while (matcher.find()) {
            Document doc = new Document(matcher.group());
            Map<String, Document> map = new HashMap<>();
            map.put(s, doc);
            System.out.println(map);
        }
        while (matcher1.find()) {
            Document doc1 = new Document(matcher1.group());
            Map<String, Document> map = new HashMap<>();
            map.put(s, doc1);
            System.out.println(map);
        }
        while (matcher2.find()) {
            Document doc2 = new Document(matcher2.group());
            Map<String, Document> map = new HashMap<>();
            map.put(s, doc2);
            System.out.println(map);
        }

    }
}