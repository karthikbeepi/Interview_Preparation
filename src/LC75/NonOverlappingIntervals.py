class Solution:
    def eraseOverlapIntervals(self, intervals: list[list[int]]) -> int:
        """
        1. Sort the intervals by their start and end times. 
            (This can be done by just using sort() as in python it sorts based on the values correctly.)
        2. Then iterate over the intervals and see if it intersects with the prev interval. 
        3. If it does not update the last interval end. 
        4. If it does, update it to the interval with the smallest end value. 
        """

        intervals.sort()

        cur_end_time = intervals[0][1]

        count = 0

        for start, end in intervals[1:]:
            if cur_end_time <= start:
                cur_end_time = end
            else:
                count += 1
                cur_end_time = min(cur_end_time, end)

        return count

        



sol = Solution()
# print(sol.eraseOverlapIntervals([[1,2], [3,4], [1,3], [4,9], [2,8]]))
print(sol.eraseOverlapIntervals([[1,2], [1,2], [1,2]]))