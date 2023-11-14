# # windows

import subprocess as sp
import os

# path = ["installer.bat"]
# process = subprocess.run(path, capture_output=True) 
# if process.returncode != 0:
#     print("some error") 
# else:
#     print("working")


# import os
# path = os.environ.get('PATH')
# pd = path.split(os.pathsep)
# print(pd)

drive = os.getenv('SystemDrive')
print(type(drive))