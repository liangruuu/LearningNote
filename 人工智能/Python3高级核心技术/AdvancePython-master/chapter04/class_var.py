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
