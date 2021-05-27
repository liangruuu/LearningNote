from class_method import Date


class User:
    def __init__(self, birthday):
        # python是没有private关键词的，所以使用双下划线代表私有属性
        self.__birthday = birthday

    def get_age(self):
        # 返回年龄
        return 2018 - self.__birthday.year


if __name__ == "__main__":
    user = User(Date(1990, 2, 1))
    # # AttributeError: 'User' object has no attribute '__birthday'
    # print(user.__birthday)

    # _classname__attrname
    # 1990/2/1
    print(user._User__birthday)
    print(user.get_age())
