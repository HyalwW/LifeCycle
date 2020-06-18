package com.example.lifecycle.tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wang.Wenhui
 * Date: 2020/6/15
 * Description: blablabla
 */
public class Task extends Thread {
    private List<Task> befores;
    private boolean isStart;

    public Task() {
    }

    public Task(Runnable target) {
        super(target);
    }

    public Task(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public Task(String name) {
        super(name);
    }

    public Task(ThreadGroup group, String name) {
        super(group, name);
    }

    public Task(Runnable target, String name) {
        super(target, name);
    }

    public Task(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public Task(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    public void runAfter(Task... tasks) {
        if (isStart) return;
        if (befores == null) {
            befores = new LinkedList<>();
        }
        befores.addAll(Arrays.asList(tasks));
    }

    @Override
    public void run() {
        isStart = true;
        if (befores != null) {
            try {
                for (Task before : befores) {
                    before.join();
                }
                befores.clear();
                super.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            super.run();
        }
    }
}
