import Multimedia.Audio;
import Multimedia.Image;
import Multimedia.MultimediaItem;
import Multimedia.Video;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static MultimediaItem[] multimediaItems = new MultimediaItem[2];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        setItems();
        player();
        scanner.close();
    }

    private static void setItems() {
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

    }

    private static void player() {
        String selector;
        int arrSelector;
        do {
            System.out.println("chose a media - 0 to quit");
            for (int i = 0; i < multimediaItems.length; i++) {
                System.out.println((i + 1) + " " + multimediaItems[i].getTitle() + " - " + multimediaItems[i].getMediaType());
            }
            selector = scanner.nextLine();
            if (selector.matches("^\\d+$")) {
                arrSelector = Integer.parseInt(selector) - 1;
                if (arrSelector < multimediaItems.length) {
                    if (multimediaItems[arrSelector] instanceof Image) ((Image) multimediaItems[arrSelector]).show();
                    if (multimediaItems[arrSelector] instanceof Audio) ((Audio) multimediaItems[arrSelector]).play();
                    if (multimediaItems[arrSelector] instanceof Video) ((Video) multimediaItems[arrSelector]).play();
                }
            }

        } while (!selector.equals("0"));
    }

}