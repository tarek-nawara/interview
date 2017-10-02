package edu.interview.datastructures.trees

import spock.lang.Specification

class BTreeSpec extends Specification {
    def "test insertion work in b-tree"() {
        given: "an empty b-tree"
        def tree = new BTree()

        when: "adding elements to the tree"
        tree.put(1, "hello")
        tree.put(2, "world")

        then: "tree size should be 2 and tree should contains all the keys"
        tree.size() == 2 &&
        tree.get(1).get() == "hello" &&
        tree.get(2).get() == "world"
    }

    def "test is-empty works"() {
        given: "an empty b-tree"
        def tree = new BTree()

        when: ""

        then: "calling is empty givens true"
        tree.isEmpty()
    }
}
