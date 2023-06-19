public class Eye extends Organ {
    private String color;
    private boolean isOpen;

    public Eye(String name, String medicalCondition, String color, boolean isOpen) {
        super(name, medicalCondition);
        this.color = color;
        this.isOpen = isOpen;
    }

    public void closeEye() {
        this.isOpen = false;
        System.out.println(this.getName() + " Closed");
    }

    public void openEye() {
        this.isOpen = true;
        System.out.println(this.getName() + " is open");
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
