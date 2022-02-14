package priv.ljh.utils.MyJWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * 前台页面JWT
 * @author lijinghai
 * @Date 2021/3/14 19:20
 *
 */
public class PCJwtUtils {

    public static final String TOKEN_LOGIN_NAME = "loginName";
    public static final String TOKEN_LOGIN_ID = "userId";
    public static final String TOKEN_SUCCESS = "success:";
    public static final String TOKEN_FAIL = "fail:";

    private static final String SINGNATURE = "^lijinghailjh@163.com*101599";

    /**
     * 生成Token header.payload.signature
     */
    public static String getToken(Map<String,String> map){
//        HashMap<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        //默认7天过期
        instance.add(Calendar.DATE,7);

        //创建JWTBuilder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        //指定过期时间
        String token = builder.withExpiresAt(instance.getTime())
                //singnature
                .sign(Algorithm.HMAC256(SINGNATURE));


//        String token = JWT.create()
//                //Header
////                .withHeader(map)
//                //payload
//                .withClaim("userId", 12)
//                .withClaim("username", "ljh")
//                //指定令牌的过期时间
//                .withExpiresAt(instance.getTime())
//                //签名
//                .sign(Algorithm.HMAC256(SINGNATURE));

       return token;
    }

    /**
     * 验证Token 合法性
     * @return
     */
    public static DecodedJWT verify(String token){
        String result = TOKEN_SUCCESS;
        //创建验证对象
        return JWT.require(Algorithm.HMAC256(SINGNATURE)).build().verify(token);

    }

    /**
     * 取出Token中的信息
     */
    public static DecodedJWT getTokenInfo(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SINGNATURE)).build().verify(token);
        return verify;
    }


}
