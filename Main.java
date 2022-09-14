import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String filePath = "/Users/dmytrokovalenko/Documents/Java_lab_1/someFile";
        String fileContent = getContent(filePath);
        String[] fileWords = fileContent.split( "[), (.!;?^:`'1234567890\n]");
        Set<String> result = searchTheBiggestWords(fileWords);
        System.out.println("\n\n\tBiggest words:");
        System.out.println(result);
    }


    public static Set<String> searchTheBiggestWords(String[] fileWords){

        Set<Character> result = new HashSet<Character>();
        Set<String> biggestWords = new HashSet<String>();
        int max = 0;
        int num;


        for(int j = 0; j< fileWords.length; j++) {

            if(fileWords[j].length() == 0){
                continue;
            }
            result.clear();
            for (int i = 0; i < fileWords[j].length(); i++) {
                result.add(fileWords[j].charAt(i));
            }

            num = result.size();

            if (num > max){
                biggestWords.clear();
                biggestWords.add(fileWords[j]);
                max = num;
                //System.out.println(max + "BIGGEST");
            } else if (num == max) {
                biggestWords.add(fileWords[j]);
            }

        }
        return biggestWords;
    }

    // Get all info from our life
    public static String getContent(String filePath){

        String fileContent = "";

        try(FileReader reader = new FileReader(filePath))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                fileContent = fileContent.concat(String.valueOf((char)c));
                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return fileContent;
    }
}