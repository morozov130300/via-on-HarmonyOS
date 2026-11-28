package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import n2.c;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class DependencyCycleException extends DependencyException {
    private final List<c> componentsInCycle;

    public DependencyCycleException(List<c> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<c> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
