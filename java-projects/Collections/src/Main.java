import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Meisam");
        names.add("Sarah");

        /*
        System.out.println(names.get(0));
        System.out.println(names.size());
        //names.clear();

        System.out.println(names.size());
        names.remove("Meisam");
        System.out.println(names.get(0));
        System.out.println(names.contains("Sarah"));
        names.remove("Sarah");
        System.out.println(names.isEmpty());
        */
        /*
        System.out.println(names.indexOf("Brad"));

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        */

        Map<String, String> emailList = new HashMap<>();
        emailList.put("Meisam", "Meisam@meicode.org");
        emailList.put("Brad", "Brad@gmail.com");
        System.out.println(emailList.get("Meisam"));
        System.out.println(emailList.size());
        emailList.remove("Brad");
        System.out.println(emailList.size());
        System.out.println(emailList.containsKey("Meisam"));
        System.out.println(emailList.containsValue("Meisam@meicode.org"));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Meisam", 15));
        students.add(new Student("Sarah", 18));

        for (Student s: students) {
            System.out.println(s.getName());
        }
    }
}