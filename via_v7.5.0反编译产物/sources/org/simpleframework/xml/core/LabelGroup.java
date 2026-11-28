package org.simpleframework.xml.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class LabelGroup {
    private final List<Label> list;
    private final int size;

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

    public LabelGroup(List<Label> list) {
        this.size = list.size();
        this.list = list;
    }
}
