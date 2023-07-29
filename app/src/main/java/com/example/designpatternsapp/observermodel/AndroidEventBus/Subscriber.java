package com.example.designpatternsapp.observermodel.AndroidEventBus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 事件接收函数的注解类,运用在函数上
 *
 * @author mrsimple
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscriber {

    /**
     * 事件的tag，类似于BroadcastReceiver中的Action，事件的标识符
     * @return
     */
    String tag() default EventType.DEFAULT_TAG;

    /**
     * 事件的执行线程，默认为主线程
     * @return
     */
    ThreadMode mode() default ThreadMode.MAIN;

}
