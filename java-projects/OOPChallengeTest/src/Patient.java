public class Patient {
    final private String name;
    final private int age;
    final private Eye leftEye;
    final private Eye rightEye;
    final private Heart heart;
    final private Stomach stomach;
    final private Skin skin;

    public Patient(String name, int age, Eye leftEye, Eye rightEye, Heart heart, Stomach stomach, Skin skin) {
        this.name = name;
        this.age = age;
        this.leftEye = leftEye;
        this.rightEye = rightEye;
        this.heart = heart;
        this.stomach = stomach;
        this.skin = skin;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public Eye getLeftEye() {
        return leftEye;
    }


    public Eye getRightEye() {
        return rightEye;
    }


    public Heart getHeart() {
        return heart;
    }


    public Stomach getStomach() {
        return stomach;
    }


    public Skin getSkin() {
        return skin;
    }


}
