## 第2章 python中一切皆对象

### 2.1 python中一切皆对象

![image-20210527102204783](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527102204783-1622082125267.png)

**1. 赋值给一个变量**

```python
def ask(name):
    print(name)

# 将函数名赋值给了一个变量，直接对变量操作就是对函数操作
my_func = ask
my_func("liangruuu")
```

![image-20210527104054826](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527104054826.png)

```python
class Person:
    def __init__(self):
        print("liangruuu")

# 类赋值同理
my_class = Person
my_class()
```

![image-20210527104228346](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527104228346.png)

**2. 可以添加到集合对象中**

```python
obj_list = []
obj_list.append(ask)
# 对类进行实例化之后会返回一个类的对象
obj_list.append(Person)
for item in obj_list:
    print(item())
```

![image-20210527104622789](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527104622789.png)

**3. 可以作为参数传递给函数**

```python
def print_type(item):
    item()
    print(type(item))
    
print_type(ask)
```

![image-20210527105157561](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527105157561.png)

**4. 可以当做函数的返回值**

```python
def decorator_func():
    print("dec start")
    return ask

my_ask = decorator_func()
my_ask("tom")
```

![image-20210527105321067](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527105321067.png)

### 2.2 type、object和class之间的关系

![image-20210527110421758](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527110421758.png)

```python
# -*- coding: utf-8 -*-
__author__ = 'bobby'
a = 1
b = "abc"
print(type(1))
print(type(int))
print(type(b))
print(type(str))
# type->int->1
# type->class->obj

# object是顶层基类
class Student:
    pass


class MyStudent(Student):
    pass


stu = Student()
# <class '__main__.Student'>
print(type(stu))
# <class 'type'>
print(type(Student))
print(int.__bases__)
print(str.__bases__)
# (<class 'object'>,)
print(Student.__bases__)
# (<class '__main__.Student'>,)
print(MyStudent.__bases__)
# (<class 'object'>,)
print(type.__bases__)
# object的基类为null
print(object.__bases__)
print(type(object))
```

![image-20210527110444100](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527110444100.png)

### 2.3 python中的内置类型

![image-20210527111835660](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527111835660.png)

## 第3章 魔法函数

### 3.1 什么是魔法函数

```python
class Company(object):
    def __init__(self, employee_list):
        self.employee = employee_list

    # 魔法函数就是python中定义的以双下划线开头，双下划线结尾的函数
    # 这些函数可以使我们可以去随意定制类的属性，魔法函数并不和特定类挂钩，而是只要是类就有这些函数
    # 比如如果定义了__getitem__函数，则遍历employee就不需要先去获得employee_list，因为该类已经被设置为了可迭代的对象
    def __getitem__(self, item):
        return self.employee[item]

    def __len__(self):
        return len(self.employee)


company = Company(["tom", "bob", "jane"])


# # case1: 没有定义__getitem__函数
# emploee = company.employee
# for em in emploee:
#     print(em)


# case2: 定义了__getitem__函数
# 用循环语句取遍历对象的时候就会调用类里面的__getitem__函数直到抛出异常
# 如果没有设置__getitem__函数函数，则会抛出异常TypeError: 'Company' object is not iterable
for em in company:
    print(em)
```

### 3.2 python数据模型对python的影响

```python
class Company(object):
    def __init__(self, employee_list):
        self.employee = employee_list

    # 魔法函数就是python中定义的以双下划线开头，双下划线结尾的函数
    # 这些函数可以使我们可以去随意定制类的属性，魔法函数并不和特定类挂钩，而是只要是类就有这些函数
    # 比如如果定义了__getitem__函数，则遍历employee就不需要先去获得employee_list，因为该类已经被设置为了可迭代的对象
    def __getitem__(self, item):
        return self.employee[item]

    def __len__(self):
        return len(self.employee)


company = Company(["tom", "bob", "jane"])


# # case1: 没有定义__getitem__函数
# emploee = company.employee
# for em in emploee:
#     print(em)


# # case2: 定义了__getitem__函数
# # 用循环语句取遍历对象的时候就会调用类里面的__getitem__函数直到抛出异常
# # 如果没有设置__getitem__函数函数，则会抛出异常TypeError: 'Company' object is not iterable
# for em in company:
#     print(em)

# # case3:
# # 在python本身的叫法中魔法函数用的比较少，只是网上习惯把双下划线开头的函数叫做魔法函数
# # 魔法函数只不过是python数据模型的一个概念而已，当我们去实现_getitem_函数之后就可以直接使用for语句去遍历这个对象
# # 魔法函数实际上是会影响python语法的，魔法函数的调用其实是隐式的。
# # 我们把魔法函数加入到这些类里的时候，它会增强这些类的类型，比如说序列类型，迭代类型...
# # 如果不实现__getitem__函数，则会抛出异常TypeError: 'Company' object is not subscriptable
# # 至于说为什么称之为魔法函数，是因为表示"很神奇"的意思，因为添加了魔法函数之后语法调用会很简单
# # python通过内置的魔法函数去定义对象或者类的时候，行为会很神奇，就像类中定义了__getitem__之后
# # 该类就可以使用for语句来遍历，二是可以对其进行列表操作
# company1 = company[:2]
# for em in company1:
#     print(em)

# case4:
# 使用了魔法函数之后会影响python内置函数的调用
# 如果不实现__getitem__函数，则会抛出异常TypeError: object of type 'Company' has no len()
# 此时可以在__len__魔法函数中定义逻辑，因为len()首先会去调用__len__函数
print(len(company))
```

### 3.3 python魔法函数一览

![image-20210527133442530](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527133442530.png)

![image-20210527133454492](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527133454492.png)

**\__str\__**

在调用print函数的时候会自动调用str()方法，当类里存在\__str\__魔法函数的时候会获取\__str\__函数返回的字符串

![image-20210527134149162](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527134149162.png)

**\__repr\__**

![image-20210527134416626](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527134416626.png)

## 第4章 深入类和对象

### 4.1 鸭子类型和多态

```python
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
```

### 4.2  抽象基类(abc模块)

```python
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
```

### 4.4 isinstance和type的区别

```python
class A:
    pass


class B(A):
    pass


b = B()

# True
print(isinstance(b, B))
# True
print(isinstance(b, A))
# True
print(type(b) is B)
```

### 4.5 类变量和实例变量

```python
class A:
    aa = 1

    def __init__(self, x, y):
        self.x = x
        self.y = y


a = A(2, 3)

A.aa = 11
a.aa = 100
# 2 3 100
print(a.x, a.y, a.aa)
# 11
print(A.aa)
# # AttributeError: type object 'A' has no attribute 'x'
# print(A.x)

b = A(3, 5)
# 11
print(b.aa)
```

### 4.6 类和实例属性的查找顺序—mro查找

```python
# 新式类
class D:
    pass


class E:
    pass


class C(E):
    pass


class B(D):
    pass


class A(B, C):
    pass


# 深度遍历
# (<class '__main__.A'>, <class '__main__.B'>, <class '__main__.D'>,
# <class '__main__.C'>, <class '__main__.E'>, <class 'object'>)
print(A.__mro__)
```

![image-20210527151006120](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527151006120.png)

### 4.7  类方法、静态方法和实例方法

```python
class Date:
    # 构造函数
    def __init__(self, year, month, day):
        self.year = year
        self.month = month
        self.day = day

    def tomorrow(self):
        self.day += 1

    @staticmethod
    def parse_from_string(date_str):
        year, month, day = tuple(date_str.split("-"))
        return Date(int(year), int(month), int(day))

    @staticmethod
    def valid_str(date_str):
        year, month, day = tuple(date_str.split("-"))
        if int(year) > 0 and (int(month) > 0 and int(month) <= 12) and (int(day) > 0 and int(day) <= 31):
            return True
        else:
            return False

    @classmethod
    def from_string(cls, date_str):
        year, month, day = tuple(date_str.split("-"))
        return cls(int(year), int(month), int(day))

    def __str__(self):
        return "{year}/{month}/{day}".format(year=self.year, month=self.month, day=self.day)


if __name__ == "__main__":
    new_day = Date(2018, 12, 31)
    new_day.tomorrow()
    # 2018/12/32
    print(new_day)

    # 2018-12-31
    date_str = "2018-12-31"
    year, month, day = tuple(date_str.split("-"))
    new_day = Date(int(year), int(month), int(day))
    # 2018/12/31
    print(new_day)

    # 用staticmethod完成初始化
    new_day = Date.parse_from_string(date_str)
    # 2018/12/31
    print(new_day)

    # 用classmethod完成初始化
    new_day = Date.from_string(date_str)
    # 2018/12/31
    print(new_day)

    # False
    print(Date.valid_str("2018-12-32"))
```

### 4.8 数据封装和私有属性

```python
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
```

### 4.9 python对象的自省机制

```python
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
```

### 4.10 super真的是调用父类吗？

```python
from threading import Thread


# 既然我们重写B的构造函数， 为什么还要去调用super？
# 重用父类代码
class MyThread(Thread):
    def __init__(self, name, user):
        self.user = user
        super().__init__(name=name)


# super到底执行顺序是什么样的？
class A:
    def __init__(self):
        print("A")


class B(A):
    def __init__(self):
        print("B")
        super().__init__()


class C(A):
    def __init__(self):
        print("C")
        super().__init__()


class D(B, C):
    def __init__(self):
        print("D")
        super(D, self).__init__()


if __name__ == "__main__":
    # (<class '__main__.D'>, <class '__main__.B'>, <class '__main__.C'>, <class '__main__.A'>, <class 'object'>)
    print(D.__mro__)
    # D->B->C->A
    d = D()
```

### 4.12 python中的with语句

![image-20210527161916951](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527161916951.png)

```python
# try except finally
def exe_try():
    try:
        print("code started")
        raise KeyError
        return 1
    except KeyError as e:
        print("key error")
        return 2
    else:
        print("other error")
        return 3
    finally:
        print("finally")
        # return 4


# 上下文管理器协议
class Sample:
    def __enter__(self):
        print("enter")
        # 获取资源fopen
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        # 释放资源fclose
        print("exit")

    def do_something(self):
        print("doing something")


# 简化try-finally
# enter->doing something->exit
with Sample() as sample:
    sample.do_something()

if __name__ == "__main__":
    result = exe_try()
    print(result)
```

### 4.13 contextlib简化上下文管理器

```python
import contextlib


# @contextlib.contextmanager：将函数变为一个上下文管理器
@contextlib.contextmanager
def file_open(file_name):
    print("file open")
    yield {}
    print("file end")


# file open->file processing->file end
with file_open("bobby.txt") as f_opened:
    print("file processing")
```

## 第5章 自定义序列类

### 5.1 python中的序列分类

![image-20210527162813696](Python3%E9%AB%98%E7%BA%A7%E6%A0%B8%E5%BF%83%E6%8A%80%E6%9C%AF.assets/image-20210527162813696.png)

```python
from collections import abc
my_list = []
my_list.append(1)
my_list.append("a")


a = [1, 2]
c = a + [3, 4]

# 就地加
a += (3, 4)
a.extend(range(3))

a.append((1, 2))
# [1, 2, 3, 4, 0, 1, 2, (1, 2)]
print(a)
```

## 第8章 元类编程

### 8.1 property动态属性

```python
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
```

### 8.2 __getattr__、__getattribute__魔法函数

```python
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
```

### 8.3 属性描述符和属性查找过程

