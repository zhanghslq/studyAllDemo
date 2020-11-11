package com.zhs.demoannotation.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: zhs
 * @since: 2020/11/11 9:00
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpLog {

    OpType opType();
    /**
     * 业务对象名称，如订单、库存、价格
     *
     * @return
     */
    String opItem();

    /**
     * 业务对象编号表达式，描述了如何获取订单号的表达式
     *
     * @return
     */
    String opItemIdExpression();


}
