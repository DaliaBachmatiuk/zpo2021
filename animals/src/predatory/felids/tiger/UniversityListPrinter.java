package predatory.felids.tiger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class UniversityListPrinter implements IUniversityListPrinter {

    @Override
    public String getString(List<University> university, String what) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "get" + what;
        Method method = University.class.getMethod(methodName);
        StringBuilder show = new StringBuilder();
        for (University value : university) {
            show.append(method.invoke(value)).append(", ");
        }
        return show.toString();
    }
}
