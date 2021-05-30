from datetime import date, datetime


class User:
    def __init__(self, name, birthday):
        self.name = name
        self.birthday = birthday
        self._age = 0

    # def get_age(self):
    #     return datetime.now().year - self.birthday.year

    # 理解成get方法
    @property
    def age(self):
        return datetime.now().year - self.birthday.year

    # 对age这个字段进行设置
    @age.setter
    def age(self, value):
        self._age = value


if __name__ == "__main__":
    user = User("bobby", date(year=1987, month=1, day=1))
    user.age = 30
    # 30
    print(user._age)
    # 34
    print(user.age)
