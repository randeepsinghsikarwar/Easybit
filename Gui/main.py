import  tkinter as tk;
from PIL import Image,ImageTk




# Tkinter constructor
root=tk.Tk()

# Getting display width and height
screen_width = root.winfo_screenwidth()
screen_height = root.winfo_screenheight()
# Setting application width and height
application_height = int(screen_height/2);
application_width = int(screen_width/2);

def getheight(Height):
    return int(application_height/100)*Height;

def getwidth(Width):
    return int(application_width/100)*Width;


# Size of the appliction in Width  X Height
root.geometry(str(application_width)+"x"+str(application_height))
# Setting the title of the application
root.title("Setup- Ezbit (User) version 1.20")
root.resizable(False,False)
flotter= Image.open('Gui/Images/isspyaarkokyanaamdu.png').resize((getwidth(120),getheight(50)))
flotter_tk = ImageTk.PhotoImage(flotter)
label = tk.Label(root,text='flotter',image=flotter_tk).place(x=getwidth(0),y=getheight(0))


welcome_text = tk.Label(root, text="Welcome to Ezybit",font=('Arial',20,"bold")).place(x=getwidth(5),y=getheight(5))


logo= Image.open('Gui/Images/Logo.png')
logo_tk = ImageTk.PhotoImage(logo)
label = tk.Label(root,text='logo',image=logo_tk).place(x=getwidth(10),y=getheight(45))


para_Heading =tk.Label(root, text="Download Ezybit",font=('Arial',18)).place(x=getwidth(60),y=getheight(30))

para1_text =tk.Label(root, text="Free and built in open source. Integrated debugging and extension",font=('Arial',12)).place(x=getwidth(45),y=getheight(40))

para2_text =tk.Label(root, text="Ezybit is an intuitive software that automates the installation of",font=('Arial',12)).place(x=getwidth(45),y=getheight(50))
para2_text =tk.Label(root, text="programming languages. With a user-friendly interface, it detects",font=('Arial',12)).place(x=getwidth(45),y=getheight(55))
para2_text =tk.Label(root, text="system requirements and swiftly sets up languages like Python, Java, ",font=('Arial',12)).place(x=getwidth(45),y=getheight(60))
para2_text =tk.Label(root, text="C++, and more, streamlining the development process effortlessly.",font=('Arial',12)).place(x=getwidth(45),y=getheight(65))

para3_text =tk.Label(root, text="With a single click, users can initiate the installation process for their",font=('Arial',12)).place(x=getwidth(45),y=getheight(75))
para3_text =tk.Label(root, text="preferred programming language, saving valuable time and effort ",font=('Arial',12)).place(x=getwidth(45),y=getheight(75))
para3_text =tk.Label(root, text="compared to traditional manual installations.",font=('Arial',12)).place(x=getwidth(45),y=getheight(80))

tk.Label(root,bg="#dadada", width=getwidth(100), height=getheight(10)).place(x=getwidth(0),y=getheight(95))

nextbtn = tk.Button(root, text ="Next" ,bg="#dadada",bd="1",highlightcolor="#dadada",padx="10")
nextbtn.place(x=getwidth(80),y=getheight(99))

Cancelbtn = tk.Button(root, text ="Cancel" ,bg="#dadada",bd="1",highlightcolor="#dadada",padx="10")
Cancelbtn.place(x=getwidth(90),y=getheight(99))
root.mainloop()



