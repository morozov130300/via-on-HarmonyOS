package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
interface Extractor<T extends Annotation> {
    T[] getAnnotations();

    Label getLabel(T t10);

    Class getType(T t10);
}
