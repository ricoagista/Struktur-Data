import java.util.ArrayList;

public class JujutsuKaisenArrayList {
    public static void main(String[] args) {
        // 1. Declaration
        ArrayList<String> sorcerers = new ArrayList<>();

        // 2. Recruitment
        sorcerers.add("Itadori");
        sorcerers.add("Fushiguro");
        sorcerers.add("Kugisaki");
        System.out.println("First Years Assembled: " + sorcerers);

        // 3. Transfer Student (Yuta join at index 0)
        sorcerers.add(0, "Okkotsu");
        System.out.println("After Yuta joins: " + sorcerers);

        // 4. Identification
        System.out.println("Student at index 2 is: " + sorcerers.get(2));

        // 5. Possession (Itadori becomes Sukuna at index 1)
        sorcerers.set(1, "Ryomen Sukuna");
        System.out.println("Oh no, Itadori switched!: " + sorcerers);

        // 6. Casualties (Remove Kugisaki at index 3)
        sorcerers.remove(3);
        System.out.println("After the Shibuya Incident: " + sorcerers);

        // 7. Report
        System.out.println("Remaining students: " + sorcerers.size());
        System.out.println("The fight continues!");

        // 8. Total Wipeout
        sorcerers.clear();
        System.out.println("Post-Culling Game Status: " + sorcerers);
    }
}