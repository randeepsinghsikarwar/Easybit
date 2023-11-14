import subprocess as sp
import os

jdk_version = "jdk-21"
# version
main_drive = os.getenv('SystemDrive')
java_path = main_drive + "\\Program Files\\Java\\" + jdk_version + "\\bin"

java_home_path = main_drive + "\\Program Files\\Java\\" + jdk_version


d_j = "curl -o executables\javaIns.exe https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe"

if not os.path.exists('executables\javaIns.exe'):
    downloading = sp.run(d_j)

silent_install = sp.run(["testng\installer.bat"], capture_output=True)
if(silent_install == 0):
    print("installed successfilly")
# checking all the system variables.
    if 'JAVA_HOME' not in os.environ:
        os.environ['JAVA_HOME'] = java_home_path 

else:
    print("error")

