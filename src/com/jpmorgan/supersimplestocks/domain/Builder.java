package com.jpmorgan.supersimplestocks.domain;

public abstract class Builder<T> {

    protected T object;

    Builder() {
        object = createObject();
    }

    public T build() {
        return object;
    }

    protected abstract T createObject();

}
