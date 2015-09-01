package cn.zsy.eg.redis.RedisPackage;

public interface RedisKey {

    public static final String ECOM_GXH_CID = "key:cid:%s";
    public static final String ECOM_GXH_SHOW_CNT = "key:show:%s:cnt";
    public static final String ECOM_GXH_SHOW_CNT_TOTAL = "key:show:%s:total";
    public static final String ECOM_GXH_SHOW_NEW_CNT = "key:show:%s:%s:cnt";
    public static final String ECOM_GXH_SHOW_NEW_CNT_TOTAL = "key:show:%s:%s:total";
    public static final String ECOM_GXH_DJ_USER = "key:show:dj:%s";
    public static final String ECOM_GXH_REQ_URL_CNT = "key:req:%s:%s:cnt";
    public static final String ECOM_GXH_REQ_TOTAL = "key:req:%s:total";

    public static final String ECOM_GXH_FILTER_TOTAL = "key:filter:%s:total";
    public static final String ECOM_GXH_USER_CNT = "key:user:%s:%s:total";
    public static final String ECOM_GXH_HAS_ICON_CNT = "key:hasIcon:%s:%s:total";

}
