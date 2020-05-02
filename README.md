# Calculator Script Test on Android

This is a practical Project to build TestScript for Android App. The simple Calculator app is used for create Automation Script.

## Basic Requirement

Use the Screenplay pattern on Serenity. Create test script for 4 common operation (+, -, *, /) with two numbers have 1 digits (value is less than 10).

The task like this:

```
Calculate.with(Operator.PLUS).between(number1).and(number2)

Calculate.with(Operator.MINUS).between(number1).and(number2)

Calculate.with(Operator.MULTIPLY).between(number1).and(number2)

Calculate.with(Operator.DIVIDE).between(number1).and(number2)
```

## Advanced Requirement

Create your own action support make operation between two numbers with no limit the digit number (with any value)
