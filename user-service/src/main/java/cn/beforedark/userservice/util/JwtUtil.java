package cn.beforedark.userservice.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

/**
 * @Description: jwt工具类
 * @Author: yjy
 * @Date: 2025/6/17 15:11
 */
public class JwtUtil {
    private static final String KEY = "s5ffd8ff2hh2wa482ddd55a4z8wd111dd2a22aw55d5da";

    //接收业务数据,生成token并返回
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(KEY));
    }

    //接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) throws Exception {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
