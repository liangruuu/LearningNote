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
