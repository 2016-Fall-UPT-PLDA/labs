### Referential transparency and immutability

Take the following Java program as an example:
```Java
class Foo {
	public int value = 42

	public getValue() {
		return this.value;
	}

	public static void main(String[] args) {
		Foo x = factoryMethod()
		//... some code here
		println(x.value)
		println(x.getValue())
	}

	public Foo factoryMethod() {
		return new Foo();
	}
}
```
There are basically three ways in which, at the end of the program, you don't wind up with `42` being printed twice:
  * mutate the field `value`
  * reassign the parameter `x`
  * override the `factoryMethod()` to return an anonymous subtype of `Foo`

Now, although all these problems can be fixed, they require one thing: *the programmer being careful*. This, unfortunately, will inevitably fail from time to time.  

Haskell, in its purely functional form will not allow such things to happen in the first place! (Although we must account for some semantic differences, but we will get to that later). In a quasi-equivalent Haskell program, we will *always* know that 42 will be printed twice at the end. This discussion will continue over the course of the semester, but if you are eager to learn more then check out this article on [FP vs. OOP](http://www.haskell.org/haskellwiki/The_Monad.Reader/Issue3/Functional_Programming_vs_Object_Oriented_Programming).

List combinators
---------------------------------------

Generally, you can find the `map`, `fold`, and `filter` operations in any functional language you look at! They are extraordinarily simple, yet they give quite a lot of expressive power. We've worked a bit with them, and I encourage you to work more by yourselves; this exercise isn't just limited to Haskell, when you sit down and write code in your language of choice try and think if whatever you are writing could be expressed in terms of these!  

Check out the reference re-implementation that we did this lab, found in the file [list-combinators.hs](./list-combinators.hs). We also introduced several different ways of implementing.  

And never forget, whenever you find yourself repeating a lot of code, abstract over it using these three little helpers as an example! It works you great... probably.

Recursion
---------------------------------------

Take a look at the quasi-quicksort implementation in [quasi-quicksort.hs](./quasi-quicksort.hs).It's easier to read than pseudo-code! Also take a look as to why this isn't really a true [quicksort implementation](http://www.haskell.org/haskellwiki/Introduction#Quicksort_in_Haskell).

Defining our own types
---------------------------------------

In Haskell we can use the data keyword to [define our own data-types](http://www.haskell.org/haskellwiki/Algebraic_data_type):

```Haskell
data OneOrInterval = 
      OneValue Integer
    | Interval Integer Integer
    deriving (Show) -- we derive Show so that the interpreter can print the value of type list
```
Here we simply state that our datatype `OneOrInterval` is either `OneValue`(a name of our choosing) or it is `Interval` that requires two other `Integer`s(predefined type).

You can instantiate values of type `OneOrInterval` in the interpreter:

```Haskell
> OneValue 42
OneValue 42

> Interval 1 42
Interval 1 42
```

We can also be more explicit in how we name each piece of data (the fields) in the variants:
```Haskell
data OneOrInterval = 
      OneValue { x ::Integer }
    | Interval { low :: Integer, high :: Integer}
    deriving (Show) -- we derive Show so that the interpreter can print the value of type list
```

Now, remember, the `data` construct will do the following for us:
  * create a new type called `OneOrInterval`
  * create a `data-constructor`(i.e. functions) for each of the variants of the above type
  * in the case you name your fields explicitely, the compiler will generate functions (named after the fields) that allow us to extract the data

```Haskell
> low (Interval 1 42)
1
> high Interval{ low=1, high=42 } -- in the latter case we also get a neat way of constructing our data, as well.
42
```

But by far the most common data extraction method is using pattern matching:
```Haskell
countElements :: OneOrInterval -> Integer
countElements ooi = case ooi of
    OneValue _ -> 1
    Interval x y -> y - x + 1
```

We can achieve roughly the same data + functionality in Java as well:
```Java
interface OneOrInterval {
    int countElements();

}

final class OneValue implements OneOrInterval {
    public final int val;
    
    OneValue (int v) {
        this.val = v;
    }

    @Override
    int countElements() {
        return 1;
    }
}



final class Interval implements OneOrInterval {
    public final int x;
    public final int y;

    Interval (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    int countElements() {
        return y - x; 
    }
}
```
And now try to recall the comparative analysis we made between the two representations when:
  * a) you change the representation of the date (i.e. add another variant to OneOrInterval)
  * b) you add new functionality

This small thought exercise will help you understand very well the difference between object oriented decomposition, and functional decomposition. Spoiler Alert! OOD is vulnerable to adding new functionality, and FD is vulnerable to adding new data.

Basics of interpretation
---------------------------------------
Let us look at the very simple [`abstract-syntax-tree (AST)`](http://en.wikipedia.org/wiki/Abstract_syntax_tree):
```Haskell
data AST = 
     IntC Integer
     | Add AST AST -- 3 + 1; (1 + 2) + (1 + 2)
     | Inc AST -- equivalent of C/Java ++ operator
     deriving (Show, Eq)
```

This very simple AST is the representation of a language that can support arbitrarily complex additions.  

Starting from the data, we then write a simple function that expresses the **_semantics_** of this language:

```Haskell
evaluate :: AST -> Integer 
evaluate ast = case ast of
  IntC n -> n
  Add ast1 ast2 -> (evaluate ast1) + (evaluate ast2)
  Inc e -> (evaluate e) + 1 

-- We test this function using:
> evaluate (IntC 1)
1

> evaluate Add (IntC 2) (IntC 2)
4

--the $ sign is used to modify the order of evaluation of functions, just like parentheses do.
> evaluate Inc $ Add (IntC 2) (IntC 2)
5
-- And now we can nest these "ad-infinitum" (within practical limits)
```  

### Keep questioning

Remember, you should take everything related to software engineering/programming practices with a grain of salt. Learn the concepts, compare and contrast them, but don't stop wondering if it's actually true. Recommended reading: [The Programming Language Wars, Andreas Stefik and Stefan Hanenberg](http://dl.acm.org/authorize?N84615), this link should redirect you to a free access version of the paper. If that doesn't work, try picking it out from [Andreas Stefik's webpage](http://web.cs.unlv.edu/stefika/Papers.php).