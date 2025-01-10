package site.mufen.middleware.dynamic.thread.pool.sdk.domain;

import site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.eneity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @author mufen
 * @Description 动态线程池服务
 * @create 2025/1/10 17:32
 */
public interface IDynamicThreadPoolService {

    List<ThreadPoolConfigEntity> queryThreadPoolList();

    ThreadPoolConfigEntity queryThreadPoolByName(String threadPoolName);

    void updateThreadPool(ThreadPoolConfigEntity threadPoolConfigEntity);


}
