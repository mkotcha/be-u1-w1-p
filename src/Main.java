import Multimedia.Audio;
import Multimedia.Image;
import Multimedia.MultimediaItem;
import Multimedia.Video;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static MultimediaItem[] multimediaItems = new MultimediaItem[2];

    public static void main(String[] args) {

        setItems();
        printItems();

    }

    private static void setItems() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < multimediaItems.length; i++) {
            String selection;
            String title;
            String duration;
            System.out.println("Create new media");
            do {
                System.out.println("please select the media type");
                System.out.println("1 - Image");
                System.out.println("2 - Audio");
                System.out.println("3 - Video");
                selection = scanner.nextLine();
            } while (!selection.matches("[123]"));
            System.out.println("enter title");
            title = scanner.nextLine();


            switch (selection) {
                case "1": {
                    multimediaItems[i] = new Image(title);
                    break;
                }
                case "2": {
                    do {
                        System.out.println("enter duration sec");
                        duration = scanner.nextLine();
                    } while (!duration.matches("^\\d+$"));
                    multimediaItems[i] = new Audio(title, Integer.parseInt(duration));
                    break;
                }
                case "3": {
                    do {
                        System.out.println("enter duration sec");
                        duration = scanner.nextLine();
                    } while (!duration.matches("^\\d+$"));
                    multimediaItems[i] = new Video(title, Integer.parseInt(duration));
                    break;
                }
            }
        }
        scanner.close();
    }

    private static void printItems() {
        for (MultimediaItem item : multimediaItems) {
            if (item instanceof Image) ((Image) item).show();
            if (item instanceof Audio) ((Audio) item).play();
            if (item instanceof Video) ((Video) item).play();
        }
    }

}