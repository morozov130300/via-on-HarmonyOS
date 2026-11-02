package org.simpleframework.xml.core;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
interface Instantiator {
    List<Creator> getCreators();

    Object getInstance();

    Object getInstance(Criteria criteria);

    Parameter getParameter(String str);

    List<Parameter> getParameters();

    boolean isDefault();
}
