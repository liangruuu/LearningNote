# 把抽象基类理解为java中的implement接口即可，在java中是无法实现多继承的，但是能实现多接口
# 同样在python中同理，同时接口是不能用来实例化的，所以说抽象基类是不能实例化的
# python是动态语言，是没有变量的类型的，在python中变量只是一个符号而已，它是可以指向任何类型的对象的
# 所以在python中不存在多态这个概念，鸭子类型贯穿python面向对象编程，它和java最大的不同在于在python中去创建一个class时
# 是不需要继承指定类的，比如Man类去继承People类；一个类到底有什么特性，或者说是属于什么类型的是看它里边到底实现了什么魔法函数的，不同的魔法函数赋予了类不同的特性
# 只要去实现某个魔法函数，这个类就是某个类型的对象


# 我们去检查某个类是否有某种方法
from collections.abc import Sized
import abc


class Company(object):
    def __init__(self, employee_list):
        self.employee = employee_list

    def __len__(self):
        return len(self.employee)


com = Company(["bobby1", "bobby2"])
# 检查Company是否是一个有长度的类型
print(hasattr(com, "__len__"))


class A:
    pass


class B:
    pass


# 我们在某些情况之下希望判定某个对象的类型
isinstance(com, Sized)

b = B()
# False
print(isinstance(b, A))
# print(len(com))

# 我们需要强制某个子类必须实现某些方法
# 实现了一个web框架，集成cache(redis, cache, memorychache)
# 需要设计一个抽象基类， 指定子类必须实现某些方法

# 如何去模拟一个抽象基类


class CacheBase(metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def get(self, key):
        pass

    @abc.abstractmethod
    def set(self, key, value):
        pass
# class CacheBase():
#     def get(self, key):
#         raise NotImplementedError
#     def set(self, key, value):
#         raise NotImplementedError
#


class RedisCache(CacheBase):
    def set(self, key, value):
        pass


# TypeError: Can't instantiate abstract class RedisCache with abstract methods get
# 必须重载get方法
redis_cache = RedisCache()
redis_cache.set("key", "value")
