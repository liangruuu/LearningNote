# __getattr__, __getattribute__
# __getattr__ 就是在查找不到属性的时候调用
from datetime import date


class User:
    def __init__(self, info={}):
        self.info = info

    def __getattr__(self, item):
        print("查找不到属性的时候访问该函数")
        return self.info[item]

    # # 无条件进入该函数
    # def __getattribute__(self, item):
    #     return "bobby"


if __name__ == "__main__":
    user = User(info={"company_name": "imooc", "name": "bobby"})
    # # KeyError: 'test'
    # # 查找不到属性的时候访问该函数
    print(user.test)

    # imooc
    print(user.company_name)
