package P01Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;
        Class superClass = clazz.getSuperclass();
        Class[] interfaces = clazz.getInterfaces();

        Object obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println("class " + clazz.getSimpleName());
        System.out.println("class " + superClass.getName());
        System.out.println(Arrays.stream(interfaces)
                .map(i -> "interface " + i.getName())
                .collect(Collectors.joining(System.lineSeparator())));
        System.out.println(obj);
    }
}
