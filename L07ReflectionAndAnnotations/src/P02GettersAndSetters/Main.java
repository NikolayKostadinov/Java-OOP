package P02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Class clazz = Reflection.class;

        System.out.println(Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .map(m -> m.getName().startsWith("get") ?
                        String.format("%s will return class %s", m.getName(), m.getReturnType().getName()) :
                        String.format("%s and will set field of class %s",
                                m.getName(), m.getParameterTypes()[0].getName()))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
