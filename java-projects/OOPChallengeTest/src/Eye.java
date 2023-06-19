public class Eye extends Organ {
    final private String color;
    private boolean isOpened;

    public Eye(String name, String medicalCondition, String color, boolean isOpen) {
        super(name, medicalCondition);
        this.color = color;
        this.isOpened = isOpen;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Color: " + this.getColor());

    }

    public void closeEye() {
        this.setOpened(false);
        System.out.println(this.getName() + " Closed");
    }

    public void openEye() {
        this.setOpened(true);
        System.out.println(this.getName() + " is open");
    }

    public boolean isOpen() {
        return isOpened;
    }

    public void setOpened(boolean open) {
        isOpened = open;
    }

    public String getColor() {
        return color;
    }


}
