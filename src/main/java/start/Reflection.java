package start;

import java.lang.reflect.Field;

public class Reflection {

    public static String retrieveProperties(Object object) {

        String s = "";
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // set modifier to public
            Object value;
            try {
                value = field.get(object);
                s+=field.getName() + " = " + value+"\n";

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return s;
    }


}
