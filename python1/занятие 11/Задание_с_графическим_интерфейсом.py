import tkinter as tk
from tkinter import messagebox
import requests
import json

def get_repo_info(repo_name):
    url = f"https://api.github.com/repos/{repo_name}"
    response = requests.get(url)
    data = response.json()

    result = {
        'company': data.get('company'),
        'created_at': data.get('created_at'),
        'email': data.get('email'),
        'id': data.get('id'),
        'name': data.get('name'),
        'url': data.get('url')
    }

    with open('7.json', 'w') as f:
        json.dump(result, f)

def on_button_click():
    repo_name = entry.get()
    get_repo_info(repo_name)
    messagebox.showinfo("Success", "Information saved to 7.json")

root = tk.Tk()
root.title("GitHub Repo Info")

label = tk.Label(root, text="Enter repository name:")
label.pack()

entry = tk.Entry(root)
entry.pack()

button = tk.Button(root, text="Get Info", command=on_button_click)
button.pack()

root.mainloop()
