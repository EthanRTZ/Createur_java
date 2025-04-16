import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void Ecrire() {
        int nbreMethode = 0;

        try {
            // demande le nom de la classe à créer
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the class name:");
            String ClassName = scanner.nextLine();
            FileWriter writer = new FileWriter(ClassName+".java");
            writer.write("public class " + ClassName + "{ \n }\n");

            //demande le nombre de methode dans cette class
            System.out.println("Enter the number of methods:");
            int nombreMethod = scanner.nextInt();

            while (nbreMethode < nombreMethod) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the method name:");
                String methodName = sc.nextLine();
                writer.write("     "+"public void " + methodName + "() {\n }\n");
                nbreMethode++;
            }





            writer.close();

            System.out.println("Successfully wrote text to file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Ecrire();
    }
}