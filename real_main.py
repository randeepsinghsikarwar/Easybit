import subprocess as sp
import os

d_j = "curl -o executables\javaIns.exe https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe"

if not os.path.exists('executables\javaIns.exe'):
    downloading = sp.run(d_j)

silent_install = sp.run(["testng\installer.bat"], capture_output=True)

