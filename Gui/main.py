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
    return (application_height/100)*Height;

def getwidth(Width):
    return (application_width/100)*Width;


# Size of the appliction in Width  X Height
root.geometry(str(application_width)+"x"+str(application_height))
# Setting the title of the application
root.title("Setup- Ezbit (User) version 1.20")
root.resizable(False,False)




welcome_text = tk.Label(root, text="Welcome to Ezybit",font=('Arial',20,"bold")).place(x=getwidth(5),y=getheight(5))


logo= Image.open('Gui/Images/Logo.png')
logo_tk = ImageTk.PhotoImage(logo)
label = tk.Label(root,text='logo',image=logo_tk).place(x=getwidth(5),y=getheight(35))

para_Heading =tk.Label(root, text="Download Ezybit",font=('Arial',18)).place(x=getwidth(60),y=getheight(25))
para1_text =tk.Label(root, text="Free and built in open source. Integrated debugging and extension",font=('Arial',12)).place(x=getwidth(45),y=getheight(35))
para1_text =tk.Label(root, text="Ezybit is an intuitive software that automates the installation of",font=('Arial',12)).place(x=getwidth(50),y=getheight(40))

root.mainloop()



