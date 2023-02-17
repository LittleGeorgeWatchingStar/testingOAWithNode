#XML2FindtheMaximumDepth
import xml.etree.ElementTree as etree

maxdepth = 0
def depth(elem, level):
    global maxdepth

    level += 1
    if level > maxdepth:
        maxdepth = level
    for e in elem:
        depth(e, level)

if __name__ == '__main__':