package edu.interview.algorithms.searching

import spock.lang.Specification

class LinearSearchSpecs extends Specification {
    def "test liner search is working"() {
        given: "list of elements"
        def list = [1, 2, 3, 4]

        when: "asked for index of element inside the list"
        def res = LinearSearch.indexOf(list, 2)

        then: "result should be 1"
        res == 1
    }
}
