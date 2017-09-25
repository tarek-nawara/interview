package edu.interview.algorithms.sorting

import edu.interview.algorithms.sorting.utils.Utilities
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class QuickSortSpec extends Specification {
    def "test quick sort algorithm"() {
        given: "array of random elements"
        def randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandom()
        final array = randomGenerator.nextObject(Integer[].class)

        when: "sorting the array"
        QuickSort.sort(array)

        then: "array should be sorted"
        Utilities.isSorted(array)
    }
}
