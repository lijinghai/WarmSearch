package priv.ljh.utils.requestMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * token类
 * @author lijinghai
 * @Date 2021-1-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyToken implements java.io.Serializable{
    private String token;
}
