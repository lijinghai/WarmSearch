package priv.ljh.utils.requestMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义统一的返回json的格式
 * @author lijinghai
 * @Date 2021-1-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse implements java.io.Serializable{
    private int code;
    private String message;
    private Object data;

}
