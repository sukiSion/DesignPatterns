package com.example.designpatternsapp.observermodel.AndroidEventBus.handler;

import android.os.Handler;
import android.os.Looper;

import com.example.designpatternsapp.observermodel.AndroidEventBus.Subscription;

/**
 * 事件处理接口
 * 
 * @author mrsimple
 */
public interface EventHandler {

    void handleEvent(Subscription subscription, Object event);
}