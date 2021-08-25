import argparse

def main():
    ang = 0;
    atAttention = True;
    newWord = True;

    # Sexy argument parsing
    parser = argparse.ArgumentParser()
    parser.add_argument("-c", "--command", help="The command given")
    args = parser.parse_args()
    print(args.command)

    wordTest = ''
    if not args.command:
        print('Command not provided.')
        wordTest = input('Enter Command > ').split()
    else:
        wordTest = args.command.split(' ')

    out = 'Output: ';
    for i in range(len(wordTest)):
        w = wordTest[i]
        if w == 'Attention' or w == 'ATTENTION':
            atAttention = True
        if w == 'At' and wordTest[i+1] == 'Ease' or w == 'AT' and wordTest[i+1] == 'EASE':
            atAttention = False
        if atAttention:
            if w == 'F' or w == 'Front' and wordTest[i+1] == 'Face' or w == 'FRONT' and wordTest[i+1] == 'FACE':
                out = out + 'F '
                ang = 0
            if w == 'A' or w == 'About' and wordTest[i+1] == 'Face' or w == 'ABOUT' and wordTest[i+1] == 'FACE':
                out = out + 'A ';
                ang += 180;
            if w == 'R' or w == 'Right' and wordTest[i+1] == 'Face' or w == 'RIGHT' and wordTest[i+1] == 'FACE':
                out = out + 'R '
                ang -= 90
            if w == 'L' or w == 'Left' and wordTest[i+1] == 'Face' or w == 'LEFT' and wordTest[i+1] == 'FACE':
                out = out + 'L ';
                ang += 90;
    print(out)
    ang = ang % 360
    print(ang)
    if ang == 0:
        print('You will be facing FORWARDS')
    if ang == 180:
        print('You will be facing BACKWARDS')
    if ang == 90:
        print('You will be facing LEFT')
    if ang == -90:
        print('You will be facing RIGHT')
    print('Done')
if __name__ == '__main__':
    main()
