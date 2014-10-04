package com.knowledgebase.general.java.question;

import org.junit.Test;

public class ImmutableUserWithBuilderTest {
    @Test
    public void test() {
        ImmutableUserWithBuilder user = new ImmutableUserWithBuilder.Builder("ssss","pppp").firstName("rachana").build();
        System.out.println(user.toString());
    }
}
