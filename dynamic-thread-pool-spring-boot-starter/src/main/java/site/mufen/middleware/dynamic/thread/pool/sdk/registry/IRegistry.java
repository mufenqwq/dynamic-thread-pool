package site.mufen.middleware.dynamic.thread.pool.sdk.registry;

import site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.eneity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @author mufen
 * @Description 注册中心接口
 * @create 2025/1/10 19:07
 */
public interface IRegistry {

    /**
     * 上报线程池
     * @param threadPoolConfigEntityList 线程池列表
     */
    void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolConfigEntityList);

    /**
     * 上报线程池配置参数
     * @param threadPoolConfigEntity 线程池配置参数
     */
    void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity);
}
