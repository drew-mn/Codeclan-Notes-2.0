# Variables and Types

**Duration: 30 minutes**

## Learning Objectives

- Be able to describe some of Python's types
- Be able to declare variables in Python

## Introduction

Just as in other programming languages, values have to belong to a certain _type_.

We can tell what type a value is by using Python's built-in `type()` function.

> Task - 5 minutes: use the `type()` function to investigate the types of the following values:

```python
type("Hello World!")
type(4)
type(4.0)
type(True)
type(False)
type(None)
```

In order, you should have found the following types:

### str / String

In Python 3, a string represents a collection of Unicode characters.

## int / Integer

Integers represent whole numbers, just as they do in other languages. (And in mathematics!)

> Task: What happens if you divide two integers that would leave you with a decimal number? What does `type(4 / 3)` return?

> Answer: We are left with a type of `float`.

## float / Float

Floats represent decimal numbers.

## bool / Boolean

Booleans represent true and false values, and once again, are used similarly to other languages.

The capitalisation is important: only `True` and `False` are of type `bool`.

## NoneType / None

This is a special type that represents the _absence_ of a value. You might be familiar with this concept from other languages - Ruby has `nil`, Java and JavaScript has `null`, and just to be different, Python has `None`.

> Quiz: ask the class - what will the following print out?

```python
type("42")
type("42.0")
type(1 + 2.4)
type(1 == 1) # hard!
type(2 == 4)
```

This isn't an exhaustive list of types in Python. In particular, we haven't looked at collections yet. Don't worry, we'll see them soon!

## Declaring variables

Python is a *dynamically typed language*. One of the implications of this is that we don't have to specify what type a variable is when we declare it; we simply use an equals sign to assign a value to a variable name.

In addition, we don't need to declare variables before assigning them. We can just use them straight away.

> Instructor note - start a new script in IDLE

As we saw before, we can do something like this:

```python
my_name = "Alan"
print(my_name)
```

Because Python is dynamically typed, there's nothing to stop the type of a variable from changing:

```python
my_name = "Alan"
my_name = 5
print(my_name)
```

However, because Python is also _strongly_ typed, it will throw an error if we try to combine two incompatible types. We can't add a `str` and an `int` together, for example:

```python
my_variable = "5" + 10
# TypeError: must be str, not int
```

One more nice little thing that Python allows: we can define more than one variable at a time:

```python
a, b = 10, 5

print(a)
print(b)
```

## Conclusion

We saw that variables in Python must belong to a _type_, which describes the type of data that they store. We also saw how to set a variable in Python.

Python also provides us with a number of different data structures, just like other languages. Let's continue by taking a look at some of these.
