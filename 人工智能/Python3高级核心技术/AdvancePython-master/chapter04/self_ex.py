# 自省是通过一定的机制查询到对象的内部结构
class Person:
    """
    人
    """
    name = "user"


class Student(Person):
    def __init__(self, scool_name):
        self.scool_name = scool_name


if __name__ == "__main__":
    user = Student("慕课网")

    # 通过__dict__查询属性
    # {'scool_name': '慕课网'}
    print(user.__dict__)
    user.__dict__["school_addr"] = "北京市"
    # 北京市
    print(user.school_addr)
    # {'__module__': '__main__', '__doc__': '\n    人\n    ',
    # 'name': 'user', '__dict__': <attribute '__dict__' of 'Person' objects>,
    # '__weakref__': <attribute '__weakref__' of 'Person' objects>}
    print(Person.__dict__)
    # user
    print(user.name)
    a = [1, 2]
    print(dir(a))
