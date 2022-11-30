package org.example;

/**
 * Sumator
 */
@FunctionalInterface
public interface Sumator < T >{

    public T sum( T i1, T i2 );
}