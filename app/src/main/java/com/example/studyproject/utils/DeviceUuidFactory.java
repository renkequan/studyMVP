package com.example.studyproject.utils;

import android.content.Context;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Ren on 2017\9\4 0004.
 *
 * @function UUID生成的原理，先获取设备的标识信息，
 * 如果能够获取到就使用该获取到的值，否则就生成一个随机数，然后通过缓存保存这个值。
 * 使用方法：private DeviceUuidFactory uuidFactory;
 * uuidFactory = new DeviceUuidFactory(this);
 * String uuid = String.valueOf(uuidFactory.getDeviceUuid());
 */

public class DeviceUuidFactory {
//    protected static final String PREFS_FILE = "device_id.xml";
//    protected static final String PREFS_DEVICE_ID = "device_id";
//    protected static UUID uuid;

//    public DeviceUuidFactory(Context context) {
//        if (uuid == null) {
//            synchronized (DeviceUuidFactory.class) {
//                if (uuid == null) {
//                    final SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE, 0);
//                    final String id = prefs.getString(PREFS_DEVICE_ID, null);
//                    if (id != null) {
//                        // Use the ids previously computed and stored in the
//                        // prefs file
//                        uuid = UUID.fromString(id);
//                    } else {
//                        final String androidId = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
//                        // Use the Android ID unless it's broken, in which case
//                        // fallback on deviceId,
//                        // unless it's not available, then fallback on a random
//                        // number which we store to a prefs file
//                        try {
//                            if (!"9774d56d682e549c".equals(androidId)) {
//                                uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8"));
//                            } else {
//                                final String deviceId = ((TelephonyManager)
//                                        context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
//                                uuid = deviceId != null ?
//                                        UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) :
//                                        UUID.randomUUID();
//                            }
//                        } catch (UnsupportedEncodingException e) {
//                            throw new RuntimeException(e);
//                        }
//                        // Write the value out to the prefs file
//                        prefs.edit().putString(PREFS_DEVICE_ID, uuid.toString()).apply();
//                    }
//                }
//            }
//        }
//    }

    public static String getDeviceId(Context context) {
//       return new DeviceUuidFactory(context).getDeviceUuid().toString();
        return getLocalMacAddressFromIp(context);
    }

//    //获取UUid
//    public UUID getDeviceUuid() {
//        return uuid;
//    }

//    public static String getIPAddress(Context context) {
//        NetworkInfo info = ((ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
//        if (info != null && info.isConnected()) {
//            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
//                try {
//                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
//                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
//                        NetworkInterface intf = en.nextElement();
//                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
//                            InetAddress inetAddress = enumIpAddr.nextElement();
//                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
//                                return inetAddress.getHostAddress();
//                            }
//                        }
//                    }
//                } catch (SocketException e) {
//                    e.printStackTrace();
//                }
//
//            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
//                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
//                return ipAddress;
//            }
//        } else {
//            //当前无网络连接,请在设置中打开网络
//        }
//        return null;
//    }
//
//    /**
//     * 将得到的int类型的IP转换为String类型
//     *
//     * @param ip
//     * @return
//     */
//    public static String intIP2StringIP(int ip) {
//        return (ip & 0xFF) + "." +
//                ((ip >> 8) & 0xFF) + "." +
//                ((ip >> 16) & 0xFF) + "." +
//                (ip >> 24 & 0xFF);
//    }

    /**
     * 根据IP地址获取MAC地址
     *
     * @return
     */
    private static String getLocalMacAddressFromIp(Context context) {
        String strMacAddr = null;
        try {
            //获得IpD地址
            InetAddress ip = getLocalInetAddress();
            byte[] b = NetworkInterface.getByInetAddress(ip).getHardwareAddress();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                if (i != 0) {
                    buffer.append(':');
                }
                String str = Integer.toHexString(b[i] & 0xFF);
                buffer.append(str.length() == 1 ? 0 + str : str);
            }
            strMacAddr = buffer.toString().toUpperCase();
        } catch (Exception e) {
        }
        return strMacAddr;
    }

    //获取移动设备本地IP
    private static InetAddress getLocalInetAddress() {
        InetAddress ip = null;
        try {
            //列举
            Enumeration<NetworkInterface> en_netInterface = NetworkInterface.getNetworkInterfaces();
            while (en_netInterface.hasMoreElements()) {//是否还有元素
                NetworkInterface ni = (NetworkInterface) en_netInterface.nextElement();//得到下一个元素
                Enumeration<InetAddress> en_ip = ni.getInetAddresses();//得到一个ip地址的列举
                while (en_ip.hasMoreElements()) {
                    ip = en_ip.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1)
                        break;
                    else
                        ip = null;
                }
                if (ip != null) {
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;
    }

}
