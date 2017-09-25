package edu.interview.algorithms.sorting

import edu.interview.algorithms.sorting.utils.Utilities
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class SelectionSortSpec extends Specification {
    def "test selection sort"() {
        given: "random array"
        def random = EnhancedRandomBuilder.aNewEnhancedRandom()
        def randomArray = random.nextObject(Integer[].class)

        when: "calling sort"
        SelectionSort.sort(randomArray)

        then: "array should be sorted"
        Utilities.isSorted(randomArray)
    }
}
