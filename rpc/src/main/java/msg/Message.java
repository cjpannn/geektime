package msg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenjiapan3
 * @date 2023/6/6
 */

/**
 * lombok.Data 是 Lombok 提供的一个注解，用于自动生成 Java 类的 getter、setter、equals、hashCode 和 toString 方法。
 * lombok.AllArgsConstructor 注解可以自动生成一个包含所有字段的构造函数，从而减少构造函数的参数数量和代码的冗长
 */

@Data
@AllArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = 325123123738581347L;

    private String msg;


}
