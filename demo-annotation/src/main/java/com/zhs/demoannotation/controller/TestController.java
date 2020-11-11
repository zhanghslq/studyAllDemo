package com.zhs.demoannotation.controller;

import com.zhs.demoannotation.anno.Facade;
import com.zhs.demoannotation.anno.OpLog;
import com.zhs.demoannotation.anno.OpType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author: zhs
 * @since: 2020/11/11 9:19
 */
public class TestController {
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @OpLog(opType = OpType.QUERY, opItem = "order", opItemIdExpression = "#id")
    public @ResponseBody
    HashMap view(@RequestParam(name = "id") String id)
            throws Exception {
        return new HashMap();
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @OpLog(opType = OpType.QUERY, opItem = "order", opItemIdExpression = "#orderVo.id")
    public @ResponseBody
    HashMap update(OrderVO orderVo)
            throws Exception {

        return null;
    }
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @OpLog(opType = OpType.QUERY, opItem = "order", opItemIdExpression = "#insertResult.id")
    public @ResponseBody
    InsertResult insert(OrderVO orderVo)
            throws Exception {

        return null;
    }
    @Facade
    public TestResponse query(User user) {

        return null;
    }


}
