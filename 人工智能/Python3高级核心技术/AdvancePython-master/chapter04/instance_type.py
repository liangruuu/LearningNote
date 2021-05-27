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
