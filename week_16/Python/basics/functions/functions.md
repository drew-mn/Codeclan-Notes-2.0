# Functions

**Duration: xx minutes**

## Learning Objectives

- Be able to define and use a function in Python
- Be able to pass and use positional arguments, default arguments, and keyword arguments
- Be able to unpack lists and dictionaries into arguments
- Be able to pass an unlimited number of positional and keyword arguments

## Introduction

In Python, as in other programming languages, we can define functions that will allow us to re-use code as needed. We can also take in arguments / parameters, do something with them, and return values as needed.

But functions in Python have a number of special features that let us do some really interesting things with them - they are considered _first class objects_, which means that functions can be assigned to variables, or even returned from other functions. As developers, this opens up a lot of possibilities for us!

### Defining a function

At its most basic, Python functions are defined as follows:

```python
def say_hello():
	return "hello world"

print(say_hello())
```

So in the function `say_hello`, we're returning the String "hello world", for our `print` function to print.

The most important thing to note here is that we need to indent our code, just as we did for `if` statements and `for` loops.

Of course, our functions might get a little bit more complex than `say_hello` - if we have an `if` statement or a `for` loop inside a function, we need to keep nesting our code further and further to the right.

For example:

```python
def set_alarm():
	day = "Monday"
	if(day == "Saturday" or day == "Sunday"):
		return None
	else:
		return "07:00"

print(set_alarm())
```

OK! So we've written a function that includes a for loop, and this works nicely. Well, not really. We've hard-coded the value "Monday" into the function, so it's always going to return "07:00". We can fix this by passing an argument to the function.

### Positional arguments

Let's pass in the `day` variable as an argument to set_alarm.

```python
# ADDED - day parameter
def set_alarm(day):
	if(day == "Saturday" or day == "Sunday"):
		return None
	else:
		return "07:00"

print(set_alarm())
```

If we run this code now, we can see an error appearing: `TypeError: set_alarm() missing 1 required positional argument: 'day'`.

This error is being thrown because we've specified that `set_alarm` take in one parameter - `day`. We can fix this quite easily:

```python
print(set_alarm("Monday"))
```

But what is a "positional" argument? Here's another example - this time with two parameters - to demonstrate.

```python
def add(a, b):
	return a + b

result = add(2, 4)
print(result)
```

In this case, `a` takes the value of 2 inside the function, because it's the first argument listed. And similarly, `b` takes the value of 4. Python relies on the _position_ of the arguments to decide what their values should be.

### Default arguments

Python also allows us to set _default_ arguments - arguments which are optional, but have a default value if they are not passed in.

```python
def add(a, b = 2):
	return a + b

result = add(2)
print(result)

result = add(2, 10)
print(result)
```

In this case, we _can_ use a different number of arguments when we call the function, because we've set a default value for `b`.

### Keyword arguments

We can also refer to the argument by their keyword, when we pass arguments. This means that we can do some really unusual things, like reversing the order we use the parameters:

```python
def add(a, b = 2):
	return a + b

result = add(b = 3, a = 1)
print(result)
```

We can also mix positional and keyword arguments. Let's investigate further.

#### Task - 10 minutes

Given the previous function `add`, think through the following function calls. Try to work out what the result will be.

Then, execute each function call and print the result. Are the results as you expected?

1) `result = add(a = -2)`
2) `result = add(b = 3)`
3) `result = add(2, b = 4)`
4) `result = add(b = 4, 2)`
5) `result = add(a = 2, 4)`

Explanations:

1) Here, we're passing one keyword argument of `-2`. With the default argument of `b = 2`, this gives us `-2 + 2`, which is zero.

2) We get an error in this case - although we've specified a value for `b`, we haven't passed a value for `a`.

3) Here, we're passing both a _positional_ argument for `a`. and a _keyword_ argument for `b`, which overrides its default value.

4) This gives us an error - "positional argument follows keyword argument." In this case, Python isn't sure what you mean. Keyword arguments must _always_ follow positional arguments, if you are using both.

5) As in number 4, we've broken the cardinal rule that keyword arguments must come last. Even if it's "clear" what we intended to do, we still have to follow the rules.

### The "star" operator

> Instructor note - this section is optional.

There's another pattern you will see regularly within the Python community: the use of the `*` operator to allow us to pass lists and dictionaries into functions.

This is really useful where we get a list or dictionary back from an external source - such as a database or CSV file. We can easily pass it in to another data structure to make it easier to work with. You'll see an example of this tomorrow, when we use Python to work with files.

Consider the following example:

```python
def add(a, b):
	return a + b

my_list = [5, 6]
```

We can use the star operator to _unpack_ the list into positional arguments.

```python
def add(a, b):
	return a + b

my_list = [5, 6]
result = add(*my_list)
print(result)
```

So this: `add(*my_list)` is exactly the same as doing this: `add(5, 6)`. We have unpacked the list into positional arguments.

Similarly, we can do this for keyword arguments. In this case, we would use a dictionary, and the double star operator: `**`.

```python
my_dictionary = {"a": 4, "b": 10}
result = add(**my_dictionary)
```

Note that we can combine both operators in one call - but we still have to obey the golden rule: positional arguments before keyword arguments.

```python
my_list = [4]
my_dictionary = {"b": 2}
result = add(*my_list, **my_dictionary)
print(result)
```

Finally, we can use the `*` operator to accept a variable number of positional or keyword arguments:

```python
def my_function(*args, **kwargs):
	print(args)
	print(kwargs)

my_function("spam", "ham", "eggs", foo = "bar", baz = "bam")
```

We should see that `args` is a tuple containing the positional arguments, and `kwargs` is a dictionary, with the keyword arguments.

Now that we know this, what can we do with this knowledge? We could refactor our `add()` function to take any number of arguments, rather than just two! Since we know that `*args` is a tuple, we can just loop over it, and add each element.

```python
def add(*args):
	total = 0
	for arg in args:
		total += arg
	return total

print(add(3, 4, 5, 6, 7))
print(add(5, 10))
```

## Conclusion

We've seen that Python offers a great deal of versatility in how we use functions and pass arguments.

Unlike other programming languages, we can change the order they are passed in, or vary the number of arguments.

This gives us a great deal of flexibility, and we'll see the some of these techniques further when we look at files and databases.
