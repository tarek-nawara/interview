package edu.interview.algorithms.sorting

import edu.interview.algorithms.sorting.utils.Utilities
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class InsertionSortSpec extends Specification {
    def "test insertion sort"() {
        given: "random array"
        final random = EnhancedRandomBuilder.aNewEnhancedRandom()
        def randomArray = random.nextObject(Integer[].class)
        println(randomArray)

        when: "calling sort"
        SelectionSort.sort(randomArray)

        then: "array should be sorted"
        Utilities.isSorted(randomArray)
    }
}
