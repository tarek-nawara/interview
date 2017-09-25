package edu.interview.datastructures.linear

import edu.interview.datastructures.linear.impl.SingleLinkedList
import spock.lang.Specification

class SingleLinkedListSpec extends Specification {
    def "add to empty linked list should return list with size one"() {
        given:"an empty linked list"
        def list = new SingleLinkedList()

        when: "adding an element"
        list.add(12)

        then: "size should be one"
        list.size() == 1
    }

    def "append to empty list should return list with size one"() {
        given: "an empty list"
        def list = new SingleLinkedList()

        when: "adding an element"
        list.append(111)

        then: "size should be one and first element should be the added element"
        list.size() == 1 && list.apply(0) == 111
    }

    def "remove element from list should work"() {
        given: ""
        def list = new SingleLinkedList()
        list.appendAll([1, 2, 3, 4, 5])

        when: ""
        list.remove(1)

        then: ""
        list.size() == 4 && list.apply(0) == 1 && list.apply(1) == 3
    }

    def "add element at a given index"() {
        given: ""
        def list = new SingleLinkedList();
        list.appendAll([1, 2, 3, 4])

        when: ""
        list.add(4, 2)

        then: ""
        list.apply(2) == 4 && list.apply(3) == 3 && list.size() == 5
    }

    def "testing flatMap"() {
        given: "list of elements"
        def list = new SingleLinkedList()
        list.appendAll([1, 2, 3, 4])

        when: "mapping each element to a list of elements"
        def f = { x ->
            def l = new SingleLinkedList()
            x.times { l.append(x) }
            return l
        }

        then: "after mapping"
        def res = list.flatMap(f)
        res.size() == 10
    }

    def "testing map and filtering"() {
        given: ""
        def list = new SingleLinkedList()
        list.appendAll([1, 2, 3, 4])

        when: "mapping each element to its square and getting only even values"
        def res = list.map{ x -> x * x }.filter{ x -> x % 2 == 0 }

        then: ""
        res.size() == 2
    }

    def "testing reversing of list"() {
        given: "list of elements"
        def list = new SingleLinkedList();
        list.appendAll([1, 2, 3, 4])

        when: "reversed twice should result the same list"
        def cloned = new SingleLinkedList()
        cloned.appendAll(list)
        list.reverse()
        list.reverse()

        then: ""
        list.equals(cloned)
    }
}
