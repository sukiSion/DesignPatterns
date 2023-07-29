package com.example.designpatternsapp.observermodel.AndroidEventBus.handler;

/**
 * 处理事件
 *
 * @param subscription 订阅对象
 * @param event 待处理的事件
 */

import android.os.Handler;
import android.os.Looper;

import com.example.designpatternsapp.observermodel.AndroidEventBus.Subscription;

/**
 * 事件处理在UI线程,通过Handler将事件处理post到UI线程的消息队列
 *
 * @author mrsimple
 */
public class UIThreadEventHandler implements EventHandler {

    /**
     * ui handler
     */
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    /**
     *
     */
    DefaultEventHandler mEventHandler = new DefaultEventHandler();

    /**
     * @param subscription
     * @param event
     */
    public void handleEvent(final Subscription subscription, final Object event) {
        mUIHandler.post(new Runnable() {

            @Override
            public void run() {
                mEventHandler.handleEvent(subscription, event);
            }
        });
    }

}