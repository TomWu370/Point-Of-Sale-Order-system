# https://pypi.org/project/python-escpos/
from escpos.printer import Usb
# use lsusb on linux system to find information about usb ports
# https://python-escpos.readthedocs.io/en/v2.1.0/user/usage.html
INTERFACE_NO = 0x04b8
END_ADDRESS = 0x0202
""" Receipt Printer (GP-U80300) """
# Usb(Interface no., Endpoint address)
def print(imagePath):
    printer = Usb(INTERFACE_NO, END_ADDRESS, profile="GP-U80300")
    printer.text("Hello World\n")
    # check if printer can print non english character directly
    # if not convert text to image using text2Image.py
    printer.image(imagePath)
    printer.cut()
