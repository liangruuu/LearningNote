'''
Description: 
Author: liangruuu
Date: 2021-05-28 12:14:13
'''


class parent():

    def __init__(self):
        self.forward()

    def forward(self):
        raise NotImplementedError


class child(parent):

    def forward(self):
        print("this is the child")


a = child()
