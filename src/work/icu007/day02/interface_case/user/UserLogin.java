package work.icu007.day02.interface_case.user;

import work.icu007.day02.interface_case.domain.User;

/**
 * @Author Charlie_Liam
 * @Date: 2024/04/13/ 23:45
 * @Description
 */

// 必须按照接口中制定的规则来编写代码
public class UserLogin implements IUserLogin{
    @Override
    public boolean login(User user) {
        return false;
    }
}
