package predatory.canines;

import predatory.canines.wolf.IMeasurable;
import predatory.canines.wolf.Spleen;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    public static void main(String[] args) {
        List<IMeasurable> list = new ArrayList<>();

        list.add(new Spleen(4, 3.5, 5.2));
        list.add(new Spleen(4.8, 3, 5.15));
        list.add(new Spleen(3.97, 3.65, 5));

        if (list.get(0).getClass() == Spleen.class) {
            System.out.println(((Spleen) list.get(0)).getData());
        }

        Nyctereutes find = new Nyctereutes();
        System.out.println(find.largest(list).toString());
        System.out.println(find.largest(list).getMeasure());
    }
}
