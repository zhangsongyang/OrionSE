package cn.zsy.eg.identify;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

/**
 * 设备类型枚举，该类定义了设备类型描述，即每一种设备类型的中文含义。
 *
 * @since 2.1.02
 */
public enum DeviceTypeTest {
    /**
     * 所有
     *
     * @since 2.1.02
     */
    ALL_TYPE(-1, "所有", "ALL"),
    /**
     * 冰箱
     *
     * @since 2.1.02
     */
    FRIDGE(1, "冰箱", "RFR"),
    /**
     * 分体空调
     *
     * @since 2.1.02
     */
    SPLIT_AIRCONDITION(2, "分体空调", "AC"),
    /**
     * 柜机空调
     *
     * @since 2.1.02
     */
    PACKAGE_AIRCONDITION(3, "柜机空调", "AC"),
    /**
     * 波轮洗衣机
     *
     * @since 2.1.02
     */
    PULSATOR_WASHING_MACHINE(4, "波轮洗衣机", "WM"),
    /**
     * 滚筒洗衣机
     *
     * @since 2.1.02
     */
    DRUM_WASHING_MACHINE(5, "滚筒洗衣机", "WM"),
    /**
     * 电热水器
     *
     * @since 2.1.02
     */
    WATER_HEATER(6, "电热水器", "EWH"),
    /**
     * 微波炉
     *
     * @since 2.1.02
     */
    MICRO_WAVE_OVEN(7, "微波炉", "MWO"),
    /**
     * 酒柜
     *
     * @since 2.1.02
     */
    WINE_CABINET(8, "酒柜", "CELL"),
    /**
     * 烟机
     *
     * @since 2.1.02
     */
    RANGE_HOOD(9, "烟机", "RH"),
    /**
     * 洗碗机
     *
     * @since 2.1.02
     */
    DISH_WASHING_MACHINE(10, "洗碗机", "DW"),
    /**
     * 消毒柜
     *
     * @since 2.1.02
     */
    DISINFECTION_CABINET(11, "消毒柜", "DTC"),
    /**
     * 保留
     *
     * @since 2.1.02
     */
    RESERVE(12, "保留", "RESERVE"),
    /**
     * 商用空调
     *
     * @since 2.1.02
     */
    COMMERCIAL_AIRCONDITION(13, "商用空调", "BAC"),
    /**
     * 电视
     *
     * @since 2.1.02
     */
    TV(14, "电视", "TV"),
    /**
     * 影音娱乐
     *
     * @since 2.1.02
     */
    HOME_ENTERTAINMENT_EQUIPMENT(15, "影音娱乐", "ETM"),
    /**
     * 灯光照明
     *
     * @since 2.1.02
     */
    LIGHTING(16, "灯光照明", "LIGHT"),
    /**
     * 安防报警
     *
     * @since 2.1.02
     */
    SECURITY_EQUIPMENT(17, "安防报警", "SECU"),
    /**
     * 视频监控
     *
     * @since 2.1.02
     */
    VIDEO_SURVEILLANCE(18, "视频监控", "VM"),
    /**
     * 传感器
     *
     * @since 2.1.02
     */
    SENSOR(19, "传感器", "SEN"),
    /**
     * 智能家居
     *
     * @since 2.1.02
     */
    SMART_HOME(20, "智能家居", "SH"),
    /**
     * 医疗健康
     *
     * @since 2.1.02
     */
    MEDICAL_CARE(21, "医疗健康", "HC"),
    /**
     * 冷柜
     *
     * @since 2.1.02
     */
    REFRIDGERATOR(22, "冷柜", "IC"),
    /**
     * 医用柜
     *
     * @since 2.1.02
     */
    MEDICAL_CABINET(23, "医用柜", "MED"),
    /**
     * 燃气热水器
     *
     * @since 2.1.02
     */
    GAS_WATER_HEATER(24, "燃气热水器", "GWH"),
    /**
     * 采暖炉
     *
     * @since 2.1.02
     */
    HEATING_FURNACE(25, "采暖炉", "BWH"),
    /**
     * 蒸箱
     *
     * @since 2.1.02
     */
    STEAM_BOX(26, "蒸箱", "SO"),
    /**
     * 咖啡机
     *
     * @since 2.1.02
     */
    COFFEE_MAKER(27, "咖啡机", "CM"),
    /**
     * 饮水机
     *
     * @since 2.1.02
     */
    WATER_MACHINE(28, "饮水机", "WD"),
    /**
     * 灶具
     *
     * @since 2.1.02
     */
    COOKING(29, "灶具", "CU"),
    /**
     * 烤箱
     *
     * @since 2.1.02
     */
    OVEN(30, "烤箱", "OV"),
    /**
     * 太阳能
     *
     * @since 2.1.02
     */
    SOLAR_WATER_HEATER(31, "太阳能", "SWH"),
    /**
     * 热泵
     *
     * @since 2.1.02
     */
    HEAT_PUMP(32, "热泵", "HWH"),
    /**
     * 空气净化设备
     *
     * @since 2.1.02
     */
    AIR_PURIFIER(33, "空气净化设备", "AIC"),
    /**
     * 净水机
     *
     * @since 2.1.02
     */
    WATER_PURIFIER(34, "净水机", "WP"),
    /**
     * 水壶
     *
     * @since 3.3.01
     */
    KETTLE(35, "水壶", "???"),
    /**
     * 新风设备
     *
     * @since 3.2.02
     */
    NEW_WIND_DEVICE(36, "新风设备", "???"),
    /**
     * 地暖设备
     *
     * @since 3.3.01
     */
    FLOOR_HEATING_DEVICE(37, "地暖设备", "???"),
    /**
     * 公共服务类
     *
     * @since 3.2.02
     */
    PUBLIC_SERVICE(38, "公共服务类", "???"),
    /**
     * 吸尘器
     *
     * @since 3.2.02
     */
    DUST_PROOF(39, "吸尘器", "???"),
    /**
     * 小厨电
     *
     * @since 3.2.02
     */
    KITCHEN_APPLIANCE(40, "小厨电", "???"),
    /**
     * 环境监测设备
     *
     * @since 3.2.02
     */
    ENV_MONITOR(41, "环境监测设备", "???"),
    /**
     * 网关
     *
     * @since 3.3.01
     */
    GATEWAY(48, "网关", "???"),
    /**
     * 干衣机
     */
    DRYER(49, "干衣机", "???"),
    /**
     * 可穿戴设备
     *
     * @since 3.2.02
     */
    WEARABLE_DEVICE(50, "可穿戴设备", "???"),
    /**
     * 空气魔方
     *
     * @since 2.1.02
     */
    AIR_CUBE(51, "空气魔方", "ACB"),
    /**
     * 浴霸及暖风机
     */
    AIR_HEATER(52, "浴霸及暖风机", "???"),
    /**
     * 其他
     *
     * @since 3.2.02
     */
    OTHER_DEVICE(53, "其他", "???"),
    /**
     * 个人护理类
     */
    PERSONAL_CLEANER(54, "个人护理类", "???"),
    /**
     * 机器人
     *
     * @since 3.3.01
     */
    ROBOT(161, "机器人", "???"),
    /**
     * 路由模块
     *
     * @since 2.1.02
     */
    ROUTING_MODULE(225, "路由模块", "RU"),
    /**
     * 路由器
     *
     * @since 2.1.02
     */
    SMART_ROUTER(226, "路由器", "SR"),
    /**
     * 控制终端
     *
     * @since 2.1.02
     */
    CONTROL_TERMINAL(241, "控制终端", "CT"),

    /**
     * 未知
     *
     * @since 2.1.02
     */
    UNKNOWN(0, "未知", "XX");

    DeviceTypeTest(int typeId, String typeInfo, String abbreviation) {
        this.typeId = typeId;
        this.typeInfo = typeInfo;
        this.abbreviation = abbreviation;
    }

    private final int typeId;

    private final String typeInfo;

    private final String abbreviation;

    private static HashMap<Integer, DeviceTypeTest> mDeviceTypeMap = new HashMap<>();

    static {
        for (DeviceTypeTest type : values()) {
            mDeviceTypeMap.put(type.typeId, type);
        }
    }

    /**
     * 获取枚举描述
     *
     * @return String 枚举描述
     * @since 2.1.02
     */
    public String getValue() {
        return typeInfo;
    }

    /**
     * 获取枚举描述
     *
     * @return int 枚举描述
     * @since 3.1.01
     */
    public int getId() {
        return typeId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * 根据枚举名称获取枚举实例
     *
     * @param content 枚举名称
     * @return DeviceType 枚举实例指针
     * @since 2.1.02
     */
    public static DeviceTypeTest getInstance(String content) {
        try {
            return DeviceTypeTest.valueOf(content);
        } catch (Exception e) {
            return DeviceTypeTest.UNKNOWN;
        }
    }

    /**
     * 根据枚举序号获取枚举实例
     *
     * @param index 枚举序号
     * @return DeviceType 枚举实例指针
     * @since 2.1.02
     */
    public static DeviceTypeTest getInstance(int index) {
        DeviceTypeTest type = mDeviceTypeMap.get(index);
        return type == null ? DeviceTypeTest.UNKNOWN : type;
    }

    /**
     * 根据缩写获取设备大类
     *
     * @param abbreviation 设备大类缩写
     * @return 设备大类枚举
     * @since 3.1.01
     */
    public static DeviceTypeTest getInstanceByAb(String abbreviation) {
        DeviceTypeTest type = DeviceTypeTest.UNKNOWN;
        if (StringUtils.isEmpty(abbreviation)) {
            return type;
        }
        abbreviation = abbreviation.toUpperCase();
        for (DeviceTypeTest typeConst : values()) {
            if (typeConst.abbreviation.equals(abbreviation)) {
                return typeConst;
            }
        }
        return type;
    }

    @Override
    public String toString() {
        return "DeviceType{" +
            "typeId=" + typeId +
            ", typeInfo='" + typeInfo + '\'' +
            ", abbreviation='" + abbreviation + '\'' +
            '}';
    }
}
