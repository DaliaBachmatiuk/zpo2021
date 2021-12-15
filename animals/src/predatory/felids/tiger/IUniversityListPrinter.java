package predatory.felids.tiger;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IUniversityListPrinter {
    String getString(List<University> university, String what) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
