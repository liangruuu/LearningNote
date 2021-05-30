class Cat(object):
    def say(self):
        print("i am a cat")


class Dog(object):
    def say(self):
        print("i am a fish")


class Duck(object):
    def say(self):
        print("i am a duck")


class Company(object):
    def __init__(self, employee_list):
        self.employee = employee_list

    def __getitem__(self, item):
        return self.employee[item]

    def __len__(self):
        return len(self.employee)


company = Company(["tom", "bob", "jane"])


animal_list = [Cat, Dog, Duck]
# 在python中实现多态需要在类中定义同一种方法
for animal in animal_list:
    animal().say()


dog = Dog()
a = ["bobby1", "bobby2"]

b = ["bobby2", "bobby"]
name_tuple = ["bobby3", "bobby4"]
name_set = set()
name_set.add("bobby5")
name_set.add("bobby6")
# 只要是迭代对象都可以作为参数传入extend()函数当中，比如只需要在一个类当中添加__getitem__,
# __iter__函数就可以当做迭代类型对象使用，魔法函数将类分成常见内置类型
# 而在比如像是java等语言当中，必须要先继承自某个父类，才能作为父类对象传入到函数中
# 实际上在python中，魔法函数正是充分利用python的鸭子类型，所以说会在很多类中写入魔法函数，这些魔法函数会被python解释器识别
a.extend(b)
print(a)
a.extend(name_set)
print(a)
a.extend(company)
print(a)
