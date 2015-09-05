package reflection;

import java.lang.reflect.Field;

public class MagicClass {

    public static <S, D> D transfer(S sourceObject, Class<D> destObjectClass) throws Exception {
        D destObject = destObjectClass.newInstance();

        Field[] fields = sourceObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            MyFieldAnnotation annotation = field.getAnnotation(MyFieldAnnotation.class);

            if (annotation != null) {
                field.setAccessible(true);
                Object value = field.get(sourceObject);

                if (value instanceof GenderBean) {
                    Field genderField = value.getClass().getDeclaredField("gender");
                    genderField.setAccessible(true);
                    System.out.println(" ...gender: " + genderField.get(value));
                }

                Field[] dFields = destObject.getClass().getDeclaredFields();

                for (Field dField : dFields) {
                    dField.setAccessible(true);
                    MyFieldAnnotation dAnnotation = dField.getAnnotation(MyFieldAnnotation.class);

                    if (dAnnotation != null && annotation.field().equals(dAnnotation.field())) {
                        dField.set(destObject, value);
                    }
                }

            }
        }

        return destObject;
    }

    public static void transfer(PersonBean personBean, PersonDomain personDomain) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        Field[] fields = personBean.getClass().getDeclaredFields();

        for (Field field : fields) {
            MyFieldAnnotation annotation = field.getAnnotation(MyFieldAnnotation.class);

            if (annotation != null) {
                field.setAccessible(true);
                Object value = field.get(personBean);

                if (value instanceof GenderBean) {
                    Field genderField = value.getClass().getDeclaredField("gender");
                    genderField.setAccessible(true);
                    System.out.println(" ...gender: " + genderField.get(value));
                }

                Field[] dFields = personDomain.getClass().getDeclaredFields();

                for (Field dField : dFields) {
                    dField.setAccessible(true);
                    MyFieldAnnotation dAnnotation = dField.getAnnotation(MyFieldAnnotation.class);

                    if (dAnnotation != null && annotation.field().equals(dAnnotation.field())) {
                        dField.set(personDomain, value);
                    }
                }

            }
        }
    }
}
