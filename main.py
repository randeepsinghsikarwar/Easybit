# windows

import subprocess

path = ["installer.bat"]
process = subprocess.run(path, capture_output=True) 
if process.returncode != 0:
    print("some error") 
else:
    print("working")

