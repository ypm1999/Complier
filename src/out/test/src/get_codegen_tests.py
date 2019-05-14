#! /bin/python3

import os

def get_file(url):
    os.system("wget " + url);


if (__name__ == "__main__"):
    url_base = "http://120.77.243.120:8080/download/testcase_"
    valid = [i for i in range(2, 57)]
    unused = [5, 51]
    used = [228, 229, 230, 232, 237, 238, 239, \
            253, 319, 324, 325, 330, 332, 333, 335, 341]
    valid = list(set(valid) - set(unused)) + used
    for i in valid:
        get_file(url_base + str(i) + ".txt")





