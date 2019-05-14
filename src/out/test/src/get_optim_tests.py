#! /bin/python3

import os

def get_file(url):
    os.system("wget " + url);


if (__name__ == "__main__"):
    url_base = "http://120.77.243.120:8080/download/testcase_"
    valid = [i for i in range(283, 293)]
    unused = [288,289]
    used = [255, 256, 257, 245, 233, 234, 235, \
            298, 300, 303, 304, 309]
    valid = list(set(valid) - set(unused)) + used
    for i in valid:
        get_file(url_base + str(i) + ".txt")





