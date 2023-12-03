import subprocess as sp
import os

jdk_version = "jdk-21"
# version
main_drive = os.getenv('SystemDrive')
java_home_path = rf"{main_drive}\Program Files\Java\{jdk_version}"
java_path = rf"{java_home_path}\bin"



d_j = "curl -o executables\javaIns.exe https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe"

if not os.path.exists('executables\javaIns.exe'):
    downloading = sp.run(d_j)

silent_install = sp.run(["testng\installer.bat"], capture_output=True)

print(silent_install)
if(silent_install.returncode == 0):
    print("installed successfilly")
# checking all the system variables.

    # setting JAVA_HOME
    # java_home_exist = os.environ.get('JAVA_HOME')
    if not os.environ.get('JAVA_HOME'):
        sp.run(['setx', 'JAVA_HOME', java_home_path, '-m'], shell=True )
        
        print("java home set")
    else:
        print("java home already exist")

# https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/setx
    # setting bin path

    path_var = os.environ.get('PATH')
    path_dir = path_var.split(os.pathsep)

    if any(java_path.lower() == dir.lower for dir in path_dir):
        print('java path already exist')
    else:
        command = ['powershell.exe', '-ExecutionPolicy', 'Unrestricted', r'C:\Easybit\update_path.ps1', '-newPath', f'"{java_path}"']
        process = sp.Popen(command, stdout = sp.PIPE, stderr=sp.PIPE, text=True)
        output, error = process.communicate()

        if process.returncode == 0:
            print(f"Script executed successfully. Output:\n{output}")
        else:
            print(f"Error executing script. Error:\n{error}")
    
    # all_paths = os.environ.get('PATH')
    # path_variables = all_paths.split(os.pathsep)
    
    # if java_path not in path_variables:
    #     updated_path = f'"{all_paths};{java_path}"'
    #     sp.run(['setx', 'PATH', updated_path, '-m'], shell=True)
    #     print("path added successfully")
    # else:
    #     print("path already exist")

else:
    print("error")

