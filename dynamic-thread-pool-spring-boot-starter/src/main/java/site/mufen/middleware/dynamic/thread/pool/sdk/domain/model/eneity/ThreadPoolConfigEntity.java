package site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.eneity;

import java.util.Objects;

/**
 * Represents the configuration for a thread pool.
 * This class contains various properties related to the thread pool configuration
 * such as the application name, thread pool name, core pool size, maximum pool size, etc.
 *
 * @author mufen
 * @version 1.0
 * @since 2025-01-10
 */
public class ThreadPoolConfigEntity {
    private String appName;
    private String threadPoolName;
    private int corePoolSize;
    private int maximumPoolSize;
    private int activeCount;
    private int pollSize;
    private String queueType;
    private int queueSize;
    private int remainingCapacity;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ThreadPoolConfigEntity that = (ThreadPoolConfigEntity) o;
        return Objects.equals(appName, that.appName) && Objects.equals(threadPoolName, that.threadPoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appName, threadPoolName);
    }

    /**
     * Default constructor.
     */
    public ThreadPoolConfigEntity() {
    }

    /**
     * Constructor with application name and thread pool name.
     *
     * @param appName the name of the application
     * @param threadPoolName the name of the thread pool
     */
    public ThreadPoolConfigEntity(String appName, String threadPoolName) {
        this.appName = appName;
        this.threadPoolName = threadPoolName;
    }

    /**
     * Gets the application name.
     *
     * @return the application name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Sets the application name.
     *
     * @param appName the application name to set
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * Gets the thread pool name.
     *
     * @return the thread pool name
     */
    public String getThreadPoolName() {
        return threadPoolName;
    }

    /**
     * Sets the thread pool name.
     *
     * @param threadPoolName the thread pool name to set
     */
    public void setThreadPoolName(String threadPoolName) {
        this.threadPoolName = threadPoolName;
    }

    /**
     * Gets the core pool size.
     *
     * @return the core pool size
     */
    public int getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * Sets the core pool size.
     *
     * @param corePoolSize the core pool size to set
     */
    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * Gets the maximum pool size.
     *
     * @return the maximum pool size
     */
    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    /**
     * Sets the maximum pool size.
     *
     * @param maximumPoolSize the maximum pool size to set
     */
    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    /**
     * Gets the active count.
     *
     * @return the active count
     */
    public int getActiveCount() {
        return activeCount;
    }

    /**
     * Sets the active count.
     *
     * @param activeCount the active count to set
     */
    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    /**
     * Gets the poll size.
     *
     * @return the poll size
     */
    public int getPollSize() {
        return pollSize;
    }

    /**
     * Sets the poll size.
     *
     * @param pollSize the poll size to set
     */
    public void setPollSize(int pollSize) {
        this.pollSize = pollSize;
    }

    /**
     * Gets the queue type.
     *
     * @return the queue type
     */
    public String getQueueType() {
        return queueType;
    }

    /**
     * Sets the queue type.
     *
     * @param queueType the queue type to set
     */
    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    /**
     * Gets the queue size.
     *
     * @return the queue size
     */
    public int getQueueSize() {
        return queueSize;
    }

    /**
     * Sets the queue size.
     *
     * @param queueSize the queue size to set
     */
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    /**
     * Gets the remaining capacity.
     *
     * @return the remaining capacity
     */
    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    /**
     * Sets the remaining capacity.
     *
     * @param remainingCapacity the remaining capacity to set
     */
    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }
}