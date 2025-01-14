package work.icu007.day02.interface_case.user;

import work.icu007.day02.interface_case.domain.User;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/13/ 23:48
 * @Description
 */
// 接口 不写任何代码 只是制定规则
public interface IUserLogin {

    // 接口中通常只写抽象方法

    /**
     * 功能: 用户登录
     * @param user 用户对象
     * @return boolean 类型: true表示登录成功, false表示登录失败.
     */
    public boolean login(User user);
}
