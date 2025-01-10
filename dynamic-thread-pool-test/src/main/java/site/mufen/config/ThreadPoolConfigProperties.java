package site.mufen.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mufen
 * @Description
 * @create 2025/1/10 16:36
 */
@Data
@ConfigurationProperties(prefix = "thread.pool.executor.config", ignoreInvalidFields = true)
public class ThreadPoolConfigProperties {

    /**
     * 核心线程数
     */
    private Integer corePoolSize = 20;
    /**
     * 最大线程数
     */
    private Integer maxPoolSize = 200;
    /**
     * 线程存活时间
     */
    private Long keepAliveTime = 10L;
    /**
     * 阻塞队列大小
     */
    private Integer blockQueueSize = 5000;

    /**
     * 线程池拒绝策略
     * AbortPolicy: 直接抛出异常
     * CallerRunsPolicy: 只用调用者所在线程来运行任务
     * DiscardOldestPolicy: 丢弃队列里最近的一个任务，并执行当前任务
     * DiscardPolicy: 不处理，丢弃
     */
    private String policy = "AbortPolicy";  // AbortPolicy, CallerRunsPolicy, DiscardOldestPolicy, DiscardPolicy

}
