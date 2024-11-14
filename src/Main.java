import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<String> arrList = new ArrayList<>();
    static Scanner pipe = new Scanner(System.in);
    static String currentChoice = " ";
    public static void main(String[] args) {

        do {


            do {
                currentChoice = SafeInput.getRegExString(pipe, "What would you like to do? A (add item), D (delete item), I (insert an item), P (print your list), Q (quit the program) ", "[AaDdIiPpQq]");
                if (currentChoice.equalsIgnoreCase("a"))
                {
                    addItem();
                }
                else if (currentChoice.equalsIgnoreCase("d"))
                {
                    deleteItem();
                }
                else if (currentChoice.equalsIgnoreCase("i"))
                {
                    insertItem();
                }
                else if (currentChoice.equalsIgnoreCase("p"))
                {
                    display();
                }

            } while (!currentChoice.equalsIgnoreCase("q"));

        }while (!SafeInput.getYNConfirm(pipe, "Are you sure you want to quit?"));
    }

    public static void display() {
        System.out.println("The current list is:");
        for (int I = 0; I < arrList.size(); I++) {
            System.out.println((I + 1) + ". " + arrList.get(I));
        }
    }
    public static void addItem() {
        arrList.add(SafeInput.getNonZeroLenString(pipe,"What would you like to add to your list"));
    }
    public static void deleteItem()
    {
        display();
        arrList.remove((SafeInput.getRangedInt(pipe,"Which item would you like to remove from your list" + "[ " + 1 + " - " + arrList.size() + " ]" , 1 , arrList.size() )) - 1);
    }
    public static void insertItem() {
        arrList.set((SafeInput.getRangedInt(pipe,"Where would you like to insert your item" + "[ " + 1 + " - " + arrList.size() + " ]" , 1, arrList.size()) - 1), SafeInput.getNonZeroLenString(pipe,"What would you like to add to your list"));
    }
}