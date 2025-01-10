package site.mufen.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RTopic;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.eneity.ThreadPoolConfigEntity;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * @author mufen
 * @Description
 * @create 2025/1/10 16:47
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiTest {

    @Resource
    private RTopic dynamicThreadPoolRedisTopic;

    @Test
    public void test_dynamic_thread_pool() throws InterruptedException {
        ThreadPoolConfigEntity threadPoolConfigEntity = new ThreadPoolConfigEntity("dynamic-thread-pool-test-app", "threadPoolExecutor02");
        threadPoolConfigEntity.setCorePoolSize(10);
        threadPoolConfigEntity.setMaximumPoolSize(100);

        dynamicThreadPoolRedisTopic.publish(threadPoolConfigEntity);

        new CountDownLatch(1).await();
    }
}
