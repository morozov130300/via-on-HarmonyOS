package org.commonmark.ext.gfm.tables;

import kc.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class TableCell extends f {

    /* renamed from: f, reason: collision with root package name */
    public boolean f10873f;

    /* renamed from: g, reason: collision with root package name */
    public Alignment f10874g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public Alignment m() {
        return this.f10874g;
    }

    public boolean n() {
        return this.f10873f;
    }

    public void o(Alignment alignment) {
        this.f10874g = alignment;
    }

    public void p(boolean z10) {
        this.f10873f = z10;
    }
}
