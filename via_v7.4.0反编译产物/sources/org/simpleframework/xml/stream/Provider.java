package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
interface Provider {
    EventReader provide(InputStream inputStream);

    EventReader provide(Reader reader);
}
