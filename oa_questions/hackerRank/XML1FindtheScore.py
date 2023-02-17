#XML1FindtheScore
import sys
import xml.etree.ElementTree as etree

def get_attr_number(node):
    # Recussive if no child return count
    if len(node) == 0:
        return len(node.attrib)
    # If got child return attribute count plus call for each child
    else:
        return len(node.attrib) + sum([get_attr_number(child) for child in node])


def get_attr_number(node):
    score = 0
    score += len(node.attrib)
    for child in node:
        score += get_attr_number(child)
    return score

if __name__ == '__main__':