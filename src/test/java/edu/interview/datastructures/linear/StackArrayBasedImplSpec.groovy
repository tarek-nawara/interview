package edu.interview.datastructures.linear

import edu.interview.datastructures.linear.impl.StackArrayBasedImpl
import spock.lang.Specification

class StackArrayBasedImplSpec extends Specification {
    def "adding elements to empty stack"() {
        given: "empty stack"
        def stack = new StackArrayBasedImpl()

        when: "adding element to stack"
        stack.push(111)

        then: "top element of stack should be that element and size = 1"
        stack.size() == 1 && stack.peek() == 111
    }

    def "testing empty stack"() {
        given: "empty stack"
        def stack = new StackArrayBasedImpl()

        expect: "stack isEmpty should be true"
        stack.isEmpty()
    }

    def "testing push and pop"() {
        given: "stack of elements"
        def stack = new StackArrayBasedImpl()
        stack.push(1)
        stack.push(3)

        when: "pop elements"
        stack.pop()

        then: "stack size = 1 && stack.peek = 1"
        stack.size() == 1 && stack.peek() == 1
    }
}
