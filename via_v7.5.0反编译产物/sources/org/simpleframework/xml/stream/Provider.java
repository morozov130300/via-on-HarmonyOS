package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
interface Provider {
    EventReader provide(InputStream inputStream);

    EventReader provide(Reader reader);
}
