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
