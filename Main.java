import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String nbrMethodParam(int nbrParam) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder parameters = new StringBuilder();

        for (int i = 0; i < nbrParam; i++) {
            System.out.println("Enter the name of parameter " + (i + 1) + ":");
            String paramName = scanner.nextLine();

            System.out.println("Enter the type of parameter " + (i + 1) + ":");
            String paramType = scanner.nextLine();

            parameters.append(paramType).append(" ").append(paramName);
            if (i < nbrParam - 1) {
                parameters.append(", ");
            }
        }

        return parameters.toString();
    }

    public static void Ecrire() {
        int nbreMethode = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the class name:");
            String className = scanner.nextLine();

            // Vérification de la première lettre si elle est majuscule
            if (!className.isEmpty() && Character.isUpperCase(className.charAt(0))) {
                System.out.println("La première lettre est une majuscule.");
            } else {
                char premiereLettre = className.charAt(0);
                System.out.println("La première lettre n'est pas une majuscule.");
                className = Character.toUpperCase(premiereLettre) + className.substring(1);
            }

            // Debut de l'ecriture dans le fichier
            FileWriter writer = new FileWriter(className + ".java");
            writer.write("public class " + className + " {\n\n");

            //ajout des variable de la classe
            System.out.println("Enter the number of attributes:");
            int nombreAttribut = scanner.nextInt();
            scanner.nextLine();

            String[] attributeNames = new String[nombreAttribut];
            String[] attributeTypes = new String[nombreAttribut];

            for (int i = 0; i < nombreAttribut; i++) {
                System.out.println("Enter the name of attribute " + (i + 1) + ":");
                attributeNames[i] = scanner.nextLine();

                System.out.println("Enter the type of attribute " + (i + 1) + ":");
                attributeTypes[i] = scanner.nextLine();

                writer.write("    private " + attributeTypes[i] + " " + attributeNames[i] + ";\n");
            }

            // Ajout du constructeur
            writer.write("\n    public " + className + "(");
            for (int i = 0; i < nombreAttribut; i++) {
                writer.write(attributeTypes[i] + " " + attributeNames[i]);
                if (i < nombreAttribut - 1) {
                    writer.write(", ");
                }
            }
            writer.write(") {\n");

            for (int i = 0; i < nombreAttribut; i++) {
                writer.write("        this." + attributeNames[i] + " = " + attributeNames[i] + ";\n");
            }
            writer.write("    }\n\n");

            // creation des methodes
            System.out.println("Enter the number of methods:");
            int nombreMethod = scanner.nextInt();
            scanner.nextLine();

            while (nbreMethode < nombreMethod) {
                System.out.println("Enter the method name:");
                String methodName = scanner.nextLine();

                System.out.println("Enter the number of parameters for the method:");
                int nbrParam = scanner.nextInt();
                scanner.nextLine(); // Consomme la ligne restante

                String parameters = nbrMethodParam(nbrParam);

                writer.write("    public void " + methodName + "(" + parameters + ") {\n");
                writer.write("    }\n\n");
                nbreMethode++;
            }

            writer.write("}\n");
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