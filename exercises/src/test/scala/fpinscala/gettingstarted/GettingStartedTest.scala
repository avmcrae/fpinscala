package scala.fpinscala.gettingstarted

import fpinscala.gettingstarted.{MyModule, PolymorphicFunctions}
import org.junit.Test
import org.junit.Assert._

class GettingStartedTest {

  @Test
  def shouldBeTrueIfListIsSorted(): Unit = {
    val numbers = Array(1, 2, 3, 4)
    def lessThan(firstValue: Int, secondValue: Int): Boolean = {
      firstValue < secondValue
    }

    val isSorted = PolymorphicFunctions.isSorted(numbers, lessThan)

    assertTrue(isSorted)
  }

  @Test
  def shouldBeFalseIfListIsUnsorted(): Unit = {
    val numbers = Array(1, 3, 2, 4)
    def lessThan(firstValue: Int, secondValue: Int): Boolean = {
      firstValue < secondValue
    }

    val isSorted = PolymorphicFunctions.isSorted(numbers, lessThan)

    assertFalse(isSorted)
  }

  @Test
  def shouldGetZeroAsZerothFibonacciNumber(): Unit = {
    val result = MyModule.fib(0)

    assertEquals(result, 0)
  }

  @Test
  def shouldGetOneAsFirstFibonacciNumber(): Unit = {
    val result = MyModule.fib(1)

    assertEquals(result, 1)
  }

  @Test
  def shouldGetOneAsSecondFibonacciNumber(): Unit = {
    val result = MyModule.fib(2)

    assertEquals(result, 1)
  }

  @Test
  def shouldGetTwoAsThirdFibonacciNumber(): Unit = {
    val result = MyModule.fib(3)

    assertEquals(result, 2)
  }

  @Test
  def shouldGetThreeAsFourthFibonacciNumber(): Unit = {
    val result = MyModule.fib(4)

    assertEquals(result, 3)
  }

  @Test
  def shouldGetFiveAsFifthFibonacciNumber(): Unit = {
    val result = MyModule.fib(5)

    assertEquals(result, 5)
  }

  @Test
  def shouldGetFiftyFiveAsTenthFibonacciNumber(): Unit = {
    val result = MyModule.fib(10)

    assertEquals(result,55)
  }

  @Test
  def shouldCurry(): Unit = {
    def times(numOne: Int, numTwo: Int): Int = {
      numOne * numTwo
    }

    val timesFive = PolymorphicFunctions.curry(times)(5)

    val result = timesFive(2)

    assertEquals(result, 10)
  }

  @Test
  def shouldUncurry(): Unit = {
    def timesFive(num: Int): Int => Int = {
      (a: Int) => a * num
    }

    val times = PolymorphicFunctions.uncurry(timesFive)

    assertEquals(times(2, 5), 10)
  }

  @Test
  def shouldComposeTwoFunctions(): Unit = {
    def timesTwo(number: Int): Int = {
      number * 2
    }

    def addThree(number: Int): Int = {
      number + 3
    }

    val composedMath = PolymorphicFunctions.compose(timesTwo, addThree)

    assertEquals(composedMath(5), 16)
  }
}
