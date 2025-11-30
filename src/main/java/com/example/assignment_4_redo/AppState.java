package com.example.assignment_4_redo;

import javafx.collections.ObservableList;

public class AppState
{
    private static final AppState instance = new AppState();


    private final ObservableList<horror_character> creatures;

    public AppState() {
        this.creatures = null;
    }
}
