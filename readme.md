# get-value-from-json

## Description
A Java program that accepts a nested JSON file and a key and the program fetch the value of the key from the file 

## Pre-requisites
- This is a Java Maven project. Make sure you have Maven and Java installed.

## Sample Runs

```
object:{"x":{"y":{"z":"a"}}}
key   :x/y/z
DEBUG: x-->{"y":{"z":"a"}}
DEBUG: y-->{"z":"a"}
DEBUG: z-->a
Value:: a

Process finished with exit code 0
```
```
object:{"x":{"y":{"z":"a"}}}
key   :x
DEBUG: x-->{"y":{"z":"a"}}
Value:: {"y":{"z":"a"}}

Process finished with exit code 0
```

```
object:{"x":{"y":{"z":"a"}}}
key   :x/y
DEBUG: x-->{"y":{"z":"a"}}
DEBUG: y-->{"z":"a"}
Value:: {"z":"a"}

Process finished with exit code 0
```
```
object:{"x":{"y":{"z":"a"}}}
key   :a/b/c
ERROR: The provided key is not present in the JSON object

Process finished with exit code 255
```

```
object:{"x":{"y":{"z":"a"}}}
key   :y
ERROR: The provided key is not present in the JSON object

Process finished with exit code 255
```
```
object:{"x":{"y":{"z":"a"}}}
key   :x/y/z/a
DEBUG: x-->{"y":{"z":"a"}}
DEBUG: y-->{"z":"a"}
DEBUG: z-->a
ERROR: The provided key is not present in the JSON object

Process finished with exit code 255

```


```
object:{"a":1,"b":{"c":"hello","d":4.0}}
key   :b/c
DEBUG: b-->{"c":"hello","d":4.0}
DEBUG: c-->hello
Value:: hello

Process finished with exit code 0
```

```
object:{"a":1,"b":{"c":"hello","d":4.0}}
key   :a
DEBUG: a-->1
Value:: 1

Process finished with exit code 0
```

```
object:{"a":1,"b":{"c":"hello","d":4.0}}
key   :b/d
DEBUG: b-->{"c":"hello","d":4.0}
DEBUG: d-->4.0
Value:: 4.0

Process finished with exit code 0
```
```
object:{"a":1,"b":{"c":"hello","d":4.0}}
key   :a/d
DEBUG: a-->1
ERROR: The provided key is not present in the JSON object

Process finished with exit code 255
```