package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class x implements LayoutInflater.Factory2 {

    /* renamed from: e, reason: collision with root package name */
    public final FragmentManager f981e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ j0 f982e;

        public a(j0 j0Var) {
            this.f982e = j0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f982e.k();
            this.f982e.m();
            SpecialEffectsController.u((ViewGroup) fragmentK.R.getParent(), x.this.f981e).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public x(FragmentManager fragmentManager) {
        this.f981e = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        j0 j0VarA;
        if (t.class.getName().equals(str)) {
            return new t(context, attributeSet, this.f981e);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Name.LABEL);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d0.c.f4438a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(d0.c.f4439b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(d0.c.f4440c, -1);
        String string = typedArrayObtainStyledAttributes.getString(d0.c.f4441d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !v.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentM0 = resourceId != -1 ? this.f981e.m0(resourceId) : null;
        if (fragmentM0 == null && string != null) {
            fragmentM0 = this.f981e.n0(string);
        }
        if (fragmentM0 == null && id != -1) {
            fragmentM0 = this.f981e.m0(id);
        }
        if (fragmentM0 == null) {
            fragmentM0 = this.f981e.z0().a(context.getClassLoader(), attributeValue);
            fragmentM0.f680x = true;
            fragmentM0.G = resourceId != 0 ? resourceId : id;
            fragmentM0.H = id;
            fragmentM0.I = string;
            fragmentM0.f681y = true;
            FragmentManager fragmentManager = this.f981e;
            fragmentM0.C = fragmentManager;
            fragmentM0.D = fragmentManager.B0();
            fragmentM0.K1(this.f981e.B0().r(), attributeSet, fragmentM0.f664j);
            j0VarA = this.f981e.k(fragmentM0);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentM0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentM0.f681y) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentM0.f681y = true;
            FragmentManager fragmentManager2 = this.f981e;
            fragmentM0.C = fragmentManager2;
            fragmentM0.D = fragmentManager2.B0();
            fragmentM0.K1(this.f981e.B0().r(), attributeSet, fragmentM0.f664j);
            j0VarA = this.f981e.A(fragmentM0);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentM0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.g(fragmentM0, viewGroup);
        fragmentM0.Q = viewGroup;
        j0VarA.m();
        j0VarA.j();
        View view2 = fragmentM0.R;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentM0.R.getTag() == null) {
            fragmentM0.R.setTag(string);
        }
        fragmentM0.R.addOnAttachStateChangeListener(new a(j0VarA));
        return fragmentM0.R;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
