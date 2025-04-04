package ru.netology.tasktwo;

@FunctionalInterface
public interface OnTaskDoneListener {
    void onDone(String result);
}
