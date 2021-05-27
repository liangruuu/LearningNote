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
