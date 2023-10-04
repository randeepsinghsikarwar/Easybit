import subprocess as sp
import os

down_java = "curl -o javaIns.exe https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe"

if not os.path.exists('javaIns.exe'):
    downloading = sp.run(down_java)



silent_install = sp.run("installer.bat", capture_output=True)