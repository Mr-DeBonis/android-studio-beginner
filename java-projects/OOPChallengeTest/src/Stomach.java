public class Stomach extends Organ {
    final private boolean isEmpty;

    public Stomach(String name, String medicalCondition, boolean isEmpty) {
        super(name, medicalCondition);
        this.isEmpty = isEmpty;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        if (this.isEmpty()) {
            System.out.println("Need to be fed");
        } else {
            System.out.println("Stomach is full");
        }
    }

    public void digest() {
        System.out.println("Digesting begin...");
    }

    public boolean isEmpty() {
        return isEmpty;
    }

}
