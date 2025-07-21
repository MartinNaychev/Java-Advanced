package ReflectionAndAnnotationsExercise.HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		Field[] fields = RichSoilLand.class.getDeclaredFields();
		Consumer<Field> printer = field ->
			System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()),
					field.getType().getSimpleName(),
					field.getName()));

while (!input.equals("HARVEST")){
	String modifierForLooking = input;

	Field[] requestedField = Arrays.stream(fields).filter(field ->
			Modifier.toString(field.getModifiers()).equals(modifierForLooking)).toArray(Field[]::new);


	if (requestedField.length!=0){
		Arrays.stream(requestedField).forEach(printer);
	}else {
		Arrays.stream(fields).forEach(printer);
	}


	input= scanner.nextLine();

}


	}
}
