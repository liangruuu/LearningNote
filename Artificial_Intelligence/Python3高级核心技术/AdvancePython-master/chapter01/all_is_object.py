'''
Description: 
Author: liangruuu
Date: 2021-05-27 10:31:22
'''


def ask(name="default"):
    print(name)


class Person:
    def __init__(self):
        print("liangruuu")


def print_type(item):
    item()
    print(type(item))


def decorator_func():
    print("dec start")
    return ask

# # 将函数名赋值给了一个变量，直接对变量操作就是对函数操作
# my_func = ask
# my_func("liangruuu")

# # 类赋值同理
# my_class = Person
# my_class()

# obj_list = []
# obj_list.append(ask)
# # 对类进行实例化之后会返回一个类的对象
# # <__main__.Person object at 0x0000027CCB970080>
# obj_list.append(Person)
# for item in obj_list:
#     print(item())

# print_type(ask)


my_ask = decorator_func()
my_ask("tom")
