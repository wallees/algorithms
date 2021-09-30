import java.util.*;

public class main
{
    public static HashMap<Integer, FamilyGroup> group = new HashMap<>();

    // tip: arguments are passed via the field below this editor
    public static void main(String[] args)
    {
        getResult(setExamples());
    }

    public static ArrayList<Family> setExamples() {

        ArrayList<Family> examples = new ArrayList<>();
        examples.add(new Family("F1", new String[]{"a", "b"}));
        examples.add(new Family("F2", new String[]{"b", "c"}));
        examples.add(new Family("F3", new String[]{"e"}));
        examples.add(new Family("F4", new String[]{"e", "f"}));
        examples.add(new Family("F5", new String[]{"c", "d"}));

        return examples;
    }

    public static void getResult(ArrayList<Family> families) {

        // group for result
        int index = 0;

        // Get each family
        for(Family family : families) {
            addFamilyToGroup(family, index);
            index++;
        }
        printResult(group);
    }

    public static void createGroup(Family family, int index) {
        FamilyGroup fg = new FamilyGroup();
        fg.lastnames.add(family.lastname);
        for(int i=0; i<family.firstnames.length; i++) {
            fg.firstnames.add((family.firstnames)[i]);
        }
        group.put(index, fg);
    }

    public static void addFamilyToGroup(Family family, int index) {
        if(group.size() == 0) {
            createGroup(family, index);
            return;
        }
        Set<Integer> keySet = group.keySet();
        for (Integer key : keySet) {
            // find from group
            FamilyGroup g = group.get(key);
            Set<String> g_firstnames = g.firstnames;
            for(int i=0; i<family.firstnames.length; i++) {
                if(g_firstnames.contains((family.firstnames)[i])) {
                    for(int j=0; j<family.firstnames.length; j++) {
                        g_firstnames.add(family.firstnames[j]);
                    }
                    g.lastnames.add(family.lastname);
                    return;
                }
            }
        }
        // There is no group of family
        createGroup(family, index);
    }

    public static void printResult(HashMap<Integer, FamilyGroup> map) {
        Collection<FamilyGroup> values = map.values();
        System.out.println(values);
    }
}

// class for group
class FamilyGroup {
    public ArrayList<String> lastnames;
    public Set<String> firstnames;

    public FamilyGroup() {
        lastnames = new ArrayList<>();
        firstnames = new HashSet<>();
    }

    public String toString() {
        String result = "";
        for(int i=0; i<lastnames.size(); i++) {
            result += lastnames.get(i) + " ";
        }
        return result.trim();
    }
}

// class for example
class Family {
    public String[] firstnames;
    public String lastname;

    public Family() {}

    public Family(String lastname, String[] firstnames) {
        this.firstnames = firstnames;
        this.lastname = lastname;
    }
}










