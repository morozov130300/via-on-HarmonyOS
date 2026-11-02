package org.simpleframework.xml;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface ElementMap {
    boolean attribute() default false;

    boolean data() default false;

    boolean empty() default true;

    String entry() default "";

    boolean inline() default false;

    String key() default "";

    Class keyType() default void.class;

    String name() default "";

    boolean required() default true;

    String value() default "";

    Class valueType() default void.class;
}
