import requests

url = "https://raw.githubusercontent.com/ajaykushwaha/Intelligent-Basket/master/Raspberry%20pi/Transfer.txt"
r = requests.get(url)
print(r.text)