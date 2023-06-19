public class Stomach extends Organ{
    private String status;

    public Stomach(String name, String medicalCondition, String status) {
        super(name, medicalCondition);
        this.status = status;
    }

    public void digest(){
        System.out.println("Digesting begin...");
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
