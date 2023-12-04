import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {


    static ArrayList<String>list=new ArrayList<>();
    static boolean newUnsavedFile = false;
    static boolean check = false;
    static JFileChooser chooser = new JFileChooser();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String menu = "A - Add, D - Delete, V - View, Q - Quit, O - Open, S - Save, C - Clear";
        boolean done = false;

        do{


            String userInput = SafeInput.getRegExString(in, menu, "[AaDdVvOoSsCcQq]");


            userInput = userInput.toUpperCase();
            switch (userInput) {
                case "A":
                    add(list);
                    view(list);
                    break;
                case "V":
                    view(list);
                    break;
                case "D":
                    delete(list);
                    view(list);
                    break;
                case "O":
                    openFile();
                    view(list);
                    break;
                case "S":
                    save();
                    break;
                case "C":
                    check = SafeInput.getYNConfirm(in,"Would you like to clear the list?");
                    if (check) {
                        list.clear();
                        newUnsavedFile = true;
                    }else{
                        System.out.println("This option is currently unavailable.");
                    }
                    break;
                case "Q":
                    if (newUnsavedFile == false){
                        done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    } else{
                        System.out.println("Please save the file before quitting.");
                    }
                    //done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    break;
                default:
                    System.out.println("Invalid operation value entered!");
            }
        } while(!done);
        //view(list);


    }

    private static void view(ArrayList<String> list) {
        System.out.println("Here is a new preview of the array list.");
        System.out.println(" ");
        int counter = 0;
        for (String value : list) {
            System.out.printf("%d- %s ",counter, value);
            counter++;
        }
        System.out.println(" ");


    }




    private static void delete(ArrayList<String> list) {

        Scanner del = new Scanner(System.in);
        int remove = SafeInput.getRangedInt(del,"Please select the index you would like to delete.",0,(list.size()-1));
        list.remove(remove);

        newUnsavedFile = true;

    }

    private static void add(ArrayList<String> list) {

        System.out.println(" ");
        System.out.println("What would you like to add to the list?");
        Scanner ad = new Scanner(System.in);


        String userAdd = "";
        if (ad.hasNext()) {

            userAdd = ad.nextLine();

        } else {

            System.out.println("You entered an incorrect string value: " + userAdd + " Please try again.");

        }
        list.add(userAdd);

        newUnsavedFile = true;
    }


    private static void save() {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\list.txt");

        try{
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String rec: list){
                writer.write(rec,0,rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data has been succesfully written to list.txt");

        }catch(IOException ex){
            ex.printStackTrace();
        }
        newUnsavedFile = false;
    }

    private static void openFile(){

        try{
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file,CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));



                while(reader.ready()){
                    String line = reader.readLine();
                    Main.list.add(line);
                    newUnsavedFile = true;
                }


                reader.close();
                System.out.println("File loaded successfully!");
            }else{

                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again");
                System.exit(0);
            }

        }catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}