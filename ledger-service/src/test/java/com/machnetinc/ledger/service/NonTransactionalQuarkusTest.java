package com.machnetinc.ledger.service;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.inject.Stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@QuarkusTest
@Stereotype
@TestTransaction
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NonTransactionalQuarkusTest {
}