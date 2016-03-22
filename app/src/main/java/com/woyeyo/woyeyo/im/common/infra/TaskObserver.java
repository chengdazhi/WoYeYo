package com.woyeyo.woyeyo.im.common.infra;

public interface TaskObserver {
	/**
	 * on task result
	 * @param task
	 * @param results
	 */
	public void onTaskResult(com.woyeyo.woyeyo.im.common.infra.Task task, Object[] results);

	/**
	 * on task progress
	 * @param task
	 * @param params
	 */
	public void onTaskProgress(com.woyeyo.woyeyo.im.common.infra.Task task, Object[] params);
}
