package org.library.service;

import org.library.dao.OperatorDao;
import org.library.entity.Operator;

/**
 * Created by admin on 2016/12/27.
 */
public class OperatorService {
    //更新数据
    public String updateOperator(Operator operator){
        OperatorDao dao = new OperatorDao();
        //1、判断该用户信息中途是否被修改
        //如果没有被修改，则调用修改I数据的方法
        //否则返回“用户信息已被修改，刷新页面重新操作！”
        if(dao.findOperatorByIdAndVer(operator) != null){
            dao.update(operator);
            return "修改成功！";
        }
        return "用户信息已被修改，刷新页面重新操作！";
    }
}
