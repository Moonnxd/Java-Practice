import java.util.Random;

public class NenUser {
    private String userName;
    private NenType nenType;

    private int determination;
    private int creativity;
    private int impulsiveness;
    private int intelligence;
    private int manipulation;
    private int uniqueness;

    private static Random random = new Random();

    public NenUser(String userName) {
        this.userName = userName;

        this.determination = random.nextInt(10);
        this.creativity = random.nextInt(10);
        this.impulsiveness = random.nextInt(10);
        this.intelligence = random.nextInt(10);
        this.manipulation = random.nextInt(10);
        this.uniqueness = random.nextInt(10);
    }

    public void setNenType(NenType nenType) {
        this.nenType = nenType;
    }

    public NenType getNenType() {
        return nenType;
    }

    public String getName(){
        return userName;
    }

    public void showStats() {
        System.out.println("Nen User: " + userName);
        System.out.println("Determination: " + determination);
        System.out.println("Creativity: " + creativity);
        System.out.println("Impulsiveness: " + impulsiveness);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Manipulation: " + manipulation);
        System.out.println("Uniqueness: " + uniqueness);
    }

    public void waterDivination() {

        NenType enhancer = new NenType("Enhancer", "The water volume changes");
        NenType emitter = new NenType("Emitter", "The water color changes");
        NenType transmuter = new NenType("Transmuter", "The water taste changes");
        NenType conjurer = new NenType("Conjurer", "The water impurities increase");
        NenType manipulator = new NenType("Manipulator", "The water moves");
        NenType specialist = new NenType("Specialist", "The water shows unique behavior");

        // Determine the user's Nen type based on their highest attributes
        if (determination >= creativity && determination >= impulsiveness && determination >= intelligence && determination >= manipulation && determination >= uniqueness) {
            this.nenType = enhancer;
            System.out.println("Nen Type: " + "Enhancer");
        } else if (impulsiveness >= determination && impulsiveness >= creativity && impulsiveness >= intelligence && impulsiveness >= manipulation && impulsiveness >= uniqueness) {
            this.nenType = emitter;
            System.out.println("Nen Type: Emitter");
        } else if (creativity >= determination && creativity >= impulsiveness && creativity >= intelligence && creativity >= manipulation && creativity >= uniqueness) {
            this.nenType = transmuter;
            System.out.println("Nen Type: Transmuter");
        }else if(manipulation >= determination && manipulation >= creativity && manipulation >= impulsiveness && manipulation >= intelligence && manipulation >= uniqueness){
            this.nenType = manipulator;
            System.out.println("Nen Type: Manipulator");
        }else if(intelligence >= determination && intelligence >= creativity && intelligence >= impulsiveness && intelligence >= manipulation && intelligence >= uniqueness){
            this.nenType = conjurer;
            System.out.println("Nen Type: Conjurer");
        } else {
            this.nenType = specialist;
            System.out.println("Nen Type: Specialist");
        }

        System.out.println("Water Divination Effect: " + nenType.getWaterEffect());
    }

    
public void assignSubTypes() {
    if (nenType == null) {
        System.out.println("Cannot assign sub-types before determining main Nen type.");
        return;
    }

    String mainType = nenType.getName();
    int chance = random.nextInt(101); // 0-100

    System.out.print("Sub-types: ");

    if (mainType.equals("Enhancer")) {
        if (chance < 80) System.out.print("Transmuter ");
        if (chance < 80) System.out.print("Emitter ");
        if (chance < 40) System.out.print("Conjurer ");
        if (chance < 40) System.out.print("Manipulator ");
        if (chance < 10) System.out.print("Specialist");
    } else if (mainType.equals("Emitter")) {
        if (chance < 80) System.out.print("Enhancer ");
        if (chance < 80) System.out.print("Manipulator ");
        if (chance < 40) System.out.print("Transmuter ");
        if (chance < 40) System.out.print("Specialist ");
        if (chance < 10) System.out.print("Conjurer");
    } else if (mainType.equals("Transmuter")) {
        if (chance < 80) System.out.print("Enhancer ");
        if (chance < 80) System.out.print("Conjurer ");
        if (chance < 40) System.out.print("Emitter ");
        if (chance < 40) System.out.print("Specialist ");
        if (chance < 10) System.out.print("Manipulator");
    } else if (mainType.equals("Conjurer")) {
        if (chance < 80) System.out.print("Transmuter ");
        if (chance < 80) System.out.print("Specialist ");
        if (chance < 40) System.out.print("Enhancer ");
        if (chance < 40) System.out.print("Manipulator ");
        if (chance < 10) System.out.print("Emitter");
    } else if (mainType.equals("Manipulator")) {
        if (chance < 80) System.out.print("Specialist ");
        if (chance < 80) System.out.print("Emitter ");
        if (chance < 40) System.out.print("Conjurer ");
        if (chance < 40) System.out.print("Enhancer ");
        if (chance < 10) System.out.print("Transmuter");
    } else if (mainType.equals("Specialist")) {
        if (chance < 80) System.out.print("Conjurer ");
        if (chance < 80) System.out.print("Manipulator ");
        if (chance < 40) System.out.print("Emitter ");
        if (chance < 40) System.out.print("Transmuter ");
        if (chance < 10) System.out.print("Enhancer");
    }

    System.out.println();
}
}
