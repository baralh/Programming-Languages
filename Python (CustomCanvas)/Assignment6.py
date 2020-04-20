#heman Baral
#Programming Assignment 6
#The goal of this program is to take a collection of rectangles and display them on a canvas using Tk GUI



#importing Tk interface
from Tkinter import *


#A class CustomCanvas
#CustomCanvas will have a constructor which takes two explicit arguments, height and width

class CustomCanvas:

	#Creating a screen
	root = Tk()


	#Rename the title of the window
	root.title("Assignment 6")


	def __init__(self, height, width):

		self.height = height

		self.width = width


	#changing the size and the background screen of window
		self.screen = Canvas(self.root, 
			height=self.height, width=self.width, bg="#0d67e3")

	

	#Pack is used to show the object int the window
	def createCanvas(self):

		self.screen.pack()




	#Creating rectangle on the screen
	def create_rect(self, rectangle):



		self.screen.create_rectangle(rectangle.x, rectangle.y, rectangle.x + 
			rectangle.width, rectangle.y + rectangle.height, fill='yellow')	

	def draw_canvas(self):
		self.screen.mainloop()
	




#A class Rectangle

class Rectangle:


	#initialize the attributes of a class
	def __init__(self, height, width, x, y):

		self.height = height

		self.width = width

		self.x = x

		self.y = y

		#default value of x and y are 0

		x = 0

		y = 0



	def printObj(self, num):
		num.create_rect(self)


#A function pack
#pack function has two parameters, allRect and canvasSize

def pack(allRect, canvasSize):


	#Return the height of the window

	def getHeight(rectangle):

		return rectangle.height

	allRect.sort(key=getHeight, reverse=True)
	
	#setting flag to false
	flag = False

	y1 = 0

	#assign y value
	y2 = allRect[0].height
	
	#looping thru rectangle
	for rectangle in allRect:

		if(allRect.index(rectangle) > 0):

			rectangle.x = (allRect[allRect.index(rectangle) - 1].x 
				+ allRect[allRect.index(rectangle) - 1].width)

			rectangle.y = y1
			
			#checking if size exceeds canvasSize 
			if((rectangle.x + rectangle.width) > canvasSize[1]):

				#setting x to 0 so eveything stay in the window
				rectangle.x = 0

				#setting y1 to y2 so it doesn't go over the border
				y1 = y2

				rectangle.y = y1

				flag = True

			#when true then get new y2 value
			if(flag == True):

				#set y2 value to y plus height
				y2 = rectangle.y + rectangle.height

				flag = False

	return allRect




#Text file import

import fileinput

#A function main

def main():


	#i = 0
	#for j in range(len(arr)):
		#if (arr[j] != 0):
  	  		#arr[i] = arr[j]
   			#i +=1
			#filename = arr[:i]

	filename = sys.argv[1]


	inputValues = []

	objSize = []

	#reading input
	for line in fileinput.input(filename):
		
		inputValues.append(line)

	#getting CanvasSize from the input

	canvasSize = inputValues.pop(0).split(',', 2)

	canvasSize[0] = int(canvasSize[0])

	#removing characters from the right based on the argument
	canvasSize[1] = int(canvasSize[1].rstrip())

	#looping to get all the value from the text file
	for item in inputValues:

		objSize.append(item.split(',', 2))


	allRect = []

	#rectangle object

	for item in objSize:

		allRect.append(Rectangle(int(item[0]), int(item[1].rstrip()), 0, 0))

	#packing all arguments in a tuple
	allRect = pack(allRect, canvasSize)

	#CustomCanvas instance
	num = CustomCanvas(canvasSize[0], canvasSize[1])

	num.createCanvas()

	for rectangle in allRect:

		rectangle.printObj(num)

	num.draw_canvas()
		


if __name__ == "__main__":
	
    main()
		
