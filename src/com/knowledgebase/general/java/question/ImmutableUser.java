package com.knowledgebase.general.java.question;

import java.util.UUID;

/**
 * my question : http://stackoverflow.com/questions/24545239/how-to-make-object-immutable-in-java
 * 
 * General interview question is what is immutability 
 * and how to create immutable class in java
 * 1) Dont allow mutters that means setter
 * 2) Make class final so that no one can extend it as if you allow to extend
 * 3) provide only public constructor to create the instance once
 * 4) make the attribute final - helps from changing the attributes using reflection 
 *                               also helps in thread safety.
 * 5) Require that they inherit from a base class you provide (which is guaranteed to be immutable)                                
 *       
 * than attributes can be changed via sub class
 * @author rachana
 *
 */
public final class ImmutableUser {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    
    public ImmutableUser(UUID id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
}
