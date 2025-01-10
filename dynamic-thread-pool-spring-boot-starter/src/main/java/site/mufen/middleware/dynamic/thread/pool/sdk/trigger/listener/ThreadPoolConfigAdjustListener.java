package site.mufen.middleware.dynamic.thread.pool.sdk.trigger.listener;

import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.mufen.middleware.dynamic.thread.pool.sdk.domain.IDynamicThreadPoolService;
import site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import site.mufen.middleware.dynamic.thread.pool.sdk.registry.IRegistry;

import java.util.List;


/**
 * @author mufen
 * @Description 动态线程池变更监听
 * @create 2025/1/10 20:28
 */
public class ThreadPoolConfigAdjustListener implements MessageListener<ThreadPoolConfigEntity> {

    private final  Logger logger = LoggerFactory.getLogger(ThreadPoolConfigAdjustListener.class);

    private final IDynamicThreadPoolService dynamicThreadPoolService;
    private final IRegistry registry;

    public ThreadPoolConfigAdjustListener(IDynamicThreadPoolService dynamicThreadPoolService, IRegistry registry) {
        this.dynamicThreadPoolService = dynamicThreadPoolService;
        this.registry = registry;
    }

    @Override
    public void onMessage(CharSequence channel, ThreadPoolConfigEntity threadPoolConfigEntity) {
        logger.info("动态线程池 调整线程池配置 线程池名称:{}, 核心线程数:{}, 最大线程数:{}", threadPoolConfigEntity.getThreadPoolName(),
            threadPoolConfigEntity.getCorePoolSize(), threadPoolConfigEntity.getMaximumPoolSize());

        // 修改线程池参数
        dynamicThreadPoolService.updateThreadPool(threadPoolConfigEntity);

        // 更新后上报最新数据
        List<ThreadPoolConfigEntity> threadPoolConfigEntities = dynamicThreadPoolService.queryThreadPoolList();
        registry.reportThreadPool(threadPoolConfigEntities);

        ThreadPoolConfigEntity threadPoolConfigEntityCur = dynamicThreadPoolService.queryThreadPoolByName(threadPoolConfigEntity.getThreadPoolName());
        registry.reportThreadPoolConfigParameter(threadPoolConfigEntityCur);


    }
}
