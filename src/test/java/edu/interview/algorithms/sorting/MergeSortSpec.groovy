package edu.interview.algorithms.sorting

import edu.interview.algorithms.sorting.utils.Utilities
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class MergeSortSpec extends Specification {
    def "test the sorting function"() {
        given: "array of elements"
        def randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandom()
        final array = randomGenerator.nextObject(Integer[].class)

        when: "invoking sorting"
        MergeSort.sort(array)

        then: "array should be sorted"
        Utilities.isSorted(array)
    }
}
