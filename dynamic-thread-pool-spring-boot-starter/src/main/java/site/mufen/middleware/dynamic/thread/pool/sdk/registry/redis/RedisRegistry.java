package site.mufen.middleware.dynamic.thread.pool.sdk.registry.redis;

import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.valobj.RegistryEnumVO;
import site.mufen.middleware.dynamic.thread.pool.sdk.registry.IRegistry;

import java.time.Duration;
import java.util.List;

/**
 * @author mufen
 * @Description Redis 注册中心
 * @create 2025/1/10 19:14
 */
public class RedisRegistry implements IRegistry {

    private final RedissonClient redissonClient;

    public RedisRegistry(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    private final Logger logger = LoggerFactory.getLogger(RedisRegistry.class);

    @Override
    public void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolConfigEntityList) {
        RList<ThreadPoolConfigEntity> list = redissonClient.getList(RegistryEnumVO.THREAD_POOL_CONFIG_LIST_KEY.getKey());
        for (ThreadPoolConfigEntity entity : threadPoolConfigEntityList) {
            if (!list.contains(entity)) {
                list.add(entity);
            }
        }
    }

    @Override
    public void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity) {
        String cacheKey = RegistryEnumVO.THREAD_POOL_CONFIG_PARAM_LIST_KEY.getKey() + "_" + threadPoolConfigEntity.getAppName() + "_" + threadPoolConfigEntity.getThreadPoolName();
        redissonClient.getBucket(cacheKey).set(threadPoolConfigEntity, Duration.ofDays(30));
    }
}
