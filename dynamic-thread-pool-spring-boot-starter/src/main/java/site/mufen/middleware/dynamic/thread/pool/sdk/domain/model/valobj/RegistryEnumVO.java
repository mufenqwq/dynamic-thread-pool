package site.mufen.middleware.dynamic.thread.pool.sdk.domain.model.valobj;

/**
 * @author mufen
 * @Description 注册中心枚举对象 key
 * @create 2025/1/10 19:28
 */
public enum RegistryEnumVO {
    THREAD_POOL_CONFIG_LIST_KEY("THEAD_POOL_CONFIG_LIST_KEY", "线程池配置列表"),
    THREAD_POOL_CONFIG_PARAM_LIST_KEY("THEAD_POOL_CONFIG_PARAM_LIST_KEY", "线程池配置参数列表"),
    DYNAMIC_THREAD_POLL_REDIS_TOPIC("DYNAMIC_THREAD_POLL_REDIS_TOPIC", "动态线程池redis topic"),
    ;
    private final String key;
    private final String desc;

    RegistryEnumVO(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getKey() {
        return key;
    }
}
