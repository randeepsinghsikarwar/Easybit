test = 'hello'

path = os.environ.get('PATH')

current_path = os.environ.get('PATH', '')

new_path = f"{current_path}{os.pathsep}{test}"

os.environ['PATH'] = new_path