import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean menuOpen = true;

        Patient patient = new Patient("Tom",
                25,
                new Eye("Left Eye", "Short Sighted", "Blue", true),
                new Eye("Right Eye", "Normal", "Blue", true),
                new Heart("Heart", "Normal", 65),
                new Stomach("Stomach", "PUD", true),
                new Skin("Skin", "Burned", "White", 40));

        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        Scanner scanner = new Scanner(System.in);

        while (menuOpen) {
            System.out.println("Choose an Organ:\n\t1. Left Eye\n\t2. Right Eye\n\t3. Heart\n\t4. Stomach\n\t5. Skin\n\t6. Quit");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    patient.getLeftEye().getDetails();
                    eyeMenu(patient.getLeftEye(), scanner);
                    break;
                case 2:
                    patient.getRightEye().getDetails();
                    eyeMenu(patient.getRightEye(), scanner);
                    break;
                case 3:
                    patient.getHeart().getDetails();
                    System.out.println("\t1. Change the heart rate");
                    selection = scanner.nextInt();
                    if (selection == 1) {
                        System.out.println("Enter the new heart rate:");
                        int rate = scanner.nextInt();
                        patient.getHeart().setRate(rate);
                    }
                    break;
                case 4:
                    patient.getStomach().getDetails();
                    System.out.println("\t1. Digest");
                    selection = scanner.nextInt();
                    if (selection == 1) {
                        patient.getStomach().digest();
                    }
                    break;
                case 5:
                    patient.getSkin().getDetails();
                    break;
                default:
                    menuOpen = false;
                    break;
            }
        }
        scanner.close();
    }


    public static void eyeMenu(Eye eye, Scanner scanner) {
        if (eye.isOpen()) {
            System.out.println("\t1. Close the Eye");
            int selection = scanner.nextInt();
            if (selection == 1) {
                eye.closeEye();
            }
        } else {
            System.out.println("\t1. Open the Eye");
            int selection = scanner.nextInt();
            if (selection == 1) {
                eye.openEye();
            }
        }
    }
}

