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
