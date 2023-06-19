import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean menuOpen = true;
        Eye leftEye = new Eye("Left Eye", "Short Sighted", "Blue", true);
        Eye rightEye = new Eye("Right Eye", "Normal", "Blue", true);
        Heart heart = new Heart("Heart", "Normal", 65);
        Stomach stomach = new Stomach("Stomach", "PUD", "Need to be fed");
        Skin skin = new Skin("Skin", "Burned");

        Patient patient = new Patient("Tom", 25, leftEye, rightEye, heart, stomach, skin);

        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());
        Scanner scanner = new Scanner(System.in);

        while (menuOpen) {
            System.out.println("Choose an Organ:\n\t1. Left Eye\n\t2. Right Eye\n\t3. Heart\n\t4. Stomach\n\t5. Skin\n\t6. Quit");
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    organStatus(patient.getLeftEye());
                    eyeMenu(patient.getLeftEye(), scanner);
                    break;
                case 2:
                    organStatus(patient.getRightEye());
                    eyeMenu(patient.getRightEye(), scanner);
                    break;
                case 3:
                    organStatus(patient.getHeart());
                    System.out.println("Heart rate: " + patient.getHeart().getRate());
                    System.out.println("\t1. Change the heart rate");
                    selection = scanner.nextInt();
                    if (selection == 1) {
                        System.out.println("Enter the new heart rate:");
                        int rate = scanner.nextInt();
                        patient.getHeart().setRate(rate);
                    }
                    break;
                case 4:
                    organStatus(patient.getStomach());
                    System.out.println(patient.getStomach().getStatus());
                    System.out.println("\t1. Digest");
                    selection = scanner.nextInt();
                    if (selection == 1) {
                        patient.getStomach().digest();
                    }
                    break;
                case 5:
                    organStatus(patient.getSkin());
                    break;
                case 6:
                    menuOpen = false;
                    break;
            }
        }
        scanner.close();
    }

    public static void organStatus(Organ organ) {
        System.out.println("Name: " + organ.getName() + "\nMedical Condition: " + organ.getMedicalCondition());
    }

    public static void eyeMenu(Eye eye, Scanner scanner) {
        System.out.println("Color: " + eye.getColor());
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

