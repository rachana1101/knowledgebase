package com.knowledgebase.general.java.question;


public final class ImmutableUserWithBuilder {
    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;

    private ImmutableUserWithBuilder(Builder builder) {
        this.userName = builder.userName;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
    }

    public static class Builder {
        private String userName;
        private String password;
        private String firstName;
        private String lastName;

        public Builder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ImmutableUserWithBuilder build() {
            return new ImmutableUserWithBuilder(this);
        }
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
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
    
    @Override
    public String toString() {
        return new StringBuilder()
                .append(" username ").append(userName)
                .append(" last name ").append(lastName)
                .append(" first name ").append(firstName)
                .toString();
    }
}
