package edu.interview.algorithms.sorting

import edu.interview.datastructures.linear.impl.EmptyList
import spock.lang.Specification

class ImmutableListSpec extends Specification {
    def "test adding element to empty list"() {
        given: "empty list"
        def list = new EmptyList()

        when: "adding element to that list"
        list = list.add(1)

        then: "list size = 1 and this element is element with index 0"
        list.size() == 1 && list.get(0) == 1
    }

    def "test converting list to array"() {
        given: "list of random elements"
        def list = new EmptyList()
        list = list.add(1).add(2).add(3)

        when: "converting it to an array"
        def a = list.toArray([].toArray())

        then: ""
        a == [3, 2, 1].toArray()
    }

    def "test mapping a list"() {
        given: "list of random elements"
        def list = new EmptyList()
        list = list.add(1).add(2).add(3)

        when: "mapping and filtering"
        list = list.map({x -> x * x}).filter({x -> x % 2 == 0})

        then: ""
        list.toArray() == [4].toArray()
    }
}
