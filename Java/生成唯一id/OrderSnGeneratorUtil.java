package leo.utils;

// import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单编号生成器
 * 生成规则：
 * 年月日 + 6位随机码 + 用户 ID 后四位 + 1位业务编码（2019102212345602221）
 *
 * @author Leo
 * @since 2019-10-22
 */
public final class OrderSnGeneratorUtil {
    /**
     * 普通订单业务编码
     */
    private static final String ORDER_CODE = "1";

    /**
     * 付款订单业务编码
     */
    private static final String PAYMENT_CODE = "2";

    /**
     * 退货订单业务编码
     */
    private static final String RETURN_CODE = "3";

    /**
     * 退款订单业务编码
     */
    private static final String REFUND_CODE = "4";

    /**
     * 加密随即编码
     */
    private static final int[] r = new int[]{7, 1, 3, 0, 9, 8, 6, 2, 5, 4};

    /**
     * 用户id和随机数总长度
     */
    private static final int MAX_LENGTH = 10;

    /**
     * 取用户id后几位
     */
    private static final int LAST_LENGTH = 4;

    /**
     * 根据id取后几位进行加密+加随机数组成固定长度编码
     *
     * @param id
     * @return String
     */
    private static String toCode(Long id) {
        // 补0 取后几位
        String idStr = String.format("%0" + LAST_LENGTH + "d", id);
        idStr = idStr.substring(idStr.length() - LAST_LENGTH);

        StringBuilder ids = new StringBuilder(MAX_LENGTH);
        ids.append(getRandom(MAX_LENGTH - idStr.length()));

        for (int i = 0; i < idStr.length(); i++) {
            ids.append(r[idStr.charAt(i) - '0']);
        }
        return ids.toString();
//        return RandomStringUtils.randomNumeric(6) + id.toString();
    }

    /**
     * 根据id进行加密+加随机数组成固定长度编码
     *
     * @param id
     * @return String
     */
    private static String toCode2(Long id) {
        String idStr = id.toString();
        StringBuilder ids = new StringBuilder(MAX_LENGTH);

        ids.append(getRandom(MAX_LENGTH - idStr.length()));

        for (int i = idStr.length() - 1; i >= 0; i--) {
            ids.append(r[idStr.charAt(i) - '0']);
        }
        return ids.toString();
//        return RandomStringUtils.randomNumeric(6) + id.toString();
    }

    /**
     * 生成日期
     *
     * @return String
     */
    private static String getDate() {
        // 获取当前时间, 返回格式如 yyyyMMdd (yyyyMMddHHmmssSSS)
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    /**
     * 生成固定长度随机码
     *
     * @param n
     * @return long
     */
    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    /**
     * 生成编码
     *
     * @param userId
     * @return String
     */
    private static synchronized String getCode(Long userId) {
        return getDate() + toCode(userId);
    }

    /**
     * 生成订单单号编码
     *
     * @param userId
     * @return String
     */
    public static String getOrderCode(Long userId) {
        return getCode(userId) + ORDER_CODE;
    }

    /**
     * 生成退货单号编码
     *
     * @param userId
     * @return String
     */
    public static String getReturnCode(Long userId) {
        return getCode(userId) + RETURN_CODE;
    }

    /**
     * 生成退款单号编码
     *
     * @param userId
     * @return String
     */
    public static String getRefundCode(Long userId) {
        return getCode(userId) + REFUND_CODE;
    }

    /**
     * 生成支付订单号编码
     *
     * @param userId
     * @return String
     */
    public static String getPaymentCode(Long userId) {
        return getCode(userId) + PAYMENT_CODE;
    }

    public static void main(String[] args) {
        System.out.println(OrderSnGeneratorUtil.getOrderCode(222L));

        // 测试一百万次性能
//        int times = 1000000;
//        long begin = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
//            OrderSnGeneratorUtil.getOrderCode(222L);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("花费时间：" + (end - begin) + "毫秒");

        // 测试一百万次重复次数
//        Set<String> set = new HashSet<String>();
//        int times = 1000000;
//        long begin = System.currentTimeMillis();
//        for (int i = 0; i < times; i++) {
//            set.add(OrderSnGeneratorUtil.getOrderCode(222L));
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("花费时间：" + (end - begin) + "毫秒");
//        System.out.println("重复了：" + (times - set.size()) + "次");
    }
}

