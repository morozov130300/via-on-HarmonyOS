package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
interface Converter {
    Object read(InputNode inputNode);

    Object read(InputNode inputNode, Object obj);

    boolean validate(InputNode inputNode);

    void write(OutputNode outputNode, Object obj);
}
