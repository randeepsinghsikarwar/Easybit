# # # windows

import subprocess as sp
import os
# import sys

# # path = ["installer.bat"]
# # process = subprocess.run(path, capture_output=True) 
# # if process.returncode != 0:
# #     print("some error") 
# # else:
# #     print("working")


# # import os
# # path = os.environ.get('PATH')
# # pd = path.split(os.pathsep)
# # print(pd)

# # drive = os.getenv('SystemDrive')
# # print(type(drive))


# # print(os.environ)''
# # jp = 'asdjnadn'

# # sp.run(['setx', 'JAVA_HOME', jp, '-m'], shell=True)
jdk_version = "jdk-21"
# # version
main_drive = os.getenv('SystemDrive')
# java_home_path = main_drive + "\\Program Files\\Java\\" + jdk_version

# if not os.environ.get('JAVA_HOME'):
#     sp.run(['setx', 'JAVA_HOME', java_home_path, '-m'], shell=True )
# else:
#     print('already')

# # sp.run(['dir'], shell=True)

java_path = "{}\Program Files\Java\{}\\bin".format(main_drive, jdk_version)

test = "C:\Program Files\Common Files\Oracle\Java\javapath"

pv = os.environ.get('PATH')
pd = pv.split(os.pathsep)

if any(test.lower() == dir.lower() for dir in pd):
    print("present")
else:
    print("not")

# else:

#     command = ['powershell.exe', '-ExecutionPolicy', 'Unrestricted', r'C:\Easybit\testng\update_path.ps1', '-newPath', f'"{new_path}"']

#     process = sp.Popen(command, stdout = sp.PIPE, stderr=sp.PIPE, text=True)
#     output, error = process.communicate()

#     if process.returncode == 0:
#         print(f"Script executed successfully. Output:\n{output}")
#     else:
#         print(f"Error executing script. Error:\n{error}")
# # print(os.environ.get('PATH'))
# new_path = main_drive + "\\Program Files\\Java\\" + jdk_version + "\\bin"


