from PIL import ImageFont, ImageDraw, Image
# https://stackoverflow.com/questions/50854235/how-to-draw-chinese-text-on-the-image-using-cv2-puttextcorrectly-pythonopen
# size needs to be changed with printer specs
WIDTH = 300
HEIGHT = 200
FONT = 'simsun.ttc'
FONT_SIZE = 24
BACKGROUND_COLOUR = (0,0,0)
TEXT_LEFTPAD = 10
TEXT_GAP = 50
TEXT_COLOUR = (0,255,255)


def convert(content, extension='png'):
    # ideally content should be dictionary containing different parts of the final receipt
    content = '你好,世界!'
    content = {'header': 'Start', 'items': ['1 Beer', '2 Wine'], 'footer': 'End'}
    header = content['header']
    items = content['items']
    footer = content['footer']

    font = ImageFont.truetype(FONT,FONT_SIZE)
    size = (WIDTH, HEIGHT)
    im = Image.new("RGBA",size,BACKGROUND_COLOUR)

    draw = ImageDraw.Draw(im)

    # draw.text( (0,50), u'你好,世界!', font=font)
    # for each line, incrementally add text gap/update text position
    text_position = (TEXT_LEFTPAD, TEXT_GAP)
    draw.text(text_position, header, font=font, fill=TEXT_COLOUR)
    for item in items:
        draw.text(text_position, item, font=font, fill=TEXT_COLOUR)
        # update text_position

    draw.text(text_position, footer, font=font, fill=TEXT_COLOUR)

    im.save("test3."+extension)


if __name__ == '__main__':
    convert('png')