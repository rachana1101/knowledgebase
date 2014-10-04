package com.knowledgebase.general.java.question;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class ImmutableUserTest {
    
    @Test
    public void reflectionFailure() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ImmutableUser user = new ImmutableUser(UUID.randomUUID(), "john", "liu");
        Field i =user.getClass().getDeclaredField("firstName");
        i.setAccessible(true);
        i.set(user, "cassandra");
        System.out.println("user " + user.getFirstName()); // prints cassandra
    }
    
    @Test
    public void reflectionTestForClassWithPrimitiveAttributes() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ImmutableUserWithPrimitives user = new ImmutableUserWithPrimitives(10);
        Field i =user.getClass().getDeclaredField("id");
        i.setAccessible(true);
        i.set(user, 1000L);
        System.out.println("user " + user.getId()); // prints cassandra
    }
    
    @Test
    public void checkClassIfFinal() {
        ImmutableUser user = new ImmutableUser(UUID.randomUUID(), "john", "liu");
        boolean result = isImmutable(user);
        Assert.assertTrue(result);
    }
    
    @Test
    public void checkClassIfFinal_withPrimitives() {
        ImmutableUserWithPrimitives user1 = new ImmutableUserWithPrimitives(10);
        boolean result = isImmutable(user1);
        Assert.assertTrue(result);
    }
    
    private boolean isImmutable(Object obj) {
        Class<?> objClass = obj.getClass();

        // Class of the object must be a direct child class of the required class
        Class<?> superClass = objClass.getSuperclass();
       /* if (!Immutable.class.equals(superClass)) {
            return false;
        }*/

        // Class must be final
        if (!Modifier.isFinal(objClass.getModifiers())) {
            return false;
        }

        // Check all fields defined in the class for type and if they are final
        Field[] objFields = objClass.getDeclaredFields();
        for (int i = 0; i < objFields.length; i++) {
//            if (!Modifier.isFinal(objFields[i].getModifiers())
//                    || !isValidFieldType(objFields[i].getType())) {
//                return false;
//            }
            
            if (!Modifier.isFinal(objFields[i].getModifiers())
                    ) {
                return false;
            }
        }

        // Lets hope we didn't forget something
        return true;
    }

    static boolean isValidFieldType(Class<?> type) {
        // Check for all allowed property types...
        return type.isPrimitive() || String.class.equals(type);
    }
    
    
}
