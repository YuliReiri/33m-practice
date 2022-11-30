import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.printf("%b%n", null);
        System.out.printf("%B%n", false );
        System.out.printf( "%B%n", 2);
        System.out.printf( "%b%n", "text");
        System.out.printf( "%2.6s%n", "Hi Guys!");
        System.out.printf( "%c%n", 'a' );
        System.out.printf("%C%n", 'a');

        int x = 100;
        System.out.printf( "Integer %d%n", x);
        System.out.printf( "PI %f\n ", Math.PI);
        System.out.printf( "Float formated PI = %.2f%n", Math.PI);

        float y = 3.14f;
        System.out.printf( "pi = %.6f\n", y);

        Date date = new Date();

        System.out.printf( 
            "hours: %tH: min: %tM: sec: %tS\n", date, date, date);
    
        System.out.printf( "date: %tT\n", date);

        System.out.printf( "%1$tA, %1$tB %1$tY\n", date );

        System.err.println("This is the error from programm");

      ///  Scanner sc = new Scanner( System.in );
      ///  int n1 = sc.nextInt();
      ///  int n2 = sc.nextInt();
      ///  System.out.println( n1 + n2 );

      InputStreamReader fStream = null;
      FileInputStream fileText = null;
      BufferedReader br = null;
 
        try {
            fileText = new FileInputStream("poem.txt");
            fStream = new InputStreamReader( fileText );
            
        /*     if (fileText != null )
                throw new Exception();
        */
            br = new BufferedReader(fStream);

            String line = br.readLine();
            System.out.println(line);
            
            br.lines().forEach( 
                (String s) -> System.out.println(s));

            //int data = fStream.read();
        /* 
            while ( data != -1 ) {
                System.out.print( (char )data);
                data = fStream.read();
            }*/
        } catch ( Exception e ){
            e.printStackTrace();
        }
        finally {
            try {
                if (fileText != null ) {
                    fileText.close();
                    fileText = null;
                    System.out.println("Text file closed");
                }
                if (fStream != null) {
                    fStream.close();
                    System.out.println("Char stream closed");
                    fStream = null;
                }
                if ( br != null ) {
                    br.close();
                    System.out.println("Buffered stream closed");
                    br = null;
                }
            }
            catch( Exception e ){
                e.printStackTrace();

            }
        }

        File file = new File("poem.txt");
        boolean isExists = file.exists();
        System.out.println("file exists: " + isExists);
        System.out.println(file.length());
        System.out.printf("file %s is dir: %b\n", 
            file.getName(), file.isDirectory());

        file = new File("./data");
        if (!file.exists()) {
            System.out.println("directory doesn't exist, creating");
            file.mkdir();
        } else {
            System.out.println("directory already created");
        }

        System.out.println(file.length());

        file.delete();

        file = new File("./");
        String[] fileList = file.list();
        if (fileList != null )
            System.out.println( Arrays.asList(fileList) );
        else 
            System.out.println("this is file");
 
        byte[] b1 = {112,1,3,4,5};

        ByteArrayOutputStream byteStream = 
        new ByteArrayOutputStream();

        try (FileOutputStream fos = 
            new FileOutputStream("code.txt",false)) 
        {  
            byteStream.write(b1, 0, b1.length);
            byteStream.write(23);
            byteStream.write(28);

            byteStream.writeTo( fos); 
        }
        catch( Exception e ) {
            e.printStackTrace();
        }







    }
}
