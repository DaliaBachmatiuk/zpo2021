package predatory.canines;

import predatory.canines.wolf.IMeasurable;
import java.util.List;

public class Nyctereutes {
    public static IMeasurable largest(List<IMeasurable> spleen) {
        double max = spleen.get(0).getMeasure();
        int index = 0;
        for (int i = 1; i < spleen.size(); i++) {
            if (spleen.get(i).getMeasure() > max) {
                max = spleen.get(i).getMeasure();
                index = i;
            }
        }
        return spleen.get(index);
    }
}
