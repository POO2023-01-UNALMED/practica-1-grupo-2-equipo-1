from tkinter import *
from itertools import cycle

root_img = "base/"

dict_imgs = {
    "img1": cycle((PhotoImage(file=root_img + "cr7_1.png"),
                   PhotoImage(file=root_img + "cr7_2.png"),
                   PhotoImage(file=root_img + "cr7_3.png"),
                   PhotoImage(file=root_img + "cr7_4.png"))),
    "img2": cycle(("messi_1.png", "messi_2.png", "messi_3.png", "messi_4.png"))
}

print(dict_imgs["img1"])
