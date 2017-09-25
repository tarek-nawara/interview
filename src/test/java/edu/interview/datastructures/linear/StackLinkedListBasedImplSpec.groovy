package edu.interview.datastructures.linear

import edu.interview.datastructures.linear.impl.StackLinkedListBasedImpl
import spock.lang.Specification

class StackLinkedListBasedImplSpec extends Specification {
    def "test adding element to stack"() {
        given: "empty stack"
        def stack = new StackLinkedListBasedImpl()

        when: "adding element to the stack"
        stack.push(1)
        stack.push(2)

        then: ""
        stack.size() == 2 && stack.peek() == 2
    }

    def "test stack iterator"() {
        given: "stack of elements"
        def stack = new StackLinkedListBasedImpl()

        when: "pushing elements"
        stack.push(1)
        stack.push(2)
        stack.push(3)

        then: ""
        def i = 0
        def l = [3, 2, 1]
        for (x in stack) {
            l.get(i) == x
            i += 1
        }
    }
}
