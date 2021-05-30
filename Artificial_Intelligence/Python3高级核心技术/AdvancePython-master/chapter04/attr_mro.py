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
