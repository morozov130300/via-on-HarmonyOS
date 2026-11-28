package com.tuyafeng.support.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends RadioGroup {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3666c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i10) {
            b.a(b.this);
        }
    }

    /* JADX INFO: renamed from: com.tuyafeng.support.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class C0051b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3669b;

        public C0051b(int i10, String str) {
            this.f3668a = i10;
            this.f3669b = str;
        }

        public int a() {
            return this.f3668a;
        }

        public String b() {
            return this.f3669b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
    }

    public b(Context context) {
        this(context, null);
    }

    public static /* synthetic */ c a(b bVar) {
        bVar.getClass();
        return null;
    }

    public final void b() {
        setOrientation(0);
        setOnCheckedChangeListener(new a());
    }

    public final void c(RadioButton radioButton, C0051b c0051b) {
        if (radioButton == null || c0051b == null) {
            return;
        }
        radioButton.setId(c0051b.a());
        radioButton.setText(c0051b.b());
        radioButton.setTextSize(0, com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13761n));
        radioButton.setSingleLine(true);
        radioButton.setMaxLines(1);
        radioButton.setTextColor(v8.h.g(getContext(), v8.h.o(getContext())));
        radioButton.setButtonDrawable((Drawable) null);
        int iH = com.tuyafeng.support.utils.x.h(getContext(), 8.0f);
        radioButton.setPadding(iH, 0, iH, 0);
        radioButton.setMinWidth(com.tuyafeng.support.utils.x.h(getContext(), 48.0f));
        radioButton.setMinHeight(com.tuyafeng.support.utils.x.h(getContext(), 28.0f));
        radioButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.tuyafeng.support.utils.x.h(getContext(), 4.0f);
        layoutParams.rightMargin = com.tuyafeng.support.utils.x.h(getContext(), 4.0f);
        layoutParams.topMargin = com.tuyafeng.support.utils.x.h(getContext(), 4.0f);
        layoutParams.bottomMargin = com.tuyafeng.support.utils.x.h(getContext(), 4.0f);
        radioButton.setLayoutParams(layoutParams);
        com.tuyafeng.support.utils.x.P(radioButton, v8.h.f(getContext()));
        v8.g.d(radioButton);
    }

    public void setFilters(List<C0051b> list) {
        C0051b next;
        if (this.f3666c.size() > 0) {
            this.f3666c.clear();
            removeAllViews();
        }
        Iterator<C0051b> it = list.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            RadioButton radioButton = new RadioButton(getContext());
            c(radioButton, next);
            addView(radioButton);
            this.f3666c.add(next);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3666c = new ArrayList();
        b();
    }

    public void setOnFilterCheckListener(c cVar) {
    }
}
