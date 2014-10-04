package com.knowledgebase.general.java.question;


public class ImmutableUserWithPrimitives {
    private final long id;
    
    public ImmutableUserWithPrimitives(long id) {
        super();
        this.id = id;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
}
