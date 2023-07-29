package com.example.designpatternsapp.observermodel.AndroidEventBus.matchpolicy;

import com.example.designpatternsapp.observermodel.AndroidEventBus.EventType;

import java.util.List;

/**
 * @author mrsimple
 */
public interface MatchPolicy {
    List<EventType> findMatchEventTypes(EventType type, Object aEvent);
}