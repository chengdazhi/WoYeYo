package com.woyeyo.woyeyo.im.common.infra;

public class DefaultTaskManager extends TaskManager {
    public DefaultTaskManager() {
    	this(new DefaultTaskWorker());
    }
    
    public DefaultTaskManager(String name) {
    	this(new DefaultTaskWorker(name));
    }
    
    public DefaultTaskManager(AbstractTaskWorker worker) {
    	super(new DefaultTaskScheduler(worker));
    }
}
