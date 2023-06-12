from itertools import cycle

dict_imgs = {
    "cr7": cycle(("cr7_1.png","cr7_2.png","cr7_3.png","cr7_4.png"))
}

print(next(dict_imgs["cr7"]))
