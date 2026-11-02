package org.simpleframework.xml.core;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
class LabelGroup {
    private final List<Label> list;
    private final int size;

    public LabelGroup(List<Label> list) {
        this.size = list.size();
        this.list = list;
    }

    public LabelGroup(Label label) {
        this((List<Label>) Arrays.asList(label));
    }

    public List<Label> getList() {
        return this.list;
    }

    public Label getPrimary() {
        if (this.size > 0) {
            return this.list.get(0);
        }
        return null;
    }
}
