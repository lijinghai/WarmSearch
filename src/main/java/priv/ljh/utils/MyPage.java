package priv.ljh.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 自定义分页
 * @author lijinghai
 * @Date 2021-1-27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPage {
    private List items;
    private int total;
}
