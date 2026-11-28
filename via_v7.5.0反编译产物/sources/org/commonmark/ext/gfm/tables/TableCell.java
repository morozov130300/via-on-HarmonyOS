package org.commonmark.ext.gfm.tables;

import oc.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class TableCell extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Alignment f11496g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public Alignment m() {
        return this.f11496g;
    }

    public boolean n() {
        return this.f11495f;
    }

    public void o(Alignment alignment) {
        this.f11496g = alignment;
    }

    public void p(boolean z10) {
        this.f11495f = z10;
    }
}
