import requests
import json

url = "https://api.github.com/repos/openshift/origin"
response = requests.get(url)
data = response.json()

with open('7r.json', 'w') as f:
    json.dump(data, f, indent=4)
