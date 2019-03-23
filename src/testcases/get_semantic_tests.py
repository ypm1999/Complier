#! /bin/python3

import os

def get_file(url):
    os.system("wget " + url);


if (__name__ == "__main__"):
    url_base = "http://120.77.243.120:8080/download/testcase_"
    valid = [i for i in range(72, 200)]
    unused = [94, 100, 102, 163, 164, 166, 169, 172, 178, 181, 182, 193, 195, 200, 201, 202, 203, ]
    used = [204, 205, 208, 214, 216, 218, 219, 220, 225, 226]
    valid = list(set(valid) - set(unused)) + used
    for i in valid:
        get_file(url_base + str(i) + ".txt")





