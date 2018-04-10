package cn.zsy.eg.identify;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mateng on 16-2-22.
 */
public class SDKUtils {

    private static final int HEX_RADIX = 16;

    private static final int DEFAULT_START_OFFSET = 14;

    private static final String FIRST_GENERATION_WIFI_DEV_PREFIX = "0";

    private static final String PATTERN_SECOND_GENERATION_WIFI_DEV = "^[1-9].*$";

    private static final Logger logger = LoggerFactory.getLogger(SDKUtils.class);

    /**
     * 根据设备uplusId解析出设备大类,中类及专用号
     *
     * @param uplusId 设备uplusId
     * @return 设备类型信息对象
     */
    public static DeviceTypeInfo parseDeviceTypeAndSpecialId(String uplusId) {
        DeviceTypeInfo deviceTypeInfo = new DeviceTypeInfo();

        if (StringUtils.isEmpty(uplusId) || !uplusId.matches("^(0\\w{31})|([1-9]\\w{63})$")) {
            logger.info("parse %s type and specialId failed.", uplusId);
            return deviceTypeInfo;
        }

        try {
            if (uplusId.startsWith(FIRST_GENERATION_WIFI_DEV_PREFIX)) { //wifi 一代设备
                parseGen1Dev(uplusId, deviceTypeInfo);
            } else if (uplusId.matches(PATTERN_SECOND_GENERATION_WIFI_DEV)) { //wifi 二代设备
                parseGen2Dev(uplusId, deviceTypeInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Invalid uplusId:%s", uplusId);
        }
        return deviceTypeInfo;
    }

    private static void parseGen1Dev(String uplusId, DeviceTypeInfo deviceTypeInfo) {
        deviceTypeInfo.mainType = DeviceType.getInstance(parseTypeIdByte(uplusId, DEFAULT_START_OFFSET, 2, 2, 6));

        deviceTypeInfo.middleType = parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 2, 2, 2, 6);

        int value = parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 4, 2, 2, 6);
        value = (value << 8) + parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 6, 2, 2, 6);
        value = (value << 8) + parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 8, 2, 2, 6);
        value = (value << 8) + parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 10, 2, 2, 6);

        int first = parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 12, 2, 4, 4);
        int second = parseTypeIdByte(uplusId, DEFAULT_START_OFFSET + 14, 2, 4, 4);
        deviceTypeInfo.specialId = String.format("%010d%s%s", value, transform(first), transform(second));
    }

    private static void parseGen2Dev(String uplusId, DeviceTypeInfo deviceTypeInfo) {
        deviceTypeInfo.mainType = DeviceType.getInstance(parseTypeIdByte(uplusId, 16, 1, 4, 0));
        deviceTypeInfo.middleType = parseTypeIdByte(uplusId, 18, 1, 4, 0);

        int flag = parseTypeIdByte(uplusId, 62, 1, 4, 0) & 0x80;
        if (flag == 0) { //企业版需要解析specialId
            int first = parseTypeIdByte(uplusId, 30, 1, 4, 0);
            int second = parseTypeIdByte(uplusId, 32, 1, 4, 0);
            int third = parseTypeIdByte(uplusId, 34, 1, 4, 0);
            deviceTypeInfo.specialId = String.format("%s%s%s%s", uplusId.substring(20, 30), transform(first)
                , transform(second), transform(third));
        } else {
            deviceTypeInfo.specialId = "";
        }
    }


    /**
     * 设备类型信息对象
     */
    public static class DeviceTypeInfo {
        public DeviceType mainType = DeviceType.UNKNOWN;//设备大类
        public int middleType;//设备中类
        public String specialId = "";//设备专用号

        public DeviceType getMainType() {
            return mainType;
        }

        public void setMainType(DeviceType mainType) {
            this.mainType = mainType;
        }

        public int getMiddleType() {
            return middleType;
        }

        public void setMiddleType(int middleType) {
            this.middleType = middleType;
        }

        public String getSpecialId() {
            return specialId;
        }

        public void setSpecialId(String specialId) {
            this.specialId = specialId;
        }

        @Override
        public String toString() {
            return "DeviceTypeInfo{" +
                "mainType=" + mainType.toString() +
                ", middleType=" + middleType +
                ", specialId='" + specialId + '\'' +
                '}';
        }
    }

    private static String transform(int target) {
        return target > 0 ? String.format("%c", target) : "0";
    }


    private static int parseTypeIdByte(String target, int begin, int offset, int left, int right) {
        int first = Integer.parseInt(target.substring(begin, begin = begin + offset), HEX_RADIX) << left;
        int second = Integer.parseInt(target.substring(begin, begin + offset), HEX_RADIX) >> right;
        return (first + second) & 0xff;
    }

}

