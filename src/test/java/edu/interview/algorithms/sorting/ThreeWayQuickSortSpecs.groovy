package edu.interview.algorithms.sorting

import edu.interview.algorithms.sorting.utils.Utilities
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class ThreeWayQuickSortSpecs extends Specification {
    def "test the three way quick sort algorithm"() {
        given: "an array of random integers"
        def randomGenerator = EnhancedRandomBuilder.aNewEnhancedRandom()
        final array = randomGenerator.nextObject(Integer[].class)

        when: "Calling the sorting function"
        ThreeWayQuickSort.sort(array)

        then: "Array should be sorted"
        Utilities.isSorted(array)
    }
}
