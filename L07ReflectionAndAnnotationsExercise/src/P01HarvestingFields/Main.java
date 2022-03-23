package P01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Predicate;

public class Main {
	private static Map<String, Predicate<Field>> fieldTypeFilter = Map.of(
			"private", getPrivateFields(),
			"protected", getProtectedFields(),
			"public", getPublicFields(),
			"all", getAllFields()
	);
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> fieldTypes = new ArrayList<>();
		String input = scan.nextLine();

		while (!"HARVEST".equals(input)){
			fieldTypes.add(input);
			input = scan.nextLine();
		}

		Class clazz = RichSoilLand.class;

		for (String fieldType : fieldTypes) {
			Arrays.stream(clazz.getDeclaredFields())
					.filter(fieldTypeFilter.get(fieldType))
					.forEach(f->printField(f));
		}
	}

	private static void printField(Field field) {
		System.out.println(String.format("%s %s %s",
				Modifier.toString(field.getModifiers()),
				field.getType().getSimpleName(),
				field.getName()));
	}

	private static Predicate<Field> getPrivateFields() {
		return f -> Modifier.isPrivate(f.getModifiers());
	}

	private static Predicate<Field> getProtectedFields() {
		return f -> Modifier.isProtected(f.getModifiers());
	}

	private static Predicate<Field> getPublicFields() {
		return f -> Modifier.isPublic(f.getModifiers());
	}

	private static Predicate<Field> getAllFields() {
		return f -> true;
	}

}
